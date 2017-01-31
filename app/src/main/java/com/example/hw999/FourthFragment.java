package com.example.hw999;

/**
 * Created by donezio on 11/20/2016.
 */

import android.content.Intent;
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
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;


public class FourthFragment extends Fragment{
    static ListView listview1;
    static ListView listview2;
    static ListView listview3;
    static legislatoradaptor adapterleg;
    static comsadapter adaptercom;
    static billsadapter adapterbill;
    //static List<legislator> favleg;
    static List<bills> favbill;
    static List<coms> favcom;
    static Map<String, Integer> mapIndex1;
    //View view;
    DesignDemoPagerAdapter adapter;

    public View onCreateView(LayoutInflater inflater,
                             ViewGroup container,
                             Bundle savedInstanceState) {











        favbill = new global().getFavBill();
        Collections.sort(favbill,new dateCom());
        adapterbill = new billsadapter(this.getActivity(),favbill);

        favcom = new global().getFavCom();
        Collections.sort(favcom,new nameCom2());
        adaptercom = new comsadapter(this.getActivity(),favcom);


        adapter = new DesignDemoPagerAdapter(getChildFragmentManager());
        View result=inflater.inflate(R.layout.fourthfragment, container, false);
        ViewPager pager=(ViewPager)result.findViewById(R.id.viewpager4);
        pager.setAdapter(adapter);
        TabLayout tabLayout = (TabLayout)result.findViewById(R.id.tablayout4);
        tabLayout.setupWithViewPager(pager);
        return(result);
    }






    public static class leg11 extends Fragment {
        private static final String TAB_POSITION = "tab_position";
        // private ArrayAdapter<String> listAdapter;
        //public legislatoradaptor adapter;
        View rootView;
        public ListView listview2;
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
            List<legislator> favleg =  new global().getFavLeg();
            Collections.sort(favleg,new nameCom());
            adapterleg = new legislatoradaptor(this.getActivity(),favleg);

            super.onCreateView(inflater, container, savedInstanceState);
            Log.d("oncreateview is called", "called");
            int tabPosition = args.getInt(TAB_POSITION);

            //sor the legislatorList in here//
            //adapterleg.notifyDataSetChanged();
            //end sorting
            rootView = inflater.inflate(R.layout.leg111, container, false);
            listview1 = (ListView)rootView.findViewById(R.id.list23);
            listview1.setAdapter((adapterleg));
            Log.d("chang!!","oh change");



            listview1.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                    //String  itemValue    = (String) listview1.getItemAtPosition(position);
                    adapterleg.notifyDataSetChanged();
                    int itemPosition     = position;
                    legislator leg1 = (legislator) parent.getItemAtPosition(position);
                    String legid = leg1.getId();
                    Intent nextIntent = new Intent(getActivity(), legdetail.class);
                    nextIntent.putExtra("id", legid);
                    startActivity(nextIntent);
                }
            });

            adapterleg.notifyDataSetChanged();
            //getIndexList(favleg);
            //displayIndex(rootView);


            return rootView;
        }


        @Override
        public  void onResume() {
            super.onResume();
            //Log.d("remsuclled","dasd");
            List<legislator> favleg1 =  new global().getFavLeg();
            //getIndexList(favleg1);
            //displayIndex(rootView);
            adapterleg.notifyDataSetChanged();
            getIndexList(favleg1);
            displayIndex(rootView);
        }







        private void getIndexList(List<legislator> fruits) {
            mapIndex1 = new LinkedHashMap<String, Integer>();
            for (int i = 0; i < fruits.size(); i++) {
                String fruit = fruits.get(i).getlast();
                String index = fruit.substring(0, 1);

                if (mapIndex1.get(index) == null)
                    mapIndex1.put(index, i);
            }
        }
        private void displayIndex(View v1) {
            LinearLayout indexLayout = (LinearLayout) rootView.findViewById(R.id.side_index);
            indexLayout.removeAllViews();
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


    public static class bill1 extends Fragment {
        private static final String TAB_POSITION = "tab_position";
        //public ListView listview2;
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
            listview2 = (ListView)rootView.findViewById(R.id.list23);

            //check global value first!!//
            adapterbill = new billsadapter(this.getActivity(),favbill);
            //not this adapter
            listview2.setAdapter((adapterbill));


            listview2.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                    //String  itemValue    = (String) listview1.getItemAtPosition(position);
                    adapterbill.notifyDataSetChanged();
                    bills leg1 = (bills) parent.getItemAtPosition(position);
                    String legid = leg1.getId();
                    Intent nextIntent = new Intent(getActivity(), billsdetail.class);
                    nextIntent.putExtra("id", legid);
                    startActivity(nextIntent);
                }
            });


            return rootView;
        }

        @Override
        public  void onResume() {
            super.onResume();
            adapterbill.notifyDataSetChanged();
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
            listview3 = (ListView)rootView.findViewById(R.id.list23);

            //check global value first!!//
            //adaptercom = new comsadapter(this.getActivity(),comsList1);
            adaptercom = new comsadapter(this.getActivity(),favcom);
            //not this adapter
            listview3.setAdapter(adaptercom);

            listview3.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                    //String  itemValue    = (String) listview1.getItemAtPosition(position);
                    adaptercom.notifyDataSetChanged();
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
        @Override
        public  void onResume() {
            super.onResume();
            adaptercom.notifyDataSetChanged();
        }
    }


    static class DesignDemoPagerAdapter extends FragmentStatePagerAdapter {

        public DesignDemoPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            //Log.d("getItem",Integer.toString(position) );
            //return leg11.newInstance(position);
            switch (position) {
                case 0:
                    return leg11.newInstance(1);
                case 1:
                    return bill1.newInstance(1);
                case 2:
                    return com1.newInstance(1);
                default:
                    return bill1.newInstance(1);
            }
        }

        @Override
        public int getCount() {
            return 3;
        }

        @Override
        public CharSequence getPageTitle(int position) {
            switch (position){
                case 0:
                    return "Legislator";
                case 1:
                    return "BILLS";
                case 2:
                    return "COMMITTEES";
                default:
                    return "default";
            }
        }
    }


    static class nameCom implements Comparator<legislator> {
        @Override
        public int compare(legislator temp1, legislator temp2){
            String t2 = temp2.getLast_name();
            String t1 = temp1.getLast_name();
            int i = t1.compareTo(t2 );
            return i;
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

    static class nameCom2 implements Comparator<coms> {
        @Override
        public int compare(coms temp1, coms temp2){
            String t2 = temp2.getComname();
            String t1 = temp1.getComname();
            int i = t1.compareTo(t2 );
            return i;
        }

    }



}
