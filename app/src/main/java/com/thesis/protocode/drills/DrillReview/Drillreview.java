package com.thesis.protocode.drills.DrillReview;


import android.database.Cursor;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.thesis.protocode.R;
import com.thesis.protocode.drills.DBDrill;
import com.thesis.protocode.drills.drill.drillList;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class Drillreview extends Fragment {
    private RecyclerView mRecyclerView;
    private DBDrill drillReview;
    private List<Review> listReview=new ArrayList<Review>();
    private Cursor cursor;
    private ReviewAdapter mReviewAdapter;
    FragmentManager fragmentManager;

    public Drillreview() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        getActivity().setTitle("Drill Review");
        View view= inflater.inflate(R.layout.fragment_drillreview, container, false);
        mRecyclerView=(RecyclerView)view.findViewById(R.id.reviewRecycler);
        drillReview=new DBDrill(getActivity());
        listReview=drillReview.getAllAnswers();
        RecyclerView.LayoutManager layoutManager=new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL,false);
        mRecyclerView.setLayoutManager(layoutManager);
        mRecyclerView.setHasFixedSize(true);
        fragmentManager = getActivity().getSupportFragmentManager();
        mReviewAdapter=new ReviewAdapter(getActivity(),listReview);
        mRecyclerView.setAdapter(mReviewAdapter);


        return view;
    }



    @Override
    public void onDetach() {
        super.onDetach();
        drillList list =new drillList();
        fragmentManager.beginTransaction().replace(R.id.frame,list).commit();
    }

}
