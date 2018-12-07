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

import java.util.HashMap;
import java.util.Map;


public class UserRegistration extends AppCompatActivity {

    EditText e1,e2,e3,e4,e5;
    Button b1;

    public static final String KEY_NAME = "name";
    public static final String KEY_PASSWORD = "pass";
    public static final String KEY_EMAIL = "mail";
    public static final String KEY_MOBILE = "mobil";
    public static final String KEY_ADDRESS = "loc";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_registration);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        e1=(EditText)findViewById(R.id.et_username_userreg);
        e2=(EditText)findViewById(R.id.et_password_userreg);
        e3=(EditText)findViewById(R.id.et_emailid_userreg);
        e4=(EditText)findViewById(R.id.et_mobilenum_userreg);
        e5=(EditText)findViewById(R.id.et_location_userreg);
        b1=(Button)findViewById(R.id.btn_submit_user);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String s1=e1.getText().toString();
                String s2=e2.getText().toString();
                String s3=e3.getText().toString();
                String s4=e4.getText().toString();
                String s5=e5.getText().toString();

                if(s1.isEmpty() || s2.isEmpty() || s3.isEmpty() || s4.isEmpty() || s5.isEmpty()) {

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


        final ProgressDialog progressDialog = new ProgressDialog(UserRegistration.this,R.style.AppTheme);
        progressDialog.setIndeterminate(true);
        progressDialog.setMessage("Creating Account...");
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
        Toast.makeText(getBaseContext(), "Login failed", Toast.LENGTH_LONG).show();

        b1 .setEnabled(true);
    }

    private void registerUser(){

        final String name= e1.getText().toString();
        final String password= e2.getText().toString();
        final String email= e3.getText().toString();
        final String mobile= e4.getText().toString();
        final String address= e5.getText().toString();

        StringRequest stringRequest = new StringRequest(Request.Method.POST, com.ashi.courierservicesystem.IpAddresses.URL_USER_REGISTRATION,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        Toast.makeText(UserRegistration.this, response, Toast.LENGTH_LONG).show();
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(UserRegistration.this, error.toString(), Toast.LENGTH_LONG).show();
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

                return params;
            }

        };

        RequestQueue requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(stringRequest);
    }
    public void onSignupSuccess() {
        //SignUp Code Placed Here
        b1.setEnabled(true);
        Toast.makeText(getApplication(), "Succesfully registered", Toast.LENGTH_SHORT).show();
        setResult(RESULT_OK, null);

        Intent in=new Intent(UserRegistration.this, com.ashi.courierservicesystem.UserLogin.class);
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
