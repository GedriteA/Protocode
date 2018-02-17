package com.thesis.protocode.samplecodes;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import com.thesis.protocode.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class Listsample extends Fragment {


    public Listsample() {
        // Required empty public constructor
    }
    FragmentManager fragmentManager;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        getActivity().setTitle("Sample Codes");
        View view= inflater.inflate(R.layout.fragment_listsample, container, false);
        ListView listSample=(ListView)view.findViewById(R.id.listSample);
        listSample.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id)
            {

                Bundle bundle=new Bundle();
                bundle.putInt("Item",position);
                fragmentManager = getFragmentManager();
                MathSample sample=new MathSample();
                sample.setArguments(bundle);
                fragmentManager.beginTransaction().replace(R.id.frame,sample).addToBackStack(null).commit();
            }
        });
        return view;
    }

}
