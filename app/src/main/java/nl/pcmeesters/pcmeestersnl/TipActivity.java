package nl.pcmeesters.pcmeestersnl;

import android.content.Intent;
import android.os.Bundle;

import android.view.View;
import android.widget.TextView;

import com.google.android.gms.auth.api.signin.GoogleSignInAccount;

import java.util.ArrayList;

/**
 * Created by School on 30-6-2016.
 */
public class TipActivity extends BottomBarActivity {
    private GoogleSignInAccount acct;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tip);
        Intent getAnswers = getIntent();
        String tip = (String)getAnswers.getExtras().get("Tip");
        ArrayList<String> answers = (ArrayList<String>) getAnswers.getExtras().get("answers");
        TextView tipView = (TextView)findViewById(R.id.tip);
        acct = (GoogleSignInAccount) getAnswers.getExtras().get("User");
        tipView.setText(tip);
    }

    public void changeTextA(View view){
        Intent returnToMaster = new Intent(this,ProblemSelectionActivity.class);
        returnToMaster.putExtra("User",acct);
        startActivity(returnToMaster);
    }
    public void changeTextB(View view){
      //  Intent sendForm = new Intent(this,FormActivity.class);
       // startActivity(sendForm);
    }
}
