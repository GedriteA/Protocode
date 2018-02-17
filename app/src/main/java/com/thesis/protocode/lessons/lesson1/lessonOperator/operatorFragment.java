package com.thesis.protocode.lessons.lesson1.lessonOperator;


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
import com.thesis.protocode.lessons.lesson1.Lesson1;
import com.thesis.protocode.lessons.lesson1.listlesson1;

/**
 * A simple {@link Fragment} subclass.
 */
public class operatorFragment extends Fragment {

    FragmentManager fragmentManager;
    Fragment fragment=null;
    public operatorFragment() {
        // Required empty public constructor
    }

    String names[] = {
            "1.4.1",
            "1.4.2",
            "1.4.3",
            "1.4.4"

    };

    String desc[] = {
            "Arithmetic Operators",
            "Increment & Decrement Operators",
            "Logical Operators",
            "Relational Operators",

    };


    Integer imageMore[] = {
            R.drawable.arrow,
            R.drawable.arrow,
            R.drawable.arrow,
            R.drawable.arrow,


    };



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v= inflater.inflate(R.layout.fragment_operator, container, false);
        getActivity().setTitle("Operators");
        CustomList customList = new CustomList(getActivity(), names, desc, imageMore);
        ListView list=(ListView)v.findViewById(R.id.operatorlist);
        list.setAdapter(customList);
        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                fragmentManager = getActivity().getSupportFragmentManager();
                Bundle bundle=new Bundle();
                bundle.putInt("position",position+5);
                listlesson1 fragment=new listlesson1();
                Lesson1 lesson1=new Lesson1();
                lesson1.setArguments(bundle);
                fragmentManager.beginTransaction().replace(R.id.frame,lesson1).addToBackStack(null).commit();
            }
        });
        return v;
    }

}
