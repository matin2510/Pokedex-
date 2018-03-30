package nyc.c4q.mustafizurmatin.pokemon.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


import java.util.List;

import nyc.c4q.mustafizurmatin.pokemon.R;

import nyc.c4q.mustafizurmatin.pokemon.models.Results;
import nyc.c4q.mustafizurmatin.pokemon.view.PokemonViewHolder;

/**
 * Created by c4q on 2/9/18.
 */

public class PokemonAdapter extends RecyclerView.Adapter<PokemonViewHolder> {

    private List<Results> resultsList;

    public PokemonAdapter(List<Results> resultsList) {
        this.resultsList = resultsList;
    }

    @Override
    public PokemonViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.pokemon_itemview, parent, false);
        return new PokemonViewHolder(view);
    }

    @Override
    public void onBindViewHolder(PokemonViewHolder holder, int position) {
        holder.onBind(resultsList.get(position));


    }

    @Override
    public int getItemCount() {
        return resultsList.size();
    }
}
