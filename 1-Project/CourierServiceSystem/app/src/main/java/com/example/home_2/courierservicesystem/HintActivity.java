package com.ashi.courierservicesystem;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import com.example.home_2.courierservicesystem.R;

public class HintActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hint);

        final ImageView imageView=(ImageView)findViewById(R.id.img);
        final RelativeLayout relativeLayout=(RelativeLayout)findViewById(R.id.front);
        relativeLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                relativeLayout.setVisibility(View.GONE);
                imageView.setVisibility(View.GONE);
            }
        });
    }
}
