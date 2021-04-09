package com.example.firstdemoapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

     Button btn;
     Button regbtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn = findViewById(R.id.button1);
        regbtn=findViewById(R.id.button2);
        btn.setOnClickListener(MainActivity.this);
        regbtn.setOnClickListener(MainActivity.this);


    }

    @Override
    public void onClick(View v) {

        switch(v.getId()){
            case R.id.button1 :
                Toast.makeText(MainActivity.this, "Hello Successfuly Logged in", Toast.LENGTH_LONG).show();
                break;
            case R.id.button2:
                Intent in = new Intent(MainActivity.this, RegisterActivity2.class);
                startActivity(in);


        }

    }
}