package com.example.fragments;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class Description extends AppCompatActivity {
ImageView img;
TextView textView,textView1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_description);
        img = findViewById(R.id.imageView2);
        textView = findViewById(R.id.textView30);
        textView1 = findViewById(R.id.textView31);
        savedInstanceState = getIntent().getExtras();
        int image = savedInstanceState.getInt("img");
        String desc = savedInstanceState.getString("description");
        String exercise = savedInstanceState.getString("name");
        img.setImageResource(image);
        textView1.setText(exercise);
        textView.setText(desc);
    }
}