package com.thesis.protocode.lessons.lesson2;


import android.animation.Animator;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;

import com.thesis.protocode.R;
import com.thesis.protocode.database.DBHelper;
import com.thesis.protocode.DialogImage;

import pl.droidsonroids.gif.GifImageView;

/**
 * A simple {@link Fragment} subclass.
 */
public class fragmentLesson2 extends Fragment {

    int position;
    ImageButton right;
    ImageButton left;
    private Animator mCurrentAnimator;
    private int mShortAnimationDuration;
            Integer imageMore[] = {
                    R.drawable.if1,R.drawable.if3,R.drawable.if2,R.drawable.if4,R.drawable.if5
            };
    DBHelper db;
    private View view;
    TextView txtDef;
    TextView txtSyntax;
    public fragmentLesson2() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v= inflater.inflate(R.layout.fragment_lesson2content, container, false);
        this.view=v;
       final TextView txtDef=(TextView)v.findViewById(R.id.lessondef);
        final TextView txtSyntax=(TextView) v.findViewById(R.id.syntax);
        final GifImageView gifView=(GifImageView)v.findViewById(R.id.viewGif2);
        right=(ImageButton) v.findViewById(R.id.right);
        left=(ImageButton) v.findViewById(R.id.left);


        db= new DBHelper(getActivity());


        Bundle bundle = this.getArguments();
        if (bundle != null) {
            position =getArguments().getInt("position");
            hideButton();
            db= new DBHelper(getActivity());
            txtDef.setText(db.getAllLessons().get(position).getLessondef());
            txtSyntax.setText(db.getAllLessons().get(position).getSyntax());
            gifView.setImageResource(imageMore[position]);
            getActivity().setTitle(db.getAllLessons().get(position).getLessonName().toString());


        }


        right.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                position++;
                hideButton();
                txtDef.setText(db.getAllLessons().get(position).getLessondef());
                txtSyntax.setText(db.getAllLessons().get(position).getSyntax());
                gifView.setImageResource(imageMore[position]);
                getActivity().setTitle(db.getAllLessons().get(position).getLessonName().toString());

            }
        });
        left.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                position--;
                hideButton();
                txtDef.setText(db.getAllLessons().get(position).getLessondef());
                txtSyntax.setText(db.getAllLessons().get(position).getSyntax());
                gifView.setImageResource(imageMore[position]);
                getActivity().setTitle(db.getAllLessons().get(position).getLessonName().toString());

            }
        });

        gifView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DialogImage image=new DialogImage();
                image.show(getActivity().getSupportFragmentManager(), "NoticeDialogFragment");
                Bundle bundle=new Bundle();
                bundle.putInt("image",imageMore[position]);
                image.setArguments(bundle);

            }
        });



        return v;

    }
    public void hideButton(){
        if(position==0){
            left.setVisibility(View.INVISIBLE);
        }
        else if(position==4){
            right.setVisibility(View.INVISIBLE);
        }
        else{
            left.setVisibility(View.VISIBLE);
            right.setVisibility(View.VISIBLE);
        }
    }




}
