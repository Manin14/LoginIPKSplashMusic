package com.manin.loginapi;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity {

    private EditText edittextusername, edittextpassword;
    private final String url = "http://almujahidin271019.000webhostapp.com/src/login.php";
    private ProgressDialog pDialog;
    Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        pDialog = new ProgressDialog(MainActivity.this);
        edittextpassword = findViewById(R.id.editText_password);
        edittextusername = findViewById(R.id.editText_username);
        edittextusername.requestFocus();


    }

  public void proses(View view) {

        final String username = edittextusername.getText().toString().trim();
        final String password = edittextpassword.getText().toString().trim();
        pDialog.setMessage("Mohon Tunggu...");
        showDialog();
        StringRequest stringRequest = new StringRequest(Request.Method.POST, url,
                new Response.Listener<String>()
                {
                    @Override
                    public void onResponse(String response)
                    {

                        if (response.contains("Berhasil"))
                        {
                            hideDialog();
                            gotoCourseActivity();

                        }
                        else
                        {
                            hideDialog();
                            Toast.makeText(MainActivity.this, "Gagal Login", Toast.LENGTH_LONG).show();
                        }
                    }
                },
                new Response.ErrorListener()
                {
                    @Override
                    public void onErrorResponse(VolleyError error)
                    {
                        //You can handle error here if you want
                        hideDialog();
                        Toast.makeText(MainActivity.this, "Koneksi Gagal", Toast.LENGTH_LONG).show();

                    }
                })
        {
            @Override
            protected Map<String, String> getParams() throws AuthFailureError
            {
                Map<String, String> params = new HashMap<>();
                params.put("username", username);
                params.put("password", password);
                return params;
            }
        };
        Volley.newRequestQueue(this).add(stringRequest);
    }

    private void showDialog()
    {
        if (!pDialog.isShowing())
            pDialog.show();
    }

    private void hideDialog()
    {
        if (pDialog.isShowing())
            pDialog.dismiss();
    }

    private void gotoCourseActivity()
    {
        Intent intent = new Intent(MainActivity.this,halaman_utama.class);
        startActivity(intent);
        finish();
    }
}
