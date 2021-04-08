package com.example.sharedpreferenceapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    SharedPreferences sf;
    EditText name;
    public static final String preference="pref";
    public static final String saveit="savekey";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        name= (EditText) findViewById(R.id.name);
        sf=getSharedPreferences(preference, Context.MODE_PRIVATE);
        if(sf.contains(saveit))
        {
            name.setText(sf.getString(saveit,""));

        }

    }

    public void sav(View view)
    {
        String store=name.getText().toString();
        SharedPreferences.Editor ed=sf.edit();
        ed.putString(saveit,store);
        ed.commit();
    }

    public void del(View v)
    {
        name= (EditText) findViewById(R.id.name);
        name.setText("");
    }

    public void ret(View v)
    {
        name= (EditText) findViewById(R.id.name);
        sf=getSharedPreferences(preference, Context.MODE_PRIVATE);
        if(sf.contains(saveit))
        {
            name.setText(sf.getString(saveit,""));
        }
    }
}
