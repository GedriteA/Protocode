package com.thesis.protocode.drills.drill;

/**
 * Created by martinlizardo on 2/10/2017.
 */

public class dataanswer
{

    private String User_answer;
    private int check_answer;
    private int q_id;
    private String difficulty;

    public static final String TABLE_ANSWER="Answer";
    public static final String Answer_ID="Answer_ID";
    public static final String User_Answer="User_answer";
    public static final String Q_ID="Question_ID";
    public static final String DIFFICULTY="difficulty";
    public static final String Check_answer="check_answer";


    public String getDifficulty() {
        return difficulty;
    }

    public void setDifficulty(String difficulty) {
        this.difficulty = difficulty;
    }

    public int getCheck_answer() {
        return check_answer;
    }

    public void setCheck_answer(int check_answer) {
        this.check_answer = check_answer;
    }

    public String getUser_answer() {
        return User_answer;
    }

    public void setUser_answer(String user_answer) {
        User_answer = user_answer;
    }

    public int getQ_id() {
        return q_id;
    }

    public void setQ_id(int q_id) {
        this.q_id = q_id;
    }


}
