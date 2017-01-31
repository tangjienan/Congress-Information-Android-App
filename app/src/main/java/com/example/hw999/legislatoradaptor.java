package com.example.hw999;

/**
 * Created by donezio on 11/22/2016.
 */


import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import android.widget.ImageView;
import com.android.volley.toolbox.ImageLoader;
import com.android.volley.toolbox.NetworkImageView;
import com.squareup.picasso.Picasso;
import android.util.Log;



import java.util.List;
public class legislatoradaptor extends BaseAdapter {

    private Context context;
    private LayoutInflater inflater;
    private  List<legislator> legislatorListList;

    public legislatoradaptor(Activity context,List<legislator> legislatorListList) {
        this.context = context;
        this.legislatorListList = legislatorListList;
        inflater = LayoutInflater.from(context);
    }


    public int getCount() {
       return legislatorListList.size();
        //return 10;
    }


    public Object getItem(int location) {
        return legislatorListList.get(location);
    }


    public long getItemId(int position) {
        return position;
    }


    public View getView(int position, View convertView, ViewGroup parent) {
        //ViewHolder holder = null;
        if (convertView == null) {
            convertView = inflater.inflate(R.layout.try1, null);
          //  holder = new ViewHolder(convertView);
            //convertView.setTag(holder);
        }
        TextView name = (TextView) convertView.findViewById(R.id.name);
        TextView district = (TextView) convertView.findViewById(R.id.district);
        ImageView image = (ImageView)  convertView.findViewById(R.id.thumbnail);
        legislator m = legislatorListList.get(position);
        name.setText(m.getName());
        district.setText(m.getDisplay());
        Picasso.with(this.context).load(m.getImgUrl()).into(image);
        //Log.e("jsonobject", m.getImgUrl());


        return convertView;
    }

/*
    public static class ViewHolder {
        private TextView name;
        private TextView district;
        private ImageView image;

        public ViewHolder(View v) {
            name = (TextView) v.findViewById(R.id.name);
            image = (ImageView) v.findViewById(R.id.thumbnail);
            district = (TextView) v.findViewById(R.id.district);
        }
    }
   */


}
