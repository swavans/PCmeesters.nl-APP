package nl.pcmeesters.pcmeestersnl;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import com.google.android.gms.auth.api.signin.GoogleSignInAccount;

public class ActivityActivity3 extends BottomActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        Intent getUser = getIntent();
        GoogleSignInAccount acct = (GoogleSignInAccount) getUser.getExtras().get("User");
        TextView name = (TextView) findViewById(R.id.greet);
        name.append(" " + acct.getDisplayName()+ " "+ getString(R.string.greet2));
    }

    public void changeText(View view) {
        TextView antwoordA = (TextView) findViewById(R.id.antwoord3A);
        antwoordA.setText("Heeft u schade op uw apparaat?");
        ImageButton ButtonA = (ImageButton) findViewById(R.id.imageButtonA);
        ButtonA.setImageResource(R.drawable.computer_schade);
    }


}
