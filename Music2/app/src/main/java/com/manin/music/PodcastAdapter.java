package com.manin.music;

import android.content.Context;
import android.media.MediaPlayer;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class PodcastAdapter extends RecyclerView.Adapter<PodcastAdapter.CustomViewHolder> {

    public Context context;
    public ArrayList<Integer> mypodcastlist;

    MediaPlayer mediaPlayer;



    public PodcastAdapter(Context context,  ArrayList<Integer> mypodcastlist, MediaPlayer mediaPlayer){

        this.context  = context;
        this.mypodcastlist = mypodcastlist;
        this.mediaPlayer= mediaPlayer;
    }



    @NonNull
    @Override
    public CustomViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        //View view = layoutInflater.inflate(R.layout.item_photos, parent, false);
        View view = layoutInflater.inflate(R.layout.item_podcast, parent, false);
        return new CustomViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CustomViewHolder holder, final int position) {


        holder.tvListPodcast.setText("List Podcast" + getItemId(position));


        holder.tvListPodcast.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                mediaPlayer = MediaPlayer.create(context,mypodcastlist.get(position));

                mediaPlayer.start();



            }
        });



    }

    @Override
    public int getItemCount() {
        return mypodcastlist.size();
    }

    public class CustomViewHolder extends RecyclerView.ViewHolder{

        AppCompatImageView imgIcon;
        AppCompatTextView tvListPodcast;

        public CustomViewHolder(@NonNull View v) {
            super(v);

            imgIcon = v.findViewById(R.id.itemImageID);
            tvListPodcast= v.findViewById(R.id.itemTitleID);


        }
    }
}

