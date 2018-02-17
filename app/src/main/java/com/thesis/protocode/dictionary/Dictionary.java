package com.thesis.protocode.dictionary;

/**
 * Created by martinlizardo on 12/30/2016.
 */
public class Dictionary
{
    public static final String TABLE = "Dictionary";

    // Labels Table Columns names
    public static final String KEY_ROWID = "_id";
    public static final String KEY_ID = "id";
    public static final String KEY_word = "Word";
    public static final String KEY_meaning = "Meaning";
    public static final String KEY_Example = "Example";

    public int word_id;

    public String getWord() {
        return Word;
    }

    public void setWord(String word) {
        Word = word;
    }

    public String getMeaning() {
        return Meaning;
    }

    public void setMeaning(String meaning) {
        Meaning = meaning;
    }

    public String getExample() {
        return Example;
    }

    public void setExample(String example) {
        Example = example;
    }

    public Dictionary(){

    }
    public Dictionary(String Word,String Meaning,String Example)
    {
        this.Word=Word;
        this.Meaning=Meaning;
        this.Example=Example;

    }



    public String Word;
    public String Meaning;
    public String Example;





}
