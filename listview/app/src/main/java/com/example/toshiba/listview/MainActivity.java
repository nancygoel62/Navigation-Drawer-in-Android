package com.example.toshiba.listview;

import android.app.Activity;
import android.content.res.TypedArray;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends Activity {

    String[] name;
    String[] hobby;
    TypedArray profile_pics;
    List<rowItem> rowItems;
    ListView mylistview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        rowItems = new ArrayList<rowItem>();

        name=getResources().getStringArray(R.array.Names);
        hobby=getResources().getStringArray(R.array.Hobby);
        profile_pics=getResources().obtainTypedArray(R.array.Profile_Pics);

        for (int i=0;i<name.length;i++)
        {
            rowItem item=new rowItem(name[i],profile_pics.getResourceId(i,-1),hobby[i]);
            rowItems.add(item);
        }

        mylistview=(ListView)findViewById(R.id.listview);
        CustomAdapter adapter= new CustomAdapter(this, rowItems);
        mylistview.setAdapter(adapter);

    }
}
