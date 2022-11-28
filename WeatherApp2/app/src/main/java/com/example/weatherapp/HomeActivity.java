package com.example.weatherapp;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

public class HomeActivity extends AppCompatActivity {
    EditText et;
    TextView tv,tv2,tv3,tv4;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        et = (EditText) findViewById(R.id.et);
        tv = (TextView) findViewById(R.id.tv);
        tv2 = (TextView) findViewById(R.id.tv2);
        tv3 = (TextView) findViewById(R.id.tv3);
        tv4 = (TextView) findViewById(R.id.tv4);
    }
    public void getWeather(View view){
        String myApi ="e47f4df1d6364f42b6ccba9b09ad98d4";
        String city  = et.getText().toString();
        String url = "https://api.openweathermap.org/data/2.5/weather?q="+city+"&appid=e47f4df1d6364f42b6ccba9b09ad98d4&units=metric";
        RequestQueue queue = Volley.newRequestQueue(getApplicationContext());
        JsonObjectRequest request = new JsonObjectRequest(Request.Method.GET, url, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                try {
                    JSONObject object =  response.getJSONObject("main");
                    JSONObject object2 = response.getJSONObject("wind");
                    String tem = object.getString("temp");
                    String Humidity = object.getString("humidity");
                    String wind = object2.getString("speed");
                    tv.setText("Temperature "+tem+"°c");
                    tv2.setText("Wind Speed "+wind);
                    tv3.setText("Humidity "+Humidity+"%");

                } catch (JSONException e) {
                    Toast.makeText(getApplicationContext(),e.getMessage(),Toast.LENGTH_LONG).show();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(HomeActivity.this,error.toString(),Toast.LENGTH_SHORT).show();
            }
        });
        queue.add(request);
    }
}