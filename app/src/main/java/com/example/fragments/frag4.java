package com.example.fragments;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;

public class frag4 extends Fragment {
ImageView imageView, imageView2, imageView3, imageView4, imageView5;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.frag4,container,false);
        imageView = view.findViewById(R.id.imageView6);
        imageView2 = view.findViewById(R.id.imageView7);
        imageView3 = view.findViewById(R.id.imageView8);
        imageView4 = view.findViewById(R.id.imageView9);
        imageView5 = view.findViewById(R.id.imageView10);

        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Uri u = Uri.parse("https://www.youtube.com/watch?v=M27ScRJ3nKs&list=PLoi2-PUbIjQ6UMl9AxI2tUXZm6MycZJRQ");
                Intent i = new Intent(Intent.ACTION_VIEW, u);
                startActivity(i);
            }
        });

        imageView2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Uri u = Uri.parse("https://www.youtube.com/watch?v=9cxmi_JBe_M&list=PLSCcAGyv98ieU4iS1nGOuhyyjG3RyLhTF");
                Intent i = new Intent(Intent.ACTION_VIEW, u);
                startActivity(i);
            }
        });

        imageView3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Uri u = Uri.parse("https://www.youtube.com/watch?v=2pLT-olgUJs&list=PLAFs3kxY4h1_XkN6EsVci1E3Y_lHj5xzK");
                Intent i = new Intent(Intent.ACTION_VIEW, u);
                startActivity(i);
            }
        });

        imageView4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Uri u = Uri.parse("https://www.youtube.com/watch?v=EpmNZnxni9s&list=PLrzjnSr6-vrLgPRXSgfY8XjlTKN2UppYt");
                Intent i = new Intent(Intent.ACTION_VIEW, u);
                startActivity(i);
            }
        });

        imageView5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Uri u = Uri.parse("https://www.youtube.com/watch?v=hG9ei-Jz1aY&list=PLC8ED282184C61B13");
                Intent i = new Intent(Intent.ACTION_VIEW, u);
                startActivity(i);
            }
        });

        return view;
    }

}
