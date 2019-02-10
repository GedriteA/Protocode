package com.thesis.protocode.codeit.Compiler;

import android.app.AlertDialog;
import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.FragmentManager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;

import com.thesis.protocode.R;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by martinlizardo on 4/2/2017.
 */

public class InputDialog  extends DialogFragment
{
    EditText input;
    FragmentManager fragmentManager;
    String Compresult;
    String code;
    String inputItem;
    String Result;
    String Error;
    String fetch;
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        // Get the layout inflater
        System.getProperty("line.separator");
        LayoutInflater inflater = getActivity().getLayoutInflater();
        View view=inflater.inflate(R.layout.dialog_input, null);
        fragmentManager = getActivity().getSupportFragmentManager();
        code=getArguments().getString("Run");
        input=(EditText)view.findViewById(R.id.input);

        // Inflate and set the layout for the dialog
        // Pass null as the parent view because its going in the dialog layout
        builder.setView((view))
                // Add action buttons
                .setPositiveButton("Run ", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int id) {
                        new Task_finder().execute();
                        InputDialog.this.getDialog().cancel();
                        inputItem=input.getText().toString();
                    }
                })
                .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        InputDialog.this.getDialog().cancel();
                    }
                });



        return builder.create   ();

    }


    public class Task_finder extends AsyncTask<Void, Void, Void> {
        private final ProgressDialog dialog = new ProgressDialog(getActivity());
        // can use UI thread here


        private Uri uri;
        protected void onPreExecute() {
            this.dialog.setMessage("Loading...");
            this.dialog.setCancelable(false);
            this.dialog.show();
        }


        @Override
        protected Void doInBackground(Void... arg0) {
            // TODO Auto-generated method stub
            DataInputStream inStream = null;
            HttpURLConnection httpURLConnection=null;
            try {
                URL url = new URL("http://rextester.com/rundotnet/api"); //Enter URL here
                httpURLConnection = (HttpURLConnection)url.openConnection();
                httpURLConnection.setDoOutput(true);
                httpURLConnection.setRequestMethod("POST"); // here you are telling that it is a POST request, which can be changed into "PUT", "GET", "DELETE" etc.
                httpURLConnection.setRequestProperty("Content-Type", "application/json"); // here you are setting the `Content-Type` for the data you are sending which is `application/json`
                httpURLConnection.connect();

                JSONObject jsonObject = new JSONObject();
                jsonObject.put("LanguageChoice", "29");
                jsonObject.put("Program",code);
                jsonObject.put("Input", inputItem);
                jsonObject.put("CompilerArgs", "source_file.c -o a.exe");

                DataOutputStream wr = new DataOutputStream(httpURLConnection.getOutputStream());
                wr.writeBytes(jsonObject.toString());
                wr.flush();
                wr.close();

            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            } catch (JSONException e) {
                e.printStackTrace();
            }

            //Read Server Reponse

            try {
                    inStream = new DataInputStream (httpURLConnection.getInputStream() );
                String str;
                while (( str = inStream.readLine()) != null){
                    Log.e("Debug","Server Response "+str);
                    Compresult=str;

                }

                inStream.close();
            }
            catch (IOException ioex){
                Log.e("Debug", "error: " + ioex.getMessage(), ioex);
            }

            return null;
        }

        @Override
        protected void onPostExecute(Void result) {
            try {

                    JSONObject jObject = new JSONObject(Compresult);
                    Result = jObject.getString("Result");
                    Error = jObject.getString("Errors");
                    Bundle bundle = new Bundle();
                    bundle.putString("Result", Result);
                    bundle.putString("Errors", Error);
                    OutputWindow output = new OutputWindow();
                    output.setArguments(bundle);
                    fragmentManager.beginTransaction().replace(R.id.frame, output).addToBackStack(null).commit();
                    Result = null;
                    Error = null;
                    this.dialog.dismiss();

            }catch (JSONException e){
                Log.e("Debug", "error: " + e.getMessage(), e);
            }


            }
        }
    }



