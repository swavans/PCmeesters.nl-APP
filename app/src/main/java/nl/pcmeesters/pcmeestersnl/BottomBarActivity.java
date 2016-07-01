package nl.pcmeesters.pcmeestersnl;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;

public abstract class BottomBarActivity extends AppCompatActivity {

    public void call(View view) {
        Toast toast = Toast.makeText(getApplicationContext(),
                R.string.startCall, Toast.LENGTH_SHORT);
        toast.show();
        Intent in=new Intent(Intent.ACTION_DIAL, Uri.parse(getString(R.string.companyPhone)));
        try{
            startActivity(in);
        }

        catch (android.content.ActivityNotFoundException ex){
            Toast.makeText(getApplicationContext(), R.string.noCallApp,Toast.LENGTH_SHORT).show();
        }
    }


    public void mail(View view)
    {
        /* Create the Intent */
        Intent emailIntent = new Intent(Intent.ACTION_SENDTO);

/* Fill it with Data */
        emailIntent.setType("plain/text");
        emailIntent.setData(Uri.parse("mailto:")); // only email apps should handle this
        emailIntent.putExtra(Intent.EXTRA_EMAIL, new String[]{getString(R.string.companyEmail)});
        emailIntent.putExtra(Intent.EXTRA_SUBJECT, getString(R.string.repairRequest));
        emailIntent.putExtra(Intent.EXTRA_TEXT, getString(R.string.emailGreet));
        Toast toast = Toast.makeText(getApplicationContext(),
                R.string.emailStart, Toast.LENGTH_SHORT);
        toast.show();
        try{startActivity(emailIntent);
        }
        catch (android.content.ActivityNotFoundException ex){
            Toast.makeText(getApplicationContext(), R.string.emailError,Toast.LENGTH_SHORT).show();
        }

    }
    public void facebook(View view)
    {
        String uri = getString(R.string.facebookContact);
        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(uri));
        Toast toast = Toast.makeText(getApplicationContext(),
                R.string.startChat, Toast.LENGTH_SHORT);
        toast.show();
        try{
            startActivity(intent);
        }
        catch (android.content.ActivityNotFoundException ex){

            Toast.makeText(getApplicationContext(), R.string.redirectFacebook,Toast.LENGTH_SHORT).show();
            String url = getString(R.string.facebookPage);
            Intent i = new Intent(Intent.ACTION_VIEW);
            i.setData(Uri.parse(url));
            startActivity(i);
        }
    }
    public void internet(View view)
    {
            String url = getString(R.string.websiteURL);
            Intent i = new Intent(Intent.ACTION_VIEW);
            i.setData(Uri.parse(url));
            startActivity(i);
        }

    public void exit(View view) {
            finishAffinity();
    }
}

