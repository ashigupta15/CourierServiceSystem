package com.ashi.courierservicesystem;
import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TableLayout;
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

public class TrackYourSingleItem extends AppCompatActivity implements View.OnClickListener {

    private EditText editTextId;
    private Button buttonGet;
    private TextView textViewResult;
    TextView t1,t2,t3,t4,t5,t6,t7,t8,t9,t10,t11;
    private ProgressDialog loading;
    TableLayout tb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_track_your_single_item);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        tb=(TableLayout)findViewById(R.id.tableid);
        tb.setVisibility(View.GONE);
        t1=(TextView)findViewById(R.id.textView113);
        t2=(TextView)findViewById(R.id.textView114);
        t3=(TextView)findViewById(R.id.textView115);
        t4=(TextView)findViewById(R.id.textView116);
        t5=(TextView)findViewById(R.id.textView117);
        t6=(TextView)findViewById(R.id.textView118);
        t7=(TextView)findViewById(R.id.textView119);
        t8=(TextView)findViewById(R.id.textView120);
        t9=(TextView)findViewById(R.id.textView121);
        t10=(TextView)findViewById(R.id.textView122);
        t11=(TextView)findViewById(R.id.textView123);
        editTextId = (EditText) findViewById(R.id.editTextId);
        buttonGet = (Button) findViewById(R.id.buttonGet);
        textViewResult = (TextView) findViewById(R.id.textViewResult);

        buttonGet.setOnClickListener(this);
    }

    private void getData() {
        String id = editTextId.getText().toString().trim();
        if (id.equals("")) {
            Toast.makeText(this, "Please enter an id", Toast.LENGTH_LONG).show();
            return;
        }
        loading = ProgressDialog.show(this,"Please wait...","Fetching...",false,false);

        String url = com.ashi.courierservicesystem.IpAddresses.URL_GET_ITEM_ID+editTextId.getText().toString().trim();

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
                        Toast.makeText(TrackYourSingleItem.this,error.getMessage().toString(),Toast.LENGTH_LONG).show();
                    }
                });

        RequestQueue requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(stringRequest);
    }

    private void showJSON(String response){
        String name="";
        String address="";
        String vc = "";
        String vc1 = "";
        String vc2 = "";
        String vc3 = "";
        String vc4 = "";
        String vc5 = "";
        String vc6 = "";
        String vc7 = "";
        String vc8 = "";
        try {
            JSONObject jsonObject = new JSONObject(response);
            JSONArray result = jsonObject.getJSONArray("result");
            JSONObject collegeData = result.getJSONObject(0);
            name = collegeData.getString("sender");
            address = collegeData.getString("sender_address");
            vc = collegeData.getString("receiver");
            vc1 = collegeData.getString("receiver_address");
            vc2 = collegeData.getString("collecting_person_name");
            vc3 = collegeData.getString("delivery_status");
            vc4 = collegeData.getString("material_type");
            vc5 = collegeData.getString("material_weight");
            vc6 = collegeData.getString("amount_payable");
            vc7 = collegeData.getString("payment_received_by");
            vc8 = collegeData.getString("note");
        } catch (JSONException e) {
            e.printStackTrace();
        }
        tb.setVisibility(View.VISIBLE);
        t1.setText(name);
        t2.setText(address);
        t3.setText(vc);
        t4.setText(vc1);
        t5.setText(vc2);
        t6.setText(vc3);
        t7.setText(vc4);
        t8.setText(vc5);
        t9.setText(vc6);
        t10.setText(vc7);
        t11.setText(vc8);
    }

    @Override
    public void onClick(View v) {
        getData();
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