package com.callor.attch;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.widget.EditText;
import android.widget.Toast;

import com.callor.attch.adapter.ChattAdapter;
import com.callor.attch.model.chatt;
import com.callor.attch.service.FirebaseServiceImplV1;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView chat_list_view;
    private EditText txt_msg;
    private AppCompatButton btn_send;

    private ChattAdapter chattAdapter;
    private List<chatt> chattList;

    // firebase와 연결하는 Connection을 위한 객체 선언
    private DatabaseReference dbRef;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txt_msg = findViewById(R.id.txt_msg);
        btn_send = findViewById(R.id.btn_send);

        chat_list_view = findViewById(R.id.chatt_list_view);
        List<chatt> chattList = new ArrayList<>();

        //1.
        chattAdapter = new ChattAdapter(chattList);


        chat_list_view.setAdapter(chattAdapter);

        //3
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        chat_list_view.setLayoutManager(layoutManager);

        FirebaseDatabase dbConn = FirebaseDatabase.getInstance();
        // 사용할 table(path)
        // reaktuneDatabase애서는 table을 path라는 개념으로 부른다
        dbRef = dbConn.getReference("chatting");

        // firebase로 부터 데이터 변화 이벤트가 전달되면
        // 이벤트를 수신하여 할일을 지정하기 위한 핸들러 선언
        ChildEventListener childEventListener = new FirebaseServiceImplV1(chattAdapter);
        // 핸들러 연결
        dbRef.addChildEventListener(childEventListener);
        


        // 1. Adapter 보여줄 데이터 객체 생성
//        chattList = new ArrayList<chatt>();
//        chatt chatt = new chatt();
//        chatt.setName("홍길동");
//        chatt.setMsg("닌 뭔데");
//        chattList.add(chatt);
//
//        chatt = new chatt();
//        chatt.setName("성춘향");
//        chatt.setMsg("어쩔");
//        chattList.add(chatt);
//
//        chatt = new chatt();
//        chatt.setName("이몽룡");
//        chatt.setMsg("ㅄㄷ");
//        chattList.add(chatt);



        /**
         * EditBox에 메시지를 입력하고 Send버튼을 틀릭했을때 할일 지정
         *
         * EditBox에 메시지를 입력하고 Send를 하면
         * FireBase의 Realtime DataBase에 데이터를 insert하기
         */

        btn_send.setOnClickListener((view)->{
            // EditBox에 입력된 문자열을 추출하여 문자열 변수에 담기
            String msg = txt_msg.getText().toString();
            if(msg != null && !msg.isEmpty()){

                String toastMsg = String.format("메시지 : %s", msg);
                Toast.makeText(MainActivity.this,toastMsg, Toast.LENGTH_SHORT).show();
                chatt attch = new chatt();
                attch.setMsg(msg);
                attch.setName("주몽");
                Log.d("클릭",attch.toString());
                // chattList.add(attch);
                // firebase의 realtimeDB의 table에 데이터를 insert하라
                // push 하라
                dbRef.push().setValue(attch);
                txt_msg.setText("");
            }
        });

    }
}