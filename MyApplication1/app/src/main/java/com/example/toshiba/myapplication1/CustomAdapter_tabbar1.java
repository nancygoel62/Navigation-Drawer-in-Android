package com.example.toshiba.myapplication1;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

/**
 * Created by toshiba on 2/5/16.
 */
public class CustomAdapter_tabbar1 extends BaseAdapter {
    Context context;
    List<rowItem_tabbar1> rowItem_tabbar1s;

    CustomAdapter_tabbar1(Context context, List<rowItem_tabbar1> rowItem_tabbar1s)
    {this.context=context;this.rowItem_tabbar1s = rowItem_tabbar1s;}

    @Override
    public int getCount() {
        return rowItem_tabbar1s.size();
    }
    @Override
    public Object getItem(int Position){return rowItem_tabbar1s.get(Position);}
    @Override
    public long getItemId(int Position){return rowItem_tabbar1s.indexOf(getItem(Position));}

    private class ViewHolder{
        ImageView profile_pic;
        TextView name;
        TextView hobby;
        TextView status;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        ViewHolder holder=null;
        final View row;
        LayoutInflater inflater=(LayoutInflater)context.getSystemService(Activity.LAYOUT_INFLATER_SERVICE);
        if(convertView==null)
        {
            convertView = inflater.inflate(R.layout.list_view,null);
            holder=new ViewHolder();

            holder.name= (TextView)convertView.findViewById(R.id.names);
            holder.profile_pic= (ImageView)convertView.findViewById(R.id.profile);
            holder.hobby= (TextView)convertView.findViewById(R.id.hobby);
            holder.status=(TextView)convertView.findViewById(R.id.status);

            rowItem_tabbar1 row_pos= rowItem_tabbar1s.get(position);
            holder.profile_pic.setImageResource(row_pos.getProfile_id());
            holder.name.setText(row_pos.getName());
            holder.hobby.setText(row_pos.getHobby());
            holder.status.setText(row_pos.getStatus());

            if(position%3==0)
                convertView.setBackgroundColor(0xFF08A4A9);
            else if(position%3==1)
                convertView.setBackgroundColor(0xFFCEA10D);
            else if(position%3==2)
            {convertView.setBackgroundColor(0xb70797);holder.name.setTextColor(0xEFAF0476);holder.hobby.setTextColor(0xFF264DB9);}


        }
        else
        {
            row = convertView;
            holder = (ViewHolder) row.getTag();
        }

        return convertView;
    }



}
