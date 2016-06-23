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

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
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
        emailIntent.putExtra(android.content.Intent.EXTRA_TEXT, "Beste PCmeester," +
                "");

        this.startActivity(Intent.createChooser(emailIntent, "Send mail..."));
    }
    public void facebook(View view)
    {
        String uri = "fb://messaging/475877505906388";
        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(uri));
        startActivity(intent);
    }

}
