package com.ashi.courierservicesystem;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.text.InputType;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.home_2.courierservicesystem.R;
import com.example.home_2.courierservicesystem.ServiceHome;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class PaymentDetails extends AppCompatActivity implements AdapterView.OnItemClickListener, View.OnClickListener, AdapterView.OnItemSelectedListener {

    String userId,itemId,userName,paymode,m_Text;
    String materialType,materialWeight,amount;
    TextView t1,t2,t3,t4,t5;
    public static final String KEY_NAME = "name";
    public static final String KEY_ADDRESS = "address";
    public static final String KEY_VC = "service";
    public static final String KEY_VC1 = "itemid";
    public static final String KEY_VC2 = "sender";
    public static final String JSON_ARRAY = "result";
    private ProgressDialog loading;
    Spinner spinner;
    Button btnsub,btnntp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payment_details);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        t1=(TextView)findViewById(R.id.textView);
        t2=(TextView)findViewById(R.id.textView2);
        t3=(TextView)findViewById(R.id.textView3);
        t4=(TextView)findViewById(R.id.textView4);
        t5=(TextView)findViewById(R.id.textView23);
        spinner=(Spinner)findViewById(R.id.spinner);
        btnsub=(Button)findViewById(R.id.buttonPaid);
        btnntp=(Button)findViewById(R.id.buttonNotPaid);
        btnntp.setOnClickListener(this);
        btnsub.setOnClickListener(this);
        spinner.setOnItemSelectedListener(this);
        Intent i=getIntent();
        userName=i.getStringExtra("un");
        userId=i.getStringExtra("uid");
        itemId=i.getStringExtra("itemid");
        t1.setText("User Name:\t"+userName);
        t2.setText("User Id:\t"+userId);
        t3.setText(itemId);
        getPaymentDetails();
    }
    private void getPaymentDetails() {
        //  String id = editTextId.getText().toString().trim();

        loading = ProgressDialog.show(this, "Please wait...", "Fetching...", false, false);

        String url = com.ashi.courierservicesystem.IpAddresses.URL_GET_PAY+userId;

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
                        Toast.makeText(PaymentDetails.this,error.getMessage().toString(),Toast.LENGTH_LONG).show();
                    }
                });

        RequestQueue requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(stringRequest);
    }
    private void showJSON(String response){
        materialType="";
        materialWeight="";
        amount="";
        try {
            JSONObject jsonObject = new JSONObject(response);
            JSONArray result = jsonObject.getJSONArray(JSON_ARRAY);
            JSONObject collegeData = result.getJSONObject(0);
            materialType = collegeData.getString(KEY_NAME);
            materialWeight = collegeData.getString(KEY_ADDRESS);
            amount = collegeData.getString(KEY_VC);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        t3.setText("Material Type:\t" + materialType);
        t4.setText("Material Weight:\t" + materialWeight);
        t5.setText("Amount Payable:\t" + amount);
    }
    private void updatePayment(String paysts) {
        //  String id = editTextId.getText().toString().trim();

        loading = ProgressDialog.show(this,"Please wait...","Fetching...",false,false);

        //String url = "http://192.168.1.3:81/CourierServiceAutomationSystem/json/updatePayment.php?paymode="+paymode+"&&status="+paysts+"&&itemid="+itemId+"&&username="+userName;

        String url= com.ashi.courierservicesystem.IpAddresses.URL_PAY+paymode+"&&status="+paysts+"&&itemid="+userId+"&&username="+userName;

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
                        Toast.makeText(PaymentDetails.this,"Error:"+error.getMessage(),Toast.LENGTH_LONG).show();
                    }
                });

        RequestQueue requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(stringRequest);
    }



    @Override
    public void onClick(View v) {
        if (v==btnntp)
        {
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setTitle("Enter Reason");
            final EditText input = new EditText(this);
            input.setInputType(InputType.TYPE_CLASS_TEXT);
            builder.setView(input);
            builder.setPositiveButton("OK", new DialogInterface.OnClickListener()
            {
              @Override
              public void onClick(DialogInterface dialog, int which)
              {
                    m_Text = input.getText().toString();
                    updatePayment(input.getText().toString());
                    Intent intent=new Intent(PaymentDetails.this,ServiceHome.class);
                    intent.putExtra("un",userName);
                    intent.putExtra("uid",userId);
                    startActivityForResult(intent,100);
                }
            });
            builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    dialog.cancel();
                }
            });

            builder.show();
        }
        else if (v==btnsub){
            updatePayment("Paid");
            Intent intent=new Intent(PaymentDetails.this,ServiceHome.class);
            intent.putExtra("un",userName);
            intent.putExtra("uid",userId);
            startActivity(intent);
        }
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        paymode=parent.getItemAtPosition(position).toString();
        Toast.makeText(this,"You Chosen : "+paymode,Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

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
