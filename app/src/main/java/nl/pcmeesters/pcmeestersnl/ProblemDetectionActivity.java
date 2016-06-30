package nl.pcmeesters.pcmeestersnl;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;

import com.google.android.gms.auth.api.signin.GoogleSignInAccount;

import java.util.ArrayList;
import java.util.Arrays;


/**
 * Created by School on 29-6-2016.
 */
public class ProblemDetectionActivity extends BottomBarActivity{
    //Questions are build by Question, Answer A, Next ID A, Answer B, Next ID B, etc
    private ArrayList<ArrayList> questions = new ArrayList<>();
    private int currentQuestionID = 0;
    private ArrayList<String> answers;
    private ArrayList<Integer> answerID;
    private int amountofQuestionsAsked = 0;
    private GoogleSignInAccount acct;





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        answers = new ArrayList<>();
        answerID = new ArrayList<>();
        Intent getUser = getIntent();
        acct = (GoogleSignInAccount) getUser.getExtras().get("User");
        addQuestions((int)getUser.getExtras().get("Category"));
        updateQuestion();
    }

    private void updateQuestion() {
        ArrayList<String> currentQuestion = questions.get(currentQuestionID);
        switch (currentQuestion.size())
        {
            case 2:setContentView(R.layout.open_awnser_question);
            TextView question = (TextView) findViewById(R.id.question);
            question.setText(currentQuestion.get(0));
            break;

            case 7:setContentView(R.layout.two_answer_question);
                TextView answer2A = (TextView) findViewById(R.id.answerA);
                answer2A.setText(currentQuestion.get(1));
                TextView answer2B = (TextView) findViewById(R.id.answerB);
                answer2B.setText(currentQuestion.get(3));

                ImageButton button2A = (ImageButton) findViewById(R.id.buttonA);
                ImageButton button2B = (ImageButton) findViewById(R.id.buttonB);
                Drawable drawable2A = getResources().getDrawable(getResources().getIdentifier(currentQuestion.get(5), "drawable", getPackageName()),getTheme());
                button2A.setImageDrawable(drawable2A);
                Drawable drawable2B = getResources().getDrawable(getResources().getIdentifier(currentQuestion.get(6), "drawable", getPackageName()),getTheme());
                button2B.setImageDrawable(drawable2B);
                break;
            case 10:setContentView(R.layout.three_answer_question);
                TextView answer3A = (TextView) findViewById(R.id.answerA);
                answer3A.setText(currentQuestion.get(1));
                TextView answer3B = (TextView) findViewById(R.id.answerB);
                answer3B.setText(currentQuestion.get(3));
                TextView answer3C = (TextView) findViewById(R.id.answerC);
                answer3C.setText(currentQuestion.get(5));

                ImageButton button3A = (ImageButton) findViewById(R.id.buttonA);
                ImageButton button3B = (ImageButton) findViewById(R.id.buttonB);
                ImageButton button3C = (ImageButton) findViewById(R.id.buttonC);
                Drawable drawable3A = getResources().getDrawable(getResources().getIdentifier(currentQuestion.get(7), "drawable", getPackageName()),getTheme());
                button3A.setImageDrawable(drawable3A);
                Drawable drawable3B = getResources().getDrawable(getResources().getIdentifier(currentQuestion.get(8), "drawable", getPackageName()),getTheme());
                button3B.setImageDrawable(drawable3B);
                Drawable drawable3C = getResources().getDrawable(getResources().getIdentifier(currentQuestion.get(9), "drawable", getPackageName()),getTheme());
                button3C.setImageDrawable(drawable3C);

                break;
            case 13:setContentView(R.layout.four_answer_question);
                TextView answer4A = (TextView) findViewById(R.id.answerA);
                answer4A.setText(currentQuestion.get(1));
                TextView answer4B = (TextView) findViewById(R.id.answerB);
                answer4B.setText(currentQuestion.get(3));
                TextView answer4C = (TextView) findViewById(R.id.answerC);
                answer4C.setText(currentQuestion.get(5));
                TextView answer4D = (TextView) findViewById(R.id.answerC);
                answer4D.setText(currentQuestion.get(7));
                ImageButton button4A = (ImageButton) findViewById(R.id.buttonA);
                ImageButton button4B = (ImageButton) findViewById(R.id.buttonB);
                ImageButton button4C = (ImageButton) findViewById(R.id.buttonC);
                ImageButton button4D = (ImageButton) findViewById(R.id.buttonD);
                Drawable drawable4A = getResources().getDrawable(getResources().getIdentifier(currentQuestion.get(9), "drawable", getPackageName()),getTheme());
                button4A.setImageDrawable(drawable4A);
                Drawable drawable4B = getResources().getDrawable(getResources().getIdentifier(currentQuestion.get(10), "drawable", getPackageName()),getTheme());
                button4B.setImageDrawable(drawable4B);
                Drawable drawable4C = getResources().getDrawable(getResources().getIdentifier(currentQuestion.get(11), "drawable", getPackageName()),getTheme());
                button4C.setImageDrawable(drawable4C);
                Drawable drawable4D = getResources().getDrawable(getResources().getIdentifier(currentQuestion.get(12), "drawable", getPackageName()),getTheme());
                button4D.setImageDrawable(drawable4D);
                break;
            default:
                setContentView(R.layout.sign_in);
                break;
        }
        TextView question = (TextView) findViewById(R.id.question);
        question.setText(currentQuestion.get(0));
    }

    public void enterOpenAnswer(View view) {
        EditText answerA = (EditText) findViewById(R.id.openAnswer);
        answers.add(amountofQuestionsAsked,answerA.getText().toString());
        ArrayList<String> currentQuestion = questions.get(currentQuestionID);
        try {
            currentQuestionID = Integer.parseInt(currentQuestion.get(1));

            answerID.add(Integer.parseInt(currentQuestion.get(1)));
            amountofQuestionsAsked++;
            updateQuestion();
        } catch (Exception e) {
            Intent startTip = new Intent(this, TipActivity.class);
            startTip.putExtra("Tip", currentQuestion.get(1));
            startTip.putExtra("Answers", answers);
            startActivity(startTip);
        }
    }
    public void changeTextA(View view) {
        TextView answerA = (TextView) findViewById(R.id.answerA);
        answers.add(amountofQuestionsAsked, (String) answerA.getText());
        ArrayList<String> currentQuestion = questions.get(currentQuestionID);
        try{currentQuestionID= Integer.parseInt(currentQuestion.get(2));
        answerID.add(Integer.parseInt(currentQuestion.get(2)));
            amountofQuestionsAsked++;
            updateQuestion();}
        catch (Exception e){
            Intent startTip = new Intent(this,TipActivity.class);
            startTip.putExtra("Tip",currentQuestion.get(2));
            startTip.putStringArrayListExtra("Answers",answers);
            startTip.putExtra("User",acct);
            startActivity(startTip);
        }

    }
    public void changeTextB(View view) {
        ArrayList<String> currentQuestion = questions.get(currentQuestionID);
        TextView answerB = (TextView) findViewById(R.id.answerB);
        answers.add(amountofQuestionsAsked, (String) answerB.getText());
        try{currentQuestionID= Integer.parseInt(currentQuestion.get(4));
            answerID.add(Integer.parseInt(currentQuestion.get(4)));
            amountofQuestionsAsked++;
            updateQuestion();
        }
        catch (Exception e){
            Intent startTip = new Intent(this,TipActivity.class);
            startTip.putExtra("Tip",currentQuestion.get(4));
            startTip.putStringArrayListExtra("Answers",answers);
            startTip.putExtra("User",acct);
            startActivity(startTip);
        }
    }
    public void changeTextC(View view) {
        ArrayList<String> currentQuestion = questions.get(currentQuestionID);
        TextView answerC = (TextView) findViewById(R.id.answerC);
        answers.add(amountofQuestionsAsked, (String) answerC.getText());
        try{currentQuestionID= Integer.parseInt(currentQuestion.get(6));
            answerID.add(Integer.parseInt(currentQuestion.get(6)));
            amountofQuestionsAsked++;
            updateQuestion();}
        catch (Exception e){
            System.out.println("Step One");
            Intent startTip = new Intent(this,TipActivity.class);
            System.out.println("Step Two");
           startTip.putExtra("Tip",currentQuestion.get(6));
            startTip.putStringArrayListExtra("Answers",answers);
            startTip.putExtra("User",acct);
            startActivity(startTip);
            }

    }
    public void changeTextD(View view) {
        ArrayList<String> currentQuestion = questions.get(currentQuestionID);
        TextView answerD = (TextView) findViewById(R.id.answerD);
        answers.add(amountofQuestionsAsked, (String) answerD.getText());
        try{currentQuestionID= Integer.parseInt(currentQuestion.get(8));
            answerID.add(Integer.parseInt(currentQuestion.get(8)));
            amountofQuestionsAsked++;
            updateQuestion();}
        catch (Exception e){
            Intent startTip = new Intent(this,TipActivity.class);
            startTip.putExtra("Tip",currentQuestion.get(8));
            startTip.putStringArrayListExtra("Answers",answers);
            startTip.putExtra("User",acct);
            startActivity(startTip);
            }

    }
    @Override
    public void onBackPressed() {

        if(amountofQuestionsAsked>0){
            updateQuestion();
            amountofQuestionsAsked--;
        currentQuestionID= answerID.get(amountofQuestionsAsked);

        }
        else
        {
            super.onBackPressed();
        }
    }


    private void addQuestions(int category){

         ArrayList<String> question0 = new ArrayList<>();
         ArrayList<String> question1 = new ArrayList<>();
         ArrayList<String> question2 = new ArrayList<>();
         ArrayList<String> question3 = new ArrayList<>();
         ArrayList<String> question4 = new ArrayList<>();
         ArrayList<String> question5 = new ArrayList<>();
        ArrayList<String> question6 = new ArrayList<>();
        ArrayList<String> question7 = new ArrayList<>();
        ArrayList<String> question8 = new ArrayList<>();
        ArrayList<String> question9 = new ArrayList<>();
        String[] questionPart0;
        String[] questionPart1;
        String[] questionPart2;
        String[] questionPart3;
        String[] questionPart4;
        String[] questionPart5;
        String[] questionPart6;
        String[] questionPart7;
        String[] questionPart8;
        String[] questionPart9;

        switch (category) {
            case 0:
             questionPart0 = new String[]{getString(R.string.iQuestion0_question),
                    getString(R.string.iQuestion0_answerA), getString(R.string.iQuestion0_nextIDA),
                    getString(R.string.iQuestion0_answerB), getString(R.string.iQuestion0_nextIDB),
                    getString(R.string.iQuestion0_imageA), getString(R.string.iQuestion0_imageB)};
            question0.addAll(Arrays.asList(questionPart0));
                 questionPart1 = new String[]{getString(R.string.iQuestion1_question),
                    getString(R.string.iQuestion1_answerA), getString(R.string.iQuestion1_nextIDA),
                    getString(R.string.iQuestion1_answerB), getString(R.string.iQuestion1_nextIDB),
                    getString(R.string.iQuestion1_answerC), getString(R.string.iQuestion1_nextIDC),
                    getString(R.string.iQuestion1_answerD), getString(R.string.iQuestion1_nextIDD),
                    getString(R.string.iQuestion1_imageA), getString(R.string.iQuestion1_imageB),
                    getString(R.string.iQuestion1_imageC), getString(R.string.iQuestion1_imageD)};
            question1.addAll(Arrays.asList(questionPart1));
                 questionPart2 = new String[]{getString(R.string.iQuestion2_question),
                    getString(R.string.iQuestion2_answerA), getString(R.string.iQuestion2_nextIDA),
                    getString(R.string.iQuestion2_answerB), getString(R.string.iQuestion2_nextIDB),
                    getString(R.string.iQuestion2_imageA), getString(R.string.iQuestion2_imageB)};
            question2.addAll(Arrays.asList(questionPart2));
             questionPart3 = new String[]{getString(R.string.iQuestion3_question),
                    getString(R.string.iQuestion3_answerA), getString(R.string.iQuestion3_nextIDA),
                    getString(R.string.iQuestion3_answerB), getString(R.string.iQuestion3_nextIDB),
                    getString(R.string.iQuestion3_answerC), getString(R.string.iQuestion3_nextIDC),
                    getString(R.string.iQuestion3_imageA), getString(R.string.iQuestion3_imageB),
                    getString(R.string.iQuestion3_imageC)
            };
            question3.addAll(Arrays.asList(questionPart3));
             questionPart4 = new String[]{getString(R.string.iQuestion4_question),
                    getString(R.string.iQuestion4_answerA), getString(R.string.iQuestion4_nextIDA),
                    getString(R.string.iQuestion4_answerB), getString(R.string.iQuestion4_nextIDB),
                    getString(R.string.iQuestion4_answerC), getString(R.string.iQuestion4_nextIDC),
                    getString(R.string.iQuestion4_imageA), getString(R.string.iQuestion4_imageB),
                    getString(R.string.iQuestion4_imageC)
            };
            question4.addAll(Arrays.asList(questionPart4));
             questionPart5 = new String[]{getString(R.string.iQuestion5_question),
                    getString(R.string.iQuestion5_answerA), getString(R.string.iQuestion5_nextIDA),
                    getString(R.string.iQuestion5_answerB), getString(R.string.iQuestion5_nextIDB),
                    getString(R.string.iQuestion5_imageA), getString(R.string.iQuestion5_imageB)
            };
            question5.addAll(Arrays.asList(questionPart5));
            break;
            case 1:
                questionPart0 = new String[]{getString(R.string.pQuestion0_question),
                        getString(R.string.pQuestion0_answerA), getString(R.string.pQuestion0_nextIDA),
                        getString(R.string.pQuestion0_answerB), getString(R.string.pQuestion0_nextIDB),
                        getString(R.string.pQuestion0_answerC), getString(R.string.pQuestion0_nextIDC),
                        getString(R.string.pQuestion0_imageA), getString(R.string.pQuestion0_imageB),
                        getString(R.string.pQuestion0_imageC)};
                question0.addAll(Arrays.asList(questionPart0));
                questionPart1 = new String[]{getString(R.string.pQuestion1_question),
                        getString(R.string.pQuestion1_answerA), getString(R.string.pQuestion1_nextIDA),
                        getString(R.string.pQuestion1_answerB), getString(R.string.pQuestion1_nextIDB),
                        getString(R.string.pQuestion1_imageA), getString(R.string.pQuestion1_imageB)} ;
                question1.addAll(Arrays.asList(questionPart1));
                questionPart2 = new String[]{getString(R.string.pQuestion2_question),
                        getString(R.string.pQuestion2_answerA), getString(R.string.pQuestion2_nextIDA),
                        getString(R.string.pQuestion2_answerB), getString(R.string.pQuestion2_nextIDB),
                        getString(R.string.pQuestion2_imageA), getString(R.string.pQuestion2_imageB)};
                question2.addAll(Arrays.asList(questionPart2));
                questionPart3 = new String[]{getString(R.string.pQuestion3_question),
                         getString(R.string.pQuestion3_nextIDA)
                };
                question3.addAll(Arrays.asList(questionPart3));
                questionPart4 = new String[]{getString(R.string.pQuestion4_question),
                        getString(R.string.pQuestion4_answerA), getString(R.string.pQuestion4_nextIDA),
                        getString(R.string.pQuestion4_answerB), getString(R.string.pQuestion4_nextIDB),
                        getString(R.string.pQuestion4_imageA), getString(R.string.pQuestion4_imageB)};
                question4.addAll(Arrays.asList(questionPart4));
                questionPart5 = new String[]{getString(R.string.pQuestion5_question),
                        getString(R.string.pQuestion5_nextIDA)
                };
                question5.addAll(Arrays.asList(questionPart5));
                questionPart6 = new String[]{getString(R.string.pQuestion6_question),
                        getString(R.string.pQuestion6_nextIDA)
                };
                question6.addAll(Arrays.asList(questionPart6));
                questionPart7 = new String[]{getString(R.string.pQuestion7_question),
                        getString(R.string.pQuestion7_answerA), getString(R.string.pQuestion7_nextIDA),
                        getString(R.string.pQuestion7_answerB), getString(R.string.pQuestion7_nextIDB),
                        getString(R.string.pQuestion7_imageA), getString(R.string.pQuestion7_imageB)};
                question7.addAll(Arrays.asList(questionPart7));

                questionPart8 = new String[]{getString(R.string.pQuestion8_question),
                        getString(R.string.pQuestion8_nextIDA)
                };
                question8.addAll(Arrays.asList(questionPart8));
                questionPart9 = new String[]{getString(R.string.pQuestion9_question),
                        getString(R.string.pQuestion9_nextIDA)
                };
                question9.addAll(Arrays.asList(questionPart9));

                break;
            case 2:
                questionPart0 = new String[]{getString(R.string.sQuestion0_question),
                        getString(R.string.sQuestion0_answerA), getString(R.string.sQuestion0_nextIDA),
                        getString(R.string.sQuestion0_answerB), getString(R.string.sQuestion0_nextIDB),
                        getString(R.string.sQuestion0_answerC), getString(R.string.sQuestion0_nextIDC),
                        getString(R.string.sQuestion0_answerD), getString(R.string.sQuestion0_nextIDD),
                        getString(R.string.sQuestion0_imageA), getString(R.string.sQuestion0_imageB),
                        getString(R.string.sQuestion0_imageC), getString(R.string.sQuestion0_imageD)};
                question0.addAll(Arrays.asList(questionPart0));
                questionPart1 = new String[]{getString(R.string.sQuestion1_question),
                        getString(R.string.sQuestion1_answerA), getString(R.string.sQuestion1_nextIDA),
                        getString(R.string.sQuestion1_answerB), getString(R.string.sQuestion1_nextIDB),
                        getString(R.string.sQuestion1_answerC), getString(R.string.sQuestion1_nextIDC),
                        getString(R.string.sQuestion1_imageA), getString(R.string.sQuestion1_imageB),
                        getString(R.string.sQuestion1_imageC)} ;
                question1.addAll(Arrays.asList(questionPart1));
                questionPart2 = new String[]{getString(R.string.sQuestion2_question),
                        getString(R.string.sQuestion2_answerA), getString(R.string.sQuestion2_nextIDA),
                        getString(R.string.sQuestion2_answerB), getString(R.string.sQuestion2_nextIDB),
                        getString(R.string.sQuestion2_answerC), getString(R.string.sQuestion2_nextIDC),
                        getString(R.string.sQuestion2_imageA), getString(R.string.sQuestion2_imageB),
                        getString(R.string.sQuestion2_imageC)};
                question2.addAll(Arrays.asList(questionPart2));
                questionPart3 = new String[]{getString(R.string.sQuestion3_question),
                        getString(R.string.sQuestion3_answerA), getString(R.string.sQuestion3_nextIDA),
                        getString(R.string.sQuestion3_answerB), getString(R.string.sQuestion3_nextIDB),
                        getString(R.string.sQuestion3_answerC), getString(R.string.sQuestion3_nextIDC),
                        getString(R.string.sQuestion3_imageA), getString(R.string.sQuestion3_imageB),
                        getString(R.string.sQuestion3_imageC)
                };
                question3.addAll(Arrays.asList(questionPart3));
                questionPart4 = new String[]{getString(R.string.sQuestion4_question),
                        getString(R.string.sQuestion4_answerA), getString(R.string.sQuestion4_nextIDA),
                        getString(R.string.sQuestion4_answerB), getString(R.string.sQuestion4_nextIDB),
                        getString(R.string.sQuestion4_imageA), getString(R.string.sQuestion4_imageB)};
                question4.addAll(Arrays.asList(questionPart4));

                questionPart5 = new String[]{getString(R.string.sQuestion5_question),
                        getString(R.string.sQuestion5_nextIDA)
                };
                question5.addAll(Arrays.asList(questionPart5));

                questionPart6 = new String[]{getString(R.string.sQuestion6_question),
                        getString(R.string.sQuestion6_answerA), getString(R.string.sQuestion6_nextIDA),
                        getString(R.string.sQuestion6_answerB), getString(R.string.sQuestion6_nextIDB),
                        getString(R.string.sQuestion6_imageA), getString(R.string.sQuestion6_imageB)};
                question6.addAll(Arrays.asList(questionPart6));

                questionPart7 = new String[]{getString(R.string.sQuestion7_question),
                        getString(R.string.sQuestion7_nextIDA)
                };
                question7.addAll(Arrays.asList(questionPart7));

                break;
            case 3:
                questionPart0 = new String[]{getString(R.string.wQuestion0_question),
                        getString(R.string.wQuestion0_answerA), getString(R.string.wQuestion0_nextIDA),
                        getString(R.string.wQuestion0_answerB), getString(R.string.wQuestion0_nextIDB),
                        getString(R.string.wQuestion0_imageA), getString(R.string.wQuestion0_imageB),};
                question0.addAll(Arrays.asList(questionPart0));
                questionPart1 = new String[]{getString(R.string.wQuestion1_question),
                        getString(R.string.wQuestion1_answerA), getString(R.string.wQuestion1_nextIDA),
                        getString(R.string.wQuestion1_answerB), getString(R.string.wQuestion1_nextIDB),
                        getString(R.string.wQuestion1_answerC), getString(R.string.wQuestion1_nextIDC),
                        getString(R.string.wQuestion1_imageA), getString(R.string.wQuestion1_imageB),
                        getString(R.string.wQuestion1_imageC)} ;
                question1.addAll(Arrays.asList(questionPart1));
                questionPart2 = new String[]{getString(R.string.wQuestion2_question),
                        getString(R.string.wQuestion2_answerA), getString(R.string.wQuestion2_nextIDA),
                        getString(R.string.wQuestion2_answerB), getString(R.string.wQuestion2_nextIDB),
                        getString(R.string.wQuestion2_answerC), getString(R.string.wQuestion2_nextIDC),
                        getString(R.string.wQuestion2_imageA), getString(R.string.wQuestion2_imageB),
                        getString(R.string.wQuestion2_imageC)};
                question2.addAll(Arrays.asList(questionPart2));
                questionPart3 = new String[]{getString(R.string.wQuestion3_question),
                        getString(R.string.wQuestion3_answerA), getString(R.string.wQuestion3_nextIDA),
                        getString(R.string.wQuestion3_answerB), getString(R.string.wQuestion3_nextIDB),
                        getString(R.string.wQuestion3_imageA), getString(R.string.wQuestion3_imageB),
                };
                question3.addAll(Arrays.asList(questionPart3));
                questionPart4 = new String[]{getString(R.string.wQuestion4_question),
                        getString(R.string.wQuestion4_answerA), getString(R.string.wQuestion4_nextIDA),
                        getString(R.string.wQuestion4_answerB), getString(R.string.wQuestion4_nextIDB),
                        getString(R.string.wQuestion4_answerC), getString(R.string.wQuestion4_nextIDC),
                        getString(R.string.wQuestion4_answerD), getString(R.string.wQuestion4_nextIDD),
                        getString(R.string.wQuestion4_imageA), getString(R.string.wQuestion4_imageB),
                        getString(R.string.wQuestion4_imageC), getString(R.string.wQuestion4_imageD)};
                question4.addAll(Arrays.asList(questionPart4));

                questionPart5 = new String[]{getString(R.string.wQuestion5_question),
                        getString(R.string.wQuestion5_nextIDA)
                };
                question5.addAll(Arrays.asList(questionPart5));

                break;
            case 7:
                questionPart0 = new String[]{getString(R.string.oQuestion0_question),
                        getString(R.string.oQuestion0_nextIDA)};
                question0.addAll(Arrays.asList(questionPart0));


                questionPart1 = new String[]{getString(R.string.oQuestion1_question),
                        getString(R.string.oQuestion1_nextIDA)};
                question1.addAll(Arrays.asList(questionPart1));
                break;
            case 6: questionPart0 = new String[]{getString(R.string.odQuestion0_question),
                    getString(R.string.odQuestion0_awnserA),getString(R.string.odQuestion0_nextIDA)
            ,getString(R.string.odQuestion0_awnserB),getString(R.string.odQuestion0_nextIDB),
            getString(R.string.odQuestion0_awnserC),getString(R.string.odQuestion0_nextIDC)
            ,getString(R.string.odQuestion0_imageA),getString(R.string.odQuestion0_imageB),
            getString(R.string.odQuestion0_imageC)};
                    question0.addAll(Arrays.asList(questionPart0));

                    questionPart1 = new String[]{getString(R.string.odQuestion1_question),
                    getString(R.string.odQuestion1_nextIDA)};
                    question1.addAll(Arrays.asList(questionPart1));
        }
        questions.add(question0);
        questions.add(question1);
        questions.add(question2);
        questions.add(question3);
        questions.add(question4);
        questions.add(question5);
        questions.add(question6);
        questions.add(question7);
        questions.add(question8);
        questions.add(question9);
    }
}
