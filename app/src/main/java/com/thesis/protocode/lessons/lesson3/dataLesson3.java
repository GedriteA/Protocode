package com.thesis.protocode.lessons.lesson3;

/**
 * Created by martinlizardo on 2/8/2017.
 */

public class dataLesson3
{
    public String getLessonName() {
        return lessonName;
    }

    public void setLessonName(String lessonName) {
        this.lessonName = lessonName;
    }

    public String getSyntax() {
        return syntax;
    }

    public void setSyntax(String syntax) {
        this.syntax = syntax;
    }

    public String getLessondef() {
        return lessondef;
    }
    public dataLesson3(){}
    public void setLessondef(String lessondef) {
        this.lessondef = lessondef;
    }

    public dataLesson3(String lessonName,String lessondef,String syntax){
        this.lessonName=lessonName;
        this.lessondef=lessondef;
        this.syntax=syntax;
    }
    String lessonName;
    String syntax;
    String lessondef;
}
