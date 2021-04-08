package com.example.sqliteapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity  {
        DatabaseHelper mDatabaseHelper;
        private Button btnAdd, btnViewData;
        private EditText editText;
        @Override
        protected void onCreate(Bundle savedInstanceState) {
                super.onCreate(savedInstanceState);
                setContentView(R.layout.activity_main);
                editText= (EditText) findViewById(R.id.editText);
                btnAdd= (Button) findViewById(R.id.addbut);
                btnViewData= (Button) findViewById(R.id.savebut);
                mDatabaseHelper=new DatabaseHelper(this);
                btnAdd.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                                String newEntry=editText.getText().toString();
                                if(editText.length() !=0){
                                        AddData(newEntry);
                                        editText.setText("");
                                }else{
                                        toastMessage("Enter Data");
                                }
                        }
                });
                btnViewData.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                                Intent intent=new Intent(MainActivity.this,ListDataActivity.class);
                                startActivity(intent);
                        }
                });
        }
        public void AddData(String newEntry){
                boolean insertData=mDatabaseHelper.addData(newEntry);
                if(insertData){
                        toastMessage("Data Succesfully Inserted");
                }else{ toastMessage("Something Went Wrong"); }
        }
        private void toastMessage(String message){
                Toast.makeText(this,message,Toast.LENGTH_SHORT).show();
        }
}