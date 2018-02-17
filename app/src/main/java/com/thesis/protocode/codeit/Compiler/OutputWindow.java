package com.thesis.protocode.codeit.Compiler;


import android.content.Context;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.system.ErrnoException;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.thesis.protocode.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class OutputWindow extends Fragment {

    TextView txtOutput,txtError;
    String result;
    String error;
    public OutputWindow() {
        // Required empty public constructor
    }
    codeit Code;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        getActivity().setTitle("Output");
        Code=new codeit();
        View v= inflater.inflate(R.layout.fragment_output_window, container, false);
        txtOutput=(TextView)v.findViewById(R.id.Output);
        txtError=(TextView)v.findViewById(R.id.Error);
        System.getProperty("line.separator");
        result=getArguments().getString("Result");
        Typeface font = Typeface.createFromAsset(getContext().getAssets(), "fonts/consola.ttf");
        error=getArguments().getString("Errors");
        if(result.equalsIgnoreCase("null"))
        {
            txtError.setText(error);
            txtError.setTypeface(font);
            Code.j=null;
        }
        else if(error.equalsIgnoreCase("null")){
            txtOutput.setText(result);
            Code.j=null;
            txtOutput.setTypeface(font);
        }

        return v;
    }

}
