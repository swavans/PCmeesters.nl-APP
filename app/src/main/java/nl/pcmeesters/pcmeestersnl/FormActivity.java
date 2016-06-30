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
            nameEntered.setError("Voer een naam in");
        else if(emailEntered.getText().toString().trim().equals(""))
            emailEntered.setError("Voer een Email adres in");
        else if (phone.getText().toString().trim().equals(""))
            phone.setError("Voer een telefoonnummer in");
        else if(adres.getText().toString().trim().equals(""))
            adres.setError("Voer een adres in");
        else if(zipCode.getText().toString().trim().equals(""))
            zipCode.setError("Voer een postcode in");
        else if(model.getText().toString().trim().equals(""))
            model.setError("Voer een Model in");
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
            emailIntent.putExtra(Intent.EXTRA_EMAIL, new String[]{"info@pcmeesters.nl"});
            emailIntent.putExtra(Intent.EXTRA_SUBJECT, "Reparatie aanvraag");
            emailIntent.putExtra(Intent.EXTRA_TEXT, "Beste PCmeester,\n\n" +
                    "Mijn " + model.getText() + " vertoont problemen en ik heb de app gebruikt om deze te registreren.\n De app heeft het volgende vast gesteld" + answer + "\n\n Mijn persoonlijke gegevens zijn:\n  Naam: "
                    + nameEntered.getText() + "\n Adres: " + adres.getText() + "\n ZipCode: " + zipCode.getText() +
                    "\n Telefoonnummer: " + phone.getText() + "\n Email: " + emailEntered.getText() + "\n\n Verder is het belangrijk dat u weet: \n " + comment.getText() + "\n\n Met vriendelijke groet, \n" + nameEntered.getText());

            Toast toast = Toast.makeText(getApplicationContext(),
                    "Bezig met starten van de Email Applicatie", Toast.LENGTH_SHORT);
            toast.show();
            try {
                startActivity(emailIntent);
                sendEmail =true;

            } catch (android.content.ActivityNotFoundException ex) {
                Toast.makeText(getApplicationContext(), "Email kon niet worden geopend", Toast.LENGTH_SHORT).show();
            }

        }

    }
    @Override
    protected void onRestart() {
        super.onRestart();
        if(sendEmail)
        {

        }
    }

}
