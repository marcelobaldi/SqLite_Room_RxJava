package mb.a1base;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

import mb.a1base.dao.DogDao;
import mb.a1base.entity.DogEntity;
import mb.a1base.room.DogRoom;
import mb.a1base.view.DogActivity;

public class MainActivity extends AppCompatActivity {
    //Atributos

    //Método Inicial
    @Override protected void onCreate(Bundle savedInstanceState){super.onCreate(savedInstanceState); setContentView(R.layout.activity_main);
        //Redirecionamento
        startActivity(new Intent(this, DogActivity.class));
    }
}

//Observações                                                                                      ***
//- Manifest:           Falta Permissões (WiFi, Ligação, Etc)
//- Gradle Module:      Falta Libs (Firebase, Etc) e Qual o Padrão?
//- Gradle Project:     Antes-MavenCentral / Depois-Google, Jcenter / Agora Nada / Qual Padrão?
//- Gradle Properties:  android.enableJetifier=true para Impedir Conflitos de Libs?

/////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////

//LiveData
//Tipos
//- LiveData:           Constante   (Nâo é Possível Setar Valor)
//- MutableLiveData:    Variável    (É Possível Setar Valor)
//* Observação:         Usar Sempre Public e Mutable, Exceto na Interface (Obrigatório LiveData);

//Instanciar Objetos
//- Instanciar:         Com LiveData/MutableLiveData e Não Com o Seu Tipo;
//* Lista Normal        private List<DogEntity>          listaDogs    = new ArrayList<>();
//* Lista LD:           MutableLiveData<List<DogEntity>> listaDogs_LD = new MutableLiveData<>();

//Manipular Objetos
//- Setar Valor:        .setValue   (Não = )
//- Pegar Val Normal:   .observe
//- Pegar Val Assinc:   .getValue()

/////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////

//Room-ORM
//- Room Database:      Banco Dados;
//- Entity:             Tabelas;
//- DAO:                CRUD nas Tabelas;
//- Repository:         (Recomendado)
//- Libs:               https://developer.android.com/training/data-storage/room
//* Conflito Libs:      Gradle.Properties(android.useAndroidX=true e android.enableJetifier=true)

