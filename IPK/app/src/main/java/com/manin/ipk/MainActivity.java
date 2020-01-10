package com.manin.ipk;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;
import androidx.appcompat.widget.AppCompatEditText;
import androidx.appcompat.widget.AppCompatTextView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    AppCompatEditText edinputnama,edinputjava,edinputphp,edinputapi=null;
    AppCompatButton btnbersih,btnhitung=null;

    boolean isValid=false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        deklarsi();
        btnhitung();
        btnbersih();
    }

    private void deklarsi() {
        edinputnama=findViewById(R.id.id_nama);
        edinputjava=findViewById(R.id.id_nilai_java);
        edinputphp=findViewById(R.id.id_nilai_php);
        edinputapi=findViewById(R.id.id_nilai_api);
        btnbersih=findViewById(R.id.id_button_bersih);
        btnhitung=findViewById(R.id.id_button_hitung);
    }

    private boolean cekValidasi(){
        if (edinputjava.getText().toString().length()<1)
        {isValid=false;
            showpesan("nilai java belum diisi"); }
        else if (edinputphp.getText().toString().length()<1)
        {isValid=false;
            //showpesan(getResources().getString(R.string.eror_berat_belum_di_isi));}
            showpesan("nilai php belum diisi"); }
        else if (edinputapi.getText().toString().length()<1)
        {isValid=false;
            //showpesan(getResources().getString(R.string.eror_berat_belum_di_isi));}
            showpesan("nilai API belum diisi"); }
        else if (edinputnama.getText().toString().length()<1)
        {isValid=false;
             showpesan("Nama belum di isi");}
        else
        {isValid=true;}
        return isValid;
    }

    private void showpesan(String message){

        if(!message.isEmpty()) {
            Toast.makeText(getApplicationContext(),message,Toast.LENGTH_LONG).show();
        }
    }

    private void btnhitung(){
        btnhitung.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (cekValidasi()==true){
                    //  Log.d("trace_result_bmi", Double.toString(calculateBMI(edweight.getText().toString().trim(),edheight.getText().toString().trim())));
                    tampilHasil(
                           edinputnama.getText().toString(),
                            edinputjava.getText().toString(),
                            edinputphp.getText().toString(),
                            edinputapi.getText().toString(),
                            prosesHitung( edinputjava.getText().toString(),
                                    edinputphp.getText().toString(),
                                    edinputapi.getText().toString()
                            ));
                }
                else {
                    showpesan("proses tidak valid");
                }

            }
        });
    }




    private void tampilHasil(String inputnama, String inputjava, String inputphp, String inputapi, double hasilbaru){
        Intent b=new Intent(MainActivity.this, Hasil.class);
        b.putExtra("flag_nama",inputnama);
        b.putExtra("flag_java",inputjava);
        b.putExtra("flag_php",inputphp);
        b.putExtra("flag_api",inputapi);
        b.putExtra("flag_hasil",Double.toString(hasilbaru));

        startActivity(b);
    }


    private void btnbersih(){
        btnbersih.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                edinputnama.setText("");
                edinputjava.setText("");
                edinputphp.setText("");
                edinputapi.setText("");
            }
        });
    }

    private Double prosesHitung(String javaNew,String phpNew, String apiNew){
        double insialJava=Double.parseDouble(javaNew);
        double inisialPhp= Double.parseDouble(phpNew);
        double inisalApi=Double.parseDouble(apiNew);
         double hasilNew=(insialJava+inisialPhp+inisalApi)/3;
        // double hasilAkhir=hasilNew/3;

        return hasilNew;
      //   return hasilAkhir;


    }
}
