package com.thesis.protocode.drills;

/**
 * Created by martinlizardo on 2/8/2017.
 */
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.thesis.protocode.database.DBHelper;
import com.thesis.protocode.drills.DrillReview.Review;
import com.thesis.protocode.drills.drill.dataanswer;
import com.thesis.protocode.drills.drill.datadrill;

import java.util.ArrayList;
import java.util.List;

public class DBDrill
{
    private DBHelper dbHelper;
    public datadrill drill;
    public static  int score;
    public DBDrill(Context context) {

        dbHelper = new DBHelper(context);
    }
    public void addQuestion(){
        SQLiteDatabase db= dbHelper.getReadableDatabase();
        try{
            Cursor c=db.rawQuery("SELECT * From Drill",null);
            c.moveToFirst();
            int j=c.getCount();
            c.moveToFirst();

           if(j>0){
               c.close();

           }
           else{

                for(int i=0; i<60;i++)
                {
                    drill=datadrill.questions[i];
                    datadrill question=new datadrill();
                    question.setQuestions(drill.getQuestions());
                    question.setOption1(drill.getOption1());
                    question.setOption2(drill.getOption2());
                    question.setOption3(drill.getOption3());
                    question.setOption4(drill.getOption4());
                    question.setAnswer(drill.getAnswer());
                    question.setDifficulty(drill.getDifficulty());
                    this.insertQuestion(question);
                }

            }
        }catch (Exception e)
        {
            e.printStackTrace();

        }


    }

    public void insertQuestion(datadrill mdrill) {
      SQLiteDatabase db = dbHelper.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(mdrill.QUESTION, mdrill.getQuestions());
        values.put(mdrill.OPTION1, mdrill.getOption1());
        values.put(mdrill.OPTION2, mdrill.getOption2());
        values.put(mdrill.OPTION3, mdrill.getOption3());
        values.put(mdrill.OPTION4, mdrill.getOption4());
        values.put(mdrill.ANSWER,mdrill.getAnswer());
        values.put(mdrill.DIFFICULTY,mdrill.getDifficulty());
        db.insert(mdrill.TABLE_DRILL, null, values);
        db.close();
    }

    public List<datadrill> getAllQuestion(String difficulty) {
        List<datadrill> Question = new ArrayList<datadrill>();


        String selectQuery = "SELECT * FROM " + drill.TABLE_DRILL + " WHERE "
                + drill.DIFFICULTY + " =?" + "Order by Random() limit 10";
        Log.e("main", selectQuery);
        SQLiteDatabase db = dbHelper.getReadableDatabase();
        Cursor c = db.rawQuery(selectQuery,new String[]{difficulty});

        // looping through all rows and adding to list
        if (c.moveToFirst()) {
            do {
                datadrill drill=new datadrill();
                drill.setQuestions(c.getString(c.getColumnIndexOrThrow(datadrill.QUESTION)));
                drill.setOption1(c.getString(c.getColumnIndexOrThrow(datadrill.OPTION1)));
                drill.setOption2(c.getString(c.getColumnIndexOrThrow(datadrill.OPTION2)));
                drill.setOption3(c.getString(c.getColumnIndexOrThrow(datadrill.OPTION3)));
                drill.setOption4(c.getString(c.getColumnIndexOrThrow(datadrill.OPTION4)));
                drill.setAnswer(c.getString(c.getColumnIndexOrThrow(datadrill.ANSWER)));
                drill.setId(c.getInt(c.getColumnIndex(datadrill.QUESTION_ID)));
                // adding to todo list
                Question.add(drill);
            } while (c.moveToNext());
        }
        db.close();
        return  Question;
    }

    public List<Review>getAllAnswers(){
        List<Review> drilLReview=new ArrayList<Review>();
        String selectQuery = "Select Drill.Question_ID,Drill.Question,Drill.answer,Answer.User_answer,Answer.difficulty from Drill inner join Answer on Drill.Question_ID=Answer.Question_ID";
        SQLiteDatabase db = dbHelper.getReadableDatabase();
        Cursor c = db.rawQuery(selectQuery, new String[] {});
        Log.e("main", selectQuery);
        if(c.moveToFirst()){
            do{
                Review drillAnswers=new Review();
                drillAnswers.setQuestionID(c.getColumnIndex("Question_ID"));
                drillAnswers.setQuestion(c.getString(c.getColumnIndex("Question")));
                drillAnswers.setUser_answer(c.getString(c.getColumnIndex("User_answer")));
                drillAnswers.setCorect_answer(c.getString(c.getColumnIndex("answer")));

                drilLReview.add(drillAnswers);
            }while(c.moveToNext());
        }

        db.close();
        return  drilLReview;
    }


  public int deleteAnswer() {
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        int i=db.delete(drill.TABLE_ANSWER,null,null);
        return i;
    }


    public void saveAnswer(dataanswer mdrill)
    {
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(mdrill.User_Answer,mdrill.getUser_answer());
        values.put(mdrill.Q_ID,mdrill.getQ_id());
        values.put(mdrill.Check_answer,mdrill.getCheck_answer());
        values.put(mdrill.DIFFICULTY,mdrill.getDifficulty());
        db.insert(mdrill.TABLE_ANSWER, null, values);
    }
    public void ShowScore(String difficulty)
    {
        SQLiteDatabase db= dbHelper.getReadableDatabase();
        try{
            Cursor c=db.rawQuery("SELECT SUM(check_answer) FROM Answer where difficulty=?",new String[]{difficulty});
            c.moveToFirst();
            int i=c.getCount();
            c.moveToFirst();

            if(i<=0){
                score=0;
                c.close();

            }
            else{

             score=c.getInt(0);
                c.close();

            }
        }catch (Exception e)
        {
            e.printStackTrace();

        }


    }

    public Cursor QueryData(String query){
        SQLiteDatabase db= dbHelper.getReadableDatabase();
        return db.rawQuery(query,null);
    }

}
