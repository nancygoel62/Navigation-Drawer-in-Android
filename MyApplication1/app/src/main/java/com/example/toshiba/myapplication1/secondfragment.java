package com.example.toshiba.myapplication1;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by toshiba on 30/4/16.
 */
public class secondfragment extends Fragment {

    View myView;

    @Override
    public  View onCreateView(LayoutInflater inflater, ViewGroup container , Bundle savedInstanceState)
    {
        myView= inflater.inflate(R.layout.layout2, container, false);
        return  myView;
    }
}
