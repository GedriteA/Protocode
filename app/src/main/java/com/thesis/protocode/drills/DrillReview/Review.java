package com.thesis.protocode.drills.DrillReview;

/**
 * Created by martinlizardo on 3/23/2017.
 */

public class Review
{


    public int getReviewID() {
        return reviewID;
    }

    public void setReviewID(int reviewID) {
        this.reviewID = reviewID;
    }

    public int getQuestionID() {
        return questionID;
    }

    public void setQuestionID(int questionID) {
        this.questionID = questionID;
    }

    public String getQuestion() {
        return Question;
    }

    public void setQuestion(String question) {
        Question = question;
    }

    public String getCorect_answer() {
        return Corect_answer;
    }

    public void setCorect_answer(String corect_answer) {
        Corect_answer = corect_answer;
    }

    public String getUser_answer() {
        return User_answer;
    }

    public void setUser_answer(String user_answer) {
        User_answer = user_answer;
    }

    public String getDifficulty() {
        return difficulty;
    }

    public void setDifficulty(String difficulty) {
        this.difficulty = difficulty;
    }

    public int reviewID;
    public int questionID;
    public String Question;
    public String Corect_answer;
    public String User_answer;
    public String difficulty;




}
