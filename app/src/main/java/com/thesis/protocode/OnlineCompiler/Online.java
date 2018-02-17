package com.thesis.protocode.OnlineCompiler;


import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.JavascriptInterface;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.thesis.protocode.R;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.io.IOException;

import static com.thesis.protocode.R.id.webview;

/**
 * A simple {@link Fragment} subclass.
 */
public class Online extends Fragment {
    private Document htmlDocument;
    private String htmlPageUrl = "http://rextester.com/l/c_online_compiler_visual";
    private String htmlContentInStringFormat;
   WebView mWebView;
    public Online() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view=inflater.inflate(R.layout.fragment_online, container, false);
        getActivity().setTitle("Code It");
         mWebView=(WebView)view.findViewById(R.id.web2);
        WebSettings webSettings=mWebView.getSettings();
        mWebView.getSettings().setLoadWithOverviewMode(true);
        mWebView.getSettings().setUseWideViewPort(true);
        if (Build.VERSION.SDK_INT >= 11){
            mWebView.setLayerType(View.LAYER_TYPE_SOFTWARE, null);
        }
        webSettings.setJavaScriptEnabled(true);
        mWebView.setWebViewClient(new WebViewClient()    {
            @Override
            public void onPageFinished(WebView view, String url) {
                super.onPageFinished(view, url);



                mWebView.loadUrl("javascript:(function() { " +
                        "document.getElementById('Wall').style.display='none';})()");
                mWebView.loadUrl("javascript:(function() { " +
                        "document.getElementById('Save').style.display='none';})()");
                mWebView.loadUrl("javascript:(function() { " +
                        "document.getElementById('LanguageChoiceWrapper').style.display='none';})()");
                // hide element by id
            }
        });
        mWebView.loadUrl("file:///android_asset/compile visual studio c online.html");
        return view ;
    }


}


