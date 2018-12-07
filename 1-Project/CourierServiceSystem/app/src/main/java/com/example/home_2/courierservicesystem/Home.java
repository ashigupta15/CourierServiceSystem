package com.ashi.courierservicesystem;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;

import com.example.home_2.courierservicesystem.R;
import com.example.home_2.courierservicesystem.ServicePersonLogin;
import com.example.home_2.courierservicesystem.UserLogin;

public class Home extends AppCompatActivity {

    ImageButton userButton,servicePersonButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        userButton=(ImageButton)findViewById(R.id.buttonUser);
        servicePersonButton=(ImageButton)findViewById(R.id.buttonServicePerson);
        userButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Home.this, UserLogin.class);
                startActivity(intent);
            }
        });
        servicePersonButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Home.this, ServicePersonLogin.class);
                startActivity(intent);
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
