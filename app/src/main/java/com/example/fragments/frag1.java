package com.example.fragments;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import java.io.Serializable;

public class frag1 extends Fragment {
    View view;
    ListView ls1, ls2, ls3;
    String[] beginner, intermediate, advanced;
    int[] img1 = {R.drawable.arm1,R.drawable.lag1,R.drawable.abs1,R.drawable.chest1,R.drawable.back1};
    int[] img2 = {R.drawable.arm2,R.drawable.lag2,R.drawable.abs2,R.drawable.chest2,R.drawable.back2};
    int[] img3 = {R.drawable.arm3,R.drawable.lag3,R.drawable.abs3,R.drawable.chest3,R.drawable.back3};

    String[] arm_Beginner, leg_Beginner, abs_Beginner, chest_Beginner, back_Beginner, arm_Intermediate, leg_Intermediate, abs_Intermediate, chest_Intermediate, back_Intermediate, arm_Advanced, leg_Advanced, abs_Advanced, chest_Advanced, back_Advanced;
    String[] description_Arm_Beginner, description_Leg_Beginner, description_Abs_Beginner, description_Chest_Beginner, description_Back_Beginner, description_Arm_Intermediate, description_Leg_Intermediate, description_Abs_Intermediate, description_Chest_Intermediate, description_Back_Intermediate, description_Arm_Advanced, description_Leg_Advanced, description_Abs_Advanced, description_Chest_Advanced, description_Back_Advanced;

    int[] arm_Beginner_Image = {R.drawable.arm_circles_clockwise,R.drawable.arm_circles_counterclockwise,R.drawable.side_arm_raise,R.drawable.arm_raise
            ,R.drawable.diamond_pushups,R.drawable.push_up,R.drawable.wall_pushup};
    int[] arm_Intermediate_Image = {R.drawable.wall_pushup,R.drawable.arm_raise,R.drawable.burpees_1,R.drawable.skipping_with_rope,R.drawable.arm_circles_counterclockwise,
            R.drawable.diamond_pushups,R.drawable.arm_circles_clockwise,R.drawable.push_up,R.drawable.floor_tricep_dips,R.drawable.arm_scissors};
    int[] arm_Advanced_Image = {R.drawable.arm_scissors,R.drawable.wall_pushup,R.drawable.diamond_pushups,R.drawable.pushupand_rotation,R.drawable.push_up
            ,R.drawable.arm_raise,R.drawable.arm_circles_clockwise,R.drawable.arm_curls_crunch,R.drawable.arm_circles_counterclockwise,R.drawable.side_arm_raise,
            R.drawable.burpees_1,R.drawable.alternating_hooks,R.drawable.skipping_with_rope};

    int[] leg_Beginner_Image = {R.drawable.side_hop,R.drawable.cross_leg,R.drawable.squat,R.drawable.sidelying_leg,R.drawable.backward_lunges,
            R.drawable.donkey_kick,R.drawable.knee_to_chest};
    int[] leg_Intermediate_Image = {R.drawable.knee_to_chest,R.drawable.quad_stretch,R.drawable.jumping_jacks,R.drawable.donkey_kick,
            R.drawable.backward_lunges,R.drawable.calf_stretch,R.drawable.sidelying_leg,R.drawable.squat,R.drawable.sumo_squats,R.drawable.side_hop};
    int[] leg_Advanced_Image = {R.drawable.side_hop,R.drawable.sumo_squats,R.drawable.fire_hydrant,R.drawable.squat,R.drawable.sidelying_leg,
            R.drawable.lunges,R.drawable.calf_stretch,R.drawable.backward_lunges,R.drawable.side_leg_circles,R.drawable.donkey_kick,
            R.drawable.jumping_jacks,R.drawable.quad_stretch,R.drawable.knee_to_chest};

    int[] abs_Beginner_Image = {R.drawable.plank2,R.drawable.mountain_climber,R.drawable.russian_twist,R.drawable.leg_raise,R.drawable.heel_touch,
            R.drawable.jumping_jacks,R.drawable.abdominal_crunches};
    int[] abs_Intermediate_Image = {R.drawable.abdominal_crunches,R.drawable.cobra_stretch,R.drawable.jumping_jacks,R.drawable.heel_touch,R.drawable.side_bridges,
            R.drawable.leg_raise,R.drawable.russian_twist,R.drawable.mountain_climber,R.drawable.v_ups,R.drawable.plank2};
    int[] abs_Advanced_Image = {R.drawable.crossover_crunch,R.drawable.plank2,R.drawable.v_ups,R.drawable.mountain_climber,
            R.drawable.leg_raise,R.drawable.russian_twist,R.drawable.sit_ups,R.drawable.side_bridges,R.drawable.jumping_jacks,R.drawable.heel_touch,
            R.drawable.cobra_stretch,R.drawable.abdominal_crunches,R.drawable.butt_bridge};

