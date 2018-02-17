package com.thesis.protocode.OnlineCompiler;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebSettings;
import android.webkit.WebView;

import com.thesis.protocode.R;
public class Playground extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_playground);

        WebView mWebView=(WebView)findViewById(R.id.web1);
        WebSettings webSettings=mWebView.getSettings();
        mWebView.getSettings().setLoadWithOverviewMode(true);
        mWebView.getSettings().setUseWideViewPort(true);
        webSettings.setJavaScriptEnabled(true);
        mWebView.setWebViewClient(new MyAppWebClient());
        mWebView.loadUrl("file:///android_asset/editor.html");


    }




}
