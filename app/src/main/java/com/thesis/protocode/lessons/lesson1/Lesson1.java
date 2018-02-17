package com.thesis.protocode.lessons.lesson1;


import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.graphics.Point;
import android.graphics.Rect;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.DecelerateInterpolator;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.thesis.protocode.PlayGifView;
import com.thesis.protocode.R;
import com.thesis.protocode.database.DBHelper;

import org.w3c.dom.Text;

/**
 * A simple {@link Fragment} subclass.
 */
public class Lesson1 extends Fragment {

    int position;

    ImageButton right;
    ImageButton left;
    DBHelper db;
    private View view;
    public Lesson1() {
        // Required empty public constructor
    }
    private Animator mCurrentAnimator;
    private int mShortAnimationDuration;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_lesson1, container, false);
        this.view=view;
        final TextView lessondef1=(TextView)view.findViewById(R.id.lessondef1);
        final TextView title2=(TextView)view.findViewById(R.id.exampleTitle2);
        final TextView lessondef2=(TextView)view.findViewById(R.id.lessondef2);
        right=(ImageButton) view.findViewById(R.id.right1);
        left=(ImageButton) view.findViewById(R.id.left1);
        db= new DBHelper(getActivity());
        Bundle bundle = this.getArguments();
        if (bundle != null) {
            position =getArguments().getInt("position");
            hideButton();
            lessondef1.setText(db.getAllLessons1().get(position).getLessonDef1().toString());
            title2.setText(db.getAllLessons1().get(position).getLessonTitle2().toString());
            lessondef2.setText(db.getAllLessons1().get(position).getLessonDef2().toString());
            getActivity().setTitle(db.getAllLessons1().get(position).getLessonName().toString());


        }

        right.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                position++;
                hideButton();
                lessondef1.setText(db.getAllLessons1().get(position).getLessonDef1().toString());
                title2.setText(db.getAllLessons1().get(position).getLessonTitle2().toString());
                lessondef2.setText(db.getAllLessons1().get(position).getLessonDef2().toString());
                getActivity().setTitle(db.getAllLessons1().get(position).getLessonName().toString());


            }
        });
        left.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                position--;
                hideButton();
                lessondef1.setText(db.getAllLessons1().get(position).getLessonDef1().toString());
                title2.setText(db.getAllLessons1().get(position).getLessonTitle2().toString());
                lessondef2.setText(db.getAllLessons1().get(position).getLessonDef2().toString());
                getActivity().setTitle(db.getAllLessons1().get(position).getLessonName().toString());


            }
        });


        return view;
    }

    public void hideButton(){
        if(position==0){
            left.setVisibility(View.INVISIBLE);
        }
        else if(position==8){
            right.setVisibility(View.INVISIBLE);
        }
        else{
            left.setVisibility(View.VISIBLE);
            right.setVisibility(View.VISIBLE);
        }
    }



}

