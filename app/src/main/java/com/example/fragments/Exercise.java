package com.example.fragments;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.io.Serializable;
import java.util.ArrayList;

public class Exercise extends AppCompatActivity {
    String exercise_name;
    int exercise_image;
    ImageView image,back;
    TextView descreption;
    ListView ls;
    ExerciseList exerciseList;
    int[] img;
    String[] exercise,description;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exercise);
        initComponent();
        getData();
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
    private void initComponent() {
        image = findViewById(R.id.desc_image);
        back =findViewById(R.id.desc_back);
        descreption = findViewById(R.id.desc_text);
        ls = findViewById(R.id.exercise_list);
    }
    public void getData (){
        Bundle saved = getIntent().getExtras();
        exercise_name = saved.getString("exercise_name");
        descreption.setText(exercise_name);
        exercise_image = saved.getInt("exercise_image");
        image.setImageResource(exercise_image);
        img = saved.getIntArray("image");
        exercise = saved.getStringArray("text");
        exerciseList = new ExerciseList(Exercise.this,exercise,img);
        description = saved.getStringArray("desc");
        ls.setAdapter(exerciseList);
        ls.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(Exercise.this,Description.class);
                intent.putExtra("img",img[i]);
                intent.putExtra("name",exercise[i]);
                intent.putExtra("description",description[i]);
                startActivity(intent);
            }
        });
    }
}