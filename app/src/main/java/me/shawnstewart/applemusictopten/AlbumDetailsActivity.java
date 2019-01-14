package me.shawnstewart.applemusictopten;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import org.json.JSONException;
import org.json.JSONObject;

public class AlbumDetailsActivity extends AppCompatActivity {

    private static final String TAG = "AlbumDetailsActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_album_details);

        Intent intent = getIntent();
        JSONObject data = null;
        String artist = null;
        String album = null;
        String artworkURL = null;
        String release = null;
        String copyright = null;

        try {
            data = new JSONObject(intent.getExtras().getString("ALBUM_DETAILS"));
            artist = data.getString("artistName");
            album = data.getString("name");
            artworkURL = data.getString("artworkUrl100");
            release = data.getString("releaseDate");
            copyright = data.getString("copyright");
        } catch (JSONException e) {
            e.printStackTrace();
        }
        Log.d(TAG, "onCreate: " + data);
    }
}
