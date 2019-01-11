package me.shawnstewart.applemusictopten;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.constraint.ConstraintLayout;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder> {

    private static final String TAG = "RecyclerViewAdapter";

    private ArrayList<String> mAlbums = new ArrayList<>();
    private ArrayList<String> mArtists = new ArrayList<>();
    private Context context;

    public RecyclerViewAdapter(Context context, ArrayList<String> mAlbums, ArrayList<String> mArtists) {
        this.mAlbums = mAlbums;
        this.mArtists = mArtists;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.layout_top_ten_albums_listitem, viewGroup, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, final int i) {
        Log.d(TAG, "onBindViewHolder: called");

        viewHolder.rank.setText(Integer.toString(i + 1));
        viewHolder.album.setText(mAlbums.get(i));
        viewHolder.artist.setText(mArtists.get(i));

        viewHolder.parentLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d(TAG, "onClick: clicked on " + mAlbums.get(i));

                Toast.makeText(context, mAlbums.get(i), Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return mAlbums.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView rank, album, artist;
        ConstraintLayout parentLayout;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            rank = itemView.findViewById(R.id.rank);
            album = itemView.findViewById(R.id.album);
            artist = itemView.findViewById(R.id.artist);
            parentLayout = itemView.findViewById(R.id.list_item_layout);
        }
    }
}
