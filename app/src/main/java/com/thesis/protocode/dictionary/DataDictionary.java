package com.thesis.protocode.dictionary;

/**
 * Created by martinlizardo on 1/5/2017.
 */
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.thesis.protocode.database.DBHelper;

import java.util.ArrayList;

public class DataDictionary
{
    private DBHelper dbHelper;

    public DataDictionary(Context context) {
        dbHelper = new DBHelper(context);
    }


    public int insert(Dictionary dataDictionary) {

        //Open connection to write data
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(Dictionary.KEY_word, dataDictionary.Word);
        values.put(Dictionary.KEY_meaning, dataDictionary.Meaning);
        values.put(Dictionary.KEY_Example, dataDictionary.Example);

        // Inserting Row
        long student_Id = db.insert(Dictionary.TABLE, null, values);
        db.close(); // Closing database connection
        return (int) student_Id;
    }

    public Cursor getDictionaryList() {
        //Open connection to read only
        SQLiteDatabase db = dbHelper.getReadableDatabase();

        Cursor cursor = db.rawQuery("Select rowid as _id ,id,Word,Meaning,Example from Dictionary Order BY Word Collate NOCASE", null);
        // looping through all rows and adding to list

        if (cursor == null) {
            return null;
        } else if (!cursor.moveToFirst()) {
            cursor.close();
            return null;
        }
        return cursor;


    }

    public Cursor  getDictionaryListByKeyword(String search) {
        //Open connection to read only
        SQLiteDatabase db = dbHelper.getReadableDatabase();
        String selectQuery =  "SELECT  rowid as " +
                Dictionary.KEY_ROWID + "," +
                Dictionary.KEY_ID + "," +
                Dictionary.KEY_word + "," +
                Dictionary.KEY_meaning + "," +
                Dictionary.KEY_Example +
                " FROM " + Dictionary.TABLE +
                " WHERE " +  Dictionary.KEY_word + "  LIKE  '%" +search + "%' "
                ;


        Cursor cursor = db.rawQuery(selectQuery, null);
        // looping through all rows and adding to list

        if (cursor == null) {
            return null;
        } else if (!cursor.moveToFirst()) {
            cursor.close();
            return null;
        }
        return cursor;


    }

    public Dictionary getDataDictionaryId(String word){
        SQLiteDatabase db = dbHelper.getReadableDatabase();
        String selectQuery =  "SELECT " +
                Dictionary.KEY_ID + "," +
                Dictionary.KEY_word + "," +
                Dictionary.KEY_meaning + "," +
                Dictionary.KEY_Example +
                " FROM " + Dictionary.TABLE
                + " WHERE " +
                Dictionary.KEY_word + "=?";// It's a good practice to use parameter ?, instead of concatenate string

        int iCount =0;
        Dictionary data = new Dictionary();

        Cursor cursor = db.rawQuery(selectQuery, new String[] { String.valueOf(word) } );

        if (cursor.moveToFirst()) {
            do {
                data.word_id =cursor.getInt(cursor.getColumnIndex(Dictionary.KEY_ID));
                data.Word =cursor.getString(cursor.getColumnIndex(Dictionary.KEY_word));
                data.Meaning=cursor.getString(cursor.getColumnIndex(Dictionary.KEY_meaning));
                data.Example =cursor.getString(cursor.getColumnIndex(Dictionary.KEY_Example));

            } while (cursor.moveToNext());
        }

        cursor.close();
        db.close();
        return data;
    }
    public ArrayList<Dictionary> getDictionary(long Id){
        SQLiteDatabase db= dbHelper.getReadableDatabase();
        ArrayList<Dictionary> user =new ArrayList<Dictionary>();
        try{
            String selectQuery =  "SELECT " +
                    Dictionary.KEY_ID + "," +
                    Dictionary.KEY_word + "," +
                    Dictionary.KEY_meaning + "," +
                    Dictionary.KEY_Example +
                    " FROM " + Dictionary.TABLE
                    + " WHERE " +
                    Dictionary.KEY_ID + "=?";

            Cursor cur = db.rawQuery(selectQuery, new String[] { String.valueOf(Id) } );
            cur.moveToFirst();
            while(cur.isAfterLast()==false){
                Dictionary data = new Dictionary();
                data.word_id =cur.getInt(cur.getColumnIndex(Dictionary.KEY_ID));
                data.Word =cur.getString(cur.getColumnIndex(Dictionary.KEY_word));
                data.Meaning=cur.getString(cur.getColumnIndex(Dictionary.KEY_meaning));
                data.Example =cur.getString(cur.getColumnIndex(Dictionary.KEY_Example));
                user.add(data);
                cur.moveToNext();
            }
            return user;
        }catch(Exception e){
            return null;
        }

    }





    public void addDictionay(){
        Dictionary d1=new Dictionary("Address", "Reference to a memory location. In C pointers are used to hold addresses.","");
        this.insert(d1);
        Dictionary d2=new Dictionary("API", "Application Programming Interface","");
        this.insert(d2);
        Dictionary d3=new Dictionary("Argument","A value passed to a function","");
        this.insert(d3);
        Dictionary d4=new Dictionary("Compilation error","Error which occurs during the translation of source code into machine code.","");
        this.insert(d4);
        Dictionary d5=new Dictionary("Compiler","A program which converts source code into machine code","");
        this.insert(d5);
        Dictionary d6=new Dictionary("Escape sequence","Control codes comprising combinations of a backslash followed by letters or digits","");
        this.insert(d6);
        Dictionary d7=new Dictionary("Character","It denotes any alphabet, digit or special symbol used to represent information","");
        this.insert(d7);
        Dictionary d8=new Dictionary("Constant","It is an identifier whose associated value cannot typically be altered by the program during its execution","");
        this.insert(d8);
        Dictionary d9=new Dictionary("Pseudocode","It is an informal high-level description of the operating principle of a computer program or other algorithm","");
        this.insert(d9);
        Dictionary d10=new Dictionary("Syntax","It is the study of the principles and processes by which sentences are constructed in particular languages","");
        this.insert(d10);
        Dictionary d11=new Dictionary("Variable","it is a storage location an associated symbolic name(an identifier) which contains some known or unknown quantity or information, a value","");
        this.insert(d11);
        Dictionary d12=new Dictionary("getch()","It prompts the user to press a character and that character is not printed on screen.","");
        this.insert(d12);
        Dictionary d13=new Dictionary("Operator","it is a symbol that tells the compiler to perform a specific mathematical or logical manipulations.","");
        this.insert(d13);
        Dictionary d14=new Dictionary("Array","it is a data structure, which can store a fixed-size sequential collection of elements of the same type","");
        this.insert(d14);
        Dictionary d15=new Dictionary("Function","it is a group of statements that together perform a task","");
        this.insert(d15);
        Dictionary d16=new Dictionary("Structure","Are to group together different types of variables under the same name.","");
        this.insert(d16);


    }


}
