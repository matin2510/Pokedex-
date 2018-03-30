package nyc.c4q.mustafizurmatin.pokemon.api;

import nyc.c4q.mustafizurmatin.pokemon.models.PokemonResponse;
import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by c4q on 2/9/18.
 */

public interface PokemonService {
   @GET("api/v2/pokemon/")
    Call<PokemonResponse> getPokemon();


}
