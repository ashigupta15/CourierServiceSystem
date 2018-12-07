package com.ashi.courierservicesystem;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import com.example.home_2.courierservicesystem.R;
import com.example.home_2.courierservicesystem.viewUserStatus;

public class UserHome extends AppCompatActivity {

    Button b1,b2,b3,b4,b5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_home);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        Intent intent=getIntent();
        final String un=intent.getStringExtra("un");
        final String pw=intent.getStringExtra("pw");
        b1=(Button)findViewById(R.id.buttonRequestForReceivingCourier);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(UserHome.this, com.ashi.courierservicesystem.RequestingForReceivingCourier.class);
                intent.putExtra("un",un);
                intent.putExtra("pw",pw);
                startActivity(intent);
            }
        });
        b2=(Button)findViewById(R.id.buttonViewStatus);
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(UserHome.this, viewUserStatus.class);
                intent.putExtra("un",un);
                intent.putExtra("pw",pw);
                startActivity(intent);
            }
        });
        b3=(Button)findViewById(R.id.buttonCourierDetails);
        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(UserHome.this, com.ashi.courierservicesystem.ShowCourierIdDetails.class);
                intent.putExtra("un",un);
                intent.putExtra("pw",pw);
                startActivity(intent);
            }
        });
        b4=(Button)findViewById(R.id.buttonTrackYourItem);
        b4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(UserHome.this, com.ashi.courierservicesystem.TrackYourSingleItem.class);
                intent.putExtra("un",un);
                intent.putExtra("pw",pw);
                startActivity(intent);
            }
        });
        b5=(Button)findViewById(R.id.buttonLogout);
        b5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(UserHome.this, com.ashi.courierservicesystem.Home.class);
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
