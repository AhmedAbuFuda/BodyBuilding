package com.example.fragments;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.Serializable;
@SuppressWarnings("serial")
public class ExerciseList extends BaseAdapter {
    Context c;
    String[] exercise;
    int[] image;

    public ExerciseList(Context c, String[] exercise, int[] image) {
        this.c = c;
        this.exercise = exercise;
        this.image = image;
    }

    @Override
    public int getCount() {
        return image.length;
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

        myview = f.inflate(R.layout.exercise_list,null);

        TextView textView = myview.findViewById(R.id.exercise_name);
        ImageView imageView = myview.findViewById(R.id.exercise_image);

        textView.setText(exercise[i]);
        imageView.setImageResource(image[i]);

        return myview;
    }
}
