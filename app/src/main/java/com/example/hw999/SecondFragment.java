package com.example.hw999;

/**
 * Created by donezio on 11/20/2016.
 */

import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.design.widget.TabLayout;

import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.GravityCompat;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

public  class SecondFragment extends Fragment {

    //View view;
    static public String url1 = String.format("http://sample-env-3.hmyyqcgznb.us-east-1.elasticbeanstalk.com/index.php?type=%s",
           "1");
    //static public String url1 = String.format("http://congress.api.sunlightfoundation.com/bills?history.active=true&per_page=50");

    static  ListView listview1;
    static  ListView listview2;
    static DesignDemoPagerAdapter adapter;
    static public List<bills> billsList1 = new ArrayList<bills>();
    static public List<bills> billsList2 = new ArrayList<bills>();
    static billsadapter adapterleg1;
    static billsadapter adapterleg2;
    static ViewPager pager;
    static int flag = 0;
    View result;



    //passing variable//
    public static SecondFragment newInstance() {
        return new SecondFragment();
    }

    public SecondFragment() {
    }


    @Nullable
    @Override

    public View onCreateView(LayoutInflater inflater,
                             ViewGroup container,
                             Bundle savedInstanceState) {



        //
        //billsList.add(new bills());
        adapter = new DesignDemoPagerAdapter(getChildFragmentManager());
        result = inflater.inflate(R.layout.secondfragment, container, false);
        pager = (ViewPager) result.findViewById(R.id.viewpager2);
        pager.setAdapter(adapter);
        pager.setCurrentItem(0);
        TabLayout tabLayout = (TabLayout) result.findViewById(R.id.tablayout2);
        tabLayout.setupWithViewPager(pager);

        //Log.d("the second global", var1.get());
        return result;
    }


    public static class bill1 extends Fragment {
        private static final String TAB_POSITION = "tab_position";
        public ListView listview2;
        View rootView;

        public bill1() {

        }

        public static bill1 newInstance(int tabPosition) {
            bill1 fragment = new bill1();
            Bundle args = new Bundle();
            args.putInt(TAB_POSITION, tabPosition);
            fragment.setArguments(args);
            return fragment;
        }

        @Nullable
        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
            Bundle args = getArguments();


            int tabPosition = args.getInt(TAB_POSITION);
            rootView = inflater.inflate(R.layout.leg11, container, false);
            listview1 = (ListView)rootView.findViewById(R.id.list23);

            //check global value first!!//
            adapterleg1 = new billsadapter(this.getActivity(),billsList1);
            //not this adapter
            listview1.setAdapter((adapterleg1));
            if(flag == 0) {
                new GetData().execute(url1);
                flag = 1;
            }
            listview1.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                    Log.d("this is click","ckucj");
                    //String  itemValue    = (String) listview1.getItemAtPosition(position);
                    adapterleg1.notifyDataSetChanged();
                    bills leg1 = (bills) parent.getItemAtPosition(position);
                    String legid = leg1.getId();
                    String date = leg1.getRealIntroduce();
                    String lt   = leg1.getLtitle();
                    String st   = leg1.getStitle();
                    Intent nextIntent = new Intent(getActivity(), billsdetail.class);
                    nextIntent.putExtra("id", legid);
                    nextIntent.putExtra("date", date);
                    nextIntent.putExtra("ltitle", lt);
                    nextIntent.putExtra("stitle", st);

