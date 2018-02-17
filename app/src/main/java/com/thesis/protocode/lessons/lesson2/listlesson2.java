package com.thesis.protocode.lessons.lesson2;


import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import com.thesis.protocode.R;
import com.thesis.protocode.lessons.CustomList;
import com.thesis.protocode.lessons.lessonFragment;

/**
 * A simple {@link Fragment} subclass.
 */
public class listlesson2 extends Fragment {

    FragmentManager fragmentManager;
    public listlesson2() {
        // Required empty public constructor
    }
    String names[] = {
            "2.1",
            "2.2",
            "2.3",
            "2.4",
            "2.5"
    };

    String desc[] = {
            "if statement",
            "if-else statement",
            "else if statement",
            "Nested if-else statement",
            "switch"
    };


    Integer imageMore[] = {
            R.drawable.arrow,
            R.drawable.arrow,
            R.drawable.arrow,
            R.drawable.arrow,
            R.drawable.arrow

    };

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        getActivity().setTitle("Lesson 2: Decision Control Statements");
        View v= inflater.inflate(R.layout.fragment_listlesson2, container, false);
        CustomList customList = new CustomList(getActivity(), names, desc, imageMore);
        ListView list=(ListView)v.findViewById(R.id.lesson2list);
        list.setAdapter(customList);

        fragmentManager = getActivity().getSupportFragmentManager();
        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id)
            {
                Bundle bundle=new Bundle();
                bundle.putInt("position",position);

                    fragmentLesson2 lesson2=new fragmentLesson2();
                    lesson2.setArguments(bundle);
                    fragmentManager.beginTransaction().replace(R.id.frame,lesson2).addToBackStack(null).commit();

            }
        });




        return  v;
    }





}
