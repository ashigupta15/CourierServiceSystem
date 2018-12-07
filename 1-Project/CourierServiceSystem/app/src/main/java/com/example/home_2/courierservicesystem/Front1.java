package com.ashi.courierservicesystem;import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;

import com.example.home_2.courierservicesystem.Front2;
import com.example.home_2.courierservicesystem.R;
import com.skyfishjy.library.RippleBackground;

public class Front1 extends AppCompatActivity {

    private final int SPLASH_DISPLAY_LENGTH = 6000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_front1);

        final RippleBackground rippleBackground=(RippleBackground)findViewById(R.id.content);
        ImageView imageView=(ImageView)findViewById(R.id.centerImage);
        rippleBackground.startRippleAnimation();

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                /* Create an Intent that will start the Menu-Activity. */
                Intent mainIntent = new Intent(Front1.this, Front2.class);
                Front1.this.startActivity(mainIntent);
                Front1.this.finish();
            }
        }, SPLASH_DISPLAY_LENGTH);
    }
}
