package com.thesis.protocode.lessons.lesson3;


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
public class Lesson3 extends Fragment {
    static int position;
    ImageButton right;
    ImageButton left;
    Integer imageMore[] = {
            R.drawable.loop1,R.drawable.loop2,R.drawable.loop3,R.drawable.loop4
    };
    DBHelper db;

    public Lesson3() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v= inflater.inflate(R.layout.fragment_lesson3content, container, false);
        final TextView txtDef=(TextView)v.findViewById(R.id.lessondef3);
        final TextView txtSyntax=(TextView) v.findViewById(R.id.syntax3);
        final PlayGifView gifView=(PlayGifView)v.findViewById(R.id.viewGif3);
        right=(ImageButton) v.findViewById(R.id.right3);
        left=(ImageButton) v.findViewById(R.id.left3);

        db= new DBHelper(getActivity());
        Bundle bundle = this.getArguments();
        if (bundle != null) {
            position =getArguments().getInt("position");
            hideButton();
            db= new DBHelper(getActivity());
            txtDef.setText(db.getAllLessons3().get(position).getLessondef());
            txtSyntax.setText(db.getAllLessons3().get(position).getSyntax());
            gifView.setImageResource(imageMore[position]);
            getActivity().setTitle(db.getAllLessons3().get(position).getLessonName().toString());
        }

        right.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                position++;
                hideButton();
                txtDef.setText(db.getAllLessons3().get(position).getLessondef());
                txtSyntax.setText(db.getAllLessons3().get(position).getSyntax());
                gifView.setImageResource(imageMore[position]);
                getActivity().setTitle(db.getAllLessons3().get(position).getLessonName().toString());


            }
        });
        left.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                position--;
                hideButton();
                txtDef.setText(db.getAllLessons3().get(position).getLessondef());
                txtSyntax.setText(db.getAllLessons3().get(position).getSyntax());
                gifView.setImageResource(imageMore[position]);
                getActivity().setTitle(db.getAllLessons3().get(position).getLessonName().toString());

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
        else if(position==3){
            right.setVisibility(View.INVISIBLE);
        }
        else{
            left.setVisibility(View.VISIBLE);
            right.setVisibility(View.VISIBLE);
        }
    }

}
