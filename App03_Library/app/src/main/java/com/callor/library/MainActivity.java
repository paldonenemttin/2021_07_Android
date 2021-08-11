package com.callor.library;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.Menu;
import android.widget.SearchView;
import android.widget.Toolbar;

import com.callor.library.service.NaverBookService;
import com.callor.library.service.impl.NaverBookServiceImplV1;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;

    /**
     * life cycle
     * 폰에서 아이콘을 터치하여 App을 실행
     * App을 사용하고
     * App을 종료하고
     *
     * App을 실행했을때
     * Android가 폰에서 어플을 읽어서
     * 메모리에 load하고
     * 화면 구성요소를 읽어서 화면을 그리고
     * onCreate**() method 내에 관련된 코드 실행
     * 각 기능을 사용하기 위한 여러 event 핸들러를 등록
     *
     */

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        Toolbar main_toolbar = findViewById(R.id.main_app_toolbar);
        setSupportActionBar(main_toolbar);

        recyclerView = findViewById(R.id.book_list_view);
        
       NaverBookService naverBookService= new NaverBookServiceImplV1(recyclerView);
       naverBookService.getNaverBooks("바니타스의 수기");
    }


    /**
     * res/menu/menu.xml 파일을 읽어서 화면의
     * ActionBar에 메뉴등을 표현할때 사용하는 method
     *
     * 이 method는 Android가 App을 화면에 띄울때 자동으로
     * 호출하여 사용하는 method
     *
     * Activity.xml 파일에 toolbar 관련된 항목이 있으면
     * Android는
     *
     */
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // 매개변수로 받은 menu는
        // toolbar에 기본으로 포함된 아무것도 없는 상태의 menu 객체

        // 현재 toolbar에 기본으로 포함된 black
        getMenuInflater().inflate(R.menu.main_toolbar_menu,menu);

        SearchView searchView = (SearchView) menu.findItem(R.id.app_bar_search).getActionView();
        return super.onCreateOptionsMenu(menu);
    }
}