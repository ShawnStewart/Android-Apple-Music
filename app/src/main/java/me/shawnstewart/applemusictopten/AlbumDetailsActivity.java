package me.shawnstewart.applemusictopten;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.Drawable;
import android.media.Image;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import org.json.JSONException;
import org.json.JSONObject;
import org.w3c.dom.Text;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;

public class AlbumDetailsActivity extends AppCompatActivity {

    private static final String TAG = "AlbumDetailsActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_album_details);

        Intent intent = getIntent();
        JSONObject data = null;
        String artist = null;
        String title = null;
        String genre = null;
        String artworkURL = null;
        String release = null;
        String copyright = null;

        try {
            data = new JSONObject(intent.getExtras().getString("ALBUM_DETAILS"));
            artist = data.getString("artistName");
            title = data.getString("name");
            genre = data.getJSONArray("genres").getJSONObject(0).getString("name");
            artworkURL = data.getString("artworkUrl100");
            release = data.getString("releaseDate");
            copyright = data.getString("copyright");

            TextView artistView = (TextView) findViewById(R.id.artist_view);
            TextView titleView = (TextView) findViewById(R.id.title_view);
            TextView genreView = (TextView) findViewById(R.id.genre_view);
            ImageView artworkView = (ImageView) findViewById(R.id.artwork_view);
            TextView releaseView = (TextView) findViewById(R.id.release_view);
            TextView copyrightView = (TextView) findViewById(R.id.copyright_view);

            artistView.setText(artist);
            titleView.setText(title);
            genreView.setText(genre);
            new DownloadImageTask(artworkView).execute(artworkURL);
            releaseView.setText(release);
            copyrightView.setText(copyright);

        } catch (JSONException e) {
            e.printStackTrace();
        }
        Log.d(TAG, "onCreate: " + data);
    }
}
