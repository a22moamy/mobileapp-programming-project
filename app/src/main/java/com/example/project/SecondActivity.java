package com.example.project;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class SecondActivity extends AppCompatActivity {

    private WebView aboutWebView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        aboutWebView = findViewById(R.id.webview);
        aboutWebView.setWebViewClient(new WebViewClient());

        WebSettings webSettings = aboutWebView.getSettings();
        webSettings.setJavaScriptEnabled(true);
        aboutWebView.loadUrl("file:///android_asset/about/index.html");
    }
}