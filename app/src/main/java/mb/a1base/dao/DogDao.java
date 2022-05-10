package mb.a1base.dao;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

import io.reactivex.Single;
import mb.a1base.entity.DogEntity;

@Dao
public interface DogDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    void salvar (DogEntity dogEntity);

    @Update
    void alterar(DogEntity dogEntity);

    @Delete
    void deletar(DogEntity dogEntity);

    ///////////////////////////////////////////////////////////////

    @Query("DELETE FROM dog_tabela WHERE id = :dogId ")
    void deletar2(Integer dogId);

    ///////////////////////////////////////////////////////////////

    @Query("SELECT * FROM dog_tabela ORDER BY nome ASC")
    Single<List<DogEntity>> buscarTodos();

    @Query("SELECT * FROM dog_tabela WHERE id = :dogId")
    Single<DogEntity> buscarporId(int dogId);
}

//Observações                                                                                      ***
//- Se Tipo Método LiveData, Então LiveData Aqui (Não MutableLiveData), Senão Erro;

//Anotações Principais
//- @Dao:           Identificação Desta Classe (CRUD nas Tabelas);
//- @Insert:        Salvar      Otimizado
//- @Update:        Atualizar   Otimizado
//- @Delete:        Deletar     Otimizado
//- @Query:         Comandos    SQL
//* Observação:     Para Salvar, Atualizar, Deletar, Pode Ser Anotação Própria ou Anotação Query;

//Anotações Secundárias
//- OnConflictStrategy:                                                                            ???
