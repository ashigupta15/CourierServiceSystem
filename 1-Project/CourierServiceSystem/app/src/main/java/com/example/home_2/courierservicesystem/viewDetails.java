package com.ashi.courierservicesystem;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.widget.TextView;

import com.example.home_2.courierservicesystem.R;

public class viewDetails extends AppCompatActivity {

    String s1,s2,s3,s4,s5,s6,s7,s8,s9;
    TextView t1,t2,t3,t4,t5,t6,t7,t8;
    TextView tt1,tt2,tt3,tt4,tt5,tt6,tt7,tt8;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_details);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        t1=(TextView)findViewById(R.id.textView92);
        t2=(TextView)findViewById(R.id.textView93);
        t3=(TextView)findViewById(R.id.textView94);
        t4=(TextView)findViewById(R.id.textView95);
        t5=(TextView)findViewById(R.id.textView96);
        t6=(TextView)findViewById(R.id.textView97);
        t7=(TextView)findViewById(R.id.textView98);
        t8=(TextView)findViewById(R.id.textView99);

        tt1=(TextView)findViewById(R.id.textView82);
        tt2=(TextView)findViewById(R.id.textView83);
        tt3=(TextView)findViewById(R.id.textView84);
        tt4=(TextView)findViewById(R.id.textView85);
        tt5=(TextView)findViewById(R.id.textView86);
        tt6=(TextView)findViewById(R.id.textView87);
        tt7=(TextView)findViewById(R.id.textView88);
        tt8=(TextView)findViewById(R.id.textView89);

        Intent intent=getIntent();
        s1=intent.getStringExtra("n1");
        s2=intent.getStringExtra("n2");
        s3=intent.getStringExtra("n3");
        s4=intent.getStringExtra("n4");
        s5=intent.getStringExtra("n5");
        s6=intent.getStringExtra("n6");
        s7=intent.getStringExtra("n7");
        s8=intent.getStringExtra("n8");

        String[] ss1=s1.split("/");
        String[] ss2=s2.split("/");
        String[] ss3=s3.split("/");
        String[] ss4=s4.split("/");
        String[] ss5=s5.split("/");
        String[] ss6=s6.split("/");
        String[] ss7=s7.split("/");
        String[] ss8=s8.split("/");

        t1.setText(ss1[0]);
        t2.setText(ss2[0]);
        t3.setText(ss3[0]);
        t4.setText(ss4[0]);
        t5.setText(ss5[0]);
        t6.setText(ss6[0]);
        t7.setText(ss7[0]);
        t8.setText(ss8[0]);
        tt1.setText(ss1[1]);
        tt2.setText(ss2[1]);
        tt3.setText(ss3[1]);
        tt4.setText(ss4[1]);
        tt5.setText(ss5[1]);
        tt6.setText(ss6[1]);
        tt7.setText(ss7[1]);
        tt8.setText(ss8[1]);
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
