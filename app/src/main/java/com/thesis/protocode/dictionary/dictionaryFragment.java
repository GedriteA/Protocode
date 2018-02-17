package com.thesis.protocode.dictionary;


import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.thesis.protocode.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class dictionaryFragment extends Fragment {

    private EditText txtFilter;
    ListView dictionaryList;
    DataDictionary cursorData;
    Cursor cursor,search;
    CursorDictionary customAdapter;
    private ArrayAdapter<String> listAdapter;
    DataDictionary data;
    public dictionaryFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        getActivity().setTitle("Dictionary");
        View view = inflater.inflate(R.layout.fragment_dictionary, container, false);
        txtFilter = (EditText) view.findViewById(R.id.txtFilter);
        cursorData = new DataDictionary(getActivity());
        cursor=cursorData.getDictionaryList();
       final ListView  dictionaryList = (ListView) view.findViewById(R.id.list);
        customAdapter = new CursorDictionary(getContext(), cursor, 0);
        if(cursor==null){
            insertDummy();
        }

        dictionaryList.setAdapter(customAdapter);
        dictionaryList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {


                FragmentManager fragmentManager = getFragmentManager();
                TextView textView = (TextView) view.findViewById(R.id.txtWord);
                String word1=textView.getText().toString();
                Bundle bundle=new Bundle();
                bundle.putString("Word",word1);
                wordFragment word=new wordFragment();
                word.setArguments(bundle);
                fragmentManager.beginTransaction().replace(R.id.frame,word).addToBackStack(null).commit();



            }

        });



        txtFilter.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                search=cursorData.getDictionaryListByKeyword(s.toString());
                customAdapter.swapCursor(search);
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });


        return view;


    }




    private void insertDummy() {

    }
}
