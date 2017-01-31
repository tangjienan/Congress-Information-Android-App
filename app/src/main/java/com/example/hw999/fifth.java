package com.example.hw999;

/**
 * Created by donezio on 11/30/2016.
 */

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


public class fifth extends Fragment {
    public static fifth newInstance(){
        return new fifth();
    }
    public fifth(){

    }
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fifth, container, false);
    }
}