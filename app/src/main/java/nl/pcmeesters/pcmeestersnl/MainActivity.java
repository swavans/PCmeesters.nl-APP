package nl.pcmeesters.pcmeestersnl;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageButton;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
    }




    private void testUpload()
    {
        int i = 3   +3;
    }

    public void changeText(View view) {
        TextView antwoordA = (TextView) findViewById(R.id.antwoord3A);
        antwoordA.setText("Heeft u schade op uw apparaat?");
        ImageButton ButtonA = (ImageButton) findViewById(R.id.imageButtonA);
        ButtonA.setImageResource(R.drawable.computer_schade);
    }
}
