package com.thesis.protocode.lessons.lesson1;


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
import com.thesis.protocode.lessons.lesson1.lessonOperator.operatorFragment;
import com.thesis.protocode.lessons.lesson2.fragmentLesson2;
import com.thesis.protocode.lessons.lessonFragment;

/**
 * A simple {@link Fragment} subclass.
 */
public class listlesson1 extends Fragment {

    FragmentManager fragmentManager;
    public listlesson1() {
        // Required empty public constructor
    }
    String names[] = {
            "1.1",
            "1.2",
            "1.3",
            "1.4",
            "1.5",
            "1.6"
    };

    String desc[] = {
            "Origin of C",
            "Structure of a C program",
            "Variables",
            "Data Types",
            "Input/Output",
            "Operators"
    };


    Integer imageMore[] = {
            R.drawable.arrow,
            R.drawable.arrow,
            R.drawable.arrow,
            R.drawable.arrow,
            R.drawable.arrow,
            R.drawable.ic_more_horiz_black_24dp

    };

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                               Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        getActivity().setTitle("Lesson 1: Introduction to C");
        View v=inflater.inflate(R.layout.fragment_listlesson1, container, false);
        CustomList customList = new CustomList(getActivity(), names, desc, imageMore);
        ListView list=(ListView)v.findViewById(R.id.lesson1list);
        list.setAdapter(customList);

        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            if(position==5){
                fragmentManager = getFragmentManager();
                operatorFragment operatorFragment =new operatorFragment();
                fragmentManager.beginTransaction().replace(R.id.frame,operatorFragment).addToBackStack(null).commit();
            }
            else
            {
                fragmentManager = getFragmentManager();
                Bundle bundle=new Bundle();
                bundle.putInt("position",position);

                Lesson1 lesson1=new Lesson1();
                lesson1.setArguments(bundle);
                fragmentManager.beginTransaction().replace(R.id.frame,lesson1).addToBackStack(null).commit();

            }


            }
        });
        return v;
    }




}
