package com.thesis.protocode.home;

import android.content.Context;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import com.thesis.protocode.R;
import com.thesis.protocode.about.aboutFragment;
import com.thesis.protocode.lessons.lesson1.listlesson1;
import com.thesis.protocode.lessons.lesson2.listlesson2;
import com.thesis.protocode.lessons.lesson3.listlesson3;
import com.thesis.protocode.lessons.lesson4.Lesson4;
import com.thesis.protocode.lessons.lesson5.listlesson5;
import com.thesis.protocode.lessons.lesson6.Lesson6;
import com.thesis.protocode.lessons.lesson6.algorithmFragment;
import com.thesis.protocode.lessons.lessonFragment;

import java.util.ArrayList;

import pl.droidsonroids.gif.GifImageView;

/**
 * Created by martinlizardo on 1/30/2017.
 */

public class MyHomeAdapter extends RecyclerView.Adapter<MyHomeAdapter.ViewHolder>
{
    Context context;
    FragmentManager fragmentManager;
    ArrayList<MyHomeObjectProvider.MyObject> MyObjects=new ArrayList<>();
    Fragment fragment=null;
    public MyHomeAdapter(Context context)
    {
        this.context=context;
        MyObjects=new MyHomeObjectProvider(context).getObjects();


    }

    @Override
    public MyHomeAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.row_home,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MyHomeAdapter.ViewHolder holder, int position) {
        holder.imageview.setImageResource(MyObjects.get(position).getImageId());

        holder.txtView.setText(MyObjects.get(position).getText());
        holder.mCardView.setTag(position);

    }

    @Override
    public int getItemCount() {
        return MyObjects.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder
    {


        GifImageView imageview;
        CardView mCardView;
        TextView txtView;

        public ViewHolder(final View itemView) {
            super(itemView);
            imageview=(GifImageView)itemView.findViewById(R.id.flash);
            fragmentManager = ((AppCompatActivity)context).getSupportFragmentManager();
            Typeface font = Typeface.createFromAsset(itemView.getContext().getAssets(), "fonts/Ubuntu-R.ttf");
            mCardView=(CardView)itemView.findViewById(R.id.my_homeCard);
            txtView=(TextView)itemView.findViewById(R.id.Lesson);
            txtView.setTypeface(font);
            itemView.setOnClickListener(new View.OnClickListener()
            {
                @Override
                public void onClick(View v)
                {
                    int tag=(int)v.getTag();

                    switch(tag) {
                        case 0:
                            fragment=new listlesson1();
                            break;
                        case 1:
                            fragment=new listlesson2();
                            break;
                        case 2:
                            fragment=new listlesson3();
                            break;
                        case 3:
                            fragment=new Lesson4();
                            break;
                        case 4:
                            fragment=new listlesson5();
                            break;
                        case 5:
                            fragment=new algorithmFragment();
                            break;
                        case 6:
                            fragment=new aboutFragment();
                            break;

                    }
                    if(tag==6) {

                        fragmentManager.beginTransaction().replace(R.id.frame, fragment).commit();
                    }
                    else{

                        fragmentManager.beginTransaction().replace(R.id.frame, fragment).addToBackStack(null).commit();

                    }
                }
            });

        }
    }

}
