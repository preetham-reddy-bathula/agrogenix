package com.example.agrogenix;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ProgressBar;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.auth.FirebaseAuth;

import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        ProgressBar pb = (ProgressBar) findViewById(R.id.progressBar);
        pb.setVisibility(ProgressBar.VISIBLE);

        Intent intent = new Intent(this,entrypage.class);
        Timer t = new Timer();
        t.schedule(new TimerTask() {
            @Override
            public void run() {
                startActivity(intent);
            }
        }, 3500);
    }
}