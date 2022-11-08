package com.example.fragments;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class MainActivity extends AppCompatActivity {
    FirebaseAuth mAuth;
    TextView emailTxt,passwordTxt;
    Button sign;
    String s,s1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mAuth = FirebaseAuth.getInstance();
        FirebaseUser user = mAuth.getCurrentUser();
        if (user != null)
        {
            Intent i = new Intent(MainActivity.this,HomeActivity.class);
            startActivity(i);
            finish();
        }else {
            setContentView(R.layout.activity_main);
            initComponents();
        }
    }
    private void initComponents(){
        emailTxt = findViewById(R.id.email);
        passwordTxt =  findViewById(R.id.password);
        sign = findViewById(R.id.sign);
    }
    private void signIn(){
        s =  emailTxt.getText().toString();
        s1 =  passwordTxt.getText().toString();
        mAuth.signInWithEmailAndPassword(s,s1).addOnSuccessListener(new OnSuccessListener<AuthResult>() {
            @Override
            public void onSuccess(AuthResult authResult) {
                FirebaseUser user = authResult.getUser();
                Intent i = new Intent(MainActivity.this, HomeActivity.class);
                startActivity(i);
                finish();
            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                Toast.makeText(MainActivity.this, e.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    public void clickCreate(View view) {
        Intent intent = new Intent(MainActivity.this,Register.class);
        startActivity(intent);
    }

    public void login(View view) {
        signIn();
    }
}