package nl.pcmeesters.pcmeestersnl;

import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by School on 30-6-2016.
 */
public class TipActivity extends BottomBarActivity {
    @Override
    public void onCreate(Bundle savedInstanceState, PersistableBundle persistentState) {
        super.onCreate(savedInstanceState, persistentState);
        setContentView(R.layout.tip);
        Intent getAnswers = getIntent();
        String tip = (String)getAnswers.getExtras().get("Tip");
        ArrayList<String> answers = (ArrayList<String>) getAnswers.getExtras().get("answers");
        TextView tipView = (TextView)findViewById(R.id.tip);
        tipView.setText(tip);
    }
}
