package com.callor.attch;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.EditText;

import com.callor.attch.adapter.ChattAdapter;
import com.callor.attch.model.chatt;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView chat_list_view;
    private EditText txt_msg;
    private AppCompatButton btn_send;

    private ChattAdapter chattAdapter;
    private List<chatt> chattList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txt_msg = findViewById(R.id.txt_msg);
        btn_send = findViewById(R.id.btn_send);

        chat_list_view = findViewById(R.id.chatt_list_view);

        // 1. Adapter 보여줄 데이터 객체 생성
        chattList = new ArrayList<chatt>();
        chatt chatt = new chatt();
        chatt.setName("홍길동");
        chatt.setMsg("니 뭐꼬");
        chattList.add(chatt);

        chatt = new chatt();
        chatt.setName("성춘향");
        chatt.setMsg("");
        chattList.add(chatt);

        chatt = new chatt();
        chatt.setName("이몽룡");
        chatt.setMsg("오늘은 좋은날");
        chattList.add(chatt);

        //1.
        chattAdapter = new ChattAdapter(chattList);

        chat_list_view.setAdapter(chattAdapter);

        //3
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        chat_list_view.setLayoutManager(layoutManager);

    }
}