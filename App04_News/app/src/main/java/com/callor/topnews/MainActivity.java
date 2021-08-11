package com.callor.topnews;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.callor.topnews.databinding.ActivityMainBinding;

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
        /**
         * 기존에 사용하던
         * setContentView(R.layout.activity_main);
         * 
         * main_binding = ActivityMainBinding.inflate((getLayoutInflater()));
         * setContentView(main_binding.getRoot());
         * 코드로 변경
         * 
         * 이 코드로 시자깅 되면 activity.xml 파일에 있는
         * 모든 view Component가 한번에 사용가능한
         * 
         */
        setContentView(R.layout.activity_main);
        main_binding = ActivityMainBinding.inflate((getLayoutInflater()));
        setContentView(main_binding.getRoot());
        
    }
}