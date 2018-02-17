package com.thesis.protocode.lessons;

/**
 * Created by martinlizardo on 1/25/2017.
 */
import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.thesis.protocode.R;

public class CustomList  extends ArrayAdapter<String>
{
    private String[] names;
    private String[] desc;
    private Integer[] imageMore;
    private Activity context;

    public CustomList(Activity context, String[] names, String[] desc, Integer[] imageMore)
    {
        super(context, R.layout.list_row_reference, names);
        this.context = context;
        this.names = names;
        this.desc = desc;
        this.imageMore = imageMore;

    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = context.getLayoutInflater();
        View listViewItem = inflater.inflate(R.layout.list_row_reference, null, true);
        TextView textViewName = (TextView) listViewItem.findViewById(R.id.tvReferenceNo);
        TextView textViewDesc = (TextView) listViewItem.findViewById(R.id.tvReferenceTitle);
        ImageView image = (ImageView) listViewItem.findViewById(R.id.ivRefMore);
        textViewName.setText(names[position]);
        textViewDesc.setText(desc[position]);
        image.setImageResource(imageMore[position]);
        return  listViewItem;
    }
}
