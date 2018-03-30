package nyc.c4q.mustafizurmatin.pokemon.daointerface;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import java.util.List;

import nyc.c4q.mustafizurmatin.pokemon.models.PokemonEntity;

/**
 * Created by c4q on 2/12/18.
 */
@Dao
public interface PokemonDao {
    @Query("SELECT * FROM pokemonentity")
    List<PokemonEntity> getAll();

    @Query("SELECT * FROM pokemonentity WHERE first_name LIKE :first LIMIT 1")
    PokemonEntity findByName(String first);


    @Insert
    void insertAll(PokemonEntity... pokemonEntities);

    @Delete
    void delete(PokemonEntity pokemonEntity);
}



