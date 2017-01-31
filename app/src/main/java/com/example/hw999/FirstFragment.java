package com.example.hw999;

import android.os.Bundle;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.List;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.SearchViewCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
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
import android.support.v7.app.ActionBar;
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
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Iterator;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;
import java.util.List;
import java.util.Map;

import android.util.Log;
import android.widget.AdapterView;
import android.content.Intent;
/**
 * Created by donezio on 11/24/2016.
 */

public  class FirstFragment extends Fragment {

    //View view;
    static public String url1 = String.format("http://sample-env-3.hmyyqcgznb.us-east-1.elasticbeanstalk.com/index.php?type=%s","1");
    static ListView listview1;
    static ListView listview2;
    static ListView listview3;
    //static public View rootView;
    static DesignDemoPagerAdapter adapter;
    static public List<legislator> legislatorList = new ArrayList<legislator>();
    static public List<legislator> senateList = new ArrayList<legislator>();
    static public List<legislator> houseList = new ArrayList<legislator>();
    static public List<bills> billsList = new ArrayList<bills>();
    static legislatoradaptor adapterleg;
    static legislatoradaptor adapterleg2;
    static legislatoradaptor adapterleg3;
    static ViewPager pager;
    static Map<String, Integer> mapIndex1;
    static Map<String, Integer> mapIndex2;
    static Map<String, Integer> mapIndex3;
    static public int call = 0;
    static  public int set = 0;
    View result;
    static global var1 = new global();
    //passing variable//
    public static FirstFragment newInstance() {
        return new FirstFragment();
    }
    public FirstFragment() {
    }
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater,
                             ViewGroup container,
                             Bundle savedInstanceState) {
        //
        //legislatorList.add(new legislator());


        adapterleg = new legislatoradaptor(this.getActivity(),legislatorList);
        adapterleg2 = new legislatoradaptor(this.getActivity(),senateList);
        adapterleg3 = new legislatoradaptor(this.getActivity(),houseList);




        adapter = new DesignDemoPagerAdapter(getChildFragmentManager());
        result = inflater.inflate(R.layout.firstfragment, container, false);
        pager = (ViewPager) result.findViewById(R.id.viewpager1);
        pager.setAdapter(adapter);
        //pager.setOffscreenPageLimit(3);
        //listview1.setAdapter((adapterleg));
        TabLayout tabLayout = (TabLayout) result.findViewById(R.id.tablayout1);
        tabLayout.setupWithViewPager(pager);
        pager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float
                    positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {

                if(position == 0){
                    Log.d("position and sort",Integer.toString(position));
                    //Collections.sort(legislatorList,new stateCom());
                    //adapterleg.notifyDataSetChanged();
                }
                else if(position == 1){
                    Log.d("position and sort",Integer.toString(position));
                    //Collections.sort(legislatorList,new nameCom());
                    //adapterleg.notifyDataSetChanged();
                }
                else{
                    Log.d("position and sort",Integer.toString(position));

                    //adapterleg.notifyDataSetChanged();
                    adapterleg2.notifyDataSetChanged();

                }
            }
            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

       //Log.d("the second global", var1.get());
        return result;
    }
    public static class leg11 extends Fragment{
        private static final String TAB_POSITION = "tab_position";
       // private ArrayAdapter<String> listAdapter;
        //public legislatoradaptor adapter;
       View rootView;
        View rooView1;
        Activity v1 = this.getActivity();
        //public ListView listview2;
        //View rootView;

        public leg11() {

        }

        public static leg11 newInstance(int tabPosition) {

           // Log.d("new instance", "called");
            leg11 fragment = new leg11();
            Bundle args = new Bundle();
            args.putInt(TAB_POSITION, tabPosition);
            fragment.setArguments(args);
            return fragment;
        }

        @Nullable
        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
            //pager.setAdapter(adapter);
            Bundle args = getArguments();
            super.onCreateView(inflater, container, savedInstanceState);
            Log.d("oncreateview is called", "called");
            int tabPosition = args.getInt(TAB_POSITION);

            //sor the legislatorList in here//
            //adapterleg.notifyDataSetChanged();
            //end sorting
            rootView = inflater.inflate(R.layout.leg111, container, false);
            listview1 = (ListView)rootView.findViewById(R.id.list23);
            listview1.setAdapter((adapterleg));
            //Log.d("chang!!","oh change");



            listview1.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                    //String  itemValue    = (String) listview1.getItemAtPosition(position);
                    adapterleg.notifyDataSetChanged();
                    int itemPosition     = position;
                    legislator leg1 = (legislator) parent.getItemAtPosition(position);
                    String legid = leg1.getId();
                    String legimg = leg1.getImgUrl();
                    String legdis = leg1.getDistrict();
                    String legf = leg1.getfirst();
                    String legl = leg1.getlast();
                    String legstate = leg1.getState_name();
                    String party = leg1.getParty();
                    Log.d("id",legid);
                    Intent nextIntent = new Intent(getActivity(), legdetail.class);
                    nextIntent.putExtra("id", legid);
                    nextIntent.putExtra("image", legimg);
                    nextIntent.putExtra("district", legdis);
                    nextIntent.putExtra("last",legl);
                    nextIntent.putExtra("first",legf);
                    nextIntent.putExtra("state",legstate);
                    nextIntent.putExtra("party",party);
                    startActivity(nextIntent);
                }
            });
            if(call == 0) {
                new GetData().execute(url1);
                call = 1;
            }

            getIndexList(legislatorList);

            displayIndex(rootView);

            return rootView;
        }

        private void getIndexList(List<legislator> fruits) {
            mapIndex1 = new LinkedHashMap<String, Integer>();
            for (int i = 0; i < fruits.size(); i++) {
                String fruit = fruits.get(i).getState();
                String index = fruit.substring(0, 1);

                if (mapIndex1.get(index) == null)
                    mapIndex1.put(index, i);
            }
        }
        private void displayIndex(View v1) {
            LinearLayout indexLayout = (LinearLayout) rootView.findViewById(R.id.side_index);

            TextView textView;
            List<String> indexList = new ArrayList<String>(mapIndex1.keySet());
            for (String index : indexList) {
                textView = (TextView)getActivity().getLayoutInflater().inflate(
                        R.layout.side_index_item, null);
                textView.setText(index);
                textView.setOnClickListener(new View.OnClickListener(){
                    @Override
                    public void onClick(View v){
                        TextView selectedIndex = (TextView) v;
                        listview1.setSelection(mapIndex1.get(selectedIndex.getText()));
                    }

                });
                textView.setTextSize(8);
                indexLayout.addView(textView);
            }
        }






    }







    public static class leg12 extends Fragment {
        private static final String TAB_POSITION = "tab_position";
        // private ArrayAdapter<String> listAdapter;
        //public legislatoradaptor adapter;
        View rootView;
        //public ListView listview2;
        //View rootView;

        public leg12() {

        }

        public static leg12 newInstance(int tabPosition) {

            // Log.d("new instance", "called");
            leg12 fragment = new leg12();
            Bundle args = new Bundle();
            args.putInt(TAB_POSITION, tabPosition);
            fragment.setArguments(args);
            return fragment;
        }

        @Nullable
        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
            //pager.setAdapter(adapter);
            Bundle args = getArguments();
            super.onCreateView(inflater, container, savedInstanceState);
            Log.d("oncreateview is called", "called");
            int tabPosition = args.getInt(TAB_POSITION);

            //sor the legislatorList in here//
            //adapterleg.notifyDataSetChanged();
            //end sorting
            rootView = inflater.inflate(R.layout.leg111, container, false);
            listview2 = (ListView)rootView.findViewById(R.id.list23);
            listview2.setAdapter((adapterleg2));
            Log.d("chang!!","oh change");



            listview2.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                    //String  itemValue    = (String) listview1.getItemAtPosition(position);
                    adapterleg2.notifyDataSetChanged();
                    int itemPosition     = position;
                    legislator leg1 = (legislator) parent.getItemAtPosition(position);
                    String legid = leg1.getId();
                    String legimg = leg1.getImgUrl();
                    String legdis = leg1.getDistrict();
                    String legf = leg1.getfirst();
                    String legl = leg1.getlast();
                    String legstate = leg1.getState_name();
                    String party = leg1.getParty();
                    Log.d("id",legid);
                    Intent nextIntent = new Intent(getActivity(), legdetail.class);
                    nextIntent.putExtra("id", legid);

                    nextIntent.putExtra("image", legimg);
                    nextIntent.putExtra("district", legdis);
                    nextIntent.putExtra("last",legl);
                    nextIntent.putExtra("first",legf);
                    nextIntent.putExtra("state",legstate);
                    nextIntent.putExtra("party",party);
                    startActivity(nextIntent);
                }
            });
            if(call == 0) {
                new GetData().execute(url1);
                call = 1;
            }

            getIndexList(senateList);

            displayIndex(rootView);
            return rootView;
        }

        private void getIndexList(List<legislator> fruits) {
            mapIndex2 = new LinkedHashMap<String, Integer>();
            for (int i = 0; i < fruits.size(); i++) {
                String fruit = fruits.get(i).getLast_name();
                String index = fruit.substring(0, 1);

                if (mapIndex2.get(index) == null)
                    mapIndex2.put(index, i);
            }
        }
        private void displayIndex(View v1) {
            LinearLayout indexLayout = (LinearLayout) rootView.findViewById(R.id.side_index);

            TextView textView;
            List<String> indexList = new ArrayList<String>(mapIndex2.keySet());
            for (String index : indexList) {
                textView = (TextView)getActivity().getLayoutInflater().inflate(
                        R.layout.side_index_item, null);
                textView.setText(index);
                textView.setOnClickListener(new View.OnClickListener(){
                    @Override
                    public void onClick(View v){
                        TextView selectedIndex = (TextView) v;
                        listview2.setSelection(mapIndex2.get(selectedIndex.getText()));
                    }

                });
                textView.setTextSize(8);
                indexLayout.addView(textView);
            }
        }

    }



    public static class leg13 extends Fragment {
        private static final String TAB_POSITION = "tab_position";
        // private ArrayAdapter<String> listAdapter;
        //public legislatoradaptor adapter;
        View rootView;
        //public ListView listview2;
        //View rootView;

        public leg13() {

        }

        public static leg13 newInstance(int tabPosition) {

            // Log.d("new instance", "called");
            leg13 fragment = new leg13();
            Bundle args = new Bundle();
            args.putInt(TAB_POSITION, tabPosition);
            fragment.setArguments(args);
            return fragment;
        }

        @Nullable
        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
            //pager.setAdapter(adapter);
            Bundle args = getArguments();
            super.onCreateView(inflater, container, savedInstanceState);
            Log.d("oncreateview is called", "called");
            int tabPosition = args.getInt(TAB_POSITION);

            //sor the legislatorList in here//
            //adapterleg.notifyDataSetChanged();
            //end sorting
            rootView = inflater.inflate(R.layout.leg111, container, false);
            listview3 = (ListView)rootView.findViewById(R.id.list23);
            listview3.setAdapter((adapterleg3));
            Log.d("chang!!","oh change");



            listview3.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                    //String  itemValue    = (String) listview1.getItemAtPosition(position);
                    adapterleg3.notifyDataSetChanged();
                    int itemPosition     = position;
                    legislator leg1 = (legislator) parent.getItemAtPosition(position);
                    String legid = leg1.getId();
                    String legimg = leg1.getImgUrl();
                    String legdis = leg1.getDistrict();
                    String legf = leg1.getfirst();
                    String legl = leg1.getlast();
                    String legstate = leg1.getState_name();
                    String party = leg1.getParty();
                    Log.d("id",legid);
                    Intent nextIntent = new Intent(getActivity(), legdetail.class);
                    nextIntent.putExtra("id", legid);
                    nextIntent.putExtra("image", legimg);
                    nextIntent.putExtra("district", legdis);
                    nextIntent.putExtra("last",legl);
                    nextIntent.putExtra("first",legf);
                    nextIntent.putExtra("state",legstate);
                    nextIntent.putExtra("party",party);

                    startActivity(nextIntent);
                }
            });
            if(call == 0) {
                new GetData().execute(url1);
                call = 1;
            }

            getIndexList(houseList);

            displayIndex(rootView);


            return rootView;
        }

        private void getIndexList(List<legislator> fruits) {
            mapIndex3 = new LinkedHashMap<String, Integer>();
            for (int i = 0; i < fruits.size(); i++) {
                String fruit = fruits.get(i).getLast_name();
                String index = fruit.substring(0, 1);

                if (mapIndex3.get(index) == null)
                    mapIndex3.put(index, i);
            }
        }
        private void displayIndex(View v1) {
            LinearLayout indexLayout = (LinearLayout) rootView.findViewById(R.id.side_index);

            TextView textView;
            List<String> indexList = new ArrayList<String>(mapIndex3.keySet());
            for (String index : indexList) {
                textView = (TextView)getActivity().getLayoutInflater().inflate(
                        R.layout.side_index_item, null);
                textView.setText(index);
                textView.setOnClickListener(new View.OnClickListener(){
                    @Override
                    public void onClick(View v){
                        TextView selectedIndex = (TextView) v;
                        listview3.setSelection(mapIndex3.get(selectedIndex.getText()));
                    }

                });
                textView.setTextSize(8);
                indexLayout.addView(textView);
            }
        }

    }







    public static class DesignDemoPagerAdapter extends FragmentStatePagerAdapter {

            public DesignDemoPagerAdapter(FragmentManager fm) {
                super(fm);
            }


            @Override
            public Fragment getItem(int position) {
                //Log.d("getItem",Integer.toString(position) );
                //return leg11.newInstance(position);
                switch (position) {
                    case 0:
                        return leg11.newInstance(position);
                    case 1:
                        return leg13.newInstance(position);
                    case 2:
                        return leg12.newInstance(position);
                    default:
                        return leg11.newInstance(position);
                }
            }

            @Override
            public int getCount() {
                return 3;
            }

            @Override
            //this is the tab title
            public CharSequence getPageTitle(int position) {
                //return "Tab " + position;
                switch (position){
                    case 0:
                        return "By State";
                    case 1:
                        return "By House";
                    case 2:
                        return "By Senate";
                    default:
                        return "default";
                }
            }
        }

    //create leg11 fragment




    public static class GetData extends AsyncTask<String, Void, global > {
        int i = 0;

        @Override
        protected global doInBackground(String... global) {
            try {
                URL url = new URL(url1);
                HttpURLConnection connection = (HttpURLConnection) url.openConnection();
               // connection.setReadTimeout(5000);
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
                //bills
                JSONObject hahaha;
                JSONObject haha22;
                JSONObject haha33;
                //committee
                JSONObject hahahaha;
                JSONObject haha222;
                JSONObject haha333;

                haha = jsonObject.getJSONObject("1");
                haha2 = haha.getJSONObject("results");
                hahaha = jsonObject.getJSONObject("2");
                haha22 = hahaha.getJSONObject("results");
                Iterator x = haha2.keys();
                Iterator x1 = haha22.keys();
                JSONArray legarray = new JSONArray();
                JSONArray billarray = new JSONArray();
                while(x1.hasNext()){
                    String key = (String)x1.next();
                    billarray.put(haha22.get(key));
                    haha3 = (JSONObject)haha22.get(key);
                    i = i +1;
                    bills bills1 = new bills();
                    if(haha3.has("shor_title")) {
                        bills1.setsTitle(haha3.getString("short_title"));
                    }
                    if(haha3.has("official_title")) {
                        bills1.setlTitle(haha3.getString("official_title"));
                    }
                    bills1.setBillid(haha3.getString("bill_id"));
                    bills1.setIntroduce(haha3.getString("introduced_on"));
                    billsList.add(bills1);
                }

                //x.hasNext() == true
                while(x.hasNext()){
                    String key = (String)x.next();
                    legarray.put(haha2.get(key));
                    haha3 = (JSONObject)haha2.get(key);
                    i = i +1;
                    legislator legislator1 = new legislator();
                    legislator1.setFirst(haha3.getString("first_name"));
                    legislator1.setChamber(haha3.getString("chamber"));
                    legislator1.setLast(haha3.getString("last_name"));
                    legislator1.setDistrict(haha3.getString("district"));
                    legislator1.setId(haha3.getString("bioguide_id"));
                    legislator1.setParty(haha3.getString("party"));
                    legislator1.setState(haha3.getString("state"));
                    legislator1.setState_name(haha3.getString("state_name"));


                    legislator1.setPic(haha3.getString("party"));
                    legislatorList.add(legislator1);
                    if(legislator1.getChamber().equals("house")){
                        houseList.add(legislator1);
                    }
                    else{
                        senateList.add(legislator1);
                       // houseList.add(legislator1);
                    }
                }
            } catch (Exception e) {
                Log.e("TAG", e.toString());
            }
            global var2 = new global();
            var2.setLeg(legislatorList);
            var2.setBills(billsList);
            return var2;
        }
        @Override
        protected void onPostExecute(global var1){



            Collections.sort(legislatorList,new stateCom());
            adapterleg.notifyDataSetChanged();
            listview1.setAdapter(adapterleg);
            adapterleg.notifyDataSetChanged();

            Collections.sort(houseList,new nameCom2());
            adapterleg3.notifyDataSetChanged();
            listview3.setAdapter(adapterleg3);
            adapterleg3.notifyDataSetChanged();
            Collections.sort(senateList,new nameCom2());
            // listview3.setAdapter(adapterleg3);
            /*
            adapterleg3.notifyDataSetChanged();
            listview3.setAdapter(adapterleg3);

            */
            //adapterleg3.notifyDataSetChanged();

            pager.setAdapter(adapter);

            if(listview1.isShown()){
                Log.d("this","this is showm");
            }
            else{
                Log.d("this","this is showm");
            }
        }
    }


    static class stateCom implements Comparator<legislator> {
        @Override
        public int compare(legislator temp1, legislator temp2){
            String t2 = temp2.getState();
            String t1 = temp1.getState();
            int i = t1.compareTo(t2 );
            if(i != 0 ) {
                return i;
            }else{
              String t3 = temp2.getName();
                String t4 = temp1.getName();
                return t4.compareTo(t3);
            }
        }
    }
    static class nameCom implements Comparator<legislator> {
        @Override
        public int compare(legislator temp1, legislator temp2){
            String t2 = temp2.getlast();
            String t1 = temp1.getlast();
            int i = t1.compareTo(t2 );
            return i;
        }

    }
    static class nameCom2 implements Comparator<legislator> {
        @Override
        public int compare(legislator temp1, legislator temp2){
            String t2 = temp2.getLast_name();
            String t1 = temp1.getLast_name();
            int i = t1.compareTo(t2 );
            return i;
        }

    }
    static class partyCom implements Comparator<legislator> {
        @Override
        public int compare(legislator temp1, legislator temp2){
            String t2 = temp2.getId();
            String t1 = temp1.getId();
            int i = t1.compareTo(t2 );
            return i;
        }

    }



}
/*

*/