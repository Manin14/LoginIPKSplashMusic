package com.manin.music;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.ProgressDialog;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ArrayList<Integer> mediaDatas = null;
    RecyclerView rvPodcast = null;
    AppCompatTextView tvPodcastTitle = null;
    AppCompatImageView currentImagePodcast = null;
    ProgressBar progressBar = null;
    ProgressDialog progressDialog=null;
    MediaPlayer mediaPlayer=null;

    PodcastAdapter podcastAdapter = null;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        declareComponent();
        generateList(mediaDatas);

    }


    private void declareComponent() {


        mediaPlayer = new MediaPlayer();

        rvPodcast = findViewById(R.id.rvPodcastListID);
        tvPodcastTitle = findViewById(R.id.podcastTitleID);
        currentImagePodcast = findViewById(R.id.currentImagePlayID);
        progressBar = findViewById(R.id.progresLoadingID);

        progressBar.setVisibility(View.VISIBLE);
        progressDialog = new ProgressDialog(MainActivity.this);
        progressDialog.setTitle("Memproses");

        mediaDatas = new ArrayList<>();

        mediaDatas.add(R.raw.lagu1);
        mediaDatas.add(R.raw.lagu2);
        mediaDatas.add(R.raw.lagu2);
        mediaDatas.add(R.raw.lagu2);
        mediaDatas.add(R.raw.lagu2);
        mediaDatas.add(R.raw.lagu2);
        mediaDatas.add(R.raw.lagu2);
        mediaDatas.add(R.raw.lagu2);
        mediaDatas.add(R.raw.lagu2);
        mediaDatas.add(R.raw.lagu2);
        mediaDatas.add(R.raw.lagu2);
        mediaDatas.add(R.raw.lagu2);
        mediaDatas.add(R.raw.lagu2);
        mediaDatas.add(R.raw.lagu2);


    }


    void generateList(ArrayList<Integer> myCollectionMediaList) {
        podcastAdapter = new PodcastAdapter(MainActivity.this, myCollectionMediaList,mediaPlayer);

        if(podcastAdapter!=null){
            progressBar.setVisibility(View.GONE);
            progressDialog.dismiss();
        }

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);

        rvPodcast.setLayoutManager(layoutManager);
        rvPodcast.setAdapter(podcastAdapter);

    }
}
