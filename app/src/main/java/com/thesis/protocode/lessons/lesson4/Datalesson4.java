package com.thesis.protocode.lessons.lesson4;

/**
 * Created by martinlizardo on 2/11/2017.
 */

public class Datalesson4
{
    public String getLessonName() {
        return lessonName;
    }

    public void setLessonName(String lessonName) {
        this.lessonName = lessonName;
    }

    public String getLessonDef() {
        return lessonDef;
    }

    public void setLessonDef(String lessonDef) {
        this.lessonDef = lessonDef;
    }

    public String getLessonTypes() {
        return lessonTypes;
    }

    public void setLessonTypes(String lessonTypes) {
        this.lessonTypes = lessonTypes;
    }

    public String getSyntaxFunction() {
        return syntaxFunction;
    }

    public void setSyntaxFunction(String syntaxFunction) {
        this.syntaxFunction = syntaxFunction;
    }

    public String getLessonParamTypes() {
        return lessonParamTypes;
    }

    public void setLessonParamTypes(String lessonParamTypes) {
        this.lessonParamTypes = lessonParamTypes;
    }

    public Datalesson4(String lessonName, String lessonDef, String lessonTypes, String syntaxFunction, String lessonParamTypes) {
        this.lessonName = lessonName;
        this.lessonDef = lessonDef;
        this.lessonTypes = lessonTypes;
        this.syntaxFunction = syntaxFunction;
        this.lessonParamTypes = lessonParamTypes;
    }

    String lessonName;
    String lessonDef;
    String lessonTypes;
    String syntaxFunction;
    String lessonParamTypes;

    public Datalesson4(){}

}
