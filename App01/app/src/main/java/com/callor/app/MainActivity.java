package com.callor.app;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    // xml에 설정된 imageview를 java code에서 사용학 ㅣ위한 선언
    private ImageView myimg = null;
    // 이미지를 교체하면서 보여주기 위한 변수 선언
    private int count = 0;
    // 이미지 정보를 담을 배열
    private int[] images;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // 선언된 ImageView에 xml에 설정된 view를 연결하기
        myimg = findViewById(R.id.myimg);

        // drawble 폴더에 있는 이밎 정보를 배열에 담기
        images = new int[3];

        images[0] = R.drawable.bread;
        images[1] = R.drawable.title;
        images[2] = R.drawable.zzz;

        // ImageView를 클릭했을때
        myimg.setOnClickListener((view)->{
            // count 변수를 1씩 증가하고
            count ++;
            //0,1,2 중의 한개의 값이 된다
            int imgNum = count % 3;
            // 3개의 배열에 담긴 정보중에 imgNum 요소의 정보를 imageView에 셋팅하기
            myimg.setImageResource(images[imgNum]);



        });
    }
}