package com.example.agrogenix;

import android.os.Bundle;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import androidx.appcompat.app.AppCompatActivity;

public class webview extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_webview);
        String url = getIntent().getStringExtra("url");
        WebView web= findViewById(R.id.web1);
        web.setWebViewClient(new WebViewClient());
        web.getSettings().setSupportZoom(true);
        web.getSettings().setJavaScriptCanOpenWindowsAutomatically(true);
        web.getSettings().setJavaScriptEnabled(true);
        web.loadUrl(url);
    }
}