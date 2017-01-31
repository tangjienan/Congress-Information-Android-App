package com.example.hw999;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import android.app.ActionBar;
import java.net.URL;
import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.AsyncTask;
import android.util.LruCache;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.design.widget.TabLayout;
import android.support.v4.app.FragmentActivity;
import android.support.v4.widget.DrawerLayout;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.GravityCompat;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.TextView;
import android.app.FragmentTransaction;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.VolleyError;
import android.widget.Toast;
import android.util.Log;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import android.widget.ListView;
import java.util.ArrayList;
import java.util.List;
import java.util.List;
import android.util.Log;
import android.widget.AdapterView;
import android.content.Intent;
import android.support.v7.widget.Toolbar;
import android.widget.ProgressBar;
/**
 * Created by donezio on 11/26/2016.
 */

public class billsdetail  extends AppCompatActivity {
    public static String url1;
    public static TextView billid;
    public static TextView title;
    public static TextView type;
    public static TextView sponsor;
    public static TextView chamber;
    public static TextView status;
    public static TextView introduce;
    public static TextView cURL;
    public static TextView version;
    public static TextView bURL;
    public static billinfo leginfo1 = new billinfo();
    public static global var1;
    public static bills favbills;
    public static ImageView star;
    public static String[] monthNames = {
            "January", "February", "March",
            "April", "May", "June", "July",
            "August", "September", "October",
            "November", "December"
    };

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.billsdetail);

        Intent myIntent = getIntent();
        String id = myIntent.getExtras().getString("id");
        String date = myIntent.getExtras().getString("date");
        String lt = myIntent.getExtras().getString("ltitle");
        String st = myIntent.getExtras().getString("stitle");
        star =  (ImageView) findViewById(R.id.star);

        star.setImageResource(R.drawable.star);




        favbills = new bills();
        favbills.setBillid(id);
        favbills.setIntroduce(date);
        favbills.setlTitle(lt);
        favbills.setsTitle(st);

        if(var1.FavBillList.contains( (favbills) ) ){
            star.setImageResource(R.drawable.fill_star);
            //Log.d("check", var1.FavlegislatorList.toString());

        }else {
            //Log.d("check", var1.FavlegislatorList.toString());
            star.setImageResource(R.drawable.star);
        }


        billid = (TextView) findViewById(R.id.billid);
        title = (TextView) findViewById(R.id.title);
        type = (TextView) findViewById(R.id.type);
        sponsor = (TextView) findViewById(R.id.sponsor);
        chamber = (TextView) findViewById(R.id.chamber);
        status = (TextView) findViewById(R.id.status);
        introduce = (TextView) findViewById(R.id.introduce);
        cURL = (TextView) findViewById(R.id.cURL);
        version = (TextView) findViewById(R.id.version);
        bURL = (TextView) findViewById(R.id.bURL);

        url1 = String.format("http://104.198.0.197:8080/bills?bill_id=%s",
                id);
        Log.d("detail URL",url1);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle("Bills Info");
        setSupportActionBar(toolbar);
        toolbar.setNavigationIcon(R.drawable.left);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();

            }
        });

        star.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {


                if(var1.FavBillList.contains((favbills)) ) {
                    star.setImageResource(R.drawable.star);
                    var1.FavBillList.remove(favbills);
                    Log.d("click", var1.FavlegislatorList.toString());
                }
                else {
                    var1.FavBillList.add(favbills);
                    star.setImageResource(R.drawable.fill_star);
                }
            }
        });


        new GetData(this).execute(url1);
    }


    public static class GetData extends AsyncTask<String, Integer, billinfo > {

        Context context;
        private GetData(Context context) {
            this.context = context.getApplicationContext();
        }




        protected billinfo doInBackground(String... leginfo) {
            //publishProgress(20);
            try {
                URL url = new URL(url1);
                HttpURLConnection connection = (HttpURLConnection) url.openConnection();
                connection.setReadTimeout(5000);
                connection.setRequestMethod("GET");
                Log.d("gett","data");
                BufferedReader bufferedReader = new BufferedReader(
                        new InputStreamReader(connection.getInputStream()));
                StringBuffer sb = new StringBuffer();
                String str = "";
                while ((str = bufferedReader.readLine()) != null) {
                    // 当读取完毕，就添加到容器中
                    sb.append(str);
                }
                JSONObject jsonObject = new JSONObject(sb.toString());
                JSONObject haha;
                JSONObject haha2;
                JSONObject haha3;
                //haha2 = jsonObject.getJSONObject("results");
                JSONArray haha20 = jsonObject.getJSONArray("results");

                //haha2 = haha.getJSONObject("results");
                int tem = 312;
                //haha2 =  new JSONObject( jsonObject.getString("results") );
               // haha2 = haha2.getJSONObject("0");
                //Iterator x = haha2.keys();
                for(int i = 0; i < haha20.length();i++){

                    haha3 =(JSONObject) haha20.get(i);
                    //String key = (String)x.next();
                    //haha3 = (JSONObject)haha2.get(key);
                    //leginfo leginfo1 = new leginfo();
                    /*
                    leginfo1.setId(haha3.getString("bill_id"));
                    //leginfo1.setId(haha3.getString("bioguide_id"));
                    leginfo1.setSponsor(haha3.getJSONObject("sponsor").getString("title"),haha3.getJSONObject("sponsor").getString("first_name"),haha3.getJSONObject("sponsor").getString("last_name"));
                    leginfo1.setTitle(haha3.getString("official_title"));
                    leginfo1.setType(haha3.getString("bill_type"));
                    leginfo1.setChamber(haha3.getString("chamber"));
                    leginfo1.setStatus(haha3.getJSONObject("history").getString("active"));
                    leginfo1.setIntroduce(haha3.getString("introduced_on"));
                    leginfo1.setVersion(haha3.getJSONObject("last_version").getString("version_name"));
                    leginfo1.setcURL(haha3.getJSONObject("urls").getString("congress"));
                    leginfo1.setbURL(haha3.getJSONObject("last_version").getJSONObject("urls").getString("pdf"));
                    */

                    leginfo1.setId(haha3.getString("bill_id"));
                    //leginfo1.setId(haha3.getString("bioguide_id"));
                    leginfo1.setSponsor(haha3.getJSONObject("sponsor").getString("title"),haha3.getJSONObject("sponsor").getString("first_name"),haha3.getJSONObject("sponsor").getString("last_name"));
                    leginfo1.setTitle(haha3.getString("official_title"));
                    leginfo1.setType(haha3.getString("bill_type"));
                    leginfo1.setChamber(haha3.getString("chamber"));
                    if(haha3.getJSONObject("history").getString("active") == "true" )
                        leginfo1.setStatus("Active");
                    else
                        leginfo1.setStatus("New");
                    leginfo1.setIntroduce(haha3.getString("introduced_on"));
                    leginfo1.setVersion(haha3.getJSONObject("last_version").getString("version_name"));
                    leginfo1.setcURL(haha3.getJSONObject("urls").getString("congress"));
                    leginfo1.setbURL(haha3.getJSONObject("last_version").getJSONObject("urls").getString("pdf"));


                }
            }
            catch (Exception  e){
                Log.e("TAG", e.toString());
            }
           // publishProgress(20);
            return leginfo1;
        }

        @Override
        protected void onProgressUpdate(Integer... progress) {

            // increment progress bar by progress value
            // progressBar.setProgress(39);
        }

        @Override
        protected void onPostExecute(billinfo var1) {

            //populta layout in here
            billid.setText(leginfo1.getId());
            //Picasso.with(context).load(leginfo1.getImgUrl()).into(legimage1);
            title.setText(leginfo1.getTitle());
            type.setText(leginfo1.getType());
            sponsor.setText(leginfo1.getSponsor());
            chamber.setText(leginfo1.getChamber());
            status.setText(leginfo1.getStatus());

            String temp = leginfo1.getIntroduce();

            String year = temp.substring(0,4);
            String mon  = temp.substring(5,7);
            String day  = temp.substring(8,10);
            int mon1      = Integer.parseInt(mon);

            temp = monthNames[mon1-1] + " " + day + "  " + year;
            introduce.setText(temp);



            cURL.setText(leginfo1.getcURL());
            version.setText(leginfo1.getVersion());
            bURL.setText(leginfo1.getbURL());





            //progressBar.setProgress(39);

        }


    }

}
