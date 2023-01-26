package com.example.agrogenix;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class othersloginpage extends AppCompatActivity {


    EditText memail,mpassword;
    ProgressBar progressbar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_othersloginpage);

        memail=findViewById(R.id.editTextTextEmailAddress);
        mpassword=findViewById(R.id.editTextTextPassword);
        progressbar=findViewById(R.id.progressBar3);

        TextView signup = (TextView) findViewById(R.id.textView6);
        TextView guest = (TextView) findViewById(R.id.textView2);
        signup.setOnClickListener(this::onclicksignuptext);
        guest.setOnClickListener(this::onClickguest);

        /*login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String email = memail.getText().toString().trim();
                String password = mpassword.getText().toString().trim();

                if(TextUtils.isEmpty(email)){
                    memail.setError("Email is required");
                    return;
                }

                if(TextUtils.isEmpty(password)){
                    mpassword.setError("Password is required");
                    return;
                }

                if(password.length()<6){
                    mpassword.setError("Password must contain min 6 characters");
                    return;
                }

                progressbar.setVisibility(View.VISIBLE);
                auth.signInWithEmailAndPassword(email,password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if(task.isSuccessful()){
                            Toast.makeText(othersloginpage.this,"Successfully Logged in!", Toast.LENGTH_SHORT).show();
                            startActivity(new Intent(getApplicationContext(),othersservices.class));
                        }
                        else{
                            Toast.makeText(othersloginpage.this,
                                    "Error! "+task.getException().getMessage(),
                                    Toast.LENGTH_SHORT).show();
                        }

                    }
                });
            }
        });*/
    }

    private void onClickguest(View view) {
        Intent i = new Intent(this, othersservices.class);
        startActivity(i);
    }

    private void onclicksignuptext(View view) {
        Intent i = new Intent(this, othersregisterpage.class);
        startActivity(i);
    }
}