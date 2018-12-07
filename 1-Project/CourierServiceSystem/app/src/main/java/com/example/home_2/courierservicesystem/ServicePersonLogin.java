package com.ashi.courierservicesystem;
import android.app.ProgressDialog;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.TimeoutError;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.home_2.courierservicesystem.R;

import java.util.HashMap;
import java.util.Map;

public class ServicePersonLogin extends AppCompatActivity {

    private static final String TAG = "EmployeeLogin";
    EditText e1,e2;
    Button b1;
    TextView tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_service_person_login);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        e1=(EditText)findViewById(R.id.et_username_userlogin);
        e2=(EditText)findViewById(R.id.et_password_userreg);
        b1=(Button)findViewById(R.id.btn_login_user);
        tv=(TextView)findViewById(R.id.textView5);
        Typeface custom_font = Typeface.createFromAsset(getAssets(),  "fonts/AppleChancery.ttf");
        tv.setTypeface(custom_font);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                login();
            }
        });

    }
    public void login() {
        Log.d(TAG, "Login");

        if (!validate()) {
            onLoginFailed();
            return;
        }
        loginUser();

        final ProgressDialog progressDialog = new ProgressDialog(ServicePersonLogin.this,R.style.AppTheme);
        progressDialog.setIndeterminate(true);
        progressDialog.setMessage("Authenticating...");
        progressDialog.show();

        String email = e1.getText().toString();
        String password = e2.getText().toString();


        // TODO: Implement your own authentication logic here.

        new android.os.Handler().postDelayed(
                new Runnable() {
                    public void run() {
                        // On complete call either onLoginSuccess or onLoginFailed
                        onLoginSuccess();
                        // moveNext();
                        // onLoginFailed();
                        progressDialog.dismiss();
                    }
                }, 3000);
    }
    public void onLoginFailed() {
        Toast.makeText(getBaseContext(), "Login failed", Toast.LENGTH_LONG).show();


    }

    public boolean validate() {
        boolean valid = true;

        String email = e1.getText().toString();
        String password = e2.getText().toString();

        return valid;
    }
    public void loginUser(){

        StringRequest stringRequest = new StringRequest(Request.Method.POST, com.ashi.courierservicesystem.IpAddresses.URL_SERVICE_LOGIN, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                // Toast.makeText(EmployeeLogin.this,response,Toast.LENGTH_LONG).show();
                String s = response.trim();
                if(s.equalsIgnoreCase("success")){

                    Toast.makeText(getApplicationContext(), "Successfully Login", Toast.LENGTH_LONG).show();
                    Intent i= new Intent(ServicePersonLogin.this, com.ashi.courierservicesystem.ServiceHome.class);
                    String a=e1.getText().toString();
                    String bb=e2.getText().toString();
                    i.putExtra("un",a);
                    i.putExtra("uid",bb);
                    startActivity(i);
                }else {
                    Toast.makeText(getApplicationContext(), "Invalid User Name or Password", Toast.LENGTH_LONG).show();
                    Log.d("Message", "Error on Login");
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError volleyError) {
                if (volleyError instanceof TimeoutError) {
                }
            }
        }) {
            @Override
            public Map<String, String> getParams() throws AuthFailureError {
                HashMap<String, String> headers = new HashMap<>();
                headers.put("username", e1.getText().toString());
                headers.put("password", e2.getText().toString());

                return headers;
            }

            @Override
            public Priority getPriority() {
                return Priority.IMMEDIATE;
            }
        };
        RequestQueue requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(stringRequest);
    }
    public void onLoginSuccess() {
        e1.setEnabled(true);
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
