package com.thesis.protocode.lessons.lesson3;


import android.content.Intent;
import android.os.Bundle;
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
public class listlesson3 extends Fragment {

    FragmentManager fragmentManager;
    public listlesson3() {
        // Required empty public constructor
    }
    String names[] = {
            "3.1",
            "3.2",
            "3.3",
            "3.4"

    };

    String desc[] = {
            "for loop",
            "nested for loop",
            "while loop",
            "do while"

    };


    Integer imageMore[] = {
            R.drawable.arrow,
            R.drawable.arrow,
            R.drawable.arrow,
            R.drawable.arrow


    };


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        getActivity().setTitle("Lesson 3: Loops");
        View v= inflater.inflate(R.layout.fragment_listlesson3, container, false);
        CustomList customList = new CustomList(getActivity(), names, desc, imageMore);
        ListView list=(ListView)v.findViewById(R.id.lesson3list);
        list.setAdapter(customList);
        fragmentManager = getActivity().getSupportFragmentManager();
        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Bundle bundle=new Bundle();
                bundle.putInt("position",position);

                Lesson3 lesson3=new Lesson3();
                lesson3.setArguments(bundle);
                fragmentManager.beginTransaction().replace(R.id.frame,lesson3).addToBackStack(null).commit();

            }
        });

        return v;
    }



}
