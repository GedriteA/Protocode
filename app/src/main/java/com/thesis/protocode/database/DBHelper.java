package com.thesis.protocode.database;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.thesis.protocode.dictionary.Dictionary;
import com.thesis.protocode.drills.drill.datadrill;
import com.thesis.protocode.lessons.lesson1.DataLesson1;
import com.thesis.protocode.lessons.lesson2.dataLesson;
import com.thesis.protocode.lessons.lesson3.dataLesson3;
import com.thesis.protocode.lessons.lesson4.Datalesson4;
import com.thesis.protocode.lessons.lesson5.DataLesson5;
import com.thesis.protocode.lessons.lesson6.DataLesson6;

import java.util.ArrayList;
import java.util.List;

import static com.thesis.protocode.drills.drill.datadrill.ANSWER;
import static com.thesis.protocode.drills.drill.datadrill.Answer_ID;
import static com.thesis.protocode.drills.drill.datadrill.Check_answer;
import static com.thesis.protocode.drills.drill.datadrill.DIFFICULTY;
import static com.thesis.protocode.drills.drill.datadrill.OPTION1;
import static com.thesis.protocode.drills.drill.datadrill.OPTION2;
import static com.thesis.protocode.drills.drill.datadrill.OPTION3;
import static com.thesis.protocode.drills.drill.datadrill.OPTION4;
import static com.thesis.protocode.drills.drill.datadrill.QUESTION;
import static com.thesis.protocode.drills.drill.datadrill.Q_ID;
import static com.thesis.protocode.drills.drill.datadrill.TABLE_ANSWER;
import static com.thesis.protocode.drills.drill.datadrill.TABLE_DRILL;
import static com.thesis.protocode.drills.drill.datadrill.User_Answer;

/**
 * Created by martinlizardo on 12/30/2016.
 */
public class DBHelper extends SQLiteOpenHelper
{
    public Dictionary DataDictionary;
    private static final String DATABASE="my_db";
    public datadrill drill;

    //Lesson1//
    private static final String TABLE_LESSON1="lesson1";
    private static final String KEY_ID1="id";
    private static final String KEY_LESSON_NAME1="lesson1_name";
    private static final String KEY_LESSON_DEF1="lesson1_def1";
    private static final String KEY_LESSON_TITLE2="lesson1_title2";
    private static final String KEY_LESSON_DEF2="lesson1_def2";

    //Lesson2//
    private static final String TABLE_LESSON="lesson";
    private static final String KEY_ID="id";
    private static final String KEY_LESSON_NAME="lesson_name";
    private static final String KEY_LESSON_DEF="lesson_def";
    private static final String KEY_SYNTAX="syntax";

    //Lesson3//
    private static final String TABLE_LESSON3="lesson3";
    private static final String KEY_ID3="id3";
    private static final String KEY_LESSON_NAME3="lesson_name3";
    private static final String KEY_LESSON_DEF3="lesson_def3";
    private static final String KEY_SYNTAX3="syntax3";

    //Lesson4//
    private static final String TABLE_LESSON4="lesson4";
    private static final String KEY_ID4="id4";
    private static final String LESSON4_NAME="lesson_name4";
    private static final String LESSON4_DEF="lesson_def4";
    private static final String TYPES_FUNCTION="functions";
    private static final String SYNTAX_SAMPLE="syntax4";
    private static final String Function_Param="Param";

    //Lesson5

    private static final String TABLE_LESSON5="lesson5";
    private static final String KEY_ID5="id5";
    private static final String LESSON5_NAME="lesson_name5";
    private static final String LESSON5_DEF="lesson_def5";
    private static final String LESSON5_NOTES="notes";
    private static final String LESSON5_SYNTAX="syntax5";

    //Lesson6
    private static final String TABLE_LESSON6="lesson6";
    private static final String KEY_ID6="id6";
    private static final String KEY_LESSON_NAME6="lesson_name6";
    private static final String KEY_LESSON_DEF6="lesson_def6";


    public DBHelper(Context context)
    {

        super(context, DATABASE, null, 3);
    }

