package nl.pcmeesters.pcmeestersnl;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.google.android.gms.auth.api.signin.GoogleSignInAccount;

public class ProblemSelectionActivity extends BottomBarActivity{
private GoogleSignInAccount acct;
    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.problemcategory_selection);
        Intent getUser = getIntent();
         acct = (GoogleSignInAccount) getUser.getExtras().get("User");
    }


    public void internetProblems(View view) {
        Intent startInternet = new Intent(this,InternetProblemsActivity.class );
        startInternet.putExtra("User", acct);
        startActivity(startInternet);
    }
}
