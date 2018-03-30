package nyc.c4q.mustafizurmatin.pokemon;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;

import nyc.c4q.mustafizurmatin.pokemon.daointerface.PokemonDao;
import nyc.c4q.mustafizurmatin.pokemon.models.PokemonEntity;

/**
 * Created by c4q on 2/12/18.
 */

@Database(entities = {PokemonEntity.class}, version = 1)
public abstract class AppDatabase extends RoomDatabase {
    public abstract PokemonDao pokemonDao();
}