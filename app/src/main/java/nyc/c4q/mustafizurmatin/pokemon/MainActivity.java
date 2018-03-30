package nyc.c4q.mustafizurmatin.pokemon;

import android.arch.persistence.room.Room;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import java.util.List;

import nyc.c4q.mustafizurmatin.pokemon.adapters.PokemonAdapter;
import nyc.c4q.mustafizurmatin.pokemon.api.PokemonService;
import nyc.c4q.mustafizurmatin.pokemon.models.PokemonEntity;
import nyc.c4q.mustafizurmatin.pokemon.models.PokemonResponse;
import nyc.c4q.mustafizurmatin.pokemon.models.Results;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {
    public static final String BASE_URL = "https://pokeapi.co/";
    private static final String TAG = "pineapples";


    private RecyclerView pokemonRV;
    private PokemonAdapter pokemonAdapter;

   private List<Results> resultsList;
   private  AppDatabase db;
   private PokemonEntity entity;





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        pokemonRV = findViewById(R.id.recycler_view);
        GridLayoutManager layoutManager = new GridLayoutManager(this,3);
        pokemonRV.setLayoutManager(layoutManager);



        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        PokemonService pokemonService = retrofit.create(PokemonService.class);
        Call<PokemonResponse> call = pokemonService.getPokemon();
        call.enqueue(new Callback<PokemonResponse>() {
            @Override
            public void onResponse(Call<PokemonResponse> call, Response<PokemonResponse> response) {
                if (response.isSuccessful()){
                    Log.d(TAG, "onResponse: ");
                    PokemonResponse pokemonResponse = response.body();
                    resultsList = pokemonResponse.getResults();
                    Log.d(TAG, "onResponse: ");
                    pokemonAdapter = new PokemonAdapter(resultsList);
                    pokemonRV.setAdapter(pokemonAdapter);

                    db = Room.databaseBuilder(getApplicationContext(),
                            AppDatabase.class, "Pokemondatabase-name").build();
                    Thread thread = new Thread(new Runnable() {
                        @Override
                        public void run() {
                            for (Results r: resultsList) {
                                PokemonEntity pokemonEntity = new PokemonEntity(r.getName());
                                db.pokemonDao().insertAll(pokemonEntity);

                            }
                            db.close();

                        }
                    });
                    thread.start();
                    try {
                        thread.join();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }


                } else {
                    Log.d(TAG, "on Response Error: " + response.errorBody().toString());
                }
            }

            @Override
            public void onFailure(Call<PokemonResponse> call, Throwable t) {
                Log.d(TAG, "onFailure: " + t.getMessage());
                t.printStackTrace();


            }
        });
    }
}
