    package com.thesis.protocode.lessons.lesson5;


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
import com.thesis.protocode.lessons.lesson6.algorithmFragment;
import com.thesis.protocode.lessons.lessonFragment;

    /**
 * A simple {@link Fragment} subclass.
 */
public class listlesson5 extends Fragment {
        FragmentManager fragmentManager;
    String names[] = {
            "5.1",
            "5.2",
            "5.3"

    };

    String desc[] = {
            "Arrays",
            "Pointers",
            "Linked List",


    };


    Integer imageMore[] = {
            R.drawable.arrow,
            R.drawable.arrow,
            R.drawable.arrow


    };

    public listlesson5() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        getActivity().setTitle("Lesson 5: Data Structures");
        View v=inflater.inflate(R.layout.fragment_listlesson5, container, false);
        CustomList customList = new CustomList(getActivity(), names, desc, imageMore);
        fragmentManager = getActivity().getSupportFragmentManager();
        ListView list=(ListView)v.findViewById(R.id.lesson5list);
        list.setAdapter(customList);
       list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
           @Override
           public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
               Bundle bundle=new Bundle();
               bundle.putInt("position",position);
               Lesson5 lesson5=new Lesson5();
               lesson5.setArguments(bundle);
               fragmentManager.beginTransaction().replace(R.id.frame,lesson5).addToBackStack(null).commit();
           }
       });
        return v;
    }




}
