package com.ashi.courierservicesystem;import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;

import com.example.home_2.courierservicesystem.Home;
import com.example.home_2.courierservicesystem.R;
import com.romainpiel.shimmer.Shimmer;
import com.romainpiel.shimmer.ShimmerTextView;

public class Front2 extends AppCompatActivity {

    Shimmer shimmer;
    ShimmerTextView myShimmerTextView;
    private final int SPLASH_DISPLAY_LENGTH = 7000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_front2);

       myShimmerTextView =(ShimmerTextView)findViewById(R.id.shimmer_tv);
        Typeface custom_font = Typeface.createFromAsset(getAssets(),  "fonts/AppleChancery.ttf");
        myShimmerTextView.setTypeface(custom_font);

        shimmer = new Shimmer();
        shimmer.start(myShimmerTextView);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                /* Create an Intent that will start the Menu-Activity. */
                Intent mainIntent = new Intent(Front2.this, Home.class);
                Front2.this.startActivity(mainIntent);
                Front2.this.finish();
            }
        }, SPLASH_DISPLAY_LENGTH);
    }
}
