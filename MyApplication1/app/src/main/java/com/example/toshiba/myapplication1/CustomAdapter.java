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
public class CustomAdapter extends BaseAdapter {
    Context context;
    List<rowItem> rowItems;
    CustomAdapter(Context context, List<rowItem> rowItems)
    {this.context=context;this.rowItems=rowItems;}

    @Override
    public int getCount() {
        return rowItems.size();
    }
    @Override
    public Object getItem(int Position){return rowItems.get(Position);}
    @Override
    public long getItemId(int Position){return rowItems.indexOf(getItem(Position));}

    private class ViewHolder{
        ImageView profile_pic;
        TextView name;
        TextView hobby;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        ViewHolder holder=null;

        LayoutInflater inflater=(LayoutInflater)context.getSystemService(Activity.LAYOUT_INFLATER_SERVICE);
        if(convertView==null)
        {
            convertView = inflater.inflate(R.layout.list_view,null);
            holder=new ViewHolder();

            holder.name= (TextView)convertView.findViewById(R.id.names);

            holder.profile_pic= (ImageView)convertView.findViewById(R.id.profile);
            holder.hobby= (TextView)convertView.findViewById(R.id.hobby);

            rowItem row_pos= rowItems.get(position);
            holder.profile_pic.setImageResource(row_pos.getProfile_id());
            holder.name.setText(row_pos.getName());
            holder.hobby.setText(row_pos.getHobby());
        }
        return convertView;
    }



}
