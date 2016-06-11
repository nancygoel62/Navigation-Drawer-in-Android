package com.example.nancy.description;

import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class posture_description extends Fragment {
    TextView textView1_description;
    @Override
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);

    }


    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle bundle) {
        View v = inflater.inflate(R.layout.activity_posture_description, container, false);

        textView1_description = (TextView)v.findViewById(R.id.textView1_description);
        String about_text = "  Nancy Goel \n\n Contact :\n nancygoel62@gmail.com ";
        textView1_description.setText(about_text);

        return v;
    }
}