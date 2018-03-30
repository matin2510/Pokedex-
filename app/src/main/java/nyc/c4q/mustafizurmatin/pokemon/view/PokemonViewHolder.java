package nyc.c4q.mustafizurmatin.pokemon.view;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import nyc.c4q.mustafizurmatin.pokemon.R;
import nyc.c4q.mustafizurmatin.pokemon.models.Results;

/**
 * Created by c4q on 2/9/18.
 */

public class PokemonViewHolder extends RecyclerView.ViewHolder {

    private TextView pokedex;
    private ImageView pokemonImage;
    public PokemonViewHolder(View itemView) {
        super(itemView);
        pokedex= itemView.findViewById(R.id.pokomon_text);
        pokemonImage= itemView.findViewById(R.id.pokemon_image);


    }


    public void onBind(Results results) {
        pokedex.setText("Pokemon: " + results.getName());

       Picasso.with(itemView.getContext()).load("https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/" + results.getNumber() + ".png")
               .into(pokemonImage);

    }
}
