package com.thesis.protocode.lessons.lesson1;

/**
 * Created by martinlizardo on 2/13/2017.
 */

public class DataLesson1
{
    public DataLesson1(){}

    public String getLessonName() {
        return lessonName;
    }

    public void setLessonName(String lessonName) {
        this.lessonName = lessonName;
    }

    public DataLesson1(String lessonName, String lessonDef1, String lessonTitle2, String lessonDef2) {
        this.lessonName = lessonName;
        this.lessonDef1 = lessonDef1;
        this.lessonTitle2 = lessonTitle2;
        this.lessonDef2 = lessonDef2;
    }

    String lessonName;

    String lessonDef1;
    String lessonTitle2;
    String lessonDef2;




    public String getLessonDef1() {
        return lessonDef1;
    }

    public void setLessonDef1(String lessonDef1) {
        this.lessonDef1 = lessonDef1;
    }

    public String getLessonTitle2() {
        return lessonTitle2;
    }

    public void setLessonTitle2(String lessonTitle2) {
        this.lessonTitle2 = lessonTitle2;
    }

    public String getLessonDef2() {
        return lessonDef2;
    }

    public void setLessonDef2(String lessonDef2) {
        this.lessonDef2 = lessonDef2;
    }
}
