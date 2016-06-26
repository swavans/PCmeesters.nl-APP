package nl.pcmeesters.pcmeestersnl;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;

/**
 * Created by Worms on 24-6-2016.
 */
public abstract class BottomMain extends AppCompatActivity {

    public void call(View view) {
        Toast toast = Toast.makeText(getApplicationContext(),
                "Starten met bellen", Toast.LENGTH_SHORT);
        toast.show();
        Intent in=new Intent(Intent.ACTION_DIAL, Uri.parse("tel:0031633094338"));
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
    public void internet(View view)
    {
            String url = "http://www.pcmeesters.nl";
            Intent i = new Intent(Intent.ACTION_VIEW);
            i.setData(Uri.parse(url));
            startActivity(i);
        }
}

