package com.example.moment;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class RecordlistActivity extends AppCompatActivity {

    TextView myname;
    //Intent intent = getIntent();
    //String name = intent.getStringExtra("name");
    
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recordlist);


        Intent intent = getIntent();
        String name = intent.getStringExtra("name");
        myname = (TextView)findViewById(R.id.myname);
        myname.setText(name);
        saveState();

    }
/*
    @Override
    protected void onPause() { // Activity가 보이지 않을때 값을 저장한다.
        super.onPause();
        saveState();
    }

    @Override
    protected void onStart() {  // Activity가 보이기 시작할때 값을 저장한다.
        super.onStart();
        restoreState();
        if(myname != null)
            myname.setText(name);

    }
*/
    protected void saveState(){ // 데이터를 저장한다.
        SharedPreferences pref = getSharedPreferences("pref", Activity.MODE_PRIVATE);
        SharedPreferences.Editor editor = pref.edit();
        Intent intent = getIntent();
        String name = intent.getStringExtra("name");
        editor.putString("name", name);

        editor.commit();


    }
    /*protected void restoreState(){  // 데이터를 복구한다.
        SharedPreferences pref = getSharedPreferences("pref", Activity.MODE_PRIVATE);
        if((pref!=null) && (pref.contains("text"))){
            name = pref.getString("text", "");
        }

    } */

}