package com.example.instancestateapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText name;
    TextView textDisplay;
    private static final String KEY_FIRSTNAME="firstname_key";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        name = (EditText) findViewById(R.id.name);
        textDisplay = (TextView) findViewById(R.id.textDisplay);

        if(savedInstanceState!=null){
            String savedname = savedInstanceState.getString(KEY_FIRSTNAME);
            textDisplay.setText(savedname);

        }
        else
            Toast.makeText(this, "new entry", Toast.LENGTH_LONG).show();
    }

    public void onSaveInstanceState(Bundle savedInstanceState){
         savedInstanceState.putString(KEY_FIRSTNAME, textDisplay.getText().toString());
        super.onSaveInstanceState(savedInstanceState);
    }

    public void display (View v){
        textDisplay.setText(name.getText().toString());
    }

}
