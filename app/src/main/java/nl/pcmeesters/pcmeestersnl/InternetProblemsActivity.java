package nl.pcmeesters.pcmeestersnl;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.google.android.gms.common.server.converter.StringToIntConverter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

/**
 * Created by School on 29-6-2016.
 */
public class InternetProblemsActivity  extends BottomBarActivity{
    //Questions are build by Question, Answer A, Next ID A, Answer B, Next ID B, etc
    private ArrayList<ArrayList> questions = new ArrayList<>();
    private int currentQuestionID = 0;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        addQuestions();
        updateQuestion();
    }

    private void updateQuestion() {
        ArrayList<String> currentQuestion = questions.get(currentQuestionID);
        System.out.println(currentQuestion.size());
        switch (currentQuestion.size())
        {

            case 5:setContentView(R.layout.two_answer_question);
                TextView answer2A = (TextView) findViewById(R.id.answerA);
                answer2A.setText(currentQuestion.get(1));
                TextView answer2B = (TextView) findViewById(R.id.answerB);
                answer2B.setText(currentQuestion.get(3));
                break;
            case 7:setContentView(R.layout.three_answer_question);
                TextView answer3A = (TextView) findViewById(R.id.answerA);
                answer3A.setText(currentQuestion.get(1));
                TextView answer3B = (TextView) findViewById(R.id.answerB);
                answer3B.setText(currentQuestion.get(3));
                TextView answer3C = (TextView) findViewById(R.id.answerC);
                answer3C.setText(currentQuestion.get(5));
                break;
            case 9:setContentView(R.layout.four_answer_question);
                TextView answer4A = (TextView) findViewById(R.id.answerA);
                answer4A.setText(currentQuestion.get(1));
                TextView answer4B = (TextView) findViewById(R.id.answerB);
                answer4B.setText(currentQuestion.get(3));
                TextView answer4C = (TextView) findViewById(R.id.answerC);
                answer4C.setText(currentQuestion.get(5));
                TextView answer4D = (TextView) findViewById(R.id.answerC);
                answer4D.setText(currentQuestion.get(7));

                break;
            default:
                setContentView(R.layout.sign_in);
                break;
        }
        TextView question = (TextView) findViewById(R.id.question);
        question.setText(currentQuestion.get(0));
    }
    public void changeTextA(View view) {
        ArrayList<String> currentQuestion = questions.get(currentQuestionID);
        try{currentQuestionID= Integer.parseInt(currentQuestion.get(2));}
        catch (Exception e){
            System.out.println(currentQuestion.get(2));
        }
        updateQuestion();
    }
    public void changeTextB(View view) {
        ArrayList<String> currentQuestion = questions.get(currentQuestionID);
        try{currentQuestionID= Integer.parseInt(currentQuestion.get(4));}
        catch (Exception e){
            System.out.println(currentQuestion.get(4));
        }        updateQuestion();
    }
    public void changeTextC(View view) {
        ArrayList<String> currentQuestion = questions.get(currentQuestionID);
        try{currentQuestionID= Integer.parseInt(currentQuestion.get(6));}
        catch (Exception e){
            System.out.println(currentQuestion.get(6));
        }        updateQuestion();
    }
    public void changeTextD(View view) {
        ArrayList<String> currentQuestion = questions.get(currentQuestionID);
        try{currentQuestionID= Integer.parseInt(currentQuestion.get(8));}
        catch (Exception e){
            System.out.println(currentQuestion.get(8));
        }        updateQuestion();
    }
    @Override
    public void onBackPressed() {
        currentQuestionID--;
        updateQuestion();
    }

    private void addQuestions(){
         ArrayList<String> question0 = new ArrayList<>();
         ArrayList<String> question1 = new ArrayList<>();
         ArrayList<String> question2 = new ArrayList<>();
         ArrayList<String> question3 = new ArrayList<>();
         ArrayList<String> question4 = new ArrayList<>();
         ArrayList<String> question5 = new ArrayList<>();
        String[] questionPart0 = new String[]{getString(R.string.iQuestion0_question),
                getString(R.string.iQuestion0_answerA),getString(R.string.iQuestion0_nextIDA),
                getString(R.string.iQuestion0_answerB),getString(R.string.iQuestion0_nextIDB)};
        question0.addAll(Arrays.asList(questionPart0));
        questions.add(question0);

        String[] questionPart1 = new String[]{getString(R.string.iQuestion1_question),
                getString(R.string.iQuestion1_answerA),getString(R.string.iQuestion1_nextIDA),
                getString(R.string.iQuestion1_answerB),getString(R.string.iQuestion1_nextIDB),
                getString(R.string.iQuestion1_answerC),getString(R.string.iQuestion1_nextIDC),
                getString(R.string.iQuestion1_answerD),getString(R.string.iQuestion1_nextIDD)};
        question1.addAll(Arrays.asList(questionPart1));
        questions.add(question1);

        String[] questionPart2 = new String[]{getString(R.string.iQuestion2_question),
                getString(R.string.iQuestion2_answerA),getString(R.string.iQuestion2_nextIDA),
                getString(R.string.iQuestion2_answerB),getString(R.string.iQuestion2_nextIDB)};
        question2.addAll(Arrays.asList(questionPart2));
        questions.add(question2);

        String[] questionPart3 = new String[]{getString(R.string.iQuestion3_question),
                getString(R.string.iQuestion3_answerA),getString(R.string.iQuestion3_nextIDA),
                getString(R.string.iQuestion3_answerB),getString(R.string.iQuestion3_nextIDB),
                getString(R.string.iQuestion3_answerC),getString(R.string.iQuestion3_nextIDC)
        };
        question3.addAll(Arrays.asList(questionPart3));
        questions.add(question3);

        String[] questionPart4 = new String[]{getString(R.string.iQuestion4_question),
                getString(R.string.iQuestion4_answerA),getString(R.string.iQuestion4_nextIDA),
                getString(R.string.iQuestion4_answerB),getString(R.string.iQuestion4_nextIDB),
                getString(R.string.iQuestion4_answerC),getString(R.string.iQuestion4_nextIDC)
        };
        question4.addAll(Arrays.asList(questionPart4));
        questions.add(question4);

        String[] questionPart5 = new String[]{getString(R.string.iQuestion5_question),
                getString(R.string.iQuestion5_answerA),getString(R.string.iQuestion5_nextIDA),
                getString(R.string.iQuestion5_answerB),getString(R.string.iQuestion5_nextIDB)};
        question5.addAll(Arrays.asList(questionPart5));
        questions.add(question5);
    }
}
