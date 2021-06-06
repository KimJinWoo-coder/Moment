package com.example.moment;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // loading 화면
        Intent intent = new Intent(this, LoadingActivity.class);
        startActivity(intent);

        // '기록시작' 버튼 클릭
        Button btn_start = (Button) findViewById(R.id.button1);
        btn_start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), MapActivity.class);
                startActivity(intent);
            }
        });

        // '기록보기' 버튼 클릭
        Button btn_record = (Button) findViewById(R.id.button2);
        btn_record.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), RecordlistActivity.class);
                startActivity(intent);
            }
        });

        // '설정' 버튼 클릭
        Button btn_setting = (Button) findViewById(R.id.button3);
        btn_setting.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), SettingActivity.class);
                startActivity(intent);
            }
        });

    }

}