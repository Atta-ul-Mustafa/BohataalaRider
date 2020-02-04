package com.example.bohataalarider;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import static com.example.bohataalarider.DAshbord.xid;

public class TaskDetails extends AppCompatActivity {
TextView a,b,c,d,e,f;
    String s;
    String xb;
    Button w;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_task_details);

       s=getIntent().getStringExtra("oid");
         xb=getIntent().getStringExtra("tid");

        Log.d("oid", "onCreate: "+s);
        Log.d("oid", "onCreate: "+xb);
      //  int t= Integer.parseInt(s);

        ClientApi clientApi = Base.getClient().create(ClientApi.class);
        ForderDetails fSubCat = new ForderDetails(s);
        Call<ROrderDetails> call = clientApi. getdetails(fSubCat);
        call.enqueue(new Callback<ROrderDetails>() {
    @Override
    public void onResponse(Call<ROrderDetails> call, Response<ROrderDetails> response) {
        ROrderDetails r=response.body();
      //  Toast.makeText(TaskDetails.this, ""+r.getMessage(), Toast.LENGTH_SHORT).show();

RorderDb rr=r.getData();

        OrderDetailC orderDetail=rr.getOrderDetail();

w=(Button)findViewById(R.id.w);
        a=(TextView)findViewById(R.id.a);
        a.setText(orderDetail.getDeliveryAddress());
        b=(TextView)findViewById(R.id.b);
        b.setText(orderDetail.getOrderDetail());
        c=(TextView)findViewById(R.id.c);
        c.setText(orderDetail.getStatus());
        d=(TextView)findViewById(R.id.d);
        d.setText(orderDetail.getCreatedAt());
        e=(TextView)findViewById(R.id.e);
        f=(TextView)findViewById(R.id.f);

w.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View view) {

        ch(w.getText().toString());

    }
});

    if(xid==0){

       w.setText("In Process");
        //Toast.makeText(TaskDetails.this, "new", Toast.LENGTH_SHORT).show();
    }else if(xid==1){
        w.setText("Done");
        //Toast.makeText(TaskDetails.this, "Inprogress", Toast.LENGTH_SHORT).show();
    }else if(xid==2){
        w.setVisibility(View.GONE);
       // Toast.makeText(TaskDetails.this, "History", Toast.LENGTH_SHORT).show();
    }
    }

    @Override
    public void onFailure(Call<ROrderDetails> call, Throwable t) {

    }
});



    }



    public void ch(String g) {
        ClientApi clientApi = Base.getClient().create(ClientApi.class);
        FRiderStatus fSubCat = new FRiderStatus(s,xb,g);
        Call<Rstatus> call = clientApi. changestats(fSubCat);
        call.enqueue(new Callback<Rstatus>() {
            @Override
            public void onResponse(Call<Rstatus> call, Response<Rstatus> response) {
                Toast.makeText(TaskDetails.this, "Success", Toast.LENGTH_SHORT).show();

             /*   ActivityCompat.finishAffinity(TaskDetails.this);
                startActivity(new Intent(TaskDetails.this,DAshbord.class));
*/
            }

            @Override
            public void onFailure(Call<Rstatus> call, Throwable t) {

            }
        });
    }
}
