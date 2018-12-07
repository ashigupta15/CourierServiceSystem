package com.ashi.courierservicesystem;
import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.ProgressBar;
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


public class ViewPaymentDetails extends AppCompatActivity {

    ListView listCollege;
    ProgressBar proCollageList;
    String s1,s2;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_view_payment_details);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        listCollege = (ListView)findViewById(R.id.listCollege);
        proCollageList = (ProgressBar)findViewById(R.id.proCollageList);

        Intent i=getIntent();
        s1=i.getStringExtra("un");
        s2=i.getStringExtra("uid");

        listCollege.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String name=((TextView)view.findViewById(R.id.adapter_text_title)).getText().toString();
                String name0=((TextView)view.findViewById(R.id.adapter_text_description)).getText().toString();
                String name1=((TextView)view.findViewById(R.id.adapter_text_description1)).getText().toString();
                String name2=((TextView)view.findViewById(R.id.adapter_text_description2)).getText().toString();
                String name3=((TextView)view.findViewById(R.id.adapter_text_description3)).getText().toString();
                String name4=((TextView)view.findViewById(R.id.adapter_text_description4)).getText().toString();
                String name5=((TextView)view.findViewById(R.id.adapter_text_description5)).getText().toString();
                String name6=((TextView)view.findViewById(R.id.adapter_text_description6)).getText().toString();
                String name7=((TextView)view.findViewById(R.id.adapter_text_description7)).getText().toString();

                Intent intent=new Intent(ViewPaymentDetails.this, com.ashi.courierservicesystem.viewData.class);
                intent.putExtra("name",name);
                intent.putExtra("name0",name0);
                intent.putExtra("name1",name1);
                intent.putExtra("name2",name2);
                intent.putExtra("name3",name3);
                intent.putExtra("name4",name4);
                intent.putExtra("name5",name5);
                intent.putExtra("name6",name6);
                intent.putExtra("name7",name7);
                startActivityForResult(intent, 100);
            }
        });
        new GetHttpResponse(this).execute();
    }

    private class GetHttpResponse extends AsyncTask<Void, Void, Void>
    {
        private Context context;
        String result;
        List<com.ashi.courierservicesystem.cources> collegeList;
        public GetHttpResponse(Context context)
        {
            this.context = context;
        }

        @Override
        protected void onPreExecute()
        {
            super.onPreExecute();
        }

        @Override
        protected Void doInBackground(Void... arg0)
        {
            HttpService httpService = new HttpService(com.ashi.courierservicesystem.IpAddresses.URL_GET_SERVICE_PERSON_LIST+s1);
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

                                college.driverName = object.getString("payment_table_id");
                                college.fromPlace = object.getString("sender_name");
                                college.toPlace = object.getString("item_id");
                                college.arrivalDate = object.getString("material_type");
                                college.arrivalTime = object.getString("material_weight");
                                college.departureDate = object.getString("amount_payable");
                                college.departureTime = object.getString("payment_mode");
                                college.durationTime = object.getString("payment_received_by");
                                college.amountPayable = object.getString("note");

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