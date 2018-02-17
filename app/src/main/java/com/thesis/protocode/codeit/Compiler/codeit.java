package com.thesis.protocode.codeit.Compiler;



import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Environment;
import android.provider.DocumentsContract;
import android.provider.Settings;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentManager;
import android.text.ClipboardManager;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.thesis.protocode.R;
import com.thesis.protocode.about.SysFragment;

import android.content.Intent;
import android.net.Uri;
import android.util.Log;
import android.view.WindowManager;
import android.webkit.JavascriptInterface;
import android.webkit.WebChromeClient;
import android.widget.Button;
import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Toast;

import org.json.JSONException;
import org.json.JSONObject;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;


/**
 * A simple {@link Fragment} subclass.
 */

public class codeit extends Fragment {
    KeyEvent event;
    ClipboardManager cb;
    private String compile;
    private static final int READ_REQUEST_CODE = 42;
    private static final int EDIT_REQUEST_CODE = 44;
    private static final int SAVE_REQUEST_CODE = 41;
    WebView mWebView;
    public static String j;
    public String k;
    int v;
    int i;
    public boolean show = true;

    public String code = "#include  <stdio.h>;\n" +
            "int main(void)\n" +
            "{\n" +
            "printf(\"Hello, world!\\n\");\n" +
            "return 0;\n" +
            "}";


    public codeit() {

    }


    @Override
    @SuppressLint("JavascriptInterface")
    public View onCreateView(final LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        getActivity().setTitle("Code It");
        System.getProperty("line.separator");
        getActivity().getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_VISIBLE);
        final View view = inflater.inflate(R.layout.fragment_codeit, container, false);
        //Code Area
        mWebView = (WebView) view.findViewById(R.id.web1);
        WebSettings webSettings = mWebView.getSettings();
        mWebView.getSettings().setLoadWithOverviewMode(true);
        mWebView.getSettings().setUseWideViewPort(true);
        mWebView.getSettings().setDomStorageEnabled(true);
        mWebView.setWebChromeClient(new WebChromeClient());
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            mWebView.setLayerType(View.LAYER_TYPE_HARDWARE, null);
        } else {
            mWebView.setLayerType(View.LAYER_TYPE_SOFTWARE, null);
        }


        webSettings.setJavaScriptEnabled(true);
        mWebView.addJavascriptInterface(new WebAppInterface(getActivity()), "Android");
        mWebView.setWebViewClient(new WebViewClient() {
            @Override
            public void onPageFinished(WebView view, String url) {
                super.onPageFinished(view, url);

                if (mWebView.getProgress() == 100) {
                    mWebView.setVisibility(View.VISIBLE);
                    mWebView.loadUrl("javascript:getSource()");

                }

                // hide element by id
            }

            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                return false;
            }

        });


        Button openButton = (Button) view.findViewById(R.id.openbutton);
        final Button newButton = (Button) view.findViewById(R.id.newbutton);
        Button saveButton = (Button) view.findViewById(R.id.savebutton);
        Button runButton = (Button) view.findViewById(R.id.runbutton);
        // _editField.paste(template);

        openButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                try {
                    editDocument();
                } catch (Exception e) {
                    e.printStackTrace();
                }

            }
        });

        newButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mWebView.loadUrl("javascript:New()");
            }
        });
        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // Create an instance of the dialog fragment and show it

                mWebView.loadUrl("javascript:getSource()");
                SaveFileDialog dialog = new SaveFileDialog();
                System.out.println(j);
                dialog.show(getFragmentManager(), "NoticeDialogFragment");
                Bundle bundle = new Bundle();
                bundle.putString("Code", j);
                dialog.setArguments(bundle);


            }
        });

        runButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                mWebView.loadUrl("javascript:getSource()");
                InputDialog inputDialog = new InputDialog();
                System.out.println(k);
                Bundle bundle = new Bundle();
                bundle.putString("Run", j);
                inputDialog.setArguments(bundle);
                inputDialog.show(getFragmentManager(), "NoticeDialogFragment");


            }
        });


        mWebView.loadUrl("file:///android_asset/editor.html");


        return view;
    }

    public class WebAppInterface {
        Context mContext;
        String data;

        @JavascriptInterface
        public String getSourceCode() {
            return codeit.this.k;
        }

        @JavascriptInterface
        public void setSourceCode(String data) {
            codeit.this.j = data;

        }

        @JavascriptInterface
        public String newCode() {

            return codeit.this.code;
        }

        WebAppInterface(Context ctx) {

            this.mContext = ctx;
        }

        @JavascriptInterface
        public void showToast(String toast) {
            Toast.makeText(mContext, toast, Toast.LENGTH_SHORT).show();
        }

    }

    @Override
    public void onActivityResult(int requestCode, int resultCode,
                                 Intent resultData) {

        // The ACTION_OPEN_DOCUMENT intent was sent with the request code
        // READ_REQUEST_CODE. If the request code seen here doesn't match, it's the
        // response to some other intent, and the code below shouldn't run at all.

        if (requestCode == READ_REQUEST_CODE && resultCode == getActivity().RESULT_OK) {
            // The document selected by the user won't be returned in the intent.
            // Instead, a URI to that document will be contained in the return intent
            // provided to this method as a parameter.
            // Pull that URI using resultData.getData().
            Uri uri = null;
            if (resultData != null) {
                uri = resultData.getData();
                Log.i("test", "Uri: " + uri.toString());


            }
        } else if (requestCode == EDIT_REQUEST_CODE) {
            Uri uri = null;
            if (resultData != null) {
                uri = resultData.getData();
                Log.i("Task", "Uri: " + uri.toString());


                try {
                    readFileContent(uri);
                } catch (IOException ioe) {
                    Log.e("Debug", "error: " + ioe.getMessage(), ioe);
                }
            }

        }

    }


    private void editDocument() {
        // ACTION_OPEN_DOCUMENT is the intent to choose a file via the system's
        // file browser.
        Intent intent = new Intent(Intent.ACTION_GET_CONTENT);

        // Filter to only show results that can be "opened", such as a
        // file (as opposed to a list of contacts or timezones).
        intent.addCategory(Intent.CATEGORY_OPENABLE);

        // Filter to show only text files.
        intent.setType("*/*");

        startActivityForResult(intent, EDIT_REQUEST_CODE);


    }

    private String readFileContent(Uri uri) throws IOException {
        String code;
        InputStream inputStream = getActivity().getContentResolver().openInputStream(uri);
        BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
        StringBuilder stringBuilder = new StringBuilder();
        String currentline;
        while ((currentline = reader.readLine()) != null) {
            stringBuilder.append(currentline + "\n");
        }
        inputStream.close();
        k = stringBuilder.toString();
        mWebView.loadUrl("javascript:getSourceCode()");
        return stringBuilder.toString();

    }


    @Override
    public void onSaveInstanceState(Bundle savedInstanceState) {
        super.onSaveInstanceState(savedInstanceState);
        mWebView.loadUrl("javascript:getSource()");
        savedInstanceState.putString("code", j);

    }


    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        if (savedInstanceState != null) {
            // Restore last state for checked position.
            code = savedInstanceState.getString("code");
            mWebView.loadUrl("javascript:New()");
        }


    }
}