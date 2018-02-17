package com.thesis.protocode.lessons.lesson5;

/**
 * Created by martinlizardo on 2/12/2017.
 */

public class DataLesson5
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

    public String getLessonNotes() {
        return lessonNotes;
    }

    public void setLessonNotes(String lessonNotes) {
        this.lessonNotes = lessonNotes;
    }

    public String getLessonSyntax() {
        return lessonSyntax;
    }

    public void setLessonSyntax(String lessonSyntax) {
        this.lessonSyntax = lessonSyntax;
    }

    String lessonTitle;
    String lessonDef;
    String lessonNotes;
    String lessonSyntax;

    public DataLesson5(String lessonTitle, String lessonDef, String lessonNotes, String lessonSyntax) {
        this.lessonTitle = lessonTitle;
        this.lessonDef = lessonDef;
        this.lessonNotes = lessonNotes;
        this.lessonSyntax = lessonSyntax;
    }

    public DataLesson5(){}
}
