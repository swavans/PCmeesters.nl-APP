package nl.pcmeesters.pcmeestersnl;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Arrays;

public class OtherProblemsActivity extends BottomBarActivity{
        //Questions are build by Question, Answer A, Next ID A, Answer B, Next ID B, etc
        private ArrayList<ArrayList> questions = new ArrayList<>();
        private int currentQuestionID = 0;
        private ArrayList<String> answers;
        private ArrayList<Integer> answerID;
        private int amountofQuestionsAsked = 0;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            addQuestions();
            updateQuestion();
            answers = new ArrayList<>();
            answerID = new ArrayList<>();
        }
        public void updateQuestion()
        {
            ArrayList<String> currentQuestion = questions.get(currentQuestionID);
            System.out.println(currentQuestion.size());
            switch (currentQuestion.size())
            {
                case 2:setContentView(R.layout.open_awnser_question);
                    TextView question = (TextView) findViewById(R.id.question);
                    question.setText(currentQuestion.get(0));
                break;
            }
        }


    public void enterOpenAnswer(View view) {
        TextView answerA = (TextView) findViewById(R.id.answerA);
        answers.add(amountofQuestionsAsked, (String) answerA.getText());
        ArrayList<String> currentQuestion = questions.get(currentQuestionID);
        try {
            currentQuestionID = Integer.parseInt(currentQuestion.get(2));
            answerID.add(Integer.parseInt(currentQuestion.get(2)));
            amountofQuestionsAsked++;
            updateQuestion();
        } catch (Exception e) {
            Intent startTip = new Intent(this, TipActivity.class);
            startTip.putExtra("Tip", currentQuestion.get(2));
            startTip.putExtra("Answers", answers);
            startActivity(startTip);
        }
    }



        public void addQuestions()
        {
            ArrayList<String> question0 = new ArrayList<>();
            ArrayList<String> question1 = new ArrayList<>();


            String[] questionPart0 = new String[]{getString(R.string.oQuestion0_question),
                    getString(R.string.oQuestion0_nextIDA)};
            question0.addAll(Arrays.asList(questionPart0));
            questions.add(question0);

            String[] questionPart1 = new String[]{getString(R.string.oQuestion1_question),
            getString(R.string.oQuestion1_nextIDA)};
            question1.addAll(Arrays.asList(questionPart1));
            questions.add(question1);
        }
    @Override
    public void onBackPressed() {

        if(amountofQuestionsAsked>0){
            amountofQuestionsAsked--;
            currentQuestionID= answerID.get(amountofQuestionsAsked);
            updateQuestion();
        }
        else
        {
            super.onBackPressed();
        }
    }

}
