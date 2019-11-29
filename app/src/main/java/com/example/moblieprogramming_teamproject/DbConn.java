package com.example.moblieprogramming_teamproject;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import android.text.method.ScrollingMovementMethod;
import android.util.Base64;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.ByteArrayOutputStream;

/*
    데이터베이스 연결 Test Activity
 */


public class DbConn extends AppCompatActivity {
    private ImageView imageViewPet;
    private EditText editTextName;
    private EditText editTextAge;
    private EditText editTextKind;
    private EditText editTextGender;
    private EditText editTextSmallArea;
    private EditText editTextInfo;
    private EditText editTextBigArea;

    private TextView mTextViewResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_db_conn);

        imageViewPet = (ImageView)findViewById(R.id.imageview_pet);

        editTextName = (EditText)findViewById(R.id.editText_name);
        editTextAge = (EditText)findViewById(R.id.editTExt_age);
        editTextKind = (EditText)findViewById(R.id.editText_kind);
        editTextGender = (EditText)findViewById(R.id.editText_gender);
        editTextBigArea = (EditText)findViewById(R.id.editText_bigarea);
        editTextSmallArea = (EditText)findViewById(R.id.editText_area);
        editTextInfo = (EditText)findViewById(R.id.editText_info);


        mTextViewResult = (TextView)findViewById(R.id.textView_main_result);

        mTextViewResult.setMovementMethod(new ScrollingMovementMethod());

        Button buttonInsert = (Button)findViewById(R.id.button_main_insert);
        buttonInsert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String image = drawableToBase64();
                String name = editTextName.getText().toString();
                String age = editTextAge.getText().toString();
                String kind = editTextKind.getText().toString();
                String gender = editTextGender.getText().toString();
                String bigarea = editTextBigArea.getText().toString();
                String smallarea = editTextSmallArea.getText().toString();
                String info = editTextInfo.getText().toString();

                DBManager task = new DBManager();
                task.insertDBInfo(image, name, age, kind, gender, bigarea, smallarea, info);
            }
        });
    }

    private String drawableToBase64(){
        Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.cat);
        ByteArrayOutputStream byteArray = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.JPEG, 100, byteArray);
        byte[] b = byteArray.toByteArray();
        String base64 = Base64.encodeToString(b, Base64.DEFAULT);

        return base64;
    }
}