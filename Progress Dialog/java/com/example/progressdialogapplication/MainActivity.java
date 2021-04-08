package com.example.progressdialogapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private static Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn = (Button) findViewById(R.id.button);
        btn.setOnClickListener(MainActivity.this);
    }

    @Override
    public void onClick(View v) {
        ProgressDialog progressDialog = new ProgressDialog(MainActivity.this);
        progressDialog.setTitle("Download");
        progressDialog.setMessage("Downloading....");
        progressDialog.setProgressStyle(progressDialog.STYLE_HORIZONTAL);//spinner
        progressDialog.setProgress(0);
        progressDialog.setMax(100);

        Thread t = new Thread(new Runnable() {
            @Override
            public void run() {
                int progress = 0;
                while(progress <=100){
                    try{
                        progressDialog.setProgress(progress);
                        progress++;
                        Thread.sleep(200);
                    }catch(Exception ex) {


                    }
                }
                progressDialog.dismiss();
                MainActivity.this.runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        Toast.makeText(MainActivity.this, "Download completed", Toast.LENGTH_SHORT).show();
                    }
                });
            }
        });
        t.start();
        progressDialog.show();
    }
}
