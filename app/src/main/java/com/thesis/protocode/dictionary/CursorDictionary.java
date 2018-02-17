package com.thesis.protocode.dictionary;

import android.content.Context;
import android.database.Cursor;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CursorAdapter;
import android.widget.TextView;

/**
 * Created by martinlizardo on 1/5/2017.
 */
import com.thesis.protocode.R;
public class CursorDictionary extends CursorAdapter
{
    private LayoutInflater mInflater;

    public CursorDictionary(Context context, Cursor c, int flags) {
        super(context, c, flags);
        mInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }
    @Override
    public View newView(Context context, Cursor cursor, ViewGroup parent) {
        View   view    =    mInflater.inflate(R.layout.item, parent, false);
        ViewHolder holder  =   new ViewHolder();
        holder.txtId    =   (TextView)  view.findViewById(R.id.txtId);
        holder.txtWord    =   (TextView)  view.findViewById(R.id.txtWord);

        view.setTag(holder);
        return view;
    }
    @Override
    public void bindView(View view, Context context, Cursor cursor) {
        //If you want to have zebra lines color effect uncomment below code
        /*if(cursor.getPosition()%2==1) {
             view.setBackgroundResource(R.drawable.item_list_backgroundcolor);
        } else {
            view.setBackgroundResource(R.drawable.item_list_backgroundcolor2);
        }*/

        ViewHolder holder  =   (ViewHolder)    view.getTag();
        holder.txtId.setText(cursor.getString(cursor.getColumnIndex(Dictionary.KEY_ID)));
        holder.txtWord.setText(cursor.getString(cursor.getColumnIndex(Dictionary.KEY_word)));


    }
    static class ViewHolder {
        TextView txtId;
        TextView txtWord;

    }

}
