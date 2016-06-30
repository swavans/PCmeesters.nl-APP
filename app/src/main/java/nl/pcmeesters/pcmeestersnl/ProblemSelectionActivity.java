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
        Intent startInternet = new Intent(this,ProblemDetectionActivity.class );
        startInternet.putExtra("User", acct);
        startInternet.putExtra("Category", 0);
        startActivity(startInternet);
    }

    public void installingProblems(View view) {
        Intent startInternet = new Intent(this,ProblemDetectionActivity.class );
        startInternet.putExtra("User", acct);
        startInternet.putExtra("Category", 1);
        startActivity(startInternet);
    }
        public void slowComputer(View view) {
            Intent startInternet = new Intent(this,ProblemDetectionActivity.class );
            startInternet.putExtra("User", acct);
            startInternet.putExtra("Category", 2);
            startActivity(startInternet);
    }
        public void computerWontGoOn(View view) {
            Intent startInternet = new Intent(this,ProblemDetectionActivity.class );
            startInternet.putExtra("User", acct);
            startInternet.putExtra("Category", 3);
            startActivity(startInternet);
    }
        public void computerVirus(View view) {
            Intent startInternet = new Intent(this,ProblemDetectionActivity.class );
            startInternet.putExtra("User", acct);
            startInternet.putExtra("Category", 4);
            startActivity(startInternet);
    }
        public void printerproblem(View view) {
            Intent startInternet = new Intent(this,ProblemDetectionActivity.class );
            startInternet.putExtra("User", acct);
            startInternet.putExtra("Category", 5);
            startActivity(startInternet);
    }
        public void otherDeviceProblem(View view) {
            Intent startInternet = new Intent(this,ProblemDetectionActivity.class );
            startInternet.putExtra("User", acct);
            startInternet.putExtra("Category", 6);
            startActivity(startInternet);
    }
        public void other(View view) {
        Intent startInternet = new Intent(this,ProblemDetectionActivity.class );
        startInternet.putExtra("User", acct);
            startInternet.putExtra("Category", 7);
        startActivity(startInternet);
    }
}
