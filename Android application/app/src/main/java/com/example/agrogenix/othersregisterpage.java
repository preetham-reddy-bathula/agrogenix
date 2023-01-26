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

public class othersregisterpage extends AppCompatActivity {

    EditText fullname,memail,mpassword,mconfirmpass,phone;
    Button signup;
    TextView loginpage,guest;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_othersregisterpage);

        fullname=findViewById(R.id.editTextTextPersonName);
        memail=findViewById(R.id.editTextTextEmailAddress2);
        mpassword=findViewById(R.id.editTextTextPassword2);
        mconfirmpass=findViewById(R.id.editTextTextPassword3);
        phone=findViewById(R.id.editTextPhone);
        loginpage=findViewById(R.id.textView7);
        guest=findViewById(R.id.textView15);
        signup=findViewById(R.id.button5);

        loginpage.setOnClickListener(this::onclicklogintext);
        guest.setOnClickListener(this::onClickguest);

        /*auth = FirebaseAuth.getInstance();
        progressbar= findViewById(R.id.progressBar2);

        if(auth.getCurrentUser()!=null){
            startActivity(new Intent(getApplicationContext(),othersservices.class));
        }

        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String email = memail.getText().toString().trim();
                String password = mpassword.getText().toString().trim();
                String confirmpass = mconfirmpass.getText().toString().trim();

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

                if(!password.equals(confirmpass)){
                    mconfirmpass.setError("Passwords did not match");
                    return;
                }

                progressbar.setVisibility(View.VISIBLE);

                auth.createUserWithEmailAndPassword(email,password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if(task.isSuccessful()){
                            Toast.makeText(othersregisterpage.this,"Successfully signed up! Login to proceed", Toast.LENGTH_SHORT).show();
                            startActivity(new Intent(getApplicationContext(),othersloginpage.class));
                        }
                        else{
                            Toast.makeText(othersregisterpage.this,
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

    private void onclicklogintext(View view) {
        Intent i = new Intent(this, othersloginpage.class);
        startActivity(i);
    }
}