package com.ashi.courierservicesystem;
import android.app.ProgressDialog;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.home_2.courierservicesystem.IpAddresses;
import com.example.home_2.courierservicesystem.PaymentDetails;
import com.example.home_2.courierservicesystem.R;
import com.example.home_2.courierservicesystem.ServiceHome;

public class DriverUpdateStatusToAdmin extends AppCompatActivity{

    private TextView textViewResult,t1;
    public static final String KEY_NAME = "name";
    public static final String KEY_ADDRESS = "address";
    public static final String KEY_VC = "service";
    public static final String KEY_VC1 = "itemid";
    public static final String KEY_VC2 = "sender";
    public static final String JSON_ARRAY = "result";
    private ProgressDialog loading;
    String id,n,itemid="";
    Button btnF,btnU,btnUd;
    EditText et;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_driver_update_status_to_admin);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        final RelativeLayout frontt=(RelativeLayout)findViewById(R.id.front);
        frontt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                frontt.setVisibility(View.GONE);
            }
        });

        t1=(TextView)findViewById(R.id.textView124);
        Typeface custom_font = Typeface.createFromAsset(getAssets(),  "fonts/myfont.ttf");
        t1.setTypeface(custom_font);

        btnF=(Button)findViewById(R.id.buttonFinal);
        btnU=(Button)findViewById(R.id.buttonUpdate);
        btnUd=(Button)findViewById(R.id.buttonUpdating);
        et=(EditText)findViewById(R.id.editTextStatus);
        et.setVisibility(View.INVISIBLE);
        btnUd.setVisibility(View.INVISIBLE);
        btnU.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                et.setVisibility(View.VISIBLE);
                btnUd.setVisibility(View.VISIBLE);
            }
        });
        Intent i = getIntent();
        n=i.getStringExtra("un");
        id=i.getStringExtra("uid");
        textViewResult = (TextView) findViewById(R.id.textViewResult);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;

    }


    private void updateService(String sts) {
        //  String id = editTextId.getText().toString().trim();

        textViewResult.setText(sts);
        loading = ProgressDialog.show(this,"Please wait...","Fetching...",false,false);

        sts=sts.replace(" ","+");
        String url = IpAddresses.URL_UPD+sts+"&&iid="+id;

        StringRequest stringRequest = new StringRequest(url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                loading.dismiss();
            }
        },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(DriverUpdateStatusToAdmin.this,"Error:"+error.getMessage(),Toast.LENGTH_LONG).show();
                    }
                });

        RequestQueue requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(stringRequest);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
      //  int id = item.getItemId();

        //noinspection SimplifiableIfStatement

        switch (item.getItemId()) {

            case R.id.action_name1:
                btnF.setVisibility(View.VISIBLE);
                btnU.setVisibility(View.VISIBLE);
                btnF.setText("Received");
                btnF.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        updateService("Received");
                        Intent intent=new Intent(DriverUpdateStatusToAdmin.this,PaymentDetails.class);
                        intent.putExtra("un",n);
                        intent.putExtra("uid",id);
                        intent.putExtra("itemid",itemid);
                        startActivityForResult(intent, 100);
                    }
                });
                btnUd.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        String sts=et.getText().toString();
                        updateService(sts);
                        Intent intent=new Intent(DriverUpdateStatusToAdmin.this,ServiceHome.class);
                        intent.putExtra("un",n);
                        intent.putExtra("uid",id);
                        intent.putExtra("itemid",itemid);
                        startActivityForResult(intent, 100);
                    }
                });
                return true;
            case R.id.action_name2:
                btnF.setVisibility(View.VISIBLE);
                btnU.setVisibility(View.VISIBLE);
                btnF.setText("Delivered");
                btnF.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        updateService("Delivered");
                        Intent intent=new Intent(DriverUpdateStatusToAdmin.this,ServiceHome.class);
                        intent.putExtra("un",n);
                        intent.putExtra("uid",id);
                        intent.putExtra("itemid",itemid);
                        startActivityForResult(intent, 100);
                    }
                });
                btnUd.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        String sts=et.getText().toString();
                        updateService(sts);
                        Intent intent=new Intent(DriverUpdateStatusToAdmin.this,ServiceHome.class);
                        intent.putExtra("un",n);
                        intent.putExtra("uid",id);
                        intent.putExtra("itemid",itemid);
                        startActivityForResult(intent, 100);
                    }
                });
                return true;
            case android.R.id.home:
                // app icon in action bar clicked; goto parent activity.
                this.finish();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}
