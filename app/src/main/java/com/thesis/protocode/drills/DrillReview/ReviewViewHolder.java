package com.thesis.protocode.drills.DrillReview;

import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.thesis.protocode.R;

/**
 * Created by martinlizardo on 3/24/2017.
 */

public class ReviewViewHolder extends RecyclerView.ViewHolder
{
    public ImageView imgRemarks;
    public TextView  txtQuestionNo;
    public TextView  txtQuestion;
    public TextView  txtUseranswer;
    public TextView  txtCorrect;
    CardView mCardView;
    public ReviewViewHolder(View itemView) {
        super(itemView);
        mCardView=(CardView)itemView.findViewById(R.id.my_Reviewcardview);
        imgRemarks=(ImageView)itemView.findViewById(R.id.imgRemarks);
        txtQuestionNo=(TextView)itemView.findViewById(R.id.QuestionNo);
        txtQuestion=(TextView)itemView.findViewById(R.id.Question);
        txtUseranswer=(TextView)itemView.findViewById(R.id.txtUsernanswer);
        txtCorrect=(TextView)itemView.findViewById(R.id.txtCorect);
    }
}
