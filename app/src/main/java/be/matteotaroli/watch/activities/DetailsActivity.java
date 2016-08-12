package be.matteotaroli.watch.activities;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Callback;
import com.squareup.picasso.NetworkPolicy;
import com.squareup.picasso.Picasso;

import be.matteotaroli.watch.R;
import be.matteotaroli.watch.pojo.MovieFull;
import butterknife.BindView;
import butterknife.ButterKnife;

public class DetailsActivity extends BaseActivity {

    @BindView(R.id.poster_toolbar_imageView)
    ImageView posterImageView;
    @BindView(R.id.title_toolbar_textView)
    TextView titleTv;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (getIntent() == null) {
            finish();
        }

        ActivityCompat.postponeEnterTransition(this);

        MovieFull movie = getIntent().getParcelableExtra("EXTRA_MOVIE");

        setContentView(R.layout.activity_detail);

        ButterKnife.bind(this);

        titleTv.setText(movie.getTitle());
        Picasso.with(this)
                .load(movie.getBigPoster()).networkPolicy(NetworkPolicy.OFFLINE)
                .fit().centerCrop().placeholder(R.drawable.ic_movie)
                .into(posterImageView, new Callback() {
                    @Override
                    public void onSuccess() {
                        ActivityCompat.startPostponedEnterTransition(DetailsActivity.this);
                    }

                    @Override
                    public void onError() {
                        ActivityCompat.startPostponedEnterTransition(DetailsActivity.this);
                    }
                });
    }
}
