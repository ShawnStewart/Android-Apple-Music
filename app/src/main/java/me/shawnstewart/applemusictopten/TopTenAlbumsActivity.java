package me.shawnstewart.applemusictopten;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import java.util.ArrayList;

public class TopTenAlbumsActivity extends AppCompatActivity {

    private static final String TAG = "TopTenAlbumsActivity";

    // variables
    private ArrayList<String> mAlbums = new ArrayList<>();
    private ArrayList<String> mArtists = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_top_ten_albums);

        initData();
    }

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
        RecyclerViewAdapter adapter = new RecyclerViewAdapter(this, mAlbums, mArtists);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }
}
