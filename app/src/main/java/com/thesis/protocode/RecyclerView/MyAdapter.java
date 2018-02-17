package com.thesis.protocode.RecyclerView;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.thesis.protocode.R;
import java.util.ArrayList;

/**
 * Created by martinlizardo on 1/30/2017.
 */

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder>
{
    Context context;
    ArrayList<MyObjectProvider.MyObject> MyObjects=new ArrayList<>();

    public MyAdapter(Context context)
    {
        this.context=context;
        MyObjects=new MyObjectProvider(context).getObjects();


    }

    @Override
    public MyAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.row,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MyAdapter.ViewHolder holder, int position) {
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
            imageview=(ImageView) itemView.findViewById(R.id.my_image);
            mCardView=(CardView)itemView.findViewById(R.id.my_cardview);
            itemView.setOnClickListener(new View.OnClickListener()
            {
                @Override
                public void onClick(View v)
                {
                    int tag=(int)v.getTag();

                    switch(tag) {

                    }
                }
            });

        }
    }

}
