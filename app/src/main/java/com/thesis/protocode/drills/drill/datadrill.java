package com.thesis.protocode.drills.drill;

/**
 * Created by martinlizardo on 2/8/2017.
 */

public class datadrill
{
    public datadrill(){

    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    //DRILL//
    public static final String TABLE_DRILL="Drill";
    public static final String QUESTION="Question";
    public static final String QUESTION_ID="Question_ID";
    public static final String OPTION1="option1";
    public static final String OPTION2="option2";
    public static final String OPTION3="option3";
    public static final String OPTION4="option4";
    public static final String ANSWER="answer";
    public static final String DIFFICULTY="difficulty";

    //DRILL Answer//
    public static final String TABLE_ANSWER="Answer";
    public static final String Answer_ID="Answer_ID";
    public static final String User_Answer="User_answer";
    public static final String Q_ID="Question_ID";
    public static final String Check_answer="check_answer";

    private int id;
    private String Questions;
    private String option1;
    private String option2;
    private String option3;
    private String option4;
    private String answer;
    private String difficulty;

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    private int score;



    public String getQuestions() {
        return Questions;
    }

    public void setQuestions(String questions) {
        Questions = questions;
    }

    public String getOption1() {
        return option1;
    }

    public void setOption1(String option1) {
        this.option1 = option1;
    }

    public String getOption2() {
        return option2;
    }

    public void setOption2(String option2) {
        this.option2 = option2;
    }

    public String getOption3() {
        return option3;
    }

    public void setOption3(String option3) {
        this.option3 = option3;
    }

    public String getOption4() {
        return option4;
    }

    public void setOption4(String option4) {
        this.option4 = option4;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public String getDifficulty() {
        return difficulty;
    }

    public void setDifficulty(String difficulty) {
        this.difficulty = difficulty;
    }

    public datadrill(String Questions,String option1,String option2,String option3,String option4,String answer,String difficulty){
        this.Questions=Questions;
        this.option1=option1;
        this.option2=option2;
        this.option3=option3;
        this.option4=option4;
        this.answer=answer;
        this.difficulty=difficulty;
    }







    public static final datadrill[] questions={
            new datadrill("He created the new language called C.","Dennis Ritchie","Dennis Richard","John Richie","Jonny Richie","Dennis Ritchie","Easy"),
            new datadrill("This operator(++) increases the value of its operand by 1.","Addition","Decrement","Increment","Checker","Increment","Easy"),
            new datadrill("The name C came about because it superseded the old programming language","C","B","C++","Java","B","Easy"),
            new datadrill("One function that must be present in every C program is?","return()","int","main()","#include","main()","Easy"),
            new datadrill("This operator(--) decreases the value of its operand by 1.","Addition","Decrement","Increment","Checker","Decrement","Easy"),
            new datadrill("How much memory is in a float?","1 Byte","2 Bytes","3 Bytes","4 Bytes","4 Bytes","Easy"),
            new datadrill("Data provided to a program.","Functions","Statements","Input","Output","Input","Easy"),
            new datadrill("Memory capacity of an integer?","1 Byte","2 Bytes","3 Bytes","4 Bytes","2 Bytes","Easy"),
            new datadrill("Data provided by a program.","Functions","Statements","Input","Output","Output","Easy"),
            new datadrill("What is the Relational Operator that chech the two variable if they are equal?","==","++","+=","=","==","Easy"),
            new datadrill("How many times \"Hello\" is get printed?\n" +
                    "        #include<stdio.h>\n" +
                    "        int main()\n" +
                    "        {\n" +
                    "        int x;\n" +
                    "        for(x=-1; x<=10; x++)\n" +
                    "        {\n" +
                    "        if(x < 5)\n" +
                    "        continue;\n" +
                    "        else\n" +
                    "        break;\n" +
                    "        printf(\"Hello\");\n" +
                    "        }\n" +
                    "        return 0;\n" +
                    "        }"," A.Infinite times","11 times","0 times","10 times","O times","Hard"),
            new datadrill("How many times the while loop will get executed if a int is 2 byte wide?\n" +
                    "        #include<stdio.h>\n" +
                    "        int main()\n" +
                    "        {\n" +
                    "        int j=1;\n" +
                    "        while(j <= 255)\n" +
                    "        {\n" +
                    "        printf(\"%c %d\\n\", j, j);\n" +
                    "        j++;\n" +
                    "        }\n" +
                    "        return 0;\n" +
                    "        }","Infinite times","255times","256 times","254 times","255 times","Hard"),
            new datadrill("What will be the output of the program?\n" +
                    "        #include<stdio.h>\n" +
                    "        int main()\n" +
                    "        {\n" +
                    "        int i=0;\n" +
                    "        for(; i<=5; i++);\n" +
                    "        printf(\"%d\", i);\n" +
                    "        return 0;\n" +
                    "        }","0, 1, 2, 3, 4, 5","5","1, 2, 3, 4","6","6","Hard"),
            new datadrill(" What will be the output of the program?\n" +
                    "        #include<stdio.h>\n" +
                    "        int main()\n" +
                    "        {\n" +
                    "        int a = 500, b = 100, c;\n" +
                    "        if(!a >= 400)\n" +
                    "        b = 300;\n" +
                    "        c = 200;\n" +
                    "        printf(\"b = %d c = %d\\n\", b, c);\n" +
                    "        return 0;\n" +
                    "        }","b = 300 c = 200","b = 100 c = 100","b = 300 c = 200","b = 100 c = 200","b = 100 c = 200","Hard"),
            new datadrill(" What will be the output of the program?\n" +
                    "        #include<stdio.h>\n" +
                    "        int main()\n" +
                    "        {\n" +
                    "        int x = 3;\n" +
                    "        float y = 3.0;\n" +
                    "        if(x == y)\n" +
                    "        printf(\"x and y are equal\");\n" +
                    "        else\n" +
                    "        printf(\"x and y are not equal\");\n" +
                    "        return 0;\n" +
                    "        }","x and y are equal","x and y are not equal","Unpredictable","No output","x and y are equal","Hard"),
            new datadrill("What will be the output of the program?\n" +
                    "        #include<stdio.h>\n" +
                    "        int main()\n" +
                    "        {\n" +
                    "        char ch;\n" +
                    "        if(ch = printf(\"\"))\n" +
                    "        printf(\"It matters\\n\");\n" +
                    "        else\n" +
                    "        printf(\"It doesn't matter\\n\");\n" +
                    "        return 0;\n" +
                    "        }","It matters","It doesn't matter","matters","No output","It doesn't matter","Hard"),
            new datadrill("What will be the output of the program?\n" +
                    "        #include<stdio.h>\n" +
                    "        int main()\n" +
                    "        {\n" +
                    "        float a = 0.7;\n" +
                    "        if(0.7 > a)\n" +
                    "        printf(\"Hi\\n\");\n" +
                    "        else\n" +
                    "        printf(\"Hello\\n\");\n" +
                    "        return 0;\n" +
                    "        }","Hi","Hello","Hi Hello","None of above","Hi","Hard"),
            new datadrill("What will be the output of the program?\n" +
                    "        #include<stdio.h>\n" +
                    "        int main()\n" +
                    "        {\n" +
                    "        int x = 10, y = 20;\n" +
                    "        if(!(!x) && x)\n" +
                    "        printf(\"x = %d\\n\", x);\n" +
                    "        else\n" +
                    "        printf(\"y = %d\\n\", y);\n" +
                    "        return 0;\n" +
                    "        }","y =20","x =0","x =10","x =1","x=10","Hard"),
            new datadrill("What will be the output of the program?\n" +
                    "        #include<stdio.h>\n" +
                    "        int main()\n" +
                    "        {\n" +
                    "        int i = 1;\n" +
                    "        switch(i)\n" +
                    "        {\n" +
                    "        printf(\"Hello\\n\");\n" +
                    "        case 1:\n" +
                    "        printf(\"Hi\\n\");\n" +
                    "        break;\n" +
                    "        case 2:\n" +
                    "        printf(\"\\nBye\\n\");\n" +
                    "        break;\n" +
                    "        }\n" +
                    "        return 0;\n" +
                    "        }","Hello\n" +
                    "        Hi",".Hello\n" +
                    "        Bye","Hi","Bye","Hi","Hard"),
            new datadrill("What will be the output of the program?\n" +
                    "        #include<stdio.h>\n" +
                    "        int X=40;\n" +
                    "        int main()\n" +
                    "        {\n" +
                    "        int X=20;\n" +
                    "        printf(\"%d\\n\", X);\n" +
                    "        return 0;\n" +
                    "        }","20","40","Error","No Output","20","Hard"),
            new datadrill("What will be the output of the program ?\n" +
                    "        #include<stdio.h>\n" +
                    "\n" +
                    "        int main()\n" +
                    "        {\n" +
                    "        int a[5] = {5, 1, 15, 20, 25};\n" +
                    "        int i, j, m;\n" +
                    "        i = ++a[1];\n" +
                    "        j = a[1]++;\n" +
                    "        m = a[i++];\n" +
                    "        printf(\"%d, %d, %d\", i, j, m);\n" +
                    "        return 0;\n" +
                    "        }","2, 1, 15","1, 2, 5","3, 2, 15","2, 3, 20","3, 2, 15","Expert"),
            new datadrill("What will be the output of the program ?\n" +
                    "        #include<stdio.h>\n" +
                    "        void fun(int **p);\n" +
                    "\n" +
                    "        int main()\n" +
                    "        {\n" +
                    "        int a[3][4] = {1, 2, 3, 4, 4, 3, 2, 8, 7, 8, 9, 0};\n" +
                    "        int *ptr;\n" +
                    "        ptr = &a[0][0];\n" +
                    "        fun(&ptr);\n" +
                    "        return 0;\n" +
                    "        }\n" +
                    "        void fun(int **p)\n" +
                    "        {\n" +
                    "        printf(\"%d\\n\", **p);\n" +
                    "        }","1","2","3","4","1","Expert"),
            new datadrill("Point out the error in the program\n" +
                    "        f(int a, int b)\n" +
                    "        {\n" +
                    "        int a;\n" +
                    "        a = 20;\n" +
                    "        return a;\n" +
                    "        }","Missing parenthesis in return statement","The function should be defined as int f(int a, int b)","Redeclaration of a","None of above","Redeclaration of a","Expert"),
            new datadrill("What will be the output of the program?\n" +
                    "        #include<stdio.h>\n" +
                    "        int main()\n" +
                    "        {\n" +
                    "        int x, y, z;\n" +
                    "        x=y=z=1;\n" +
                    "        z = ++x || ++y && ++z;\n" +
                    "        printf(\"x=%d, y=%d, z=%d\\n\", x, y, z);\n" +
                    "        return 0;\n" +
                    "        }","x=2, y=1, z=1","x=2, y=2, z=1","x=2, y=2, z=2","x=1, y=2, z=1","x=2, y=1, z=1","Expert"),
            new datadrill("What will be the output of the program?\n" +
                    "        #include<stdio.h>\n" +
                    "        int i;\n" +
                    "        int fun();\n" +
                    "\n" +
                    "        int main()\n" +
                    "        {\n" +
                    "        while(i)\n" +
                    "        {\n" +
                    "        fun();\n" +
                    "        main();\n" +
                    "        }\n" +
                    "        printf(\"Hello\\n\");\n" +
                    "        return 0;\n" +
                    "        }\n" +
                    "        int fun()\n" +
                    "        {\n" +
                    "        printf(\"Hi\");\n" +
                    "        }","Hello","Hi Hello","No output","Infinite loop","Hello","Expert"),
            new datadrill("What will be the output of the program?\n" +
                    "        #include<stdio.h>\n" +
                    "        int check (int, int);\n" +
                    "\n" +
                    "        int main()\n" +
                    "        {\n" +
                    "        int c;\n" +
                    "        c = check(10, 20);\n" +
                    "        printf(\"c=%d\\n\", c);\n" +
                    "        return 0;\n" +
                    "        }\n" +
                    "        int check(int i, int j)\n" +
                    "        {\n" +
                    "        int *p, *q;\n" +
                    "        p=&i;\n" +
                    "        q=&j;\n" +
                    "        i>=45 ? return(*p): return(*q);\n" +
                    "        }","Print 10","Print 20","Print 1","Compile error","Print 1","Expert"),
            new datadrill("What will be the output of the program?\n" +
                    "        #include<stdio.h>\n" +
                    "        int i;\n" +
                    "        int fun1(int);\n" +
                    "        int fun2(int);\n" +
                    "\n" +
                    "        int main()\n" +
                    "        {\n" +
                    "        extern int j;\n" +
                    "        int i=3;\n" +
                    "        fun1(i);\n" +
                    "        printf(\"%d,\", i);\n" +
                    "        fun2(i);\n" +
                    "        printf(\"%d\", i);\n" +
                    "        return 0;\n" +
                    "        }\n" +
                    "        int fun1(int j)\n" +
                    "        {\n" +
                    "        printf(\"%d,\", ++j);\n" +
                    "        return 0;\n" +
                    "        }\n" +
                    "        int fun2(int i)\n" +
                    "        {\n" +
                    "        printf(\"%d,\", ++i);\n" +
                    "        return 0;\n" +
                    "        }\n" +
                    "        int j=1;","3, 4, 4, 3","4, 3, 4, 3","3, 3, 4, 4","3, 4, 3, 4","4, 3, 4, 3","Expert"),
            new datadrill("What will be the output of the program?\n" +
                    "        #include<stdio.h>\n" +
                    "        int func1(int);\n" +
                    "\n" +
                    "        int main()\n" +
                    "        {\n" +
                    "        int k=35;\n" +
                    "        k = func1(k=func1(k=func1(k)));\n" +
                    "        printf(\"k=%d\\n\", k);\n" +
                    "        return 0;\n" +
                    "        }\n" +
                    "        int func1(int k)\n" +
                    "        {\n" +
                    "        k++;\n" +
                    "        return k;\n" +
                    "        }","k=35","k=36","k=37","k=38","k=38","Expert"),
            new datadrill("What will be the output of the program?\n" +
                    "        #include<stdio.h>\n" +
                    "        int check(int);\n" +
                    "        int main()\n" +
                    "        {\n" +
                    "        int i=45, c;\n" +
                    "        c = check(i);\n" +
                    "        printf(\"%d\\n\", c);\n" +
                    "        return 0;\n" +
                    "        }\n" +
                    "        int check(int ch)\n" +
                    "        {\n" +
                    "        if(ch >= 45)\n" +
                    "        return 100;\n" +
                    "        else\n" +
                    "        return 10;\n" +
                    "        }","100","10","1","0","100","Expert"),
            new datadrill("What will be the output of the program?\n" +
                    "        #include<stdio.h>\n" +
                    "\n" +
                    "        int fun(int i)\n" +
                    "        {\n" +
                    "        i++;\n" +
                    "        return i;\n" +
                    "        }\n" +
                    "\n" +
                    "        int main()\n" +
                    "        {\n" +
                    "        int fun(int);\n" +
                    "        int i=3;\n" +
                    "        fun(i=fun(fun(i)));\n" +
                    "        printf(\"%d\\n\", i);\n" +
                    "        return 0;\n" +
                    "        }","5","4","Error","Null value","5","Expert"),
            new datadrill("Which of the following is not a valid variable name declaration?","int _a3","int a_3","int a_3"," int _3a","int 3_a","Easy"),
            new datadrill("All keywords in C are in","LowerCase letters","UpperCase letters","CamelCase letters"," None","LowerCase letters","Easy"),
            new datadrill("Which of the following is not a valid C variable name?","int number;","float rate;","int variable_count;","int $main;","int $main;","Easy"),
            new datadrill("Which of the following is true for variable names in C?","They can contain alphanumeric characters as well as special characters","It is not an error to declare a variable to be one of the keywords(like goto, static)","Variable names cannot start with a digit","Variable can be of any length","Variable names cannot start with a digit","Easy"),
            new datadrill("The format identifier ‘%i’ is also used for _____ data type?","char","int","float","double","int","Easy"),
            new datadrill("Which of the following is a User-defined data type?","typedef int Boolean;","typedef enum {Mon, Tue, Wed, Thu, Fri} Workdays;","struct {char name[10], int age};","all of the mentioned","all of the mentioned","Easy"),
            new datadrill("Which of the following declaration is illegal?","char *str = “C programming”;","char str[] = “C programming”;","char str[20] = “C programming”;","char[] str = “C programming”;","char[] str = “C programming”;","Easy"),
            new datadrill("Which of the following is not a pointer declaration?","char a[10];","char a[] = {‘1’, ‘2’, ‘3’, ‘4’};","char *str;","char a;","char a;","Easy"),
            new datadrill("Which is false ?","A variable defined once can be defined again with different scope","A single variable cannot be defined with two different types in the same scope","A variable must be declared and defined at the same time"," A variable refers to a location in memory","A variable must be declared and defined at the same time","Easy"),
            new datadrill("A variable declared in a function can be used in main","True","False","True if it is declared static","None of the mentioned","False","Easy"),
            new datadrill("The output of the code below is\n" +
                    "\n" +
                    "    #include <stdio.h>\n" +
                    "    void main()\n" +
                    "    {\n" +
                    "        int x = 5;\n" +
                    "        if (x < 1)\n" +
                    "            printf(\"hello\");\n" +
                    "        if (x == 5)\n" +
                    "            printf(\"hi\");\n" +
                    "        else\n" +
                    "            printf(\"no\");\n" +
                    "    }","hi","hello","no","None of the mentioned","hi","Hard"),
            new datadrill("The output of the code below is\n" +
                    "\n" +
                    "    #include <stdio.h>\n" +
                    "    int x;\n" +
                    "    void main()\n" +
                    "    {\n" +
                    "        if (x)\n" +
                    "            printf(\"hi\");\n" +
                    "        else\n" +
                    "            printf(\"how are u\");\n" +
                    "    }","hi","how are you","Compile time error","None of the mentioned"," how are you","Hard"),
            new datadrill(" Comment on the following code below\n" +
                    "\n" +
                    "    #include <stdio.h>\n" +
                    "    void main()\n" +
                    "    {\n" +
                    "        int x = 5;\n" +
                    "        if (true);\n" +
                    "        printf(\"hello\");\n" +
                    "    }","It will display hello","It will throw an error","Nothing will be displayed","Compiler dependent","It will throw an error","Hard"),
            new datadrill("The output of the code below is\n" +
                    "\n" +
                    "    #include <stdio.h>\n" +
                    "    void main()\n" +
                    "    {\n" +
                    "        int x = 0;\n" +
                    "        if (x == 0)\n" +
                    "            printf(\"hi\");\n" +
                    "        else\n" +
                    "            printf(\"how are u\");\n" +
                    "        printf(\"hello\");\n" +
                    "    }","hi","how are you","hello","hihello"," hihello","Hard"),
            new datadrill(" What is the output of this C code?\n" +
                    "\n" +
                    "        #include <stdio.h>\n" +
                    "    void main()\n" +
                    "    {\n" +
                    "        double k = 0;\n" +
                    "        for (k = 0.0; k < 3.0; k++)\n" +
                    "            printf(\"Hello\");\n" +
                    "    }","Run time error","Hello is printed thrice","Hello is printed twice","Hello is printed infinitely"," Hello is printed thrice","Hard"),
            new datadrill("What is the output of this C code?\n" +
                    "\n" +
                    "        #include <stdio.h>\n" +
                    "    void main()\n" +
                    "    {\n" +
                    "        int k = 0;\n" +
                    "        for (k < 3; k++)\n" +
                    "            printf(\"Hello\");\n" +
                    "    }","Compile time error","Hello is printed thrice","Nothing","Varies","Compile time error","Hard"),
            new datadrill(" What is the output of this C code?\n" +
                    "\n" +
                    "        #include <stdio.h>\n" +
                    "    int main()\n" +
                    "    {\n" +
                    "        do\n" +
                    "            printf(\"In while loop \");\n" +
                    "        while (0);\n" +
                    "        printf(\"After loop\\n\");\n" +
                    "    }","In while loop","In while loop\n" +
                    "    after loop","After loop","Infinite loop","In while loop\n" +
                    "    after loop","Hard"),
            new datadrill("What is the output of this C code?\n" +
                    "\n" +
                    "        #include <stdio.h>\n" +
                    "    int main()\n" +
                    "    {\n" +
                    "        int i = 0;\n" +
                    "        do {\n" +
                    "            i++;\n" +
                    "            printf(\"In while loop\\n\");\n" +
                    "        } while (i < 3);\n" +
                    "    }","In while loop\n" +
                    "    In while loop\n" +
                    "    In while loop","In while loop\n" +
                    "    In while loop","Depends on the compiler","Compile time error","In while loop\n" +
                    "    In while loop\n" +
                    "    In while loop","Hard"),
            new datadrill("How many times i value is checked in the below code?\n" +
                    "\n" +
                    "        #include <stdio.h>\n" +
                    "    int main()\n" +
                    "    {\n" +
                    "        int i = 0;\n" +
                    "        do {\n" +
                    "            i++;\n" +
                    "            printf(\"in while loop\\n\");\n" +
                    "        } while (i < 3);\n" +
                    "    }","2","3","4","1","3","Hard"),
            new datadrill("How many times i value is checked in the below code?\n" +
                    "\n" +
                    "        #include <stdio.h>\n" +
                    "    int main()\n" +
                    "    {\n" +
                    "        int i = 0;\n" +
                    "        while (i < 3)\n" +
                    "            i++;\n" +
                    "        printf(\"In while loop\\n\");\n" +
                    "    }","2","3","4","1","4","Hard"),



        new datadrill("What will be the data type returned for the following function?\n" +
                "\n" +
                "        #include <stdio.h>\n" +
                "    int func()\n" +
                "    {\n" +
                "        return (double)(char)5.0;\n" +
                "    }","char","int","double","multiple type-casting in return is illegal","int","Expert"),
            new datadrill("TN he output of the code below is\n" +
                    "\n" +
                    "    #include <stdio.h>\n" +
                    "    void main()\n" +
                    "    {\n" +
                    "        int k = m();\n" +
                    "        printf(\"%d\", k);\n" +
                    "    }\n" +
                    "    void m()\n" +
                    "    {\n" +
                    "        printf(\"hello\");\n" +
                    "    }","hello 5","Error","Nothing"," Junk value","hello 5","Expert"),
            new datadrill("The output of the code below is\n" +
                    "\n" +
                    "    #include <stdio.h>\n" +
                    "    int *m()\n" +
                    "{\n" +
                    "    int *p = 5;\n" +
                    "    return p;\n" +
                    "}\n" +
                    "    void main()\n" +
                    "    {\n" +
                    "        int *k = m();\n" +
                    "        printf(\"%d\", k);\n" +
                    "    }","5","Junk value","0","Error","5","Expert"),
            new datadrill("What is the output of this C code?\n" +
                    "\n" +
                    "        #include <stdio.h>\n" +
                    "    int main()\n" +
                    "    {\n" +
                    "        void foo();\n" +
                    "        printf(\"1 \");\n" +
                    "        foo();\n" +
                    "    }\n" +
                    "    void foo()\n" +
                    "    {\n" +
                    "        printf(\"2 \");\n" +
                    "    }","1 2","Compile time error","1 2 1 2","Depends on the compiler","1 2","Expert"),
            new datadrill("What is the output of this C code?\n" +
                    "\n" +
                    "        #include <stdio.h>\n" +
                    "    void foo();\n" +
                    "    int main()\n" +
                    "    {\n" +
                    "        void foo();\n" +
                    "        foo();\n" +
                    "        return 0;\n" +
                    "    }\n" +
                    "    void foo()\n" +
                    "    {\n" +
                    "        printf(\"2 \");\n" +
                    "    }","Compile time error","2","Depends on the compiler","Depends on the standard","2","Expert"),
            new datadrill("What is the output of this C code?\n" +
                    "\n" +
                    "        #include <stdio.h>\n" +
                    "    void m();\n" +
                    "    void n()\n" +
                    "    {\n" +
                    "        m();\n" +
                    "    }\n" +
                    "    void main()\n" +
                    "    {\n" +
                    "        void m()\n" +
                    "        {\n" +
                    "            printf(\"hi\");\n" +
                    "        }\n" +
                    "    }","hi","Compile time error","Nothing","Varies","Compile time error","Expert"),
            new datadrill("What is the output of this C code?\n" +
                    "\n" +
                    "        #include <stdio.h>\n" +
                    "    void main()\n" +
                    "    {\n" +
                    "        static int x;\n" +
                    "        printf(\"x is %d\", x);\n" +
                    "    }","0","1","Junk value","Run time error","0","Expert"),
            new datadrill("What is the output of this C code?\n" +
                    "\n" +
                    "        #include <stdio.h>\n" +
                    "    int main()\n" +
                    "    {\n" +
                    "        int i = 10;\n" +
                    "        void *p = &i;\n" +
                    "        printf(\"%f\\n\", *(float*)p);\n" +
                    "        return 0;\n" +
                    "    }","Compile time error","Undefined behaviour","10","0.000000","0.000000","Expert"),
            new datadrill("What is the output of this C code?\n" +
                    "\n" +
                    "        #include <stdio.h>\n" +
                    "    int *f();\n" +
                    "    int main()\n" +
                    "    {\n" +
                    "        int *p = f();\n" +
                    "        printf(\"%d\\n\", *p);\n" +
                    "    }\n" +
                    "    int *f()\n" +
                    "{\n" +
                    "    int j = 10;\n" +
                    "    return &j;\n" +
                    "}","10","Compile time error","Segmentation fault/runtime crash","Undefined behaviour","10","Expert"),
            new datadrill("What is the output of this C code?\n" +
                    "\n" +
                    "        #include <stdio.h>\n" +
                    "    int main()\n" +
                    "    {\n" +
                    "        int *ptr, a = 10;\n" +
                    "        ptr = &a;\n" +
                    "        *ptr += 1;\n" +
                    "        printf(\"%d,%d/n\", *ptr, a);\n" +
                    "    }","10,10","10,11","11,10","11,11","11,11","Expert"),};


















}
















