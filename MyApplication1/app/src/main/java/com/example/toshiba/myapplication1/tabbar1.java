package com.example.toshiba.myapplication1;

import android.content.res.TypedArray;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by toshiba on 1/5/16.
 */


public class tabbar1 extends Fragment {

    String[] name;
    String[] hobby;
    TypedArray profile_pics;
    List<rowItem> rowItems;
    ListView mylistview;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle bundle) {
        View v = inflater.inflate(R.layout.tabbar1, container, false);
        rowItems = new ArrayList<rowItem>();

        name=getResources().getStringArray(R.array.Names);
        hobby=getResources().getStringArray(R.array.Hobby);
        profile_pics=getResources().obtainTypedArray(R.array.Profile_Pics);

        for (int i=0;i<name.length;i++)
        {
            rowItem item=new rowItem(name[i],profile_pics.getResourceId(i,-1),hobby[i]);
            rowItems.add(item);
        }

        mylistview=(ListView)v.findViewById(R.id.listview);
        CustomAdapter adapter= new CustomAdapter(v.getContext(), rowItems);
        mylistview.setAdapter(adapter);

        return v;
    }

}