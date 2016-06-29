package nl.pcmeesters.pcmeestersnl;

import android.os.Bundle;
import android.view.View;

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
                break;
            case 7:setContentView(R.layout.three_answer_question);
                break;
            case 9:setContentView(R.layout.four_answer_question);
                break;
            default:
                setContentView(R.layout.sign_in);
                break;
        }
    }
    public void changeText(View view) {
        currentQuestionID++;
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
