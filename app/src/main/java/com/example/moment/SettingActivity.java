package com.example.moment;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class SettingActivity extends Activity implements View.OnClickListener {

    Button btn_name;
    EditText rename;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting);

        rename = (EditText)findViewById(R.id.rename);
        btn_name = (Button)findViewById(R.id.btn_name);
        btn_name.setOnClickListener((View.OnClickListener) this);

}
        @Override
        public void onClick(View v){
            Intent intent = new Intent(SettingActivity.this, RecordlistActivity.class);
            intent.putExtra("name", rename.getText().toString());

            Toast.makeText(getApplicationContext(),"이름이 변경되었습니다",Toast.LENGTH_SHORT).show();
            startActivity(intent);


        }



}
