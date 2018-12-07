package com.ashi.courierservicesystem;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.widget.TextView;

import com.example.home_2.courierservicesystem.R;

public class viewData extends AppCompatActivity {

    String s1,s2,s3,s4,s5,s6,s7,s8,s9;
    TextView t1,t2,t3,t4,t5,t6,t7,t8,t9;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_data);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        Intent intent=getIntent();
        s1=intent.getStringExtra("name");
        s2=intent.getStringExtra("name0");
        s3=intent.getStringExtra("name1");
        s4=intent.getStringExtra("name2");
        s5=intent.getStringExtra("name3");
        s6=intent.getStringExtra("name4");
        s7=intent.getStringExtra("name5");
        s8=intent.getStringExtra("name6");
        s9=intent.getStringExtra("name7");

        t1=(TextView)findViewById(R.id.textView73);
        t2=(TextView)findViewById(R.id.textView74);
        t3=(TextView)findViewById(R.id.textView75);
        t4=(TextView)findViewById(R.id.textView76);
        t5=(TextView)findViewById(R.id.textView77);
        t6=(TextView)findViewById(R.id.textView78);
        t7=(TextView)findViewById(R.id.textView79);
        t8=(TextView)findViewById(R.id.textView80);
        t9=(TextView)findViewById(R.id.textView81);

        t1.setText(s1);
        t2.setText(s2);
        t3.setText(s3);
        t4.setText(s4);
        t5.setText(s5);
        t6.setText(s6);
        t7.setText(s7);
        t8.setText(s8);
        t9.setText(s9);
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