                    startActivity(nextIntent);
                }
            });


            return rootView;
        }


    }


    public static class bill2 extends Fragment {
        private static final String TAB_POSITION = "tab_position";
       // public ListView listview2;
        View rootView;

        public bill2() {

        }

        public static bill2 newInstance(int tabPosition) {
            bill2 fragment = new bill2();
            Bundle args = new Bundle();
            args.putInt(TAB_POSITION, tabPosition);
            fragment.setArguments(args);
            return fragment;
        }

        @Nullable
        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
            Bundle args = getArguments();


            int tabPosition = args.getInt(TAB_POSITION);
            rootView = inflater.inflate(R.layout.leg11, container, false);
            listview2 = (ListView)rootView.findViewById(R.id.list23);

            //check global value first!!//
            adapterleg2 = new billsadapter(this.getActivity(),billsList2);
            //not this adapter
            listview2.setAdapter((adapterleg2));
            if(flag == 0) {
                new GetData().execute(url1);
                flag = 1;
            }
            listview2.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                    //String  itemValue    = (String) listview1.getItemAtPosition(position);
                    adapterleg2.notifyDataSetChanged();
                    int itemPosition     = position;
                    bills leg1 = (bills) parent.getItemAtPosition(position);
                    String legid = leg1.getId();
                    String date = leg1.getRealIntroduce();
                    String lt   = leg1.getLtitle();
                    String st   = leg1.getStitle();
                    Intent nextIntent = new Intent(getActivity(), billsdetail.class);
                    nextIntent.putExtra("id", legid);
                    nextIntent.putExtra("date", date);
                    nextIntent.putExtra("ltitle", lt);
                    nextIntent.putExtra("stitle", st);

                    startActivity(nextIntent);
                }
            });


            return rootView;
        }
    }







    public static class DesignDemoPagerAdapter extends FragmentStatePagerAdapter {

        public DesignDemoPagerAdapter(FragmentManager fm) {
            super(fm);
        }
        @Override
        public int getItemPosition(Object object) {
            // POSITION_NONE makes it possible to reload the PagerAdapter
            return POSITION_NONE;
        }

        @Override
        public Fragment getItem(int position) {
            //return DesignDemoFragment.newInstance(position);
            switch (position) {
                case 0:
                    return bill1.newInstance(1);
                case 1:
                    return bill2.newInstance(1);
                default:
                    return bill1.newInstance(1);
            }
        }

        @Override
        public int getCount() {
            return 2;
        }

        @Override
        //this is the tab title
        public CharSequence getPageTitle(int position) {
            if(position == 0){
                return "Active Bills";
            }
            else{
                return "New Bills";
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
                connection.setReadTimeout(5000);
                connection.setRequestMethod("GET");
                BufferedReader bufferedReader = new BufferedReader(
                        new InputStreamReader(connection.getInputStream()));
                StringBuffer sb = new StringBuffer();
                String str = "";
                while ((str = bufferedReader.readLine()) != null) {
                    // 当读取完毕，就添加到容器中
                    sb.append(str);
                }
                JSONObject jsonObject = new JSONObject(sb.toString());
                //JSONObject jsonObject2 = new JSONObject(sb.toString());
                //JSONObject jsonObject3 = new JSONObject(sb.toString());
                //Log.e("jsonobject", ""+jsonObject.toString());
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



                haha = jsonObject.getJSONObject("3");
                haha2 = haha.getJSONObject("results");

                hahaha = jsonObject.getJSONObject("2");
                haha22 = hahaha.getJSONObject("results");

                Iterator x = haha2.keys();
                Iterator x1 = haha22.keys();





                while(x1.hasNext()){
                    String key = (String)x1.next();
                    //billarray.put(haha22.get(key));
                    //haha3 = (JSONObject)haha22.get(key);
                    haha3 = (JSONObject)haha2.get(key);  //new api
                    i = i +1;
                    bills bills1 = new bills();
                    bills1.setsTitle(haha3.getString("short_title"));
                    bills1.setlTitle(haha3.getString("official_title"));
                    bills1.setBillid(haha3.getString("bill_id"));
                    bills1.setSponsor(haha3.getString("sponsor_id"));
                    bills1.setIntroduce(haha3.getString("introduced_on"));
                    billsList1.add(bills1);
                }

                while(x.hasNext()){
                    String key = (String)x.next();
                    //billarray.put(haha2.get(key));
                    haha3 = (JSONObject)haha22.get(key);
                    i = i +1;
                    bills bills1 = new bills();
                    bills1.setsTitle(haha3.getString("short_title"));
                    bills1.setSponsor(haha3.getString("sponsor_id"));
                    bills1.setlTitle(haha3.getString("official_title"));
                    bills1.setBillid(haha3.getString("bill_id"));
                    bills1.setIntroduce(haha3.getString("introduced_on"));
                    billsList2.add(bills1);
                }


            } catch (Exception e) {
                Log.e("TAG", e.toString());
            }

            global var2 = new global();
            //var2.setLeg(legislatorList);
            var2.setBills(billsList1);
            //billsList1 = billsList2;
            return var2;
        }
        @Override
        protected void onPostExecute(global var1) {
            Collections.sort(billsList1,new dateCom());
            Collections.sort(billsList2,new dateCom());
            adapterleg1.notifyDataSetChanged();
            listview1.setAdapter(adapterleg1);
            adapterleg2.notifyDataSetChanged();
            listview2.setAdapter(adapterleg2);
            if(listview1.isShown()){
                Log.d("this","this is showm");
            }
            else{
                Log.d("this","this is showm");
            }
        }
    }





    static class dateCom implements Comparator<bills> {
        @Override
        public int compare(bills temp1, bills temp2){
          int year = temp1.getYear() - temp2.getYear();
          int month = temp1.getMonth() - temp2.getMonth();
            int day = temp1.getDay() - temp2.getDay();
            if(year !=0){
                if(year > 0){
                    return -1;
                }
                else{
                    return 1;
                }
            }
            else if(month != 0){
                if(month > 1){
                    return -1;
                }
                else{
                    return 1;
                }
            }
            else{
                if(day >=0){
                    return -1;
                }
                else{
                    return 1;
                }
            }
        }

    }
}
