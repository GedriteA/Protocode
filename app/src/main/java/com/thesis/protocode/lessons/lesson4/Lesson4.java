package com.thesis.protocode.lessons.lesson4;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.thesis.protocode.DialogImage;
import com.thesis.protocode.PlayGifView;
import com.thesis.protocode.R;
import com.thesis.protocode.database.DBHelper;
import com.thesis.protocode.lessons.lessonFragment;

/**
 * A simple {@link Fragment} subclass.
 */
public class Lesson4 extends Fragment {
    FragmentManager fragmentManager;
    DBHelper db;
    public Lesson4() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_lesson4, container, false);
        db= new DBHelper(getActivity());
        fragmentManager = getActivity().getSupportFragmentManager();
        final TextView txtDef=(TextView)view.findViewById(R.id.lessondef4);
        final TextView txtTypesFunciton=(TextView) view.findViewById(R.id.txtTypesFunction);
        final TextView txtSyntax=(TextView)view.findViewById(R.id.syntaxSample);
        final TextView paramSample=(TextView)view.findViewById(R.id.ParamSample);
        final PlayGifView gifView=(com.thesis.protocode.PlayGifView)view.findViewById(R.id.viewGif4);
        getActivity().setTitle(db.getAllLessons4().get(0).getLessonName());
        txtDef.setText(db.getAllLessons4().get(0).getLessonDef());
        txtTypesFunciton.setText(db.getAllLessons4().get(0).getLessonTypes());
        txtSyntax.setText(db.getAllLessons4().get(0).getSyntaxFunction());
        paramSample.setText(db.getAllLessons4().get(0).getLessonParamTypes());

        gifView.setImageResource(R.drawable.function);

        gifView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DialogImage image=new DialogImage();
                image.show(getActivity().getSupportFragmentManager(), "NoticeDialogFragment");
                Bundle bundle=new Bundle();
                bundle.putInt("image",R.drawable.function);
                image.setArguments(bundle);

            }
        });
        return view;
    }



}
