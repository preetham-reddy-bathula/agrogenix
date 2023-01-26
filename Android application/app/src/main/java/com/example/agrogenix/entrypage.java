package com.example.agrogenix;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.speech.RecognizerIntent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import java.util.List;

public class entrypage extends AppCompatActivity {
    private static final int SPEECH_REQUEST_CODE = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_entrypage);

        Button rythu = (Button) findViewById(R.id.button);
        Button others = (Button) findViewById(R.id.button2);
        Button soilpatterns = (Button) findViewById(R.id.button3);
        ImageButton mic = (ImageButton) findViewById(R.id.imageButton9);
        
        rythu.setOnClickListener(this::onClickedrythu);
        others.setOnClickListener(this::onClickedothers);
        soilpatterns.setOnClickListener(this::onClickedsoilpatterns);
        mic.setOnClickListener(this::onClickMic);


        AlertDialog.Builder builder
                = new AlertDialog
                .Builder(entrypage.this);
        builder.setMessage("In phone settings, enable talkback and talkback shortcut. Hold volume buttons for 3 seconds to enable. \n ఫోన్ సెట్టింగ్లలో, టాక్బ్యాక్ మరియు టాక్బ్యాక్ సత్వరమార్గాన్ని ప్రారంభించండి. ప్రారంభించడానికి వాల్యూమ్ బటన్లను 3 సెకన్ల పాటు పట్టుకోండి.");
        builder.setTitle("Text to Speech");
        builder.setCancelable(false);
        builder
                .setNegativeButton(
                        "OK",
                        new DialogInterface
                                .OnClickListener() {

                            @Override
                            public void onClick(DialogInterface dialog,
                                                int which)
                            {

                                // If user click no
                                // then dialog box is canceled.
                                dialog.cancel();
                            }
                        });

        AlertDialog alertDialog = builder.create();
        alertDialog.show();


    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode,
                                    Intent data) {
        if (requestCode == SPEECH_REQUEST_CODE && resultCode == RESULT_OK) {
            List<String> results = data.getStringArrayListExtra(
                    RecognizerIntent.EXTRA_RESULTS);
            String spokenText = results.get(0).toLowerCase().trim();
            if (spokenText.equals("others")){
                Intent i = new Intent(this, othersloginpage.class);
                startActivity(i);
            }
            if (spokenText.equals("soil patterns")||spokenText.equals("నేల నమూనాలు")){
                Intent intent = new Intent(getApplicationContext(), webview.class);
                intent.putExtra("url","https://thingspeak.com/channels/1727129");
                startActivity(intent);
            }
            if (spokenText.equals("రైతు")||spokenText.equals("rythu")||spokenText.equals("raithu")||spokenText.equals("raitu")){
                Intent i = new Intent(this, farmerspage.class);
                startActivity(i);
            }
        }
        super. (requestCode, resultCode, data);
    }

    private void onClickMic(View view) {

        Intent intent = new Intent(RecognizerIntent.ACTION_RECOGNIZE_SPEECH);
        intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE_MODEL,
                RecognizerIntent.LANGUAGE_MODEL_FREE_FORM);
// This starts the activity and populates the intent with the speech text.
        startActivityForResult(intent, SPEECH_REQUEST_CODE);


    }

    private void onClickedsoilpatterns(View view) {
        Intent intent = new Intent(getApplicationContext(), webview.class);
        intent.putExtra("url","https://thingspeak.com/channels/1727129");
        startActivity(intent);

    }

    private void onClickedothers(View view) {
        Intent i = new Intent(this, othersloginpage.class);
        startActivity(i);
    }

    private void onClickedrythu(View view) {
        Intent i = new Intent(this, farmerspage.class);
        startActivity(i);
    }

    public void onBackPressed(){
        Intent a = new Intent(Intent.ACTION_MAIN);
        a.addCategory(Intent.CATEGORY_HOME);
        a.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(a);

    }
}