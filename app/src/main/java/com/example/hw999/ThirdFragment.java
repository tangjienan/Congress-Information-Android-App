package com.example.hw999;

/**
 * Created by donezio on 11/20/2016.
 */

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

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;

import android.content.Intent;

import org.json.JSONObject;

public class ThirdFragment extends Fragment{


    //View view;
    static public String url1 = String.format("http://sample-env-3.hmyyqcgznb.us-east-1.elasticbeanstalk.com/index.php?type=%s",
            "1");
    //http://104.198.0.197:8080/committees?committee_id=SSCM
    //static public String url1 = String.format("http://congress.api.sunlightfoundation.com/bills?history.active=true&per_page=50");

    static ListView listview1;
    static ListView listview2;
    static ListView listview3;
    static DesignDemoPagerAdapter adapter;
    static public ArrayList<coms> comsList1 = new ArrayList<coms>();
    static public ArrayList<coms> comsList2 = new ArrayList<coms>();
    static public ArrayList<coms> comsList3 = new ArrayList<coms>();
    static comsadapter adapterleg1;
    static comsadapter adapterleg2;
    static comsadapter adapterleg3;
    static ViewPager pager;
    static int flag = 0;
    View result;


    //View view;


    public View onCreateView(LayoutInflater inflater,
                             ViewGroup container,
                             Bundle savedInstanceState) {

        adapter = new DesignDemoPagerAdapter(getChildFragmentManager());
        View result=inflater.inflate(R.layout.thirdfragment, container, false);
        ViewPager pager=(ViewPager)result.findViewById(R.id.viewpager3);
        pager.setAdapter(adapter);
        TabLayout tabLayout = (TabLayout)result.findViewById(R.id.tablayout3);
        tabLayout.setupWithViewPager(pager);
        return(result);
    }


    public static class com2 extends Fragment {
        private static final String TAB_POSITION = "tab_position";
        // public ListView listview2;
        View rootView;

        public com2() {

        }

