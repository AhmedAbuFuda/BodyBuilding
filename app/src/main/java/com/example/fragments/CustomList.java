package com.example.fragments;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class CustomList extends BaseAdapter {
Context c;
String[] s;
int[] img;

    public CustomList(Context c, String[] s, int[] img) {
        this.c = c;
        this.s = s;
        this.img = img;
    }

    @Override
    public int getCount() {
        return img.length;
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 1;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        View myview ;
        LayoutInflater f = (LayoutInflater) c.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        myview = f.inflate(R.layout.custom_list,null);

        TextView textView = myview.findViewById(R.id.exercise_name);
        RelativeLayout relativeLayout = myview.findViewById(R.id.relative);

        textView.setText(s[i]);
        relativeLayout.setBackgroundResource(img[i]);

        return myview;
    }
}
