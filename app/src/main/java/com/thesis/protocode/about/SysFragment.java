package com.thesis.protocode.about;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.thesis.protocode.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class SysFragment extends Fragment {


    public SysFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        getActivity().setTitle("Application");
        View view= inflater.inflate(R.layout.fragment_sys, container, false);


        return view;
    }

}
