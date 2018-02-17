package com.thesis.protocode.drills.drill;


import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.thesis.protocode.R;
import com.thesis.protocode.drills.DBDrill;

import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class drillContent extends Fragment {
    FragmentManager fragmentManager;
    public static int position=0;
    public static String level;
    public  int score=0;
    public int totalScore;
    String answer;
    int l;
    TextView txtQuestion,timer;
    public boolean finishanswer=false;
    RadioButton opt1;
    RadioButton opt2;
    List<datadrill> question;
    RadioButton opt3;
    RadioButton opt4;
    RadioGroup grp;
    TextView txtNumber;
    Button btnSubmit;
    CountDownTimer countDownTimer;
    public drillContent() {
        // Required empty public constructor
    }
    DBDrill db;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        l=getArguments().getInt("level");
        View v=inflater.inflate(R.layout.fragment_drill_content, container, false);
        txtQuestion=(TextView)v.findViewById(R.id.txtQuestion);
        fragmentManager = getActivity().getSupportFragmentManager();
        opt1=(RadioButton)v.findViewById(R.id.opt1);
        opt2=(RadioButton)v.findViewById(R.id.opt2);
        opt3=(RadioButton)v.findViewById(R.id.opt3);
        opt4=(RadioButton)v.findViewById(R.id.opt4);
        timer=(TextView)v.findViewById(R.id.txtimer);
        btnSubmit=(Button)v.findViewById(R.id.btnNext);
        txtNumber=(TextView)v.findViewById(R.id.txtNumber);
        grp=(RadioGroup)v.findViewById(R.id.radioGrp);
        db=new DBDrill(getActivity());
        levelSetting();
        timer();
        SetQuestion();
        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkAnswer();
                SaveAnswer();
                position++;
                SetQuestion();
                grp.clearCheck();
                if(countDownTimer!=null){
                    countDownTimer.cancel();
                    timer();
                }

            }
        });
        return v;
    }


    public void SetQuestion()
    {

        if (position == 10) {
            finishanswer = true;
            position = 0;
            DrillScoreDialog dialog = new DrillScoreDialog();
            drillList list =new drillList();
            dialog.show(getActivity().getSupportFragmentManager(), "NoticeDialogFragment");
            fragmentManager.beginTransaction().replace(R.id.frame,list).commit();
            Bundle bundle=new Bundle();
            bundle.putString("level",level);
            dialog.setArguments(bundle);
            if(countDownTimer!=null){
                countDownTimer.cancel();

            }

        }
        else{
            txtQuestion.setText(question.get(position).getQuestions());
            opt1.setText(question.get(position).getOption1());
            opt2.setText(question.get(position).getOption2());
            opt3.setText(question.get(position).getOption3());
            opt4.setText(question.get(position).getOption4());
            txtNumber.setText("Question#"+String.valueOf(position+1));
        }
    }

    public void levelSetting(){

        if(l==0){
            level="Easy";
            getActivity().setTitle("Drills:Easy Mode");

        }
        else if(l==1){
            level="Hard";
            getActivity().setTitle("Drills:Hard Mode");
        }
        else if(l==2){
            level="Expert";

            getActivity().setTitle("Drills:Expert Mode");
        }
        question = db.getAllQuestion(level);
        SetQuestion();

    }
    public void timer()
    {

      countDownTimer=new CountDownTimer(30000, 1000) {

            public void onTick(long millisUntilFinished)
            {
                timer.setText(""+ millisUntilFinished / 1000);
            }

            public void onFinish()
            {
                checkAnswer();
                SaveAnswer();
                position++;
                SetQuestion();
                grp.clearCheck();
                if(countDownTimer!=null){
                    countDownTimer.cancel();
                    timer();
                }
            }

        }.start();
    }



    public void checkAnswer()
    {
        String dAnswer=db.getAllQuestion(level).get(position).getAnswer();

        if(opt1.isChecked()==true)
        {

            if (dAnswer.equals(opt1.getText()))
            {
                answer=opt1.getText().toString();
                opt1.setChecked(false);
                score=1;


            }
            else{
                answer=opt1.getText().toString();
                opt1.setChecked(false);
                score=0;
            }

        }
        else if(opt2.isChecked()==true)
        {

            if(dAnswer.equals(opt2.getText())){
                answer=opt2.getText().toString();
                opt2.setChecked(false);;
                score=1;
            }
            else {
                answer=opt2.getText().toString();
                opt2.setChecked(false);
                score=0;
            }
        }
        else if(opt3.isChecked()==true)
        {
            if(dAnswer.equals(opt3.getText())){
                answer=opt3.getText().toString();
                opt3.setChecked(false);
                score=1;
            }
            else {
                answer=opt3.getText().toString();
                opt3.setChecked(false);
                score=0;
            }


        }
        else if(opt4.isChecked()==true)
        {
            if(dAnswer.equals(opt4.getText())){
                answer=opt4.getText().toString();
                opt4.setChecked(false);
                score=1;

            }
            else{
                answer=opt4.getText().toString();
                opt4.setChecked(false);
                score=0;
            }

        }
        else{
            answer="";
            score=0;
        }



    }
    public void SaveAnswer(){
        dataanswer mdrill=new dataanswer();
        mdrill.setUser_answer(answer);
        mdrill.setQ_id(question.get(position).getId());
        mdrill.setCheck_answer(score);
        mdrill.setDifficulty(level);
        db.saveAnswer(mdrill);
    }
    @Override
    public void onStop() {
        super.onStop();
          countDownTimer.cancel();
          position=0;
    }

    @Override
    public void onStart()
    {
        super.onStart();
        db.deleteAnswer();
    }


}
