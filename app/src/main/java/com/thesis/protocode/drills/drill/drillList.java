package com.thesis.protocode.drills.drill;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.thesis.protocode.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class drillList extends Fragment {


    public drillList() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        getActivity().setTitle("Drills");
        View v= inflater.inflate(R.layout.fragment_drill_list, container, false);
        RecyclerView.LayoutManager layoutManager=new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL,false);
        RecyclerView recyclerView=(RecyclerView)v.findViewById(R.id.my_drillRecyclerView);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(new MyDrillAdapter(getActivity()));
        recyclerView.setHasFixedSize(true);
        return v;
    }

}
