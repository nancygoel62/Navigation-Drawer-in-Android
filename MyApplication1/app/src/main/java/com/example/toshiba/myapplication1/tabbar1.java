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
    String[] status={" Worlds largest wall, to protect China","Rome a place to live and die","The indian beauty","Pyramids, the place for Mummy","Please google it, its a great place to go", "Beware of stones, Bye!"};

    TypedArray profile_pics;
    List<rowItem> rowItems;
    ListView mylistview , getMylistview;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle bundle) {
        View v = inflater.inflate(R.layout.tabbar1, container, false);
        rowItems = new ArrayList<rowItem>();
    profile_pics=getResources().obtainTypedArray(R.array.Profile_Pics);

        rowItem item=new rowItem(name[0],profile_pics.getResourceId(0,-1),hobby[0],status[0]);
        rowItems.add(item);
        item=new rowItem(name[1],profile_pics.getResourceId(1,-1),hobby[1],status[1]);
        rowItems.add(item);
        item=new rowItem(name[2],profile_pics.getResourceId(2,-1),hobby[2],status[2]);
        rowItems.add(item);
        item=new rowItem(name[3],profile_pics.getResourceId(3,-1),hobby[3],status[3]);
        rowItems.add(item);
        item=new rowItem(name[4],profile_pics.getResourceId(4,-1),hobby[4],status[4]);
        rowItems.add(item);
        item=new rowItem(name[5],profile_pics.getResourceId(5,-1),hobby[5],status[5]);
        rowItems.add(item);

        mylistview=(ListView)v.findViewById(R.id.listview);
        CustomAdapter adapter= new CustomAdapter(v.getContext(), rowItems);
        mylistview.setAdapter(adapter);

        return v;
    }

}