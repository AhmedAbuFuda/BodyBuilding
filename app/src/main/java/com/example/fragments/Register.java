package com.example.fragments;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Register extends AppCompatActivity {
    FirebaseAuth mAuth;
    private DatabaseReference reference;
    FirebaseUser user;
    TextView firstName, secondName, weight, height, email, password;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        initComponents();
        mAuth = FirebaseAuth.getInstance();
        FirebaseDatabase db = FirebaseDatabase.getInstance();
        reference = db.getReference();
    }
    private void initComponents(){
        firstName = findViewById(R.id.firstName);
        secondName = findViewById(R.id.secondName);
        weight = findViewById(R.id.weight);
        height = findViewById(R.id.height);
        email = findViewById(R.id.Email);
        password = findViewById(R.id.Password);
    }

    private void signUp(){
        String s = email.getText().toString();
        String s1 = password.getText().toString();
        mAuth.createUserWithEmailAndPassword(s,s1).addOnSuccessListener(new OnSuccessListener<AuthResult>() {
            @Override
            public void onSuccess(AuthResult authResult) {
                Intent i = new Intent(Register.this,MainActivity.class);
                startActivity(i);
                finish();
            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                Toast.makeText(Register.this,e.getMessage(),Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void createUserAccount(){
        user = mAuth.getCurrentUser();
        User usermodel = new User(user.getUid(),firstName.getText().toString(),secondName.getText().toString(),weight.getText().toString(),
                height.getText().toString(),email.getText().toString());
        reference.child("User ").child(user.getUid()).setValue(usermodel).addOnSuccessListener(new OnSuccessListener<Void>() {
            @Override
            public void onSuccess(Void aVoid) {
                Toast.makeText(Register.this,"Done",Toast.LENGTH_SHORT).show();
            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                Toast.makeText(Register.this,e.getMessage(),Toast.LENGTH_SHORT).show();
            }
        });
    }

    public void clickRegister(View view) {
        signUp();
    }

    @Override
    protected void onPause() {
        super.onPause();
        createUserAccount();
    }
}