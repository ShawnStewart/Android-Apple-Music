package me.shawnstewart.applemusictopten;

import android.app.ProgressDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class TopTenAlbumsActivity extends AppCompatActivity {

    private static final String TAG = "TopTenAlbumsActivity";

    // variables
    private ArrayList<String> mAlbums = new ArrayList<>();
    private ArrayList<String> mArtists = new ArrayList<>();
    private JSONArray data = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_top_ten_albums);

        OkHttpClient client = new OkHttpClient();

        String url = "https://rss.itunes.apple.com/api/v1/us/apple-music/top-albums/all/10/explicit.json";

        Request request = new Request.Builder().url(url).build();

        final ProgressDialog progressDialog = new ProgressDialog(this);
        progressDialog.setMessage("Loading data...");
        progressDialog.show();

        client.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                progressDialog.dismiss();
                Toast.makeText(getApplicationContext(), e.getMessage(), Toast.LENGTH_LONG).show();
                e.printStackTrace();
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                progressDialog.dismiss();
                if (!response.isSuccessful()) {
                    throw new IOException("Unexpected code " + response);
                } else {

                    try {
                        data = new JSONObject(response.body().string()).getJSONObject("feed").getJSONArray("results");
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }

                    Log.d(TAG, "onResponse: " + data);
                }
            }
        });

//        initData();
    }

    // Placeholder Data
    private void initData() {
        Log.d(TAG, "initData: preparing data");

        mAlbums.add("An Album");
        mArtists.add("An Artist");

        mAlbums.add("An Album");
        mArtists.add("An Artist");

        initRecyclerView();
    }

    private void initRecyclerView() {
        Log.d(TAG, "initRecyclerView: init recyclerview");
        RecyclerView recyclerView = findViewById(R.id.recycler_view);
        RecyclerViewAdapter adapter = new RecyclerViewAdapter(this, data);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }
}
