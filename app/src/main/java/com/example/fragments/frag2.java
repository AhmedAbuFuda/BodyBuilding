package com.example.fragments;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class frag2 extends Fragment {
    View view;
    ListView ls;
    String[] days, exercise_day1, exercise_day2, exercise_day3, exercise_day4, exercise_day5, exercise_day6;
    String[] description_day1, description_day2, description_day3, description_day4, description_day5, description_day6;
    int[] img_day1 ={R.drawable.leg_raise,R.drawable.plank2,R.drawable.hip_extensions_left_side,R.drawable.hip_extensions_left_side,
    R.drawable.march_in_place};
    int[] img_day2 = {R.drawable.tricep_kickbacks,R.drawable.sumo_squat,R.drawable.stiff_legged_deadlift,R.drawable.heel_touches,
            R.drawable.high_knees_in_place};
    int[] img_day3 = {R.drawable.goblet_squat,R.drawable.knee_touches_in_place,R.drawable.tricep_kickbacks,R.drawable.rear_leg_extension_left_leg,
            R.drawable.rear_leg_extension_right_leg};
    int[] img_day4 = {R.drawable.rest_day,R.drawable.walk};
    int[] img_day5 = {R.drawable.march_in_place,R.drawable.traditional_crunch,R.drawable.chair_squat,R.drawable.wall_pushup,R.drawable.bodyweight_glute_bridge};
    int[] img_day6 = {R.drawable.toe_reach,R.drawable.alternating_lunges,R.drawable.lying_oblique_twis,R.drawable.body_weight_squat,R.drawable.high_knees_in_place};

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.frag2,container,false);

        ls = view.findViewById(R.id.list);
        getData();
        ArrayAdapter adapter = new ArrayAdapter(getActivity(),R.layout.days,R.id.textView4,days);
        ls.setAdapter(adapter);

        ls.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(getActivity(),Exercise.class);
                intent.putExtra("exercise_name",days[i]);
                intent.putExtra("exercise_image",R.drawable.weightloss);
                if (i == 0) {
                    intent.putExtra("image",img_day1);
                    intent.putExtra("text",exercise_day1);
                    intent.putExtra("desc",description_day1);
                }
                if (i == 1) {
                    intent.putExtra("image",img_day2);
                    intent.putExtra("text",exercise_day2);
                    intent.putExtra("desc",description_day2);
                }
                if (i == 2) {
                    intent.putExtra("image",img_day3);
                    intent.putExtra("text",exercise_day3);
                    intent.putExtra("desc",description_day3);
                }
                if (i == 3) {
                    intent.putExtra("image",img_day4);
                    intent.putExtra("text",exercise_day4);
                    intent.putExtra("desc",description_day4);
                }
                if (i == 4) {
                    intent.putExtra("image",img_day5);
                    intent.putExtra("text",exercise_day5);
                    intent.putExtra("desc",description_day5);
                }
                if (i == 5) {
                    intent.putExtra("image",img_day6);
                    intent.putExtra("text",exercise_day6);
                    intent.putExtra("desc",description_day6);
                }
                startActivity(intent);
            }
        });
        return view;
    }

    private void getData() {
        days = getResources().getStringArray(R.array.days);
        exercise_day1 = getResources().getStringArray(R.array.exercise_day1);
        exercise_day2 = getResources().getStringArray(R.array.exercise_day2);
        exercise_day3 = getResources().getStringArray(R.array.exercise_day3);
        exercise_day4 = getResources().getStringArray(R.array.exercise_day4);
        exercise_day5 = getResources().getStringArray(R.array.exercise_day5);
        exercise_day6 = getResources().getStringArray(R.array.exercise_day6);

        description_day1 = getResources().getStringArray(R.array.description_day1);
        description_day2 = getResources().getStringArray(R.array.description_day2);
        description_day3 = getResources().getStringArray(R.array.description_day3);
        description_day4 = getResources().getStringArray(R.array.description_day4);
        description_day5 = getResources().getStringArray(R.array.description_day5);
        description_day6 = getResources().getStringArray(R.array.description_day1);
    }

}
