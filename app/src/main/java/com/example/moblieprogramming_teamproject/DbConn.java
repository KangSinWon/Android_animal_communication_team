package com.example.moblieprogramming_teamproject;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import android.text.method.ScrollingMovementMethod;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

/*
    데이터베이스 연결 Test Activity
 */


public class DbConn extends AppCompatActivity {
    private static String IP_ADDRESS = "210.115.48.93:8888";

    private EditText editTextName;
    private EditText editTextAge;
    private EditText editTextKind;
    private EditText editTextArea;
    private EditText editTextIntro;

    private TextView mTextViewResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_db_conn);

        editTextName = (EditText)findViewById(R.id.editText_name);
        editTextAge = (EditText)findViewById(R.id.editTExt_age);
        editTextKind = (EditText)findViewById(R.id.editText_kind);
        editTextArea = (EditText)findViewById(R.id.editText_area);
        editTextIntro = (EditText)findViewById(R.id.editText_intro);


        mTextViewResult = (TextView)findViewById(R.id.textView_main_result);

        mTextViewResult.setMovementMethod(new ScrollingMovementMethod());

        Button buttonInsert = (Button)findViewById(R.id.button_main_insert);
        buttonInsert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = editTextName.getText().toString();
                String age = editTextName.getText().toString();
                String kind = editTextName.getText().toString();
                String area = editTextName.getText().toString();
                String intro = editTextName.getText().toString();

                DBManager task = new DBManager();
                // task.insertDBInfo("http://" + IP_ADDRESS + "/insert.php", name, age, kind, area, intro);

                editTextName.setText("");
            }
        });
    }
}