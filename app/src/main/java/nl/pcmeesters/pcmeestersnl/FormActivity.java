package nl.pcmeesters.pcmeestersnl;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.auth.api.signin.GoogleSignInAccount;

import java.util.ArrayList;

/**
 * Created by School on 30-6-2016.
 */
public class FormActivity extends BottomBarActivity {
    private GoogleSignInAccount acct;
    private ArrayList<String> answers;
    private EditText nameEntered;
    private EditText emailEntered;
    private boolean sendEmail =false;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.form);
        Intent getAnswers = getIntent();
         answers= (ArrayList<String>) getAnswers.getStringArrayListExtra("Answers");
         acct = (GoogleSignInAccount) getAnswers.getExtras().get("User");
         nameEntered = (EditText)findViewById(R.id.nameEnterd);
         emailEntered = (EditText)findViewById(R.id.emailEntered);
        nameEntered.setText(acct.getDisplayName());
        emailEntered.setText(acct.getEmail());
    }
    public void sendForm(View view)
    {
        EditText model = (EditText) findViewById(R.id.brandAndModelEntered);
        EditText adres = (EditText) findViewById(R.id.adressEntered);
        EditText zipCode = (EditText) findViewById(R.id.zipCodeEntered);
        EditText phone = (EditText) findViewById(R.id.phoneEntered);
        EditText comment = (EditText) findViewById(R.id.commentEntered);
        if(nameEntered.getText().toString().trim().equals(""))
            nameEntered.setError(getString(R.string.nameError));
        else if(emailEntered.getText().toString().trim().equals(""))
            emailEntered.setError(getString(R.string.mailError));
        else if (phone.getText().toString().trim().equals(""))
            phone.setError(getString(R.string.phoneError));
        else if(adres.getText().toString().trim().equals(""))
            adres.setError(getString(R.string.addressError));
        else if(zipCode.getText().toString().trim().equals(""))
            zipCode.setError(getString(R.string.zipCodeError));
        else if(model.getText().toString().trim().equals(""))
            model.setError(getString(R.string.modelError));
        else {

        /* Create the Intent */
            Intent emailIntent = new Intent(Intent.ACTION_SENDTO);
            String answer = "\n";
            for (String s : answers) {
                answer = answer + "\n" + s;
            }

/* Fill it with Data */
            emailIntent.setType("plain/text");
            emailIntent.setData(Uri.parse("mailto:")); // only email apps should handle this
            emailIntent.putExtra(Intent.EXTRA_EMAIL, new String[]{getString(R.string.companyEmail)});
            emailIntent.putExtra(Intent.EXTRA_SUBJECT, getString(R.string.repairRequest));
            emailIntent.putExtra(Intent.EXTRA_TEXT, getString(R.string.emailGreet) +
                    getString(R.string.my) + model.getText() + getString(R.string.appConclusion) + answer + getString(R.string.contactInfo)+getString(R.string.name)
                    + nameEntered.getText() + getString(R.string.address) + adres.getText() + getString(R.string.zipCode) + zipCode.getText() +
                    getString(R.string.phonenumber) + phone.getText() + getString(R.string.email) + emailEntered.getText() + getString(R.string.alsoImportant) + comment.getText() + getString(R.string.bye) + nameEntered.getText());

            Toast toast = Toast.makeText(getApplicationContext(),
                    getString(R.string.emailStart), Toast.LENGTH_SHORT);
            toast.show();
            try {
                startActivity(emailIntent);
                sendEmail =true;
            } catch (android.content.ActivityNotFoundException ex) {
                Toast.makeText(getApplicationContext(),getString( R.string.emailError), Toast.LENGTH_SHORT).show();
            }

        }

    }
    @Override
    protected void onRestart() {
        super.onRestart();
        if(sendEmail)
        {
            setContentView(R.layout.end_screen);
        }
    }

}
