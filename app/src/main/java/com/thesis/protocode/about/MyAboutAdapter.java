package com.thesis.protocode.about;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.thesis.protocode.R;
import com.thesis.protocode.about.developers.DevFragment;

import java.util.ArrayList;

/**
 * Created by martinlizardo on 1/30/2017.
 */

public class MyAboutAdapter extends RecyclerView.Adapter<MyAboutAdapter.ViewHolder>
{
    Context context;
    FragmentManager fragmentManager;
    ArrayList<MyAboutObjectProvider.MyObject> MyObjects=new ArrayList<>();
    Fragment fragment=null;
    public MyAboutAdapter(Context context)
    {
        this.context=context;
        MyObjects=new MyAboutObjectProvider(context).getObjects();


    }

    @Override
    public MyAboutAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.row,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MyAboutAdapter.ViewHolder holder, int position) {
        holder.imageview.setImageResource(MyObjects.get(position).getImageId());
        holder.mCardView.setTag(position);

    }

    @Override
    public int getItemCount() {
        return MyObjects.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder
    {

        String position;
        ImageView imageview;
        CardView mCardView;
        TextView txtView;

        public ViewHolder(final View itemView) {
            super(itemView);
            fragmentManager = ((AppCompatActivity)context).getSupportFragmentManager();
            imageview=(ImageView) itemView.findViewById(R.id.my_image);
            mCardView=(CardView)itemView.findViewById(R.id.my_cardview);
            itemView.setOnClickListener(new View.OnClickListener()
            {
                @Override
                public void onClick(View v)
                {
                    int tag=(int)v.getTag();

                    switch(tag) {
                        case 0:

                           fragment=new DevFragment();
                            break;
                        case 1:

                            fragment=new SysFragment();
                            break;
                    }
                    fragmentManager.beginTransaction().replace(R.id.frame,fragment).addToBackStack(null).commit();

                }
            });

        }
    }

}
