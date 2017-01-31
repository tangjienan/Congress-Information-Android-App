package com.example.hw999;

/**
 * Created by donezio on 11/24/2016.
 */
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
public class legdetail extends AppCompatActivity  {

    public static String url1;
    public static leginfo leginfo1 = new leginfo();
    public static TextView name;
    public static ImageView legimage1;
    public static ProgressBar progressBar;
    public static TextView email;
    public static TextView chamber;
    public static TextView contact;
    public static TextView sterm;
    public static TextView eterm;
    public static TextView office;
    public static TextView state;
    public static TextView fax;
    public static TextView birthday;
    public static TextView party1;
    public static ImageView star;
    public static global var1;
    public static legislator favleg1;
    public static ImageView facebook;
    public static ImageView website;
    public static ImageView twitter;
    public static ImageView party;
    public static TextView progress;


    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.legdetail);

        Intent myIntent = getIntent();
        String id = myIntent.getExtras().getString("id");
        String legimg = myIntent.getExtras().getString("image");
        String legdis = myIntent.getExtras().getString("district");
        String legState = myIntent.getExtras().getString("state");
        String first = myIntent.getExtras().getString("first");
        String last = myIntent.getExtras().getString("last");
        String party2 = myIntent.getExtras().getString("party");
        favleg1 = new legislator();

        favleg1.setPic(legimg);
        favleg1.setDistrict(legdis);
        favleg1.setId(id);
        favleg1.setFirst(first);
        favleg1.setLast(last);
        favleg1.setParty(party2);

        favleg1.setState_name(legState);
        Log.d("id",id);
        var1 = new global();
        //var1.FavlegislatorList.add(favleg1);

       url1 = String.format("http://sample-env-3.hmyyqcgznb.us-east-1.elasticbeanstalk.com/index.php?type=2&id=%s",
                id);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);

        //get id
        star =  (ImageView) findViewById(R.id.star);







        party=  (ImageView) findViewById(R.id.party);
        facebook =  (ImageView) findViewById(R.id.facebook);
        twitter =  (ImageView) findViewById(R.id.twitter);
         website =  (ImageView) findViewById(R.id.earth);
        legimage1 =  (ImageView) findViewById(R.id.legimage);
        name = (TextView) findViewById(R.id.name);
        progressBar = (ProgressBar) findViewById(R.id.progressBar1);

        email = (TextView) findViewById(R.id.email);
        chamber  = (TextView) findViewById(R.id.chamber);
        contact  = (TextView) findViewById(R.id.contact);
        party1  = (TextView) findViewById(R.id.party1);
        sterm = (TextView) findViewById(R.id.sterm);
        eterm = (TextView) findViewById(R.id.eterm);
        office =  (TextView) findViewById(R.id.office);
        state =  (TextView) findViewById(R.id.state);
        fax =  (TextView) findViewById(R.id.fax);
        birthday =  (TextView) findViewById(R.id.birthday);
        progress =  (TextView) findViewById(R.id.progressBarinsideText);




       // progressBar.setProgress(100);
        //
        if(var1.FavlegislatorList.contains( (favleg1) ) ){
            star.setImageResource(R.drawable.fill_star);
            Log.d("check", var1.FavlegislatorList.toString());

        }else {
            Log.d("check", var1.FavlegislatorList.toString());
            star.setImageResource(R.drawable.star);
        }

        star.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {


                if(var1.FavlegislatorList.contains((favleg1)) ) {
                    star.setImageResource(R.drawable.star);
                    var1.FavlegislatorList.remove(favleg1);
                    Log.d("click", var1.FavlegislatorList.toString());
                }
                else {
                    var1.FavlegislatorList.add(favleg1);
                    Log.d("click", var1.FavlegislatorList.toString());
                    star.setImageResource(R.drawable.fill_star);
                }
            }
        });

        facebook.setImageResource(R.drawable.facebook);
        twitter.setImageResource(R.drawable.twitter);
        website.setImageResource(R.drawable.earth);

        toolbar.setTitle("Legislator Info");
        new GetData(this).execute(url1);

        setSupportActionBar(toolbar);
        toolbar.setNavigationIcon(R.drawable.left);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();

            }
        });
    }

    public static class GetData extends AsyncTask<String, Integer, leginfo > {

        Context context;
        private GetData(Context context) {
            this.context = context.getApplicationContext();
        }




        protected leginfo doInBackground(String... leginfo) {
            publishProgress(20);
            try {
                URL url = new URL(url1);
                HttpURLConnection connection = (HttpURLConnection) url.openConnection();
                connection.setReadTimeout(50000);
                connection.setRequestMethod("GET");
                BufferedReader bufferedReader = new BufferedReader(
                        new InputStreamReader(connection.getInputStream()));
                StringBuffer sb = new StringBuffer();
                String str = "";
                while ((str = bufferedReader.readLine()) != null) {

                    sb.append(str);
                }
                JSONObject jsonObject = new JSONObject(sb.toString());
                JSONObject haha;
                JSONObject haha2;
                JSONObject haha3;
                haha = jsonObject.getJSONObject("1");
                haha2 = haha.getJSONObject("results");
                Iterator x = haha2.keys();
                while(x.hasNext()){
                    String key = (String)x.next();
                    haha3 = (JSONObject)haha2.get(key);
                    //leginfo leginfo1 = new leginfo();
                    leginfo1.setParty(haha3.getString("party"));
                    leginfo1.setId(haha3.getString("bioguide_id"));
                    leginfo1.setName(haha3.getString("title"),haha3.getString("first_name"),haha3.getString("last_name"));
                    leginfo1.setBirthday(haha3.getString("birthday"));
                    leginfo1.setContact(haha3.getString("phone"));
                    leginfo1.setEmail(haha3.getString("oc_email"));
                    leginfo1.setChamber(haha3.getString("chamber"));
                    leginfo1.setState(haha3.getString("state"));
                    leginfo1.setStart(haha3.getString("term_start"));
                    leginfo1.setEnd(haha3.getString("term_end"));
                    if(haha3.has("office")) {
                        leginfo1.setOffice(haha3.getString("office"));
                    }
                    else{
                        leginfo1.setOffice("N.A");
                    }
                    if(haha3.has("fax")) {
                        leginfo1.setFax(haha3.getString("fax"));
                    }
                    else{
                        leginfo1.setFax("N.A");
                    }
                    if(haha3.has("facebook_id")) {
                        leginfo1.setFacebook(haha3.getString("facebook_id"));
                    }
                    else{
                        leginfo1.setFacebook("no");
                    }
                    if(haha3.has("twitter_id")) {
                        leginfo1.setTwitter(haha3.getString("twitter_id"));
                    }
                    else{
                        leginfo1.setTwitter("no");
                    }
                    if(haha3.has("website")) {
                        leginfo1.setWebsite(haha3.getString("website"));
                    }
                    else{
                        leginfo1.setWebsite("no");
                    }




                }
            }
            catch (Exception  e){
                Log.e("TAG", e.toString());
            }
            publishProgress(20);
            return leginfo1;
        }

        @Override
        protected void onProgressUpdate(Integer... progress) {

            // increment progress bar by progress value
           // progressBar.setProgress(39);
        }

        @Override
        protected void onPostExecute(leginfo var1) {
            //populta layout in here
            name.setText(leginfo1.getName());
            Picasso.with(context).load(leginfo1.getImgUrl()).into(legimage1);

            if(!leginfo1.getEmail().equals("null")) {
                email.setText(leginfo1.getEmail());
            }
            else{
                email.setText("N.A");
            }

            chamber.setText(leginfo1.getChamber());

            if(!leginfo1.getContact().equals("null")) {
                contact.setText(leginfo1.getContact());
            }
            else{
                contact.setText("N.A");
            }
            sterm.setText(leginfo1.getStart());
            eterm.setText(leginfo1.getEnd());


            if(!leginfo1.getOffice().equals("null")) {
                office.setText(leginfo1.getOffice());
            }
            else{
                office.setText("N.A");
            }

            state.setText(leginfo1.getState());


            if(!leginfo1.getFax().equals("null"))
            {fax.setText(leginfo1.getFax());}
            else{
                fax.setText("N.A");
            }
            birthday.setText(leginfo1.getBirthday());
            int temp = leginfo1.getProgress();

            progress.setText(String.valueOf(temp)+"%");

            progressBar.setProgress(leginfo1.getProgress());
            party1.setText(leginfo1.getParty());
            if(leginfo1.getParty().equals("R")) {
                party.setImageResource(R.drawable.r);
            }else {
                party.setImageResource(R.drawable.d);
            }

            website.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                if(leginfo1.getWebsite().equals("no")) {
                    Toast.makeText(context,
                            "No website",
                            Toast.LENGTH_LONG).show();
                }
                else {
                    Intent intent = new Intent();
                    intent.setAction(Intent.ACTION_VIEW);
                    intent.addCategory(Intent.CATEGORY_BROWSABLE);
                    intent.setData(Uri.parse(leginfo1.getWebsite()));
                    intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    context.startActivity(intent);
                    }
                }
            });



            facebook.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    if(leginfo1.getFacebook().equals("no")) {
                        Toast.makeText(context,
                                "No website",
                                Toast.LENGTH_LONG).show();
                    }
                    else {
                        Intent intent = new Intent();
                        intent.setAction(Intent.ACTION_VIEW);
                        intent.addCategory(Intent.CATEGORY_BROWSABLE);
                        intent.setData(Uri.parse(leginfo1.getFacebook()));
                        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                        context.startActivity(intent);
                    }
                }
            });


            twitter.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    if(leginfo1.getFacebook().equals("no")) {
                        Toast.makeText(context,
                                "No website",
                                Toast.LENGTH_LONG).show();
                    }
                    else {
                        Intent intent = new Intent();
                        intent.setAction(Intent.ACTION_VIEW);
                        intent.addCategory(Intent.CATEGORY_BROWSABLE);
                        intent.setData(Uri.parse(leginfo1.getTwitter()));
                        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                        context.startActivity(intent);
                    }
                }
            });









        }


    }
}
