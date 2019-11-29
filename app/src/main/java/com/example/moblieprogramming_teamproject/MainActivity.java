package com.example.moblieprogramming_teamproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

/*
    초기화 Activity
 */

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    // 각 버튼 클릭시 원하는 화면으로 넘어감
    public void button_onclicked(View view){
        Intent intent;
        switch (view.getId()){
            case R.id.button_registe:
                intent = new Intent(this, RegisteActivity.class);
                startActivity(intent);
                break;
            case R.id.button_search:
                intent = new Intent(this, SearchActivity.class);
                startActivity(intent);
                break;
            case R.id.buuton_community:
                intent = new Intent(this, CommunityActivity.class);
                startActivity(intent);
                break;
            case R.id.button_profile:
                intent = new Intent(this, ProfileActivity.class);
                startActivity(intent);
                break;
            case R.id.button_db_conn:
                intent = new Intent(this, DBSearchActivity.class);
                startActivity(intent);
                break;
        }
    }
}
