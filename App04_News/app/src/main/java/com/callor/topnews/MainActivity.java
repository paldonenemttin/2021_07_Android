package com.callor.topnews;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.callor.topnews.databinding.ActivityMainBinding;
import com.callor.topnews.service.NaverService;
import com.callor.topnews.service.impl.NaverNewsServiceImplV1;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;

public class MainActivity extends AppCompatActivity {

    /**
     * activitu.xml 파일에 선언된 view Component 를
     * 사용할때 findbyViewId 를 사용하지 않고
     * 접그느 할 수 있도록 선언된 경우
     *      buildFeature{
     *          viewBinding true
     *      }
     * activitiy_main.xml 파일이름을 확장하여
     * ActivityMainBinding 이라는 클래스가 생성된다
     */
    ActivityMainBinding main_binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        /**
         * 기존에 사용하던
         * setContentView(R.layout.activity_main);
         * 
         * main_binding = ActivityMainBinding.inflate((getLayoutInflater()));
         * setContentView(main_binding.getRoot());
         * 코드로 변경
         * 
         * 이 코드로 시자깅 되면 activity.xml 파일에 있는
         * 모든 view Component가 한번에 사용가능한 상태로 변경됨
         * 
         */

        main_binding = ActivityMainBinding.inflate((getLayoutInflater()));
        setContentView(main_binding.getRoot());

        Date date = new Date(System.currentTimeMillis());
        SimpleDateFormat sd = new SimpleDateFormat("yyyy-MM-dd");
        String curDate = sd.format(date);

        NaverService naverService = new NaverNewsServiceImplV1(main_binding.newsListView);
        naverService.getNews(curDate);

        
    }
}