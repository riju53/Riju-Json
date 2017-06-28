package com.example.rijunath.jasontoast9;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class MainActivity extends AppCompatActivity {
    ListView lv;
    String url="",Product_Id="",Item_Name="";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        lv=(ListView)findViewById(R.id.lv);
        url="http://220.225.80.177/onlineShoppingapp/Show.asmx/GetProduct?catid=4";
        new Json().execute("");
    }
    public class Json extends AsyncTask<String,String,String>{

        @Override
        protected String doInBackground(String... params) {
            JSONParser jp = new JSONParser();
            JSONObject jobj=jp.getJsonFromURL(url);
            try {
                JSONArray jarr=jobj.getJSONArray("Products");
                for (int i=0;i<=jarr.length();i++){
                    JSONObject obj=jarr.getJSONObject(i);
                     Product_Id=obj.getString("Product_Id");
                     Item_Name=obj.getString("Item_Name");
                }

            }catch (JSONException e){
                e.printStackTrace();
            }
            return null;
        }

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
        }

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);
            Toast.makeText(MainActivity.this,"Id:-"+Product_Id+"\n"+"Name:-"+Item_Name,Toast.LENGTH_LONG).show();
        }
    }
}
