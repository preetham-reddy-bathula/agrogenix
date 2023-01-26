package com.example.agrogenix;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.speech.RecognizerIntent;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import java.util.List;

public class cropsgrid extends AppCompatActivity {
    private static final int SPEECH_REQUEST_CODE = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cropsgrid);

        ImageButton sugar = (ImageButton) findViewById(R.id.imageButton);
        ImageButton cotton = (ImageButton) findViewById(R.id.imageButton3);
        ImageButton paddy = (ImageButton) findViewById(R.id.imageButton4);
        ImageButton wheat = (ImageButton) findViewById(R.id.imageButton5);
        ImageButton mic = (ImageButton) findViewById(R.id.imageButton11);

        TextView tsugar = (TextView) findViewById(R.id.textView10);
        TextView tcotton = (TextView) findViewById(R.id.textView11);
        TextView tpaddy = (TextView) findViewById(R.id.textView12);
        TextView twheat = (TextView) findViewById(R.id.textView13);

        sugar.setOnClickListener(this::onClickSugar);
        cotton.setOnClickListener(this::onClickCotton);
        paddy.setOnClickListener(this::onClickPaddy);
        wheat.setOnClickListener(this::onClickWheat);

        tsugar.setOnClickListener(this::onClickSugart);
        tcotton.setOnClickListener(this::onClickCottont);
        tpaddy.setOnClickListener(this::onClickPaddyt);
        twheat.setOnClickListener(this::onClickWheatt);

        mic.setOnClickListener(this::onClickMic);

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode,
                                    Intent data) {
        if (requestCode == SPEECH_REQUEST_CODE && resultCode == RESULT_OK) {
            List<String> results = data.getStringArrayListExtra(
                    RecognizerIntent.EXTRA_RESULTS);
            String spokenText = results.get(0).toLowerCase().trim();
            if (spokenText.equals("చెరుకుగడ")||spokenText.equals("చెరుకు")||spokenText.equals("cheruku")||spokenText.equals("cherukugada")){
                Intent intent = new Intent(getApplicationContext(), webview.class);
                intent.putExtra("url","https://drive.google.com/file/d/15heOvSom547nxR04vukek2jtnzDX-nIq/view?usp=sharing");
                startActivity(intent);
            }
            if (spokenText.equals("పత్తి")||spokenText.equals("cotton")||spokenText.equals("patti")){
                Intent intent = new Intent(getApplicationContext(), webview.class);
                intent.putExtra("url","https://drive.google.com/file/d/1zqIAf2ymMnfQB5BEOmm_lli1yc0-hB_G/view?usp=sharing");
                startActivity(intent);
            }
            if (spokenText.equals("వరి")||spokenText.equals("paddy")||spokenText.equals("worry")){
                Intent intent = new Intent(getApplicationContext(), webview.class);
                intent.putExtra("url","https://drive.google.com/file/d/1kHd_p1Vb_Vekow5SPiso8lzz7vyVV5wH/view?usp=sharing");
                startActivity(intent);
            }
            if (spokenText.equals("గోధుమ")||spokenText.equals("wheat")||spokenText.equals("godhuma")||spokenText.equals("goduma")){
                Intent intent = new Intent(getApplicationContext(), webview.class);
                intent.putExtra("url","https://drive.google.com/file/d/1IgRVdCcHiriVR0N_fp_pyLz6W3TsayHO/view?usp=sharing");
                startActivity(intent);
            }


        }
        super.onActivityResult(requestCode, resultCode, data);
    }

    private void onClickMic(View view) {
        Intent intent = new Intent(RecognizerIntent.ACTION_RECOGNIZE_SPEECH);
        intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE_MODEL,
                RecognizerIntent.LANGUAGE_MODEL_FREE_FORM);
// This starts the activity and populates the intent with the speech text.
        startActivityForResult(intent, SPEECH_REQUEST_CODE);
    }

    private void onClickWheatt(View view) {
        Intent intent = new Intent(getApplicationContext(), webview.class);
        intent.putExtra("url","https://drive.google.com/file/d/1IgRVdCcHiriVR0N_fp_pyLz6W3TsayHO/view?usp=sharing");
        startActivity(intent);
    }

    private void onClickWheat(View view) {
        Intent intent = new Intent(getApplicationContext(), webview.class);
        intent.putExtra("url","https://drive.google.com/file/d/1IgRVdCcHiriVR0N_fp_pyLz6W3TsayHO/view?usp=sharing");
        startActivity(intent);
    }

    private void onClickPaddyt(View view) {
        Intent intent = new Intent(getApplicationContext(), webview.class);
        intent.putExtra("url","https://drive.google.com/file/d/1kHd_p1Vb_Vekow5SPiso8lzz7vyVV5wH/view?usp=sharing");
        startActivity(intent);
    }

    private void onClickPaddy(View view) {
        Intent intent = new Intent(getApplicationContext(), webview.class);
        intent.putExtra("url","https://drive.google.com/file/d/1kHd_p1Vb_Vekow5SPiso8lzz7vyVV5wH/view?usp=sharing");
        startActivity(intent);
    }

    private void onClickCottont(View view) {
        Intent intent = new Intent(getApplicationContext(), webview.class);
        intent.putExtra("url","https://drive.google.com/file/d/1zqIAf2ymMnfQB5BEOmm_lli1yc0-hB_G/view?usp=sharing");
        startActivity(intent);
    }

    private void onClickCotton(View view) {
        Intent intent = new Intent(getApplicationContext(), webview.class);
        intent.putExtra("url","https://drive.google.com/file/d/1zqIAf2ymMnfQB5BEOmm_lli1yc0-hB_G/view?usp=sharing");
        startActivity(intent);
    }

    private void onClickSugart(View view) {
        Intent intent = new Intent(getApplicationContext(), webview.class);
        intent.putExtra("url","https://drive.google.com/file/d/15heOvSom547nxR04vukek2jtnzDX-nIq/view?usp=sharing");
        startActivity(intent);
    }

    private void onClickSugar(View view) {
        Intent intent = new Intent(getApplicationContext(), webview.class);
        intent.putExtra("url","https://drive.google.com/file/d/15heOvSom547nxR04vukek2jtnzDX-nIq/view?usp=sharing");
        startActivity(intent);
    }
}