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
            Intent in=new Intent(Intent.ACTION_DIAL,Uri.parse("tel:0633094338"));
            try{
                startActivity(in);
            }

            catch (android.content.ActivityNotFoundException ex){
                Toast.makeText(getApplicationContext(),"yourActivity is not founded",Toast.LENGTH_SHORT).show();
            }
    }

}
