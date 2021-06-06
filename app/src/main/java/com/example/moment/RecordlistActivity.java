package com.example.moment;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class RecordlistActivity extends AppCompatActivity {

    TextView myname;
    ImageView mypath1;
    //Intent intent = getIntent();
    //String name = intent.getStringExtra("name");
    /*public String get = getIntent().getStringExtra("Img");

    public static Bitmap StringToBitmap(String get) {
        try {
            byte[] encodeByte = Base64.decode(get, Base64.DEFAULT);
            Bitmap bmp = BitmapFactory.decodeByteArray(encodeByte, 0, encodeByte.length);
            return bmp;
        } catch (Exception e) {
            e.getMessage();
            return null;
        }

    } */


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recordlist);

        /*Intent intent = getIntent();
        String name = intent.getStringExtra("name");
        myname = (TextView)findViewById(R.id.myname);
        myname.setText(name);
        saveState(); */



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
    /*protected void saveState(){ // 데이터를 저장한다.
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

}}
