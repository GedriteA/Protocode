package com.thesis.protocode.lessons.lesson2;

import android.graphics.Bitmap;

/**
 * Created by martinlizardo on 1/31/2017.
 */

public class dataLesson
{


    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    int image;
    String lessonName;
    String syntax;
    String lessondef;

    public dataLesson(){

    }
    public String getLessondef() {
        return lessondef;
    }

    public void setLessondef(String lessondef) {
        this.lessondef = lessondef;
    }

    public String getSyntax() {
        return syntax;
    }

    public void setSyntax(String syntax) {
        this.syntax = syntax;
    }



    public dataLesson(String lessonName,String lessondef,String syntax){
        this.lessonName=lessonName;
        this.lessondef=lessondef;
        this.syntax=syntax;
    }
    public String getLessonName() {
        return lessonName;
    }

    public void setLessonName(String lessonName) {
        this.lessonName = lessonName;
    }

}
