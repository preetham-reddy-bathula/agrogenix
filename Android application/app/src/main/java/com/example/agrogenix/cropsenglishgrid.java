package com.example.agrogenix;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

public class cropsenglishgrid extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cropsenglishgrid);

        ImageButton sugar = (ImageButton) findViewById(R.id.imageButton2);
        ImageButton cotton = (ImageButton) findViewById(R.id.imageButton6);
        ImageButton paddy = (ImageButton) findViewById(R.id.imageButton7);
        ImageButton wheat = (ImageButton) findViewById(R.id.imageButton8);

        TextView tsugar = (TextView) findViewById(R.id.textView16);
        TextView tcotton = (TextView) findViewById(R.id.textView17);
        TextView tpaddy = (TextView) findViewById(R.id.textView18);
        TextView twheat = (TextView) findViewById(R.id.textView19);

        sugar.setOnClickListener(this::onClickSugar);
        cotton.setOnClickListener(this::onClickCotton);
        paddy.setOnClickListener(this::onClickPaddy);
        wheat.setOnClickListener(this::onClickWheat);

        tsugar.setOnClickListener(this::onClickSugart);
        tcotton.setOnClickListener(this::onClickCottont);
        tpaddy.setOnClickListener(this::onClickPaddyt);
        twheat.setOnClickListener(this::onClickWheatt);
    }

    private void onClickWheatt(View view) {
        Intent intent = new Intent(getApplicationContext(), webview.class);
        intent.putExtra("url","https://drive.google.com/file/d/1DttRJlkSHET72Ufl5FbkTtldmmQOjITF/view?usp=sharing");
        startActivity(intent);
    }

    private void onClickWheat(View view) {
        Intent intent = new Intent(getApplicationContext(), webview.class);
        intent.putExtra("url","https://drive.google.com/file/d/1DttRJlkSHET72Ufl5FbkTtldmmQOjITF/view?usp=sharing");
        startActivity(intent);
    }

    private void onClickPaddyt(View view) {
        Intent intent = new Intent(getApplicationContext(), webview.class);
        intent.putExtra("url","https://drive.google.com/file/d/12aDbVbMoCnIpezKjOtgNhgEpOwzDW65q/view?usp=sharing");
        startActivity(intent);
    }

    private void onClickPaddy(View view) {
        Intent intent = new Intent(getApplicationContext(), webview.class);
        intent.putExtra("url","https://drive.google.com/file/d/12aDbVbMoCnIpezKjOtgNhgEpOwzDW65q/view?usp=sharing");
        startActivity(intent);
    }


    private void onClickCottont(View view) {
        Intent intent = new Intent(getApplicationContext(), webview.class);
        intent.putExtra("url","https://drive.google.com/file/d/1TOdCPzKJpVtkdomnDmQuVf10DkXjJPfW/view?usp=sharing");
        startActivity(intent);
    }

    private void onClickCotton(View view) {
        Intent intent = new Intent(getApplicationContext(), webview.class);
        intent.putExtra("url","https://drive.google.com/file/d/1TOdCPzKJpVtkdomnDmQuVf10DkXjJPfW/view?usp=sharing");
        startActivity(intent);
    }

    private void onClickSugart(View view) {
        Intent intent = new Intent(getApplicationContext(), webview.class);
        intent.putExtra("url","https://drive.google.com/file/d/1YCyo_aeensgeQ8FgUw3PWDipr5KCK1jJ/view?usp=sharing");
        startActivity(intent);
    }

    private void onClickSugar(View view) {
        Intent intent = new Intent(getApplicationContext(), webview.class);
        intent.putExtra("url","https://drive.google.com/file/d/1YCyo_aeensgeQ8FgUw3PWDipr5KCK1jJ/view?usp=sharing");
        startActivity(intent);
    }
}