    int[] chest_Beginner_Image = {R.drawable.jumping_jacks,R.drawable.push_up,R.drawable.incline_pushup,R.drawable.wide_arm_pushup,R.drawable.knee_pushup,R.drawable.cobra_stretch,
            R.drawable.chest_stretch};
    int[] chest_Intermediate_Image = {R.drawable.chest_stretch,R.drawable.cobra_stretch,R.drawable.hindu_pushup,R.drawable.knee_pushup,R.drawable.wide_arm_pushup,
            R.drawable.staggered_pushup,R.drawable.incline_pushup,R.drawable.push_up,R.drawable.pushupand_rotation,R.drawable.jumping_jacks};
    int[] chest_Advanced_Image = {R.drawable.jumping_jacks,R.drawable.pushupand_rotation,R.drawable.spiderman_pushup,R.drawable.push_up,R.drawable.incline_pushup,
            R.drawable.staggered_pushup,R.drawable.shoulder_stretch,R.drawable.wide_arm_pushup,R.drawable.knee_pushup,R.drawable.hindu_pushup,R.drawable.box_pushup,
            R.drawable.cobra_stretch,R.drawable.chest_stretch};

    int[] back_Beginner_Image = {R.drawable.knee_pushup,R.drawable.arm_scissors,R.drawable.cat_cow_pose,R.drawable.prone_triceps_pushup,R.drawable.reclined_rhombold,R.drawable.jumping_jacks,
            R.drawable.childs_pose};
    int[] back_Intermediate_Image = {R.drawable.childs_pose,R.drawable.jumping_jacks,R.drawable.tricep_kickbacks,R.drawable.reclined_rhombold,R.drawable.prone_triceps_pushup,R.drawable.floor_tricep_dips,
            R.drawable.cat_cow_pose,R.drawable.arm_scissors,R.drawable.swimmer_and_superman,R.drawable.knee_pushup};
    int[] back_Advanced_Image = {R.drawable.knee_pushup,R.drawable.swimmer_and_superman,R.drawable.pike_pushup,R.drawable.arm_scissors,R.drawable.cat_cow_pose,
            R.drawable.floor_tricep_dips,R.drawable.inchworms,R.drawable.prone_triceps_pushup,R.drawable.reclined_rhombold,R.drawable.tricep_kickbacks,R.drawable.supine_pushup,
            R.drawable.jumping_jacks,R.drawable.childs_pose};
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.f1,container,false);

        ls1 = view.findViewById(R.id.list1);
        ls2 = view.findViewById(R.id.list2);
        ls3 = view.findViewById(R.id.list3);

        getData();

        ls1.setAdapter(new CustomList(getActivity(),beginner,img1));
        ls1.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(getActivity(),Exercise.class);
                intent.putExtra("exercise_name",beginner[i]);
                intent.putExtra("exercise_image",img1[i]);

                if(i == 0){
                    intent.putExtra("image",arm_Beginner_Image);
                    intent.putExtra("text",arm_Beginner);
                    intent.putExtra("desc",description_Arm_Beginner);
                }
                if(i == 1){
                    intent.putExtra("image",leg_Beginner_Image);
                    intent.putExtra("text",leg_Beginner);
                    intent.putExtra("desc",description_Leg_Beginner);
                }
                if(i == 2){
                    intent.putExtra("image",abs_Beginner_Image);
                    intent.putExtra("text",abs_Beginner);
                    intent.putExtra("desc",description_Abs_Beginner);
                }
                if(i == 3){
                    intent.putExtra("image",chest_Beginner_Image);
                    intent.putExtra("text",chest_Beginner);
                    intent.putExtra("desc",description_Chest_Beginner);
                }
                if(i == 4){
                    intent.putExtra("image",back_Beginner_Image);
                    intent.putExtra("text",back_Beginner);
                    intent.putExtra("desc",description_Back_Beginner);
                }

                startActivity(intent);
            }
        });

        ls2.setAdapter(new CustomList(getActivity(),intermediate,img2));
        ls2.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(getActivity(),Exercise.class);
                intent.putExtra("exercise_name",intermediate[i]);
                intent.putExtra("exercise_image",img2[i]);

                if(i == 0){
                    intent.putExtra("image",arm_Intermediate_Image);
                    intent.putExtra("text",arm_Intermediate);
                    intent.putExtra("desc",description_Arm_Intermediate);
                }
                if(i == 1){
                    intent.putExtra("image",leg_Intermediate_Image);
                    intent.putExtra("text",leg_Intermediate);
                    intent.putExtra("desc",description_Leg_Intermediate);
                }
                if(i == 2){
                    intent.putExtra("image",abs_Intermediate_Image);
                    intent.putExtra("text",abs_Intermediate);
                    intent.putExtra("desc",description_Abs_Intermediate);
                }
                if(i == 3){
                    intent.putExtra("image",chest_Intermediate_Image);
                    intent.putExtra("text",chest_Intermediate);
                    intent.putExtra("desc",description_Chest_Intermediate);
                }
                if(i == 4){
                    intent.putExtra("image",back_Intermediate_Image);
                    intent.putExtra("text",back_Intermediate);
                    intent.putExtra("desc",description_Back_Intermediate);
                }

                startActivity(intent);
            }
        });

        ls3.setAdapter(new CustomList(getActivity(),advanced,img3));
        ls3.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(getActivity(),Exercise.class);
                intent.putExtra("exercise_name",advanced[i]);
                intent.putExtra("exercise_image",img3[i]);

                if(i == 0){
                    intent.putExtra("image",arm_Advanced_Image);
                    intent.putExtra("text",arm_Advanced);
                    intent.putExtra("desc",description_Arm_Advanced);
                }
                if(i == 1){
                    intent.putExtra("image",leg_Advanced_Image);
                    intent.putExtra("text",leg_Advanced);
                    intent.putExtra("desc",description_Leg_Advanced);
                }
                if(i == 2){
                    intent.putExtra("image",abs_Advanced_Image);
                    intent.putExtra("text",abs_Advanced);
                    intent.putExtra("desc",description_Abs_Advanced);
                }
                if(i == 3){
                    intent.putExtra("image",chest_Advanced_Image);
                    intent.putExtra("text",chest_Advanced);
                    intent.putExtra("desc",description_Chest_Advanced);
                }
                if(i == 4){
                    intent.putExtra("image",back_Advanced_Image);
                    intent.putExtra("text",back_Advanced);
                    intent.putExtra("desc",description_Back_Advanced);
                }

                startActivity(intent);
            }
        });

        return view;
    }
    void getData(){
        beginner = getResources().getStringArray(R.array.beginner);
        intermediate = getResources().getStringArray(R.array.intermediate);
        advanced = getResources().getStringArray(R.array.advanced);

        arm_Beginner = getResources().getStringArray(R.array.arm_Beginner);
        arm_Intermediate = getResources().getStringArray(R.array.arm_Intermediate);
        arm_Advanced = getResources().getStringArray(R.array.arm_Advanced);

        leg_Beginner = getResources().getStringArray(R.array.leg_Beginner);
        leg_Intermediate = getResources().getStringArray(R.array.leg_Intermediate);
        leg_Advanced = getResources().getStringArray(R.array.leg_Advanced);

        abs_Beginner = getResources().getStringArray(R.array.abs_Beginner);
        abs_Intermediate = getResources().getStringArray(R.array.abs_Intermediate);
        abs_Advanced = getResources().getStringArray(R.array.abs_Advanced);

        chest_Beginner = getResources().getStringArray(R.array.chest_Beginner);
        chest_Intermediate = getResources().getStringArray(R.array.chest_Intermediate);
        chest_Advanced = getResources().getStringArray(R.array.chest_Advanced);

        back_Beginner = getResources().getStringArray(R.array.back_Beginner);
        back_Intermediate = getResources().getStringArray(R.array.back_Intermediate);
        back_Advanced = getResources().getStringArray(R.array.back_Advanced);

        description_Arm_Beginner = getResources().getStringArray(R.array.description_Arm_Beginner);
        description_Arm_Intermediate = getResources().getStringArray(R.array.description_Arm_Intermediate);
        description_Arm_Advanced = getResources().getStringArray(R.array.description_Arm_Advanced);

        description_Leg_Beginner = getResources().getStringArray(R.array.description_Leg_Beginner);
        description_Leg_Intermediate = getResources().getStringArray(R.array.description_Leg_Intermediate);
        description_Leg_Advanced = getResources().getStringArray(R.array.description_Leg_Advanced);

        description_Abs_Beginner = getResources().getStringArray(R.array.description_Abs_Beginner);
        description_Abs_Intermediate = getResources().getStringArray(R.array.description_Abs_Intermediate);
        description_Abs_Advanced = getResources().getStringArray(R.array.description_Abs_Advanced);

        description_Chest_Beginner = getResources().getStringArray(R.array.description_Chest_Beginner);
        description_Chest_Intermediate = getResources().getStringArray(R.array.description_Chest_Intermediate);
        description_Chest_Advanced = getResources().getStringArray(R.array.description_Chest_Advanced);

        description_Back_Beginner = getResources().getStringArray(R.array.description_Back_Beginner);
        description_Back_Intermediate = getResources().getStringArray(R.array.description_Back_Intermediate);
        description_Back_Advanced = getResources().getStringArray(R.array.description_Back_Advanced);
    }
}