    public void onCreate(SQLiteDatabase db)
    {
        db.execSQL(CREATE_LESSONS4_TABLE);
        db.execSQL(CREATE_TABLE_Dictionary);
        db.execSQL(CREATE_LESSONS_TABLE);
        db.execSQL(CREATE_LESSONS3_TABLE);
        db.execSQL(Create_Question_TABLE);
        db.execSQL(CREATE_LESSON5_TABLE);
        db.execSQL(CREATE_LESSONS6_TABLE);
        db.execSQL(CREATE_LESSONS1_TABLE);
        db.execSQL(CREATE_ANSWER);




    }
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion)
    {
        db.execSQL("DROP TABLE IF EXISTS " + DataDictionary.TABLE);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_LESSON1);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_LESSON);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_LESSON3);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_DRILL);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_ANSWER);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_LESSON4);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_LESSON5);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_LESSON6);
        onCreate(db);

    }

    //TABLES
    String CREATE_LESSONS1_TABLE = "CREATE TABLE " + TABLE_LESSON1 + "("
            + KEY_ID1 + " INTEGER PRIMARY KEY," + KEY_LESSON_NAME1 + " TEXT," + KEY_LESSON_DEF1 + " TEXT," + KEY_LESSON_TITLE2 + " TEXT," + KEY_LESSON_DEF2 + " TEXT)";

    String CREATE_TABLE_Dictionary = "CREATE TABLE " + DataDictionary.TABLE  + "("
            + DataDictionary.KEY_ID  + " INTEGER PRIMARY KEY AUTOINCREMENT ,"
            + DataDictionary.KEY_word + " TEXT, "
            + DataDictionary.KEY_meaning + " TEXT, "
            + DataDictionary.KEY_Example + " TEXT )";


    String CREATE_LESSONS_TABLE = "CREATE TABLE " + TABLE_LESSON + "("
            + KEY_ID + " INTEGER PRIMARY KEY," + KEY_LESSON_NAME + " TEXT," + KEY_LESSON_DEF + " TEXT,"
            + KEY_SYNTAX + " TEXT)";
    String CREATE_LESSONS3_TABLE = "CREATE TABLE " + TABLE_LESSON3 + "("
            + KEY_ID3 + " INTEGER PRIMARY KEY," + KEY_LESSON_NAME3 + " TEXT," + KEY_LESSON_DEF3 + " TEXT,"
            + KEY_SYNTAX3 + " TEXT)";
    String Create_Question_TABLE="Create table " + TABLE_DRILL+ "(" + datadrill.QUESTION_ID +" integer primary key," + QUESTION +" text," + OPTION1 +" text," + OPTION2 +" text," + OPTION3 +"," + OPTION4 + " text," + ANSWER + " text," + DIFFICULTY + " text)";

    String CREATE_ANSWER = "CREATE TABLE " + TABLE_ANSWER + "("
            + Answer_ID + " INTEGER PRIMARY KEY," + User_Answer + " TEXT," + Q_ID+ " INTEGER," + DIFFICULTY + " TEXT,"
            + Check_answer + " INTEGER)";
    String CREATE_LESSONS4_TABLE = "CREATE TABLE " + TABLE_LESSON4 + "("
            + KEY_ID4 + " INTEGER PRIMARY KEY," + LESSON4_NAME + " TEXT," + LESSON4_DEF + " TEXT,"
            + TYPES_FUNCTION + " TEXT," + SYNTAX_SAMPLE + " TEXT," + Function_Param + " TEXT)";
    String CREATE_LESSON5_TABLE="CREATE TABLE " + TABLE_LESSON5 + "("
            + KEY_ID5 + " INTEGER PRIMARY KEY," + LESSON5_NAME + " TEXT," + LESSON5_DEF + " TEXT," + LESSON5_NOTES + " TEXT," + LESSON5_SYNTAX + " TEXT)";

    String CREATE_LESSONS6_TABLE = "CREATE TABLE " + TABLE_LESSON6 + "("
            + KEY_ID6 + " INTEGER PRIMARY KEY," + KEY_LESSON_NAME6 + " TEXT," + KEY_LESSON_DEF6 + " TEXT)";



    public void insertLesson1(DataLesson1 lesson){

             SQLiteDatabase db=this.getWritableDatabase();
                ContentValues values = new ContentValues();
                values.put(KEY_LESSON_NAME1,lesson.getLessonName());
                values.put(KEY_LESSON_DEF1, lesson.getLessonDef1());
                values.put(KEY_LESSON_TITLE2, lesson.getLessonTitle2());
                values.put(KEY_LESSON_DEF2, lesson.getLessonDef2());
                db.insert(TABLE_LESSON1, null, values);


    }

    public void addLesson1(){
        SQLiteDatabase db= this.getReadableDatabase();
        try {

            Cursor c=db.rawQuery("SELECT * From lesson1",null);
            c.moveToFirst();
            int i=c.getCount();
            c.moveToFirst();

            if(i>0){

                c.close();

            }
            else {
                DataLesson1 origin = new DataLesson1("Origin of C", "In 1970 a programmer, Dennis Ritchie, created a new language called C.\n" +
                        "The name came about because it superseded the old programming language he was using : B.\n The language was extremely simple and flexible, and soon was used for many different types of programs.\n" +
                        "It quickly became one of the most popular programming languages in the world.", "Features of C", "Fast and Efficient\n" +
                        "Programs written in C are efficient and fast. This is due to its variety of data type and powerful operators.\n" +
                        "\n" +
                        "Portable\n" +
                        "C is highly portable. This means that programs once written can be run on another machines with little or no modification.\n" +
                        "\n" +
                        "Function and Rich Libraries\n" +
                        "C program is basically a collection of functions that are supported by C library. We can also create our own functions and add it to the C library.\n" +
                        "\n" +
                        "Modularity\n" +
                        "Modular programming is a software design technique that increases the extent to which software is composed of separate parts, called modules.\n" +
                        "\n" +
                        "Easy to Extend\n" +
                        "In C, New feature can be added at any time by programmer.\n" +
                        "\n" +
                        "Case Sensitive\n" +
                        "It is a case sensitive language, that it can differentiate the character is upper case or lower case.");
                DataLesson1 struct = new DataLesson1("Structure of C Program", "C is a case sensitive language.\n" +
                        "C Program consist of one or more functions.\n" +
                        "One function that must be present in every C program is main(). This is the 1st function called up when program execution begins", "C program basically consists of the following parts:", "Preprocessor Commands\n" +
                        "Functions\n" +
                        "Variables\n" +
                        "Statements & Expressions\n" +
                        "Comments");
                DataLesson1 var = new DataLesson1("Variables", "Variable in C Programming is called as container to store the data.\n" +
                        "Variable name may have different data types to identify the type of value stored.", "Following are the types of variable in C :", "Local Variable is accessible only from function or block in which it is declared.\n Global Variables Scope of Global variable is throughout the program");
                DataLesson1 dTypes = new DataLesson1("Data Types", "DataTypes are used for declaring variables And functions of different types.", "Following are the list of Data Types in C :", "Keyword\tMemory\tRange\n" +
                        "char or signed char\t1 Byte\t-128 to 127\n" +
                        "unsigned char\t1 Byte\t0 to 255\n" +
                        "int or signed int\t2 Byte\t-32,768 - 32,767\n" +
                        "unsigned int\t2 Byte\t0 to 65535\n" +
                        "short int or signed short int\t1 Byte\t-128 to 127\n" +
                        "unsigned short int\t1 Byte\t0 to 255\n" +
                        "long or signed long\t4 Bytes\t-2,147,483,648 to 2,147,483,647\n" +
                        "unsigned long\t4 Bytes\t0 to 4,294,967,295\n" +
                        "float\t4 Bytes\t3.4E - 38 to 3.4E + 38\n" +
                        "double\t8 Byte\t1.7E - 308 to 1.7E + 308\n" +
                        "long double\t10 Bytes\t3.4E-4932 to 1.1E + 4932\n");
                DataLesson1 InOp = new DataLesson1("Basic Input/Output", "Input : data provided to a program.\n" +
                        "Output : data provided by a program.", "", "The basic input/output function are getchar, putchar, gets, puts, scanf, printf. getchar and putchar : Single Character getchar function : Single Character Input");
                DataLesson1 arithmetic = new DataLesson1("Arithmetic Operator", "Arithmetic operators are used for Arithmetic Calculation.", "Example", "addition (+), subtraction(-), multiplication (*), division (/), and modulus (remainder) (%).");
                DataLesson1 InDe = new DataLesson1("Increment & Decrement Operator", "Increment operator (++) increases the value of its operand by 1\n" +
                        "Decrement operator (--) decreases the value of its operand by 1", "Example", "// Increment operators\n" +
                        "x = 1;\n" +
                        "y = ++x;    // x is now 2, y is also 2\n" +
                        "y = x++;    // x is now 3, y is 2\n" +
                        "\n" +
                        "// Decrement operators\n" +
                        "x = 3;\n" +
                        "y = x--;    // x is now 2, y is 3\n" +
                        "y = --x;    // x is now 1, y is also 1");
                DataLesson1 logic = new DataLesson1("Logical Operators", "Logical operators are used to perform logical operations on the given two variables.", "Example", "Operator\tUsage\n" +
                        "&&\texpr1 && expr2\n" +
                        "||\texpr1 || expr2\n" +
                        "!\t!expr1");
                DataLesson1 relational = new DataLesson1("Relational Operator", "Relational operators are used to compare the value of two variables.", "Example", "Operator\tUse\n" +
                        "==\tCheck value of 2 variable are equal\n" +
                        "!=\tCheck value of 2 variable are equal or not\n" +
                        ">\tcheck is value is greater than\n" +
                        ">=\tcheck is value is greater than or equal to\n" +
                        "<\tcheck value is less than\n" +
                        "<=\tcheck value is less than or equal to\n");
                this.insertLesson1(origin);
                this.insertLesson1(struct);
                this.insertLesson1(var);
                this.insertLesson1(dTypes);
                this.insertLesson1(InOp);
                this.insertLesson1(arithmetic);
                this.insertLesson1(InDe);
                this.insertLesson1(logic);
                this.insertLesson1(relational);
            }

        }catch (Exception e){
            e.printStackTrace();
        }



    }
    public List<DataLesson1> getAllLessons1() {
        ArrayList<DataLesson1> lessonslist = new ArrayList<DataLesson1>();
        String selectQuery = "SELECT  * FROM " +TABLE_LESSON1;
        SQLiteDatabase db= this.getReadableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);
        if (cursor.moveToFirst()) {
            do {
                DataLesson1 Lesson =new DataLesson1();
                Lesson.setLessonName(cursor.getString(cursor.getColumnIndex(KEY_LESSON_NAME1)));
                Lesson.setLessonDef1(cursor.getString(cursor.getColumnIndex(KEY_LESSON_DEF1)));
                Lesson.setLessonTitle2(cursor.getString(cursor.getColumnIndex(KEY_LESSON_TITLE2)));
                Lesson.setLessonDef2(cursor.getString(cursor.getColumnIndex(KEY_LESSON_DEF2)));
                lessonslist.add(Lesson);
            } while (cursor.moveToNext());
        }
        return lessonslist;
    }

    //TABLE 2
    public void insertLesson(dataLesson lesson) {


                SQLiteDatabase db=this.getWritableDatabase();
                ContentValues values = new ContentValues();
                values.put(KEY_LESSON_NAME,lesson.getLessonName());
                values.put(KEY_LESSON_DEF, lesson.getLessondef());
                values.put(KEY_SYNTAX, lesson.getSyntax());
                db.insert(TABLE_LESSON, null, values);
    }

    public void addLesson(){
        SQLiteDatabase db= this.getReadableDatabase();
        try {
            Cursor c=db.rawQuery("SELECT * From lesson",null);
            c.moveToFirst();
            int i=c.getCount();
            c.moveToFirst();

            if(i>0){

                c.close();

            }
            else {
                dataLesson ifLesson = new dataLesson("If Statement", "It is used to execute an instruction given that the condition is fulfilled or true", " if(condition)\n" +
                        "    {\n" +
                        "         statement;\n" +
                        "    }");

                this.insertLesson(ifLesson);

                dataLesson ifelseLesson = new dataLesson("If-else Statement", "It is used when different set of statements is to be executed on a condition whether it is true and false", " if(condition)\n" +
                        "    {\n" +
                        "        statement 1;\n" +
                        "    }\n" +
                        "    else\n" +
                        "    {\n" +
                        "        statement 2;\n" +
                        "    }");
                this.insertLesson(ifelseLesson);
                dataLesson elseifLesson = new dataLesson("Else-if Statement", "It is used to show a multi-way decisions based on several conditions", "if(condition_2)\n" +
                        " {\n" +
                        "    statement 1;\n" +
                        " }\n" +
                        " else if (condition_2)\n" +
                        " {\n" +
                        "     statement 2;\n" +
                        " }\n" +
                        " else if(condition_n)\n" +
                        " {\n" +
                        "    statement 3;\n" +
                        " }\n" +
                        " else\n" +
                        " {\n" +
                        "      statement n;\n" +
                        " }");
                this.insertLesson(elseifLesson);


                dataLesson nestedifLesson = new dataLesson("Nested if-else", "It is used to show when a series of decisions are involved", "if(condition)\n" +
                        "        {\n" +
                        "        //statement\n" +
                        "        }\n" +
                        "else if(condition)\n" +
                        "        {\n" +
                        "          if(condition)\n" +
                        "          {\n" +
                        "          // statement 1\n" +
                        "          }\n" +
                        "          else\n" +
                        "          {\n" +
                        "          //statement 2\n" +
                        "          }\n" +
                        "\n" +
                        "      \t}");

                this.insertLesson(nestedifLesson);

                dataLesson switchLesson = new dataLesson("Switch", "It is used when we need to make a decision based on a condition then execute it accordingly",
                        "switch (<variable>)\n" +
                                "    {\n" +
                                "    case a-constant-expression :\n" +
                                "    //Code to execute if <variable> == a-constant-expression\n" +
                                "    break;\n" +
                                "\n" +
                                "    case b-constant-expression :\n" +
                                "    //Code to execute if <variable> == b-constant-expression\n" +
                                "    break;\n" +
                                " \n" +
                                "\n" +
                                "    default:\n" +
                                "    //Code to execute if <variable> does not equal the value following any of the cases\n" +
                                "    }");

                this.insertLesson(switchLesson);
            }
        }catch(Exception e){

        }

    }

    public List<dataLesson> getAllLessons() {
        ArrayList<dataLesson> lessonslist = new ArrayList<dataLesson>();
        String selectQuery = "SELECT  * FROM " +TABLE_LESSON;
        SQLiteDatabase db= this.getReadableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);
        if (cursor.moveToFirst()) {
            do {
                dataLesson Lesson =new dataLesson();
                Lesson.setLessonName(cursor.getString(cursor.getColumnIndex(KEY_LESSON_NAME)));
                Lesson.setLessondef(cursor.getString(cursor.getColumnIndex(KEY_LESSON_DEF)));
                Lesson.setSyntax(cursor.getString(cursor.getColumnIndex(KEY_SYNTAX)));


                lessonslist.add(Lesson);
            } while (cursor.moveToNext());
        }
        return lessonslist;
    }


    //Table 3
    public void insertLesson3(dataLesson3 lesson) {

                SQLiteDatabase db = this.getWritableDatabase();
                ContentValues values = new ContentValues();
                values.put(KEY_LESSON_NAME3, lesson.getLessonName());
                values.put(KEY_LESSON_DEF3, lesson.getLessondef());
                values.put(KEY_SYNTAX3, lesson.getSyntax());
                db.insert(TABLE_LESSON3, null, values);
    }



    public void addLesson3(){
        SQLiteDatabase db = this.getReadableDatabase();
        try {

            Cursor c = db.rawQuery("SELECT * From lesson3", null);
            c.moveToFirst();
            int i = c.getCount();
            c.moveToFirst();
            if (i>0) {

                c.close();

            }
            else {
                dataLesson3 forLesson = new dataLesson3("For Loop", "Loops are used to repeat a block of code.\n init - Initializes the variable at the beginning of the loop to some value. This value is the starting point of the loop.\n" +
                        "\n" +
                        "condition - Decides whether the loop will continue running or not. While this condition is true, the loop will continue running.\n" +
                        "\n" +
                        "increment - The part of the loop that changes the value of the variable created in the variable declaration part of the loop. The increment statement is the part of the loop which will eventually stop the loop from running.",
                        " for (init; condition; increment)\n" +
                                " {\n" +
                                "    // block of statement.\n" +
                                " }");
                this.insertLesson3(forLesson);
                dataLesson3 nestedLesson = new dataLesson3("Nested For Loop", "A for loop inside another for loop", "for ( init; condition; increment ) {\n" +
                        "\n" +
                        "   for ( init; condition; increment ) {\n" +
                        "      statement(s);\n" +
                        "   }\n" +
                        "\t\n" +
                        "   statement(s);\n" +
                        "}");
                this.insertLesson3(nestedLesson);
                dataLesson3 whileLesson = new dataLesson3("While loop", "repeatedly executes a target statement as long as a given condition is true.", "  while( condition )\n" +
                        "    {\n" +
                        "    statement(s);\n" +
                        "    }");
                this.insertLesson3(whileLesson);
                dataLesson3 doLesson = new dataLesson3("Do While loop", "It is similar to a while loop, except that a do-while loop is guaranteed to execute at least one time. The conditional expression appears at the end of the loop, so the statement(s) in the loop execute once before the condition is tested", "   do\n" +
                        "    {\n" +
                        "    statement(s);\n" +
                        "    } while( condition );\n");
                this.insertLesson3(doLesson);
            }
        }catch(Exception e)
        {
            e.printStackTrace();
        }
    }

    public List<dataLesson3> getAllLessons3() {
        ArrayList<dataLesson3> lessonslist = new ArrayList<dataLesson3>();
        String selectQuery = "SELECT  * FROM " +TABLE_LESSON3;
        SQLiteDatabase db= this.getReadableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);
        if (cursor.moveToFirst()) {
            do {
                dataLesson3 Lesson =new dataLesson3();
                Lesson.setLessonName(cursor.getString(cursor.getColumnIndex(KEY_LESSON_NAME3)));
                Lesson.setLessondef(cursor.getString(cursor.getColumnIndex(KEY_LESSON_DEF3)));
                Lesson.setSyntax(cursor.getString(cursor.getColumnIndex(KEY_SYNTAX3)));
                lessonslist.add(Lesson);
            } while (cursor.moveToNext());
        }
        return lessonslist;
    }

    //TABLE4
    public void insertLesson4(Datalesson4 lesson) {
        SQLiteDatabase db=this.getWritableDatabase();
                ContentValues values = new ContentValues();
                values.put(LESSON4_NAME,lesson.getLessonName());
                values.put(LESSON4_DEF, lesson.getLessonDef());
                values.put(TYPES_FUNCTION, lesson.getLessonTypes());
                values.put(SYNTAX_SAMPLE, lesson.getSyntaxFunction());
                values.put(Function_Param, lesson.getLessonParamTypes());
                db.insert(TABLE_LESSON4, null, values);

            }


    public void addLesson4(){
        SQLiteDatabase db = this.getReadableDatabase();
        try {
            Cursor c = db.rawQuery("SELECT * From lesson4", null);
            c.moveToFirst();
            int i = c.getCount();
            c.moveToFirst();

            if (i>0) {

                c.close();

            }else {
                Datalesson4 data1 = new Datalesson4("Functions", "A function is a block of statements, which is used to perform a specific task.\n" +
                        "A C program has at least one function named main().", "Library functions \n" +
                        "are the built-in function in C such as puts(), gets(), printf(), scanf() etc.\n" +
                        "User defined function\n" +
                        "These are the functions which already have a definition in header files.\n", "return_type function_name (argument list)\n" +
                        "{\n" +
                        "    Block of code\n" +
                        "}\n" +
                        "return_type : return types are the type of data that is returned by the function. If nothing is returned then the return type is void.\n" +
                        "\n" +
                        "argument list : argument list contains variables names along with their data types. These arguments are inputs for the function.\t", "Actual parameters :\n" +
                        "Are parameters that appear in function calls.\n" +
                        "Formal parameters :\n" +
                        "Are parameters that appear in function declarations.");
                this.insertLesson4(data1);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public List<Datalesson4> getAllLessons4() {
        ArrayList<Datalesson4> lessonslist = new ArrayList<Datalesson4>();
        String selectQuery = "SELECT  * FROM " +TABLE_LESSON4;
        SQLiteDatabase db= this.getReadableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);
        if (cursor.moveToFirst()) {
            do {
                Datalesson4 Lesson =new Datalesson4();
                Lesson.setLessonName(cursor.getString(cursor.getColumnIndex(LESSON4_NAME)));
                Lesson.setLessonDef(cursor.getString(cursor.getColumnIndex(LESSON4_DEF)));
                Lesson.setLessonTypes(cursor.getString(cursor.getColumnIndex(TYPES_FUNCTION)));
                Lesson.setSyntaxFunction(cursor.getString(cursor.getColumnIndex(SYNTAX_SAMPLE)));
                Lesson.setLessonParamTypes(cursor.getString(cursor.getColumnIndex(Function_Param)));
                lessonslist.add(Lesson);
            } while (cursor.moveToNext());
        }
        return lessonslist;
    }



    //TABLE 5
    public void insertLesson5(DataLesson5 lesson) {
        SQLiteDatabase db = this.getReadableDatabase();
        try {
            Cursor c = db.rawQuery("SELECT * From lesson5", null);
            c.moveToFirst();
            int i = c.getCount();
            c.moveToFirst();

            if (i>0) {

                c.close();

            } else {
                db=this.getWritableDatabase();
                ContentValues values = new ContentValues();
                values.put(LESSON5_NAME,lesson.getLessonTitle());
                values.put(LESSON5_DEF, lesson.getLessonDef());
                values.put(LESSON5_NOTES, lesson.getLessonNotes());
                values.put(LESSON5_SYNTAX, lesson.getLessonSyntax());
                db.insert(TABLE_LESSON5, null, values);

           }


        } catch (Exception e) {
            e.printStackTrace();

        }

    }

    public void addLesson5(){
        SQLiteDatabase db = this.getReadableDatabase();
        try {
            Cursor c = db.rawQuery("SELECT * From lesson5", null);
            c.moveToFirst();
            int i = c.getCount();
            c.moveToFirst();

            if (i>0) {

                c.close();

            }
            else {
                DataLesson5 array = new DataLesson5("Array", "Array is collection of similar data type. for example array of int type data or float", "*index of array starts with zero (0).\n" +
                        "*index of last element in array is n-1, where n is the size of the array\n" +
                        "*array has static memory allocation. i.e memory size once allocated for an array cannot be changed.\n", " datatype array_name [array_size];");
                DataLesson5 pointers = new DataLesson5("Pointers", "Pointer is a variable that points to an address of a value.", "& (ampersand sign) : ‘Address of operator’. It determines the address of a variable.\n" +
                        "* (asterisk sign) : indirection operator / value at address. Accesses the value at the address.", "datatype *variable_name;");
                DataLesson5 linked = new DataLesson5("Linked List", "Linked List is a dynamic data structure which contains memory blocks occupying random memory locations. The elements in the linked list are called nodes.", "Link - Each Link of a linked list can store a data called an element.\n" +
                        "Next - Each Link of a linked list contain a link to next link called Next.\n" +
                        "LinkedList - A LinkedList contains the connection link to the first Link called First.", "struct structure_name\n" +
                        "{\n" +
                        "    data_type member1;\n" +
                        "    data_type member2;\n" +
                        "    .\n" +
                        "    .\n" +
                        "    data_type memeberN;\n" +
                        "};");


                this.insertLesson5(array);
                this.insertLesson5(pointers);
                this.insertLesson5(linked);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public List<DataLesson5> getAllLessons5() {
        ArrayList<DataLesson5> lessonslist = new ArrayList<DataLesson5>();
        String selectQuery = "SELECT  * FROM " +TABLE_LESSON5;
        SQLiteDatabase db= this.getReadableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);
        if (cursor.moveToFirst()) {
            do {
                DataLesson5 Lesson =new DataLesson5();
                Lesson.setLessonTitle(cursor.getString(cursor.getColumnIndex(LESSON5_NAME)));
                Lesson.setLessonDef(cursor.getString(cursor.getColumnIndex(LESSON5_DEF)));
                Lesson.setLessonNotes(cursor.getString(cursor.getColumnIndex(LESSON5_NOTES)));
                Lesson.setLessonSyntax(cursor.getString(cursor.getColumnIndex(LESSON5_SYNTAX)));
                lessonslist.add(Lesson);
            } while (cursor.moveToNext());
        }
        return lessonslist;
    }

    //TABLE 6

    public void insertLesson6(DataLesson6 lesson)
    {

        SQLiteDatabase db=this.getWritableDatabase();
                ContentValues values = new ContentValues();
                values.put(KEY_LESSON_NAME6,lesson.getLessonTitle());
                values.put(KEY_LESSON_DEF6, lesson.getLessonDef());
                db.insert(TABLE_LESSON6, null, values);



    }

    public void addLesson6(){
        SQLiteDatabase db = this.getReadableDatabase();
        try{
        Cursor c=db.rawQuery("SELECT * From lesson6",null);
        c.moveToFirst();
        int i=c.getCount();
        c.moveToFirst();

        if(i>0){

        c.close();

        }
        else{
        DataLesson6 Bsort=new DataLesson6("Bubble Sort","This sorting algorithm is comparison-based algorithm in which each pair of adjacent elements is compared and the elements are swapped if they are not in order.");
        DataLesson6 Msort=new DataLesson6("Merge Sort","Merge sort is a sorting technique based on divide and conquer technique. With worst-case time complexity being Ο(n log n), it is one of the most respected algorithms.\n"+
        "Merge sort first divides the array into equal halves and then combines them in a sorted manner.");
        DataLesson6 Qsort=new DataLesson6("Quick Sort","Quick sort is a highly efficient sorting algorithm and is based on partitioning of array of data into smaller arrays.\n"+
        "A large array is partitioned into two arrays one of which holds values smaller than the specified value, say pivot, based on which the partition is made and another array holds values greater than the pivot value.");
        DataLesson6 Isort=new DataLesson6("Insertion Sort","Insertion is a simplest data Sorting algorithm which sorts the array elements by shifting elements one by one and inserting each element into its proper position. This technique is also used for sort array elements.");

        this.insertLesson6(Bsort);
        this.insertLesson6(Msort);
        this.insertLesson6(Qsort);
        this.insertLesson6(Isort);
        }
        }catch(Exception e){
            e.printStackTrace();
        }

    }


    public List<DataLesson6> getAllLessons6() {
        ArrayList<DataLesson6> lessonslist = new ArrayList<DataLesson6>();
        String selectQuery = "SELECT  * FROM " +TABLE_LESSON6;
        SQLiteDatabase db= this.getReadableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);
        if (cursor.moveToFirst()) {
            do {
                DataLesson6 Lesson =new DataLesson6();
                Lesson.setLessonTitle(cursor.getString(cursor.getColumnIndex(KEY_LESSON_NAME6)));
                Lesson.setLessonDef(cursor.getString(cursor.getColumnIndex(KEY_LESSON_DEF6)));
                lessonslist.add(Lesson);
            } while (cursor.moveToNext());
        }
        return lessonslist;
    }
}
