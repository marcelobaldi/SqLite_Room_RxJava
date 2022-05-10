package mb.a1base.entity;
import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.io.Serializable;

@Entity(tableName = "dog_tabela")
public class DogEntity implements Serializable {
    //Atributos
    @PrimaryKey(autoGenerate = true) @ColumnInfo(name = "id")
    public Integer idDog;

    @ColumnInfo(name = "nome") @NonNull
    public String nomeDog;

    @ColumnInfo(name = "idade") @NonNull
    public Integer idadeDog;

    //Construtor (Vazio, SemId, ComId)
    public DogEntity() { }
    public DogEntity(@NonNull String nomeDog, @NonNull Integer idadeDog) {
        this.nomeDog = nomeDog;
        this.idadeDog = idadeDog;
    }
    public DogEntity(Integer idDog, @NonNull String nomeDog, @NonNull Integer idadeDog) {
        this.idDog = idDog;
        this.nomeDog = nomeDog;
        this.idadeDog = idadeDog;
    }

    //Lista
    @Override public String toString() { return "DogEntity{" + "idDog='" + idDog + '\'' + ", nomeDog='" + nomeDog + '\'' +  ", idadeDog=" + idadeDog +  '}';  }
}

//Observações                                                                                     ***
//- Não Utilizar Anotação @NonNull no PrimaryKey (Campo Id), Pois ao Salvar Não é Enviado o Id;

//Anotações Principais
//- @Entity:        Identificação Desta Classe      (Tabela)
//- @PrimaryKey:    Identificação Chave Primária    (Registro Único)
//- @ColumnInfo:    Nome dos Campos da Tabela

//Anotações Secundárias
//- @NonNull:       Não Aceitar Campos Vazios
