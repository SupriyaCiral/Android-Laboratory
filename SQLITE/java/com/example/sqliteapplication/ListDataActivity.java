package com.example.sqliteapplication;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class ListDataActivity extends AppCompatActivity {

    private static final String TAG="ListDataActivity";
    DatabaseHelper mDatabaseHelper;
    private ListView mlistView;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_data);
        mlistView= (ListView) findViewById(R.id.simpleListView);
        mDatabaseHelper=new DatabaseHelper(this);
        populateListView();
    }
    private void populateListView() {
        Log.d(TAG,"Populate ListView: Displaying data in ListView");
        Cursor data=mDatabaseHelper.getData();
        ArrayList<String> listData=new ArrayList<>();
        while(data.moveToNext()){
            listData.add(data.getString(1));
        }
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,R.layout.activity_listview,R.id.textView,listData);
        mlistView.setAdapter(adapter);
    }
    private void toastMessage(String message){
        Toast.makeText(this,message,Toast.LENGTH_SHORT).show();
    }
}
