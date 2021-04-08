package com.example.alertdialogapplication;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity  implements View.OnClickListener {

private static Button button_sbm;

@Override
protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button_sbm = (Button) findViewById(R.id.button);
        button_sbm.setOnClickListener((View.OnClickListener) MainActivity.this);
        }

@Override
public void onClick(View v) {
        AlertDialog.Builder a_builder = new AlertDialog.Builder(MainActivity.this);
        a_builder.setMessage("Do you want to close this app!!!");

        a_builder.setPositiveButton("yes", new DialogInterface.OnClickListener() {
@Override
                        public void onClick(DialogInterface dialog, int which) {
                         finish();
                    }
        });

        a_builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
@Override
            public void onClick(DialogInterface dialog, int which) {
             dialog.cancel();
        }
        });

        AlertDialog alert = a_builder.create();
        alert.setTitle("ALERT!!");
        alert.show();

        }
        }
