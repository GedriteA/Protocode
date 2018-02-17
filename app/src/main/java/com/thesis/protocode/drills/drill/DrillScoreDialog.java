package com.thesis.protocode.drills.drill;

import android.app.AlertDialog;
import android.app.Dialog;
import android.support.v4.app.DialogFragment;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.RatingBar;
import android.widget.TextView;

import com.thesis.protocode.R;
import com.thesis.protocode.drills.DBDrill;
import com.thesis.protocode.drills.DrillReview.Drillreview;

/**
 * Created by martinlizardo on 2/13/2017.
 */

public class DrillScoreDialog extends DialogFragment
{
    FragmentManager fragmentManager;
    DBDrill db;

    String level;
     TextView txtScore;
    Button Review,Back;
    @Override

    public Dialog onCreateDialog(Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        // Get the layout inflatern
        db = new DBDrill(getActivity());
        LayoutInflater inflater = getActivity().getLayoutInflater();
        View view=inflater.inflate(R.layout.dialog_score, null);
        level=getArguments().getString("level");
        db.ShowScore(level);

        float rating=(float)db.score;
        RatingBar bar=(RatingBar)view.findViewById(R.id.ratingBar1);
        TextView t=(TextView)view.findViewById(R.id.textResult);
        bar.setRating(rating);
        fragmentManager = getActivity().getSupportFragmentManager();
        Review=(Button)view.findViewById(R.id.txtReview);
        Back=(Button)view.findViewById(R.id.txtDrillMenu);
        builder.setTitle("Drills: "+level);
        switch (db.score)
        {
            case 0:
            case 1:
            case 2:
            case 3:
                t.setText("Better Luck Next Time!");
                break;
            case 4:
            case 5:
            case 6:
                t.setText("Good Job !!!");
                break;
            case 7:
            case 8:
                t.setText("Great !!!");
                break;
            case 9:
            case 10:
                t.setText("Excellent !!!!");

        }
        Back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
              Bundle bundle=new Bundle();
                if(level=="Easy"){
                  bundle.putInt("level",0);
                }
                else if (level=="Hard"){
                    bundle.putInt("level",1);
                }
                else if (level=="Expert"){
                    bundle.putInt("level",2);
                }

                drillContent drill2 = new drillContent();
                drill2.setArguments(bundle);
                fragmentManager.beginTransaction().replace(R.id.frame,drill2).addToBackStack(null).commit();
                getDialog().dismiss();
            }
        });
        Review.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Drillreview drillreview=new Drillreview();
                fragmentManager.beginTransaction().replace(R.id.frame,drillreview).addToBackStack(null).commit();
                getDialog().dismiss();
            }
        });



        // Inflate and set the layout for the dialog
        // Pass null as the parent view because its going in the dialog layout
        builder.setView((view));
                // Add action buttons


        return builder.create();
    }

}
