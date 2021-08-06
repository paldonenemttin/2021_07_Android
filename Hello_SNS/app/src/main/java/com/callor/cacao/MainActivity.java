package com.callor.cacao;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.Toast;

import com.callor.cacao.adapter.ChattAdapter;
import com.callor.cacao.model.Chatt;
import com.callor.cacao.service.FirebaseServiceImplV1;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView chat_list_view;
    private EditText txt_msg;
    private AppCompatButton btn_send;

    private ChattAdapter chattAdapter;
    private List<Chatt> chattList;

    private DatabaseReference dbRef;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /**
         * custom된 toolbar를 ActionBar로 설정하기 위한 코드
         */
        Toolbar main_toolbar = findViewById(R.id.main_toolbar);
        setSupportActionBar(main_toolbar);

        /**
         * 새로운 Activity가 열렸을때
         * 이전 Activity(page)로 돌아가기 아이콘을 표시하기
         * MainActivity에서는 의미가 없기 때문에 사용 않음
         */
        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);

        txt_msg = findViewById(R.id.txt_msg);
        btn_send = findViewById(R.id.btn_send);

        chat_list_view = findViewById(R.id.chatt_list_view);
        List<Chatt> chattList = new ArrayList<>();

        chattAdapter = new ChattAdapter(chattList);

        chat_list_view.setAdapter(chattAdapter);

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        chat_list_view.setLayoutManager(layoutManager);

        FirebaseDatabase dbConn = FirebaseDatabase.getInstance();

        dbRef = dbConn.getReference("chatting");

        ChildEventListener childEventListener = new FirebaseServiceImplV1(chattAdapter);
        dbRef.addChildEventListener(childEventListener);

        btn_send.setOnClickListener((view)->{
            String msg = txt_msg.getText().toString();
            if(msg != null && !msg.isEmpty()){
                String toastMsg = String.format("메시지 : %s", msg);

                Toast.makeText(MainActivity.this,toastMsg, Toast.LENGTH_SHORT).show();

                Chatt attch = new Chatt();
                attch.setMsg(msg);
                attch.setName("팔도네넴띤");

                Log.d("클릭",attch.toString());

                dbRef.push().setValue(attch);
                txt_msg.setText("");
            }
        });
    }

    /**
     * Custom한 toolBar가 MainActivity에 적용될때
     * setSupportActionBar() method가 실행될때
     * event가 발생하고 자동으로 호출되는 method
     *
     * toolBar를 ㅅ용하여 ActionBar를 Custom하는 이유중에 하나가
     * onCreateOptionMenu() method를 Override 하여
     * 더욱 세밀한 CustomMizing하기 위해서 이다
     *
     * ToolBar에 사용자 정의형 meny를 설정하여
     * 다른 기능을 수행하도록 하는 UI를 구현 가능
     *
     * @param menu
     * @return
     */
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        super.onCreateOptionsMenu(menu);
        getMenuInflater().inflate(R.menu.main_tool_menu,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int menu_item = item.getItemId();
        if(menu_item == R.id.app_bar_se){
            Toast.makeText().show();
        }

        return super.onOptionsItemSelected(item);
    }
}