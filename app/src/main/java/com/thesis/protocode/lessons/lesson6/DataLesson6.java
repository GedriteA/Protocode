package com.thesis.protocode.lessons.lesson6;

/**
 * Created by martinlizardo on 2/12/2017.
 */

public class DataLesson6
{
    public String getLessonTitle() {
        return lessonTitle;
    }

    public void setLessonTitle(String lessonTitle) {
        this.lessonTitle = lessonTitle;
    }

    public String getLessonDef() {
        return lessonDef;
    }

    public void setLessonDef(String lessonDef) {
        this.lessonDef = lessonDef;
    }

    public DataLesson6(String lessonTitle) {
        this.lessonTitle = lessonTitle;
    }
    public DataLesson6(){}

    public DataLesson6(String lessonTitle, String lessonDef) {
        this.lessonTitle = lessonTitle;
        this.lessonDef = lessonDef;
    }

    String lessonTitle;
    String lessonDef;

}
