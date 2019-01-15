package me.shawnstewart.applemusictopten;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    private final String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onClickComingSoon(View view) {
        onClickMenuItem(view, "https://rss.itunes.apple.com/api/v1/us/apple-music/coming-soon/all/10/explicit.json");
    }

    public void onClickHotRightNow(View view) {
        onClickMenuItem(view, "https://rss.itunes.apple.com/api/v1/us/apple-music/hot-tracks/all/10/explicit.json");
    }

    public void onClickTopAlbums (View view) {
        onClickMenuItem(view, "https://rss.itunes.apple.com/api/v1/us/apple-music/top-albums/all/10/explicit.json");
    }

    public void onClickTopSongs (View view) {
        onClickMenuItem(view, "https://rss.itunes.apple.com/api/v1/us/apple-music/top-songs/all/10/explicit.json");
    }

    public void onClickNewReleases (View view) {
        onClickMenuItem(view, "https://rss.itunes.apple.com/api/v1/us/apple-music/new-releases/all/10/explicit.json");
    }

    public void onClickMenuItem(View view, String reqStr) {
        Intent intent = new Intent(this, TopTenAlbumsActivity.class);
        intent.putExtra("REQUEST_STRING", reqStr);
        startActivity(intent);
    }
}
