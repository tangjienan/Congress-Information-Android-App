package com.example.hw999;

import android.widget.BaseAdapter;

/**
 * Created by donezio on 11/26/2016.
 */



import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;



public class comsadapter  extends BaseAdapter {
    private Context context;
    private LayoutInflater inflater;
    private List<coms> billsList;

    public comsadapter(Activity context, List<coms> billsList) {
        this.context = context;
        this.billsList = billsList;
        inflater = LayoutInflater.from(context);
    }


    public int getCount() {
        return billsList.size();
        //return 10;
    }


    public Object getItem(int location) {
        return billsList.get(location);
    }


    public long getItemId(int position) {
        return position;
    }


    public View getView(int position, View convertView, ViewGroup parent) {

        if (convertView == null)
            convertView = inflater.inflate(R.layout.try3, null);

        TextView comid = (TextView) convertView.findViewById(R.id.comid);
        TextView comname = (TextView) convertView.findViewById(R.id.comname);
        TextView chamber = (TextView) convertView.findViewById(R.id.chamber);
        coms m = billsList.get(position);
        comid.setText(m.getComid());
        comname.setText(m.getComname());
        chamber.setText(m.getChamber());
        return convertView;
    }
}
