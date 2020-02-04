package com.example.bohataalarider;

import androidx.appcompat.app.AppCompatActivity;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText a, b;
    Button c;
    public static RloginB rloginB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        a = (EditText) findViewById(R.id.a);
        b = (EditText) findViewById(R.id.b);
        c = (Button) findViewById(R.id.c);
        c.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                req();
             }
        });
    }


    void req() {

        ClientApi clientApi = Base.getClient().create(ClientApi.class);
        Flogin fSubCat = new Flogin(a.getText().toString(), b.getText().toString());
        Call<RloginA> call = clientApi.login(fSubCat);
        call.enqueue(new Callback<RloginA>() {
            @Override
            public void onResponse(Call<RloginA> call, Response<RloginA> response) {
                RloginA rloginA = response.body();

                Toast.makeText(MainActivity.this, ""+rloginA.getMessage(), Toast.LENGTH_SHORT).show();

                rloginB = rloginA.getData();
                Log.d("wer", "onResponse: "+rloginB.getEmail());
                startActivity(new Intent(MainActivity.this, DAshbord.class));



            }

            @Override
            public void onFailure(Call<RloginA> call, Throwable t) {
                Toast.makeText(MainActivity.this, "wrong id password", Toast.LENGTH_SHORT).show();
            }
        });

    }


}
