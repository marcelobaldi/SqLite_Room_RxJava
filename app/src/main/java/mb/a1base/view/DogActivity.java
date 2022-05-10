package mb.a1base.view;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;

import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.Single;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.observers.DisposableSingleObserver;
import io.reactivex.schedulers.Schedulers;
import mb.a1base.MainActivity;
import mb.a1base.R;
import mb.a1base.dao.DogDao;
import mb.a1base.entity.DogEntity;
import mb.a1base.room.DogRoom;

public class DogActivity extends AppCompatActivity {
    //Atributos
    private DogDao              dogDao;                                     //BD CRUD
    private List<DogEntity>     listaDogs   = new ArrayList<>();            //Lista Normal
    private CompositeDisposable cDisposable = new CompositeDisposable();    //RxJava (ouvinte off)

    //Método Inicial
    @Override protected void onCreate(Bundle savedInstanceState){super.onCreate(savedInstanceState); setContentView(R.layout.activity_dog);
        //BD - Instanciar
        DogRoom bd = DogRoom.getInstance(DogActivity.this);
        dogDao = bd.dogDao();

        ////////////////////////////////////////////////////////////////////////////////////////////

        //Salvar Dados - Via RxJava_Single
        // ???

        ////////////////////////////////////////////////////////////////////////////////////////////

        //Pegar Dados - Via RxJava_Single
        cDisposable.add(
            Single.just(dogDao.buscarTodos())
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(new DisposableSingleObserver<List<DogEntity>>() {
                    @Override public void onSuccess(List<DogEntity> dogEntities) { }
                    @Override public void onError(Throwable e) { }
                })
        );
    }
}

//Salvar Dados - Via AsyncTask (Ok)
//new AsyncTask<Void, Void, Void>(){
//    @Override protected Void doInBackground(Void... voids) {
//        DogEntity dogEntity = new DogEntity("Belinha", 16);
//        dogDao.salvar(dogEntity);
//        return null;
//    }
//}.execute();

