package com.ashi.courierservicesystem;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.widget.TextView;

import com.example.home_2.courierservicesystem.R;

public class ViewCourierDetails extends AppCompatActivity {

    String s1,s2,s3,s4,s5,s6,s7,s8,s9;
    TextView t1,t2,t3,t4,t5,t6,t7,t8,t9;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_courier_details);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        Intent i=getIntent();
        s1=i.getStringExtra("name");
        s2=i.getStringExtra("name0");
        s3=i.getStringExtra("name1");
        s4=i.getStringExtra("name2");
        s5=i.getStringExtra("name3");
        s6=i.getStringExtra("name4");
        s7=i.getStringExtra("name5");
        s8=i.getStringExtra("name6");


        t1=(TextView)findViewById(R.id.textView25);
        t2=(TextView)findViewById(R.id.textView26);
        t3=(TextView)findViewById(R.id.textView27);
        t4=(TextView)findViewById(R.id.textView28);
        t5=(TextView)findViewById(R.id.textView29);
        t6=(TextView)findViewById(R.id.textView30);
        t7=(TextView)findViewById(R.id.textView31);
        t8=(TextView)findViewById(R.id.textView32);

        t1.setText(s1);
        t2.setText(s2);
        t3.setText(s3);
        t4.setText(s4);
        t5.setText(s5);
        t6.setText(s6);
        t7.setText(s7);
        t8.setText(s8);

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
