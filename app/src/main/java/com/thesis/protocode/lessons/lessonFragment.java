package com.thesis.protocode.lessons;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import com.thesis.protocode.R;
import com.thesis.protocode.lessons.lesson1.listlesson1;
import com.thesis.protocode.lessons.lesson2.listlesson2;
import com.thesis.protocode.lessons.lesson3.listlesson3;
import com.thesis.protocode.lessons.lesson4.Lesson4;
import com.thesis.protocode.lessons.lesson5.listlesson5;
import com.thesis.protocode.lessons.lesson6.algorithmFragment;

/**
 * A simple {@link Fragment} subclass.
 */
public class lessonFragment extends Fragment {

    FragmentManager fragmentManager;
    public lessonFragment() {
        // Required empty public constructor
    }

     String names[] = {
            "1",
            "2",
            "3",
            "4",
             "5",
             "6"
    };

    String desc[] = {
            "Introduction to C",
            "Decision Control Statements",
            "Loops",
            "Functions",
            "Data Structure",
            "Algorithms"
    };


 Integer imageMore[] = {
            R.drawable.ic_more_horiz_black_24dp,
            R.drawable.ic_more_horiz_black_24dp,
            R.drawable.ic_more_horiz_black_24dp,
            R.drawable.arrow,
            R.drawable.ic_more_horiz_black_24dp,
            R.drawable.ic_more_horiz_black_24dp

    };
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        getActivity().setTitle("Lessons");
        View v= inflater.inflate(R.layout.fragment_lesson, container, false);
        CustomList customList = new CustomList(getActivity(), names, desc, imageMore);
        ListView list=(ListView)v.findViewById(R.id.lessonlist);
        list.setAdapter(customList);
        Fragment fragment=null;
        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if(position==0){
                    fragmentManager = getFragmentManager();
                    listlesson1 lesson1=new listlesson1();
                    fragmentManager.beginTransaction().replace(R.id.frame,lesson1).addToBackStack(null).commit();
                }
                else if(position==1){
                    fragmentManager = getFragmentManager();
                    listlesson2 lesson2=new listlesson2();
                    fragmentManager.beginTransaction().replace(R.id.frame,lesson2).addToBackStack(null).commit();
                }
                else if(position==2){
                    fragmentManager = getFragmentManager();
                    listlesson3 lesson3=new listlesson3();
                    fragmentManager.beginTransaction().replace(R.id.frame,lesson3).addToBackStack(null).commit();
                }
                else if(position==3){
                    fragmentManager = getFragmentManager();
                    Lesson4 lesson4=new Lesson4();
                    fragmentManager.beginTransaction().replace(R.id.frame,lesson4).addToBackStack(null).commit();
                }
                else if(position==4){
                    fragmentManager = getFragmentManager();
                    listlesson5 lesson5=new listlesson5();
                    fragmentManager.beginTransaction().replace(R.id.frame,lesson5).addToBackStack(null).commit();
                }
                else if(position==5){
                    fragmentManager = getFragmentManager();
                    algorithmFragment algo=new algorithmFragment();
                    fragmentManager.beginTransaction().replace(R.id.frame,algo).addToBackStack(null).commit();
                }

            }
        });
        //Recycler View//
        
        return v;
    }

}
