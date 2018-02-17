package com.thesis.protocode.dictionary;


import android.graphics.Typeface;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.thesis.protocode.R;

import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class wordFragment extends Fragment {

    DataDictionary data;

    public wordFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_word, container, false);

        TextView txtWord=(TextView)view.findViewById(R.id.word);
        TextView txtMeaning=(TextView)view.findViewById(R.id.meaning);
        TextView txtExample=(TextView)view.findViewById(R.id.example);
        Typeface font = Typeface.createFromAsset(getContext().getAssets(), "fonts/Comfortaa-Regular.ttf");
        String strtext = getArguments().getString("Word");
        data=new DataDictionary(getActivity());
        Dictionary mDictionary=data.getDataDictionaryId(strtext);
        txtWord.setText(mDictionary.getWord());
        txtMeaning.setText(mDictionary.getMeaning());
         txtExample.setText(mDictionary.getExample());

        txtWord.setTypeface(font);
        txtMeaning.setTypeface(font);
        txtExample.setTypeface(font);





        return view;
    }

}
