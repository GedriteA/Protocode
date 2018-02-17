package com.thesis.protocode.home;


import android.media.Image;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.MediaController;
import com.bumptech.glide.Glide;
import com.thesis.protocode.PlayGifView;
import com.thesis.protocode.R;
import com.thesis.protocode.lessons.lessonFragment;

/**
 * A simple {@link Fragment} subclass.
 */
public class home extends Fragment {
    private RecyclerView mRecyclerView;
    MediaController mediaC;
    public home() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v= inflater.inflate(R.layout.fragment_home, container, false);
        getActivity().setTitle("Home");
        mRecyclerView=(RecyclerView)v.findViewById(R.id.homeRecycler);
        RecyclerView.LayoutManager layoutManager=new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL,false);
        mRecyclerView.setLayoutManager(layoutManager);
        mRecyclerView.setHasFixedSize(true);
        mRecyclerView.setAdapter(new MyHomeAdapter(getActivity()));


        return v;
    }

}
