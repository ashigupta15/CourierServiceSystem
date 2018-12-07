package com.ashi.courierservicesystem;
import android.content.Context;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.home_2.courierservicesystem.R;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.params.BasicHttpParams;
import org.apache.http.params.HttpConnectionParams;
import org.apache.http.params.HttpParams;
import org.apache.http.protocol.HTTP;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;

public class viewUserStatus extends AppCompatActivity {

    private TextView textViewResult;
    String status;
    String ID;
    String NAME;
    String ADDRESS;
    String NAME2;
    String ADDRESS2;
    String ID2;
    String NAME3;
    String STATUS;
    String STATUS2;
    ListView listCollege;
    ProgressBar proCollageList;
    String un, pw, id, n, itemid = "";
    Button btnF, btnU, btnUd;
    EditText et;
    TextView t1, t2, t3, t4, t5, t6, t7, t8, t9,tt1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_user_status);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        final RelativeLayout frontt=(RelativeLayout)findViewById(R.id.front);
        frontt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                frontt.setVisibility(View.GONE);
            }
        });
        tt1=(TextView)findViewById(R.id.textView124);
        Typeface custom_font = Typeface.createFromAsset(getAssets(),  "fonts/myfont.ttf");
        tt1.setTypeface(custom_font);

        Intent i = getIntent();
        un = i.getStringExtra("un");
        pw = i.getStringExtra("pw");
        listCollege = (ListView) findViewById(R.id.listCollege);
        proCollageList = (ProgressBar) findViewById(R.id.proCollageList);
        listCollege.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                t1 = (TextView) view.findViewById(R.id.adapter_text_title);
                t2 = (TextView) view.findViewById(R.id.adapter_text_description);
                t3 = (TextView) view.findViewById(R.id.adapter_text_description1);
                t4 = (TextView) view.findViewById(R.id.adapter_text_description2);
                t5 = (TextView) view.findViewById(R.id.adapter_text_description3);
                t6 = (TextView) view.findViewById(R.id.adapter_text_description4);
                t7 = (TextView) view.findViewById(R.id.adapter_text_description5);
                t8 = (TextView) view.findViewById(R.id.adapter_text_description6);
                t9 = (TextView) view.findViewById(R.id.adapter_text_description7);
                Intent intent = new Intent(viewUserStatus.this, com.ashi.courierservicesystem.viewDetails.class);
                intent.putExtra("n1", t1.getText().toString()+"/"+ID);
                intent.putExtra("n2", t2.getText().toString()+"/"+NAME);
                intent.putExtra("n3", t3.getText().toString()+"/"+ADDRESS);
                intent.putExtra("n4", t4.getText().toString()+"/"+NAME2);
                intent.putExtra("n5", t5.getText().toString()+"/"+ADDRESS2);
                intent.putExtra("n6", t6.getText().toString()+"/"+ID2);
                intent.putExtra("n7", t7.getText().toString()+"/"+NAME3);
                intent.putExtra("n8", t8.getText().toString()+"/"+STATUS);
                intent.putExtra("n9", t9.getText().toString()+"/"+STATUS2);
                startActivity(intent);

            }
        });


}



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.option_menu, menu);
        menu.setQwertyMode(true);
        return true;
    }


    private class GetHttpResponse extends AsyncTask<Void, Void, Void>
    {
        private Context context;
        String result,url;
        List<com.ashi.courierservicesystem.cources> collegeList;
        public GetHttpResponse(Context context,String sts)
        {
            this.context = context;
            if(sts=="shipment"){
                url= com.ashi.courierservicesystem.IpAddresses.URL_GET_DELIVER_STATUS + un;
                ID="table_id";
                 NAME="sender";
                 ADDRESS="sender_address";
                 NAME2="receiver";
                 ADDRESS2="receiver_address";
                 ID2="delivery_id";
                 NAME3="collecting_person_name";
                 STATUS="delivery_status";
                 STATUS2="user_intimation_status";
            }
            else if (sts=="payment"){
                url= com.ashi.courierservicesystem.IpAddresses.URL_GET_USER_PAYMENT + un;
                 ID="payment_table_id";
                 NAME="sender_name";
                 ADDRESS="item_id";
                 NAME2="material_type";
                 ADDRESS2="material_weight";
                 ID2="amount_payable";
                 NAME3="payment_mode";
                 STATUS="payment_received_by";
                 STATUS2="note";
            }
        }

        @Override
        protected void onPreExecute()
        {
            super.onPreExecute();
        }

        @Override
        protected Void doInBackground(Void... arg0)
        {
                HttpService httpService = new HttpService(url);
            try
            {
                httpService.ExecutePostRequest();

                if(httpService.getResponseCode() == 200)
                {
                    result = httpService.getResponse();
                    Log.d("Result", result);
                    if(result != null)
                    {
                        JSONArray jsonArray = null;
                        try {
                            jsonArray = new JSONArray(result);

                            JSONObject object;
                            JSONArray array;
                            com.ashi.courierservicesystem.cources college;
                            collegeList = new ArrayList<com.ashi.courierservicesystem.cources>();
                            for(int i=0; i<jsonArray.length(); i++)
                            {
                                college = new com.ashi.courierservicesystem.cources();
                                object = jsonArray.getJSONObject(i);

                                college.driverName = object.getString(ID);
                                college.fromPlace = object.getString(NAME);
                                college.toPlace = object.getString(ADDRESS);
                                college.arrivalDate = object.getString(NAME2);
                                college.arrivalTime = object.getString(ADDRESS2);
                                college.departureDate = object.getString(ID2);
                                college.departureTime = object.getString(NAME3);
                                college.durationTime = object.getString(STATUS);
                                college.amountPayable = object.getString(STATUS2);

                                collegeList.add(college);
                            }
                        }
                        catch (JSONException e) {
                            // TODO Auto-generated catch block
                            e.printStackTrace();
                        }
                    }
                }
                else
                {
                    Toast.makeText(context, httpService.getErrorMessage(), Toast.LENGTH_SHORT).show();
                }
            }
            catch (Exception e)
            {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            return null;
        }

        @Override
        protected void onPostExecute(Void result)

        {
            proCollageList.setVisibility(View.GONE);
            listCollege.setVisibility(View.VISIBLE);
            if(collegeList != null)
            {
                com.ashi.courierservicesystem.ListAdapter adapter = new com.ashi.courierservicesystem.ListAdapter(collegeList, context);
                listCollege.setAdapter(adapter);
            }
        }
    }

    public class HttpService
    {
        private ArrayList <NameValuePair> params;
        private ArrayList <NameValuePair> headers;

        private String url;
        private int responseCode;
        private String message;
        private String response;

        public String getResponse()
        {
            return response;
        }

        public String getErrorMessage()
        {
            return message;
        }

        public int getResponseCode()
        {
            return responseCode;
        }

        public HttpService(String url)
        {
            this.url = url;
            params = new ArrayList<NameValuePair>();
            headers = new ArrayList<NameValuePair>();
        }

        public void AddParam(String name, String value)
        {
            params.add(new BasicNameValuePair(name, value));
        }

        public void AddHeader(String name, String value)
        {
            headers.add(new BasicNameValuePair(name, value));
        }

        public void ExecuteGetRequest() throws Exception
        {
            String combinedParams = "";
            if(!params.isEmpty())
            {
                combinedParams += "?";
                for(NameValuePair p : params)
                {
                    String paramString = p.getName() + "=" + URLEncoder.encode(p.getValue(), "UTF-8");
                    if(combinedParams.length() > 1)
                    {
                        combinedParams += "&" + paramString;
                    }
                    else
                    {
                        combinedParams += paramString;
                    }
                }
            }

            HttpGet request = new HttpGet(url + combinedParams);
            for(NameValuePair h : headers)
            {
                request.addHeader(h.getName(), h.getValue());
            }

            executeRequest(request, url);
        }

        public void ExecutePostRequest() throws Exception
        {
            HttpPost request = new HttpPost(url);
            for(NameValuePair h : headers)
            {
                request.addHeader(h.getName(), h.getValue());
            }

            if(!params.isEmpty())
            {
                request.setEntity(new UrlEncodedFormEntity(params, HTTP.UTF_8));
            }

            executeRequest(request, url);
        }

        private void executeRequest(HttpUriRequest request, String url)
        {
            HttpParams httpParameters = new BasicHttpParams();
            int timeoutConnection = 10000;
            HttpConnectionParams.setConnectionTimeout(httpParameters, timeoutConnection);
            int timeoutSocket = 10000;
            HttpConnectionParams.setSoTimeout(httpParameters, timeoutSocket);

            HttpClient client = new DefaultHttpClient(httpParameters);
            HttpResponse httpResponse;
            try
            {
                httpResponse = client.execute(request);
                responseCode = httpResponse.getStatusLine().getStatusCode();
                message = httpResponse.getStatusLine().getReasonPhrase();

                HttpEntity entity = httpResponse.getEntity();
                if (entity != null)
                {
                    InputStream instream = entity.getContent();
                    response = convertStreamToString(instream);
                    instream.close();
                }
            }
            catch (ClientProtocolException e)
            {
                client.getConnectionManager().shutdown();
                e.printStackTrace();
            }
            catch (IOException e)
            {
                client.getConnectionManager().shutdown();
                e.printStackTrace();
            }
        }

        private String convertStreamToString(InputStream is)
        {
            BufferedReader reader = new BufferedReader(new InputStreamReader(is));
            StringBuilder sb = new StringBuilder();

            String line = null;
            try
            {
                while ((line = reader.readLine()) != null)
                {
                    sb.append(line + "\n");
                }
            }
            catch (IOException e)
            {
                e.printStackTrace();
            }
            finally
            {
                try
                {
                    is.close();
                }
                catch (IOException e)
                {
                    e.printStackTrace();
                }
            }
            return sb.toString();
        }
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        //  int id = item.getItemId();

        //noinspection SimplifiableIfStatement

        switch (item.getItemId()) {

            case R.id.action_name3:
                new GetHttpResponse(this,"shipment").execute();
                return true;
            case R.id.action_name4:
                new GetHttpResponse(this,"payment").execute();
                return true;
            case android.R.id.home:
                this.finish();
                return true;

            default:
                return super.onOptionsItemSelected(item);
        }


    }

}
