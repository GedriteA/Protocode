package com.thesis.protocode.lessons.lesson5;


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

import org.w3c.dom.Text;

/**
 * A simple {@link Fragment} subclass.
 */
public class Lesson5 extends Fragment {
    Integer imageMore[] = {
            R.drawable.d1,R.drawable.d2,R.drawable.d3
    };
    int position;
    ImageButton right;
    ImageButton left;
    DBHelper db;
    public Lesson5() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_lesson5, container, false);
        final TextView txtDef=(TextView)view.findViewById(R.id.lessondef5);
        final TextView txtNotes=(TextView)view.findViewById(R.id.txtNotes);
        final TextView txtSyntax=(TextView)view.findViewById(R.id.syntaxSample5);
        final PlayGifView gifView5=(PlayGifView)view.findViewById(R.id.viewGif5);
        right=(ImageButton)view.findViewById(R.id.right5);
        left=(ImageButton)view.findViewById(R.id.left5);
        db=new DBHelper(getActivity());
        Bundle bundle = this.getArguments();
        if (bundle != null) {
            position =getArguments().getInt("position");
            hideButton();
            db= new DBHelper(getActivity());
            txtDef.setText(db.getAllLessons5().get(position).getLessonDef());
            txtNotes.setText(db.getAllLessons5().get(position).getLessonNotes());
            txtSyntax.setText(db.getAllLessons5().get(position).getLessonSyntax());
            gifView5.setImageResource(imageMore[position]);
            getActivity().setTitle(db.getAllLessons5().get(position).getLessonTitle().toString());


        }

        right.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                position++;
                hideButton();
                txtDef.setText(db.getAllLessons5().get(position).getLessonDef());
                txtNotes.setText(db.getAllLessons5().get(position).getLessonNotes());
                txtSyntax.setText(db.getAllLessons5().get(position).getLessonSyntax());
                gifView5.setImageResource(imageMore[position]);
                getActivity().setTitle(db.getAllLessons5().get(position).getLessonTitle().toString());

            }
        });
        left.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                position--;
                hideButton();
                txtDef.setText(db.getAllLessons5().get(position).getLessonDef());
                txtNotes.setText(db.getAllLessons5().get(position).getLessonNotes());
                txtSyntax.setText(db.getAllLessons5().get(position).getLessonSyntax());
                gifView5.setImageResource(imageMore[position]);
                getActivity().setTitle(db.getAllLessons5().get(position).getLessonTitle().toString());
            }
        });
        gifView5.setOnClickListener(new View.OnClickListener() {
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
        else if(position==2){
            right.setVisibility(View.INVISIBLE);
        }
        else{
            left.setVisibility(View.VISIBLE);
            right.setVisibility(View.VISIBLE);
        }
    }

}
