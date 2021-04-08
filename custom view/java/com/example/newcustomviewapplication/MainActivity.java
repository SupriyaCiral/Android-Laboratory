package com.example.newcustomviewapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

import com.example.newcustomviewapplication.view.CustomView;

public class MainActivity extends AppCompatActivity {
    private CustomView mCustomView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mCustomView=(CustomView)findViewById(R.id.CustomView1);
        findViewById(R.id.btnswapcolor).setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View V)
            {
                mCustomView.SwapColor();
            }
        });
    }
}






