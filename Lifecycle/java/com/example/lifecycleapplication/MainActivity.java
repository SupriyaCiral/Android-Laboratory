package com.example.lifecycleapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity {
    private static final String Tag=MainActivity.class.getSimpleName();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.i(Tag,"in method onCreate");
    }



    @Override
    protected void onStart() {
        super.onStart();
        Log.i(Tag,"in method onStart");
    }



    @Override
    protected void onResume() {
        super.onResume();
        Log.i(Tag,"in method onResume");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.i(Tag,"in method onPause");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.i(Tag,"in method onStop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.i(Tag,"in method onDestroy");
    }
}

