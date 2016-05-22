package be.matteotaroli.watch.activities;

import android.support.v7.app.AppCompatActivity;

import be.matteotaroli.watch.omdb.OmdbManager;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by matt on 22/05/16.
 */
public class BaseActivity extends AppCompatActivity{

    public OmdbManager getOmdbManager() {
        return new Retrofit.Builder()
                .baseUrl(OmdbManager.ENDPOINT)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(OmdbManager.class);
    }
}
