package nl.pcmeesters.pcmeestersnl;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.auth.api.signin.GoogleSignInAccount;

public class MainActivity3 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        Intent getUser = getIntent();
        GoogleSignInAccount acct = (GoogleSignInAccount) getUser.getExtras().get("User");
        TextView name = (TextView) findViewById(R.id.name);
        name.setText(acct.getDisplayName());
    }


    public void laptopSelected(View view) {

    }

    public void desktopSelected(View view) {


    }

    public void changeText(View view) {
        TextView antwoordA = (TextView) findViewById(R.id.antwoord3A);
        antwoordA.setText("Heeft u schade op uw apparaat?");
        ImageButton ButtonA = (ImageButton) findViewById(R.id.imageButtonA);
        ButtonA.setImageResource(R.drawable.computer_schade);
    }

    public void call(View view) {
        Toast toast = Toast.makeText(getApplicationContext(),
                "calling", Toast.LENGTH_SHORT);
        toast.show();
            Intent in=new Intent(Intent.ACTION_DIAL,Uri.parse("tel:0031633094338"));
            try{
                startActivity(in);
            }

            catch (android.content.ActivityNotFoundException ex){
                Toast.makeText(getApplicationContext(),"yourActivity is not founded",Toast.LENGTH_SHORT).show();
            }
    }
    public void mail(View view)
    {
        /* Create the Intent */
        final Intent emailIntent = new Intent(android.content.Intent.ACTION_SEND);

/* Fill it with Data */
        emailIntent.setType("plain/text");
        emailIntent.putExtra(android.content.Intent.EXTRA_EMAIL, new String[]{"info@pcmeesters.nl"});
        emailIntent.putExtra(android.content.Intent.EXTRA_SUBJECT, "Reparatie aanvraag");
        emailIntent.putExtra(android.content.Intent.EXTRA_TEXT, "Beste PCmeester,\n\n");
        Toast toast = Toast.makeText(getApplicationContext(),
                "Bezig met starten van de Email Applicatie", Toast.LENGTH_SHORT);
        toast.show();
        try{this.startActivity(Intent.createChooser(emailIntent, "Email starten"));
        }
        catch (android.content.ActivityNotFoundException ex){
            Toast.makeText(getApplicationContext(),"Email kon niet worden geopend",Toast.LENGTH_SHORT).show();
        }

    }
    public void facebook(View view)
    {
        String uri = "fb://messaging/475877505906388";
        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(uri));
        Toast toast = Toast.makeText(getApplicationContext(),
                "Bezig met starten van Facebook Messenger", Toast.LENGTH_SHORT);
        toast.show();
        try{
            startActivity(intent);
        }
        catch (android.content.ActivityNotFoundException ex){

            Toast.makeText(getApplicationContext(),"Messenger niet geïnstalleerd, de website wordt nu geopend.",Toast.LENGTH_SHORT).show();
            String url = "http://www.facebook.com/pcmeesters.nl/";
            Intent i = new Intent(Intent.ACTION_VIEW);
            i.setData(Uri.parse(url));
            startActivity(i);
        }
    }

}
