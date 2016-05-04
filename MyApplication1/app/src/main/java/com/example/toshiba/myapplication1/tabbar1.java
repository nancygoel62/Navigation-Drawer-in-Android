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

    String[] name={"China Wall","Colosseum in Rome","Taj","Pyramid of Giza","Hagia Sophia", "Stonehenge"};
    String[] hobby={"China","Rome","India","Egypt","Istanbul", "England"};
    String[] status={"Wall to protect China","Rome a place to live and die","The indian beauty","Pyramids, the place for Mummy","Please google it, its a great place to go", "Beware of stones, Bye!"};

    TypedArray profile_pics;
    List<rowItem> rowItems;
    ListView mylistview , getMylistview;
    int i;
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle bundle) {
        View v = inflater.inflate(R.layout.tabbar1, container, false);
        rowItems = new ArrayList<rowItem>();
    profile_pics=getResources().obtainTypedArray(R.array.Profile_Pics);
        i=0;
        for (i=0;i<6;i++)
        {
            System.out.print(i);
            rowItem item=new rowItem(name[i],profile_pics.getResourceId(i,-1),hobby[i],status[i]);
            rowItems.add(item);
        }

        mylistview=(ListView)v.findViewById(R.id.listview);
        CustomAdapter adapter= new CustomAdapter(v.getContext(), rowItems);
        mylistview.setAdapter(adapter);

        return v;
    }

}