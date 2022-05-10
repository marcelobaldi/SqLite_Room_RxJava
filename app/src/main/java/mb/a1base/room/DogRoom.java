package mb.a1base.room;
import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import mb.a1base.dao.DogDao;
import mb.a1base.entity.DogEntity;

@Database(entities = {DogEntity.class}, version = 1, exportSchema = false)
public abstract class DogRoom extends RoomDatabase {
    //Atributos
    public  abstract DogDao dogDao();
    private static   DogRoom INSTANCE;

    //Instanciar
    public static DogRoom getInstance(Context context) {
        if (INSTANCE == null) {
            synchronized (DogRoom.class) {
                if (INSTANCE == null) {
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                            DogRoom.class, "empresa_bd").build();
                }
            }
        }
        return INSTANCE;
    }
}

//Dúvidas
//* E Se Utilizar Várias Tabelas?                                                                  ***

//Anotações Principais
//- @Database:      Identificação Desta Classe (Banco Dados)

