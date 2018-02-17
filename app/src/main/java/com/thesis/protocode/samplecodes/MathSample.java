package com.thesis.protocode.samplecodes;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.thesis.protocode.DialogImage;
import com.thesis.protocode.PlayGifView;
import com.thesis.protocode.R;

import pl.droidsonroids.gif.GifImageView;

/**
 * A simple {@link Fragment} subclass.
 */
public class MathSample extends Fragment {


    public MathSample() {
        // Required empty public constructor
    }

    int item;
    Integer imageMore[] = {R.drawable.addnumber,R.drawable.celcius,R.drawable.factors,R.drawable.fato,R.drawable.fibo,R.drawable.evenorodd,R.drawable.greatest3numbers,R.drawable.printinteger,R.drawable.sumofeven,R.drawable.sumofsquare};
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this
        String []titles=new String[]{"Add nth Numbers","Celsius to Fahrenheit","Factors of a Number","Factorial of a Number","Fibonacci Series","Find Even or Odd","Greatest among 3 Numbers","Print an Integer","Sum of Even Numbers from 1 to N","Sum of Squares"};


        item=getArguments().getInt("Item");
        getActivity().setTitle(titles[item]);

        View view= inflater.inflate(R.layout.fragment_showsample, container, false);
        GifImageView sample=(GifImageView) view.findViewById(R.id.sampleCode);
        sample.setImageResource(imageMore[item]);

        sample.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DialogImage image=new DialogImage();
                image.show(getActivity().getSupportFragmentManager(), "NoticeDialogFragment");
                Bundle bundle=new Bundle();
                bundle.putInt("image",imageMore[item]);
                image.setArguments(bundle);
            }
        });
        return view;
    }

}
