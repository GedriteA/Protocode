package com.thesis.protocode.lessons.lesson6;


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
import com.thesis.protocode.lessons.lesson2.fragmentLesson2;
import com.thesis.protocode.lessons.lessonFragment;

/**
 * A simple {@link Fragment} subclass.
 */
public class algorithmFragment extends Fragment {

    FragmentManager fragmentManager;
    String names[] = {
            "6.1",
            "6.2",
            "6.3",
            "6.4",

    };

    String desc[] = {
            "Bubble Sort",
            "Merge Sort",
            "Quick Sort",
            "Insertion Sort"


    };


    Integer imageMore[] = {
            R.drawable.arrow,
            R.drawable.arrow,
            R.drawable.arrow,
            R.drawable.arrow,



    };

    public algorithmFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        getActivity().setTitle("Lesson 6: Algorithms");
        View v= inflater.inflate(R.layout.fragment_algorithm, container, false);
        CustomList customList = new CustomList(getActivity(), names, desc, imageMore);
        ListView list=(ListView)v.findViewById(R.id.algolist);
        fragmentManager = getActivity().getSupportFragmentManager();
        list.setAdapter(customList);
        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Bundle bundle=new Bundle();
                bundle.putInt("position",position);

                Lesson6 lesson6=new Lesson6();
                lesson6.setArguments(bundle);
                fragmentManager.beginTransaction().replace(R.id.frame,lesson6).addToBackStack(null).commit();
            }
        });












        return v;
    }




}
