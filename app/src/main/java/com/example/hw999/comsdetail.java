package com.example.hw999;

import android.support.v7.app.AppCompatActivity;

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

public class comsdetail  extends AppCompatActivity {
    public static String url1;
    public static TextView comid;
    public static TextView comname;
    public static TextView chamber;
    public static TextView parent;
    public static TextView contact;
    public static TextView office;
    public static cominfo leginfo1 = new cominfo();
    public static global var1;
    public static coms favcom;
    public static ImageView star;



    public void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.comsdetail);

        Intent myIntent = getIntent();
        String id = myIntent.getExtras().getString("id");
        String name1 = myIntent.getExtras().getString("name");
        String chamber1 = myIntent.getExtras().getString("chamebr");
        String comaparent1 = myIntent.getExtras().getString("comparent");
        String comcontact1 = myIntent.getExtras().getString("comcontact");
        String comoffice1 = myIntent.getExtras().getString("comoffice");

        favcom = new coms();
        favcom.setComid(id);
        favcom.setChamber(chamber1);
        favcom.setComname(name1);
        favcom.setParent(comaparent1);
        favcom.setContact(comcontact1);
        favcom.setOffice(comoffice1);

        /*
        nextIntent.putExtra("id", comid);
        nextIntent.putExtra("name", name);
        nextIntent.putExtra("chamebr", chamber);
        nextIntent.putExtra("comparent", comparent);
        nextIntent.putExtra("comcontact", comcontact);
        nextIntent.putExtra("comoffice", comoffice);
        */




        star =  (ImageView) findViewById(R.id.star);

        star.setImageResource(R.drawable.star);

        if(var1.FavComList.contains( (favcom) ) ){
            star.setImageResource(R.drawable.fill_star);


        }else {
            Log.d("check", var1.FavlegislatorList.toString());

        }


        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle("Commitees Info");
        setSupportActionBar(toolbar);
        toolbar.setNavigationIcon(R.drawable.left);

        star.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {


                if(var1.FavComList.contains((favcom)) ) {
                    star.setImageResource(R.drawable.star);
                    var1.FavComList.remove(favcom);

                }
                else {
                    var1.FavComList.add(favcom);
                    Log.d("click", var1.FavComList.toString());
                    star.setImageResource(R.drawable.fill_star);
                }
            }
        });





        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();

            }
        });
        url1 = String.format("http://sample-env-3.hmyyqcgznb.us-east-1.elasticbeanstalk.com/index.php?type=2&id=%s",
                id);

        comid = (TextView) findViewById(R.id.comid);
        comid.setText(id);
        comname = (TextView) findViewById(R.id.comname);
        comname.setText(name1);
        chamber = (TextView) findViewById(R.id.chamber);
        chamber.setText(chamber1);
        parent = (TextView) findViewById(R.id.parent);
        parent.setText(comaparent1);
        contact = (TextView) findViewById(R.id.contact);
        contact.setText(comcontact1);
        office = (TextView) findViewById(R.id.office);
        office.setText(comoffice1);




    }



}
