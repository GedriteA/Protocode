package com.thesis.protocode.drills.drill;

import android.content.Context;
import android.os.Bundle;
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
import com.thesis.protocode.drills.DBDrill;

import java.util.ArrayList;

/**
 * Created by martinlizardo on 1/30/2017.
 */

public class MyDrillAdapter extends RecyclerView.Adapter<MyDrillAdapter.ViewHolder>
{
    Context context;
    ArrayList<MyDrillObjectProvider.MyObject> MyObjects=new ArrayList<>();
         FragmentManager fragmentManager;
    DBDrill drill=new DBDrill(context);
    public MyDrillAdapter(Context context)
    {
        this.context=context;
        MyObjects=new MyDrillObjectProvider(context).getObjects();


    }

    @Override
    public MyDrillAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.drillrow,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MyDrillAdapter.ViewHolder holder, int position) {
        holder.imageview.setImageResource(MyObjects.get(position).getImageId());
        holder.mCardView.setTag(position);
        holder.txtView.setText(MyObjects.get(position).getText());


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
        TextView Score;
        public ViewHolder(final View itemView) {
            super(itemView);
            fragmentManager = ((AppCompatActivity)context).getSupportFragmentManager();
            imageview=(ImageView) itemView. findViewById(R.id.my_drillImage);
            txtView=(TextView)itemView.findViewById(R.id.drillText);
            mCardView=(CardView)itemView.findViewById(R.id.my_cardview);
            itemView.setOnClickListener(new View.OnClickListener()
            {
                @Override
                public void onClick(View v)
                {
                    int tag=(int)v.getTag();
                    Bundle bundle=new Bundle();
                    switch(tag) {
                        case 0:

                            bundle.putInt("level",tag);
                            drillContent drill = new drillContent();
                            drill.setArguments(bundle);
                            fragmentManager.beginTransaction().replace(R.id.frame,drill).addToBackStack(null).commit();
                            break;
                        case 1:

                            drillContent drill1 = new drillContent();
                            bundle.putInt("level",tag);
                            drill1.setArguments(bundle);
                            fragmentManager.beginTransaction().replace(R.id.frame,drill1).addToBackStack(null).commit();
                            break;
                        case 2:
                            drillContent drill2 = new drillContent();
                            bundle.putInt("level",tag);
                            drill2.setArguments(bundle);
                            fragmentManager.beginTransaction().replace(R.id.frame,drill2).addToBackStack(null).commit();
                            break;


                    }
                }
            });

        }
    }

}
