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
    List<rowItem_tabbar1> rowItem_tabbar1s;
    ListView mylistview , getMylistview;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle bundle) {
        View v = inflater.inflate(R.layout.tabbar1, container, false);
        rowItem_tabbar1s = new ArrayList<rowItem_tabbar1>();
    profile_pics=getResources().obtainTypedArray(R.array.Profile_Pics);

        rowItem_tabbar1 item=new rowItem_tabbar1(name[0],profile_pics.getResourceId(0,-1),hobby[0],status[0]);
        rowItem_tabbar1s.add(item);
        item=new rowItem_tabbar1(name[1],profile_pics.getResourceId(1,-1),hobby[1],status[1]);
        rowItem_tabbar1s.add(item);
        item=new rowItem_tabbar1(name[2],profile_pics.getResourceId(2,-1),hobby[2],status[2]);
        rowItem_tabbar1s.add(item);
        item=new rowItem_tabbar1(name[3],profile_pics.getResourceId(3,-1),hobby[3],status[3]);
        rowItem_tabbar1s.add(item);
        item=new rowItem_tabbar1(name[4],profile_pics.getResourceId(4,-1),hobby[4],status[4]);
        rowItem_tabbar1s.add(item);
        item=new rowItem_tabbar1(name[5],profile_pics.getResourceId(5,-1),hobby[5],status[5]);
        rowItem_tabbar1s.add(item);

        mylistview=(ListView)v.findViewById(R.id.listview);
        CustomAdapter_tabbar1 adapter= new CustomAdapter_tabbar1(v.getContext(), rowItem_tabbar1s);
        mylistview.setAdapter(adapter);

        return v;
    }

}