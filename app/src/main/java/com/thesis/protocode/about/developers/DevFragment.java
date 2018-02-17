package com.thesis.protocode.about.developers;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.thesis.protocode.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class DevFragment extends Fragment {


    public DevFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        getActivity().setTitle("Developers");
        View view=inflater.inflate(R.layout.fragment_dev, container, false);
        return view;
    }

}
