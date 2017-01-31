package com.example.hw999;

/**
 * Created by donezio on 11/24/2016.
 */


import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;



/**
 * Created by donezio on 11/24/2016.
 */
import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.android.volley.toolbox.ImageLoader;
import com.android.volley.toolbox.NetworkImageView;
import java.util.List;
public class billsadapter extends BaseAdapter {

    private Context context;
    private LayoutInflater inflater;
    private List<bills> billsList;

    public billsadapter(Activity context, List<bills> billsList) {
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
            convertView = inflater.inflate(R.layout.try2, null);

        TextView name = (TextView) convertView.findViewById(R.id.name);
        TextView title = (TextView) convertView.findViewById(R.id.title);
        TextView date = (TextView) convertView.findViewById(R.id.date);
        bills m = billsList.get(position);
        name.setText(m.getId());
        title.setText(m.getTitle());
        date.setText(m.getIntroduce());
        return convertView;
    }
}