        public static com2 newInstance(int tabPosition) {
            com2 fragment = new com2();
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
            adapterleg2 = new comsadapter(this.getActivity(),comsList2);
            //not this adapter
            listview2.setAdapter(adapterleg2);
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
                    coms leg1 = (coms) parent.getItemAtPosition(position);
                    //String legid = leg1.getid();


                    String comid = leg1.getComid();
                    String name  = leg1.getComname();
                    String chamber = leg1.getChamber();
                    String comparent = leg1.getParent();
                    String comcontact = leg1.getContact();
                    String comoffice = leg1.getOffice();



                    Intent nextIntent = new Intent(getActivity(), comsdetail.class);

                    nextIntent.putExtra("id", comid);
                    nextIntent.putExtra("name", name);
                    nextIntent.putExtra("chamebr", chamber);
                    nextIntent.putExtra("comparent", comparent);
                    nextIntent.putExtra("comcontact", comcontact);
                    nextIntent.putExtra("comoffice", comoffice);


                    startActivity(nextIntent);
                }
            });


            return rootView;
        }
    }


    public static class com3 extends Fragment {
        private static final String TAB_POSITION = "tab_position";
        // public ListView listview2;
        View rootView;

        public com3() {

        }

        public static com3 newInstance(int tabPosition) {
            com3 fragment = new com3();
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
            listview3 = (ListView)rootView.findViewById(R.id.list23);

            //check global value first!!//
            Collections.sort(comsList3,new nameCom());
            adapterleg3 = new comsadapter(this.getActivity(),comsList3);
            //not this adapter
            listview3.setAdapter(adapterleg3);
            if(flag == 0) {
                new GetData().execute(url1);
                flag = 1;
            }
            listview3.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                    //String  itemValue    = (String) listview1.getItemAtPosition(position);
                    adapterleg3.notifyDataSetChanged();
                    int itemPosition     = position;

                    coms leg1 = (coms) parent.getItemAtPosition(position);

                    String comid = leg1.getComid();
                    String name  = leg1.getComname();
                    String chamber = leg1.getChamber();
                    String comparent = leg1.getParent();
                    String comcontact = leg1.getContact();
                    String comoffice = leg1.getOffice();

                    Intent nextIntent = new Intent(getActivity(), comsdetail.class);
                    nextIntent.putExtra("id", comid);
                    nextIntent.putExtra("name", name);
                    nextIntent.putExtra("chamebr", chamber);
                    nextIntent.putExtra("comparent", comparent);
                    nextIntent.putExtra("comcontact", comcontact);
                    nextIntent.putExtra("comoffice", comoffice);





                    startActivity(nextIntent);
                }
            });


            return rootView;
        }
    }

    public static class com1 extends Fragment {
        private static final String TAB_POSITION = "tab_position";
        // public ListView listview2;
        View rootView;

        public com1(){

        }

        public static com1 newInstance(int tabPosition) {
            com1 fragment = new com1();
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
            adapterleg1 = new comsadapter(this.getActivity(),comsList1);
            //not this adapter
            listview1.setAdapter(adapterleg1);
            if(flag == 0) {
                new GetData().execute(url1);
                flag = 1;
            }
            listview1.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                    //String  itemValue    = (String) listview1.getItemAtPosition(position);
                    adapterleg1.notifyDataSetChanged();
                    int itemPosition     = position;

                    coms leg1 = (coms) parent.getItemAtPosition(position);


                    String comid = leg1.getComid();
                    String name  = leg1.getComname();
                    String chamber = leg1.getChamber();
                    String comparent = leg1.getParent();
                    String comcontact = leg1.getContact();
                    String comoffice = leg1.getOffice();
                    //String comdate  = leg1.get



                    Intent nextIntent = new Intent(getActivity(), comsdetail.class);

                    nextIntent.putExtra("id", comid);
                    nextIntent.putExtra("name", name);
                    nextIntent.putExtra("chamebr", chamber);
                    nextIntent.putExtra("comparent", comparent);
                    nextIntent.putExtra("comcontact", comcontact);
                    nextIntent.putExtra("comoffice", comoffice);



                    startActivity(nextIntent);
                }
            });


            return rootView;
        }
    }













    static class DesignDemoPagerAdapter extends FragmentStatePagerAdapter {

        public DesignDemoPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            switch (position) {
                case 0:
                    return com1.newInstance(1);
                case 1:
                    return com2.newInstance(1);
                case 2:
                    return com3.newInstance(1);
                default:
                    return com3.newInstance(1);
            }
        }

        @Override
        public int getCount() {
            return 3;
        }

        @Override
        public CharSequence getPageTitle(int position) {
            switch (position) {
                case 0:
                    return "HOUSE";
                case 1:
                    return "SENATE";
                default:
                    return "JOINT";
            }

        }
    }

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



                haha = jsonObject.getJSONObject("5");
                haha2 = haha.getJSONObject("results");

                hahaha = jsonObject.getJSONObject("6");
                haha22 = hahaha.getJSONObject("results");

                hahahaha = jsonObject.getJSONObject("7");
                haha222 = hahahaha.getJSONObject("results");

                Iterator x = haha2.keys();
                Iterator x1 = haha22.keys();
                Iterator x11 = haha222.keys();


                while(x11.hasNext()){
                    String key = (String)x11.next();
                    //billarray.put(haha22.get(key));
                    //haha3 = (JSONObject)haha22.get(key);
                    haha3 = (JSONObject)haha222.get(key);  //new api
                    i = i +1;
                    coms bills1 = new coms();
                    bills1.setChamber(haha3.getString("chamber"));
                    bills1.setComid(haha3.getString("committee_id"));
                    bills1.setComname(haha3.getString("name"));
                    bills1.setid(haha3.getString("name"));
                    //bills1.setIntroduce(haha3.getString("introduced_on"));
                    if(haha3.has("parent_committee_id")) {
                        bills1.setParent(haha3.getString("parent_committee_id"));
                    }
                    if(haha3.has("phone")) {
                        bills1.setContact(haha3.getString("phone"));
                    }
                    if(haha3.has("office")) {
                        bills1.setContact(haha3.getString("office"));
                    }
                    comsList3.add(bills1);
                }




                while(x1.hasNext()){
                    String key = (String)x1.next();
                    //billarray.put(haha22.get(key));
                    //haha3 = (JSONObject)haha22.get(key);
                    haha3 = (JSONObject)haha2.get(key);  //new api
                    i = i +1;
                    coms bills1 = new coms();
                    bills1.setChamber(haha3.getString("chamber"));
                    bills1.setComid(haha3.getString("committee_id"));
                    bills1.setComname(haha3.getString("name"));
                    if(haha3.has("parent_committee_id")) {
                        bills1.setParent(haha3.getString("parent_committee_id"));
                    }
                    if(haha3.has("phone")) {
                        bills1.setContact(haha3.getString("phone"));
                    }
                    if(haha3.has("office")) {
                        bills1.setContact(haha3.getString("office"));
                    }
                    comsList1.add(bills1);
                }

                while(x.hasNext()){
                    String key = (String)x.next();
                    //billarray.put(haha2.get(key));
                    haha3 = (JSONObject)haha22.get(key);
                    i = i +1;
                    coms bills1 = new coms();
                    bills1.setChamber(haha3.getString("chamber"));
                    bills1.setComid(haha3.getString("committee_id"));
                    bills1.setComname(haha3.getString("name"));
                    if(haha3.has("parent_committee_id")) {
                        bills1.setParent(haha3.getString("parent_committee_id"));
                    }
                    if(haha3.has("phone")) {
                        bills1.setContact(haha3.getString("phone"));
                    }
                    if(haha3.has("office")) {
                        bills1.setContact(haha3.getString("office"));
                    }
                    //bills1.setid(haha3.getString(""));
                    comsList2.add(bills1);
                }


            } catch (Exception e) {
                Log.e("TAG", e.toString());
            }

            global var2 = new global();
            //var2.setLeg(legislatorList);
            //var2.setBills(billsList1);
            //billsList1 = billsList2;
            return var2;
        }
        @Override
        protected void onPostExecute(global var1) {
            Collections.sort(comsList1,new nameCom());
            Collections.sort(comsList2,new nameCom());
            adapterleg1.notifyDataSetChanged();
            listview1.setAdapter(adapterleg1);
            adapterleg2.notifyDataSetChanged();
            listview2.setAdapter(adapterleg2);
            //adapterleg3.notifyDataSetChanged();
            //listview3.setAdapter(adapterleg3);
            if(listview1.isShown()){
                Log.d("this","this is showm");
            }
            else{
                Log.d("this","this is showm");
            }
        }
    }

    static class nameCom implements Comparator<coms> {
        @Override
        public int compare(coms temp1, coms temp2){
            String t2 = temp2.getComname();
            String t1 = temp1.getComname();
            int i = t1.compareTo(t2 );
            return i;
        }

    }


}
