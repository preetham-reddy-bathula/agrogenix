package com.example.agrogenix;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class othersservices extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_othersservices);

        Button experts = (Button) findViewById(R.id.button6);
        Button buyproducts = (Button) findViewById(R.id.button9);
        experts.setOnClickListener(this::onClickexperts);
        buyproducts.setOnClickListener(this::onClickbuyproducts);
    }

    private void onClickbuyproducts(View view) {
        Intent i = new Intent(this, buyingportal.class);
        startActivity(i);
    }

    private void onClickexperts(View view) {
        Intent i = new Intent(this, cropsenglishgrid.class);
        startActivity(i);
    }
}