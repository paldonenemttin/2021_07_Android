package com.callor.hello;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.snackbar.Snackbar;

/*
Activity.class
기본적으로 하는일
1. 화면에 UI를 표현하는 일 *.xml을 읽어서 화면을 구현 event Handling 수행
2.Activity 이름 짓기
  Activity 클래스는 UI 관련된 파일을 1개 이상 연결한다
  이름Activity.java 라는 이름으로 작성하고
  activity_이름.xml 라는 이름으로 화면구현 xml 파일을 작성
*/
public class MainActivity extends AppCompatActivity {

    private TextView txt1 = null;
    private TextView txt2 = null;

    private EditText edit01 = null;

    /*
    on* () method는 대체로 event Handler 들이다
    Create동작이 실행 될때 같이 동반하여 작동되는 method
    작성하고 있는 App이 안드로이드 phone에서 생성될때 작동하는 method

    안드로이드 어플에서는 onCreate method를 진입점 method로 취급한다
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        /*
        res.layout.activity_main.xml 파일을 읽어서(열어서)
        시작화면(현재클래스가 작도오디는 화면)을 만들어라
         */
        setContentView(R.layout.activity_main);
        /*
        xml view에 설정된 view content를 java code에서 사용하기 위해 import하는 절차
         */
        txt1 = findViewById(R.id.txt01);
        txt2 = findViewById(R.id.txt02);

        edit01.findViewById(R.id.edit01);

        txt1.setText("졸려");
        txt2.setText("집 보내줘");

        txt2.setOnClickListener((view)->{

            String txt = edit01.getText().toString();
            txt = "입력한 번호" + txt;

            Toast.makeText(this,txt,Toast.LENGTH_LONG).show();
        });

        txt1.setOnClickListener((view)->{
            Snackbar.make(view,txt1.getText(),Snackbar.LENGTH_SHORT).show();
        });


    }
}