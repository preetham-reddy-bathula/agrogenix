package com.example.agrogenix;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.speech.RecognizerIntent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import androidx.appcompat.app.AppCompatActivity;

import java.util.List;

public class farmerspage extends AppCompatActivity {

    private static final int SPEECH_REQUEST_CODE = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_farmerspage);

        Button cropspage = (Button) findViewById(R.id.button10);
        Button weather = (Button) findViewById(R.id.button11);
        Button sellingportal = (Button) findViewById(R.id.button7);
        Button detect = (Button) findViewById(R.id.button12);
        ImageButton mic = (ImageButton) findViewById(R.id.imageButton10);

        cropspage.setOnClickListener(this::onClickedcropspage);
        detect.setOnClickListener(this::onClickDetect);
        weather.setOnClickListener(this::onClickedweather);
        sellingportal.setOnClickListener(this::onClickedSellingportal);
        mic.setOnClickListener(this::onClickMic);

    }

    private void onClickDetect(View view) {
        Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://harvestify.herokuapp.com/disease-predict"));
        startActivity(browserIntent);

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode,
                                    Intent data) {
        if (requestCode == SPEECH_REQUEST_CODE && resultCode == RESULT_OK) {
            List<String> results = data.getStringArrayListExtra(
                    RecognizerIntent.EXTRA_RESULTS);
            String spokenText = results.get(0).toLowerCase().trim();
            if (spokenText.equals("వ్యవసాయ రంగం")||spokenText.equals("vyavasaya rangam")){
                Intent i = new Intent(this, cropsgrid.class);
                startActivity(i);
            }
            if (spokenText.equals("weather")||spokenText.equals("vatavaran suchana")||spokenText.equals("vatavaran")){
                Intent intent = new Intent(getApplicationContext(), webview.class);
                intent.putExtra("url","https://www.accuweather.com/te/in/yamnampet/2831212/weather-forecast/2831212");
                startActivity(intent);
            }
            if (spokenText.equals("పంటను అమ్మడానికి")||spokenText.equals("సమస్యకు పరిష్కారం")||spokenText.equals("pantanu ammadaniki")||spokenText.equals("samasya parishkaram")){
                Intent i = new Intent(this, sellingportal.class);
                startActivity(i);
            }
            if (spokenText.equals("పంట వ్యాధి నిర్ధారణ")){
                Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://harvestify.herokuapp.com/disease-predict"));
                startActivity(browserIntent);
            }

        }
        super.onActivityResult(requestCode, resultCode, data);
    }


    private void onClickMic(View view) {
        Intent intent = new Intent(RecognizerIntent.ACTION_RECOGNIZE_SPEECH);
        intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE_MODEL,
                RecognizerIntent.LANGUAGE_MODEL_FREE_FORM);
        startActivityForResult(intent, SPEECH_REQUEST_CODE);

    }

    private void onClickedSellingportal(View view) {
        Intent i = new Intent(this, sellingportal.class);
        startActivity(i);
    }



    private void onClickedweather(View view) {
        Intent intent = new Intent(getApplicationContext(), webview.class);
        intent.putExtra("url","https://www.accuweather.com/te/in/yamnampet/2831212/weather-forecast/2831212");
        startActivity(intent);
    }

    private void onClickedcropspage(View view) {
        Intent i = new Intent(this, cropsgrid.class);
        startActivity(i);
    }
}