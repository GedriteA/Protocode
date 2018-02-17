package com.thesis.protocode.drills.DrillReview;

import android.content.Context;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.thesis.protocode.R;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by martinlizardo on 3/24/2017.
 */

public class ReviewAdapter extends RecyclerView.Adapter<ReviewViewHolder> {
    Context mContext;
    List<Review> drillReview=new ArrayList<>();
    public ReviewAdapter(Context context,List<Review> drillReview){
        this.drillReview=drillReview;
        this.mContext=context;
    }
    @Override
    public ReviewViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.row_review,parent,false);
        return new ReviewViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ReviewViewHolder holder, int position) {
            holder.txtQuestionNo.setText("Question#"+String.valueOf(position+1));
            holder.txtQuestion.setText(drillReview.get(position).getQuestion());
            holder.txtUseranswer.setText("Your Answer :"+drillReview.get(position).getUser_answer());
            holder.txtCorrect.setText("Correct Answer :"+drillReview.get(position).getCorect_answer());
            if(drillReview.get(position).getUser_answer().equals(drillReview.get(position).getCorect_answer())){
                holder.imgRemarks.setImageResource(R.drawable.correct);
            }
            else{
                holder.imgRemarks.setImageResource(R.drawable.wrong);
            }
            holder.mCardView.setTag(position);
    }

    @Override
    public int getItemCount() {
        return drillReview.size();
    }



}

