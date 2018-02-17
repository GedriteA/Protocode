package com.thesis.protocode.lessons.lesson6;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;

import com.thesis.protocode.DialogImage;
import com.thesis.protocode.PlayGifView;
import com.thesis.protocode.R;
import com.thesis.protocode.database.DBHelper;

/**
 * A simple {@link Fragment} subclass.
 */
public class Lesson6 extends Fragment {
    int position;

    ImageButton right;
    ImageButton left;
    Integer imageMore[] = {
            R.drawable.a1,R.drawable.a2,R.drawable.a3,R.drawable.a4
    };
    DBHelper db;
    TextView txtDef;
    TextView txtSyntax;

    public Lesson6() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_lesson6, container, false);
        final TextView txtDef=(TextView)view.findViewById(R.id.lessondef6);
        final PlayGifView gifView=(PlayGifView)view.findViewById(R.id.viewGif6);
        right=(ImageButton) view.findViewById(R.id.right6);
        left=(ImageButton) view.findViewById(R.id.left6);
        db= new DBHelper(getActivity());

        Bundle bundle = this.getArguments();
        if (bundle != null) {
            position =getArguments().getInt("position");
            hideButton();
            db= new DBHelper(getActivity());
            txtDef.setText(db.getAllLessons6().get(position).getLessonDef());
            gifView.setImageResource(imageMore[position]);
            getActivity().setTitle(db.getAllLessons6().get(position).getLessonTitle().toString());


        }
        right.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                position++;
                hideButton();
                txtDef.setText(db.getAllLessons6().get(position).getLessonDef());
                gifView.setImageResource(imageMore[position]);
                getActivity().setTitle(db.getAllLessons6().get(position).getLessonTitle().toString());


            }
        });
        left.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                position--;
                hideButton();
                txtDef.setText(db.getAllLessons6().get(position).getLessonDef());
                gifView.setImageResource(imageMore[position]);
                getActivity().setTitle(db.getAllLessons6().get(position).getLessonTitle().toString());


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
        return  view;

    }
    public void hideButton(){
        if(position==0){
            left.setVisibility(View.INVISIBLE);
        }
        else if(position==3){
            right.setVisibility(View.INVISIBLE);
        }
        else{
            left.setVisibility(View.VISIBLE);
            right.setVisibility(View.VISIBLE);
        }
    }

}
