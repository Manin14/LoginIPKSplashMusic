package com.manin.ipk;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;

import android.os.Bundle;

public class Hasil extends AppCompatActivity {
    AppCompatImageView ivnilai,ivlogo=null;
    AppCompatTextView textViewnama,textViewjava,textViewphp,textViewapi,textViewTotal,textViewketerangan=null;

    Bundle bundle=null;
    int iconNilai=0;
    int iconLikeOrNolike=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hasil);
        bundle=getIntent().getExtras();
        deklarasi();
        tampilHasil();
    }

    private void deklarasi() {
        ivnilai=findViewById(R.id.id_image_A);
        ivlogo=findViewById(R.id.id_image_lulus);
        textViewnama=findViewById(R.id.id_txview_nama);
        textViewjava=findViewById(R.id.id_txview_nilai_java);
          textViewphp=findViewById(R.id.id_txview_nilai_php);
          textViewapi=findViewById(R.id.id_txview_nilai_api);
          textViewTotal=findViewById(R.id.id_txview_total);
          textViewketerangan=findViewById(R.id.id_textview_keterangan);
    }

    private void tampilHasil(){
        if(bundle!=null){
            textViewnama.setText(bundle.getString("flag_nama"));
            textViewjava.setText(bundle.getString("flag_java"));
            textViewphp.setText(bundle.getString("flag_php"));
            textViewapi.setText(bundle.getString("flag_api"));
            textViewTotal.setText(bundle.getString("flag_hasil"));

            tampilIconNilai(bundle.getString("flag_hasil"));
            tampilKeterangan(bundle.getString("flag_hasil"));
            tampilIconLike(bundle.getString("flag_hasil"));
        }
        else {}

    }


    private void tampilIconNilai(String flagTotal){
    double iconTotal=Double.parseDouble(flagTotal);
      if (iconTotal <= 59)
               { iconNilai=R.drawable.nilaide;}
      else if (iconTotal >=60 && iconTotal <=69)
               {iconNilai=R.drawable.nilaice;}
      else  if (iconTotal >=70 && iconTotal <=79)
               {iconNilai=R.drawable.nilaibe;}
      else if (iconTotal > 80)
               { iconNilai=R.drawable.nilaia;}

      ivnilai.setImageResource(iconNilai);
    }


    private void tampilKeterangan (String flagHasil){
        double keteranganHasil=Double.parseDouble(flagHasil);

        if(keteranganHasil <=59){ textViewketerangan.setText("Anda Tidak Lulus");}
        else {textViewketerangan.setText("Anda  Lulus");}

    }

    private void tampilIconLike(String flagDariHasil){
        double iconLike=Double.parseDouble(flagDariHasil);
        if (iconLike <=59)
            {iconLikeOrNolike=R.drawable.sedih;}
        else if (iconLike >= 60)
             {iconLikeOrNolike=R.drawable.like;}

        ivlogo.setImageResource(iconLikeOrNolike);

    }
}
