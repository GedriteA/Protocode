package com.thesis.protocode.drills.drill;

/**
 * Created by martinlizardo on 1/30/2017.
 */

import android.content.Context;

import com.thesis.protocode.database.DBHelper;

import java.util.ArrayList;


/**
 * Created by martinlizardo on 9/30/2016.
 */
public class MyDrillObjectProvider
{
    private DBHelper dbHelper;
    public MyDrillObjectProvider(Context context) {

        this.context = context;
    }

    Context context;

    public ArrayList<MyObject> getObjects()
    {
        String name[]=new String[]{"Easy","Average","Difficult"};
        ArrayList<MyObject> myObjects =new ArrayList<>();
        for(int i=1;i<=3;i++){
            MyObject myObject=new MyObject();
            myObject.setImageId(context.getResources().getIdentifier("image".concat(String.valueOf(i)),"drawable",context.getPackageName()));
            myObject.setText(name[i-1]);
            myObjects.add(myObject);

        }

        return myObjects;
    }
    public class MyObject
    {   int imageId;
        String text;


        String score;

        public String getScore() {
            return score;
        }

        public void setScore(String score) {
            this.score = score;
        }

        public int getImageId() {
            return imageId;
        }

        public void setImageId(int imageId) {
            this.imageId = imageId;
        }

        public String getText() {
            return text;
        }

        public void setText(String text) {
            this.text = text;
        }


    }
}

