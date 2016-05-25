package be.matteotaroli.watch.activities;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

import be.matteotaroli.watch.R;
import be.matteotaroli.watch.pojo.MovieFull;
import butterknife.BindView;
import butterknife.ButterKnife;

public class DetailsActivity extends BaseActivity {

    @BindView(R.id.poster_toolbar_imageView)
    ImageView posterImageView;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (getIntent() == null){
            finish();
        }

        MovieFull movie = getIntent().getParcelableExtra("EXTRA_MOVIE");

        setContentView(R.layout.activity_detail);

        ButterKnife.bind(this);
        Picasso.with(this).load(movie.getPoster()).fit().centerCrop().into(posterImageView);
    }
}
