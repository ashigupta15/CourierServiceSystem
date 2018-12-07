package com.ashi.courierservicesystem;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.home_2.courierservicesystem.R;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class notificationToServiceMan extends AppCompatActivity {


    private TextView t1,t2,t3,t4,t5,t6,t7;
    public static final String KEY_NAME = "name";
    public static final String KEY_ADDRESS = "address";
    public static final String KEY_VC = "service";
    public static final String KEY_VC1 = "itemid";
    public static final String KEY_VC2 = "sender";
    public static final String KEY_VC3 = "senderaddress";
    public static final String KEY_VC4 = "materialtype";
    public static final String KEY_VC5 = "materialwgt";
    public static final String JSON_ARRAY = "result";
    private ProgressDialog loading;
    String id,n;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notification_to_service_man);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        Intent i = getIntent();
        n=i.getStringExtra("un");
        id=i.getStringExtra("uid");
        t1 = (TextView) findViewById(R.id.textView36);
        t2 = (TextView) findViewById(R.id.textView39);
        t3 = (TextView) findViewById(R.id.textView42);
        t4 = (TextView) findViewById(R.id.textView45);
        t5 = (TextView) findViewById(R.id.textView48);
        t6 = (TextView) findViewById(R.id.textView51);
        t7 = (TextView) findViewById(R.id.textView54);
        getData();

    }

    private void getData() {
        //  String id = editTextId.getText().toString().trim();
        if (id=="") {
            Toast.makeText(this, "Please enter an id", Toast.LENGTH_LONG).show();
            return;
        }
        loading = ProgressDialog.show(this,"Please wait...","Fetching...",false,false);

       // String url = "http://192.168.1.14:81/CourierServiceAutomationSystem/json/getData.php?id="+id;

        String url= com.ashi.courierservicesystem.IpAddresses.URL_TRY+id;
        StringRequest stringRequest = new StringRequest(url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                loading.dismiss();
                showJSON(response);
            }
        },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(notificationToServiceMan.this,error.getMessage(),Toast.LENGTH_LONG).show();
                    }
                });

        RequestQueue requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(stringRequest);
    }

    private void showJSON(String response){
        String name="";
        String address="";
        String service = "";
        String itemid = "";
        String sender = "";
        String senderad = "";
        String materialt = "";
        String materialw = "";
        try {
            JSONObject jsonObject = new JSONObject(response);
            JSONArray result = jsonObject.getJSONArray(JSON_ARRAY);
            JSONObject collegeData = result.getJSONObject(0);
            name = collegeData.getString(KEY_NAME);
            address = collegeData.getString(KEY_ADDRESS);
            service = collegeData.getString(KEY_VC);
            itemid = collegeData.getString(KEY_VC1);
            sender = collegeData.getString(KEY_VC2);
            senderad = collegeData.getString(KEY_VC3);
            materialt = collegeData.getString(KEY_VC4);
            materialw = collegeData.getString(KEY_VC5);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        t1.setText(sender);
        t2.setText(senderad);
        t3.setText(service);
        t4.setText(itemid);
        t5.setText(materialt);
        t6.setText(materialw);
        t7.setText(name);
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