package com.ashi.courierservicesystem;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import com.example.home_2.courierservicesystem.R;
import com.example.home_2.courierservicesystem.ViewPaymentDetails;

public class ServiceHome extends AppCompatActivity {

    Button b1,b2,b3,b4;
    String s1,s2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_service_home);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        Intent in=getIntent();
        s1=in.getStringExtra("un");
        s2=in.getStringExtra("uid");

        b1=(Button)findViewById(R.id.buttonNotification);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(ServiceHome.this, com.ashi.courierservicesystem.notificationToServiceMan.class);
                i.putExtra("un", s1);
                i.putExtra("uid", s2);
                startActivity(i);
            }
        });
        b2=(Button)findViewById(R.id.buttonReceiving);
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(ServiceHome.this, com.ashi.courierservicesystem.DriverUpdateStatusToAdmin.class);
                i.putExtra("un", s1);
                i.putExtra("uid", s2);
                startActivity(i);
            }
        });
        b3=(Button)findViewById(R.id.buttonPaymentDetails);
        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(ServiceHome.this, ViewPaymentDetails.class);
                i.putExtra("un", s1);
                i.putExtra("uid", s2);
                startActivity(i);
            }
        });
        b4=(Button)findViewById(R.id.buttonLogout);
        b4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(ServiceHome.this, com.ashi.courierservicesystem.Home.class);
                startActivity(i);
            }
        });
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                // app icon in action bar clicked; goto parent activity.
                this.finish();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}
