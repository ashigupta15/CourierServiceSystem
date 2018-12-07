package com.ashi.courierservicesystem;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.home_2.courierservicesystem.R;
import com.example.home_2.courierservicesystem.UserHome;

import java.util.HashMap;
import java.util.Map;

public class RequestingForReceivingCourier extends AppCompatActivity {

    EditText e1,e2,e3,e4,e5,e6;
    Button b1;
    String sv1,sv2;

    public static final String KEY_NAME = "name";
    public static final String KEY_PASSWORD = "pass";
    public static final String KEY_EMAIL = "mail";
    public static final String KEY_MOBILE = "mobil";
    public static final String KEY_ADDRESS = "loc";
    public static final String KEY_ADDRESS1 = "loc1";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_requesting_for_receiving_courier);

        Intent i=getIntent();
        sv1=i.getStringExtra("un");
        sv2=i.getStringExtra("pw");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        e1=(EditText)findViewById(R.id.editTextSenderName);
        e2=(EditText)findViewById(R.id.editTextSenderAddress);
        e3=(EditText)findViewById(R.id.editTextRecieverName);
        e4=(EditText)findViewById(R.id.editTextRecieverAddress);
        e5=(EditText)findViewById(R.id.editTextMaterialType);
        e6=(EditText)findViewById(R.id.editTextMaterialWeight);
        b1=(Button)findViewById(R.id.buttonNext);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String s1 = e1.getText().toString();
                String s2 = e2.getText().toString();
                String s3 = e3.getText().toString();
                String s4 = e4.getText().toString();
                String s5 = e5.getText().toString();
                String s6 = e6.getText().toString();

                if (s1.isEmpty() || s2.isEmpty() || s3.isEmpty() || s4.isEmpty() || s5.isEmpty()|| s6.isEmpty()) {

                    Toast.makeText(getApplicationContext(), "Enter the Fields", Toast.LENGTH_SHORT).show();

                } else {

                    signup();
                }
            }
        });
    }
    public void signup() {
        //  Log.d(TAG, "Signup");

        if (!validate()) {
            onSignupFailed();
            return;
        }
        registerUser();
        b1.setEnabled(false);


        final ProgressDialog progressDialog = new ProgressDialog(RequestingForReceivingCourier.this,R.style.AppTheme);
        progressDialog.setIndeterminate(true);
        progressDialog.setMessage("Creating Your Request...");
        progressDialog.show();



        // TODO: Implement your own signup logic here.

        new android.os.Handler().postDelayed(
                new Runnable() {
                    public void run() {
                        // On complete call either onSignupSuccess or onSignupFailed
                        // depending on success
                        onSignupSuccess();
                        // onSignupFailed();
                        progressDialog.dismiss();
                    }
                }, 3000);
    }
    public boolean validate() {
        boolean valid = true;
        return valid;
    }
    public void onSignupFailed() {
        Toast.makeText(getBaseContext(), "failed", Toast.LENGTH_LONG).show();

        b1 .setEnabled(true);
    }

    private void registerUser(){

        final String name= e1.getText().toString();
        final String password= e2.getText().toString();
        final String email= e3.getText().toString();
        final String mobile= e4.getText().toString();
        final String address= e5.getText().toString();
        final String address1= e6.getText().toString();

        StringRequest stringRequest = new StringRequest(Request.Method.POST, com.ashi.courierservicesystem.IpAddresses.URL_USER_REQUEST,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        Toast.makeText(RequestingForReceivingCourier.this, response, Toast.LENGTH_LONG).show();
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(RequestingForReceivingCourier.this, error.toString(), Toast.LENGTH_LONG).show();
                    }
                }){
            @Override
            protected Map<String,String> getParams(){
                Map<String,String> params = new HashMap<String, String>();
                params.put(KEY_NAME,name);
                params.put(KEY_PASSWORD,password);
                params.put(KEY_EMAIL,email);
                params.put(KEY_MOBILE,mobile);
                params.put(KEY_ADDRESS,address);
                params.put(KEY_ADDRESS1,address1);

                return params;
            }

        };

        RequestQueue requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(stringRequest);
    }
    public void onSignupSuccess() {
        //SignUp Code Placed Here
        b1.setEnabled(true);
        Toast.makeText(getApplication(), "Succesfully Request Sent", Toast.LENGTH_SHORT).show();
        setResult(RESULT_OK, null);

        Intent in=new Intent(RequestingForReceivingCourier.this,UserHome.class);
        in.putExtra("un",sv1);
        in.putExtra("pw",sv2);
        startActivity(in);

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
