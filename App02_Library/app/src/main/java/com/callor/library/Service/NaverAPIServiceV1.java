package com.callor.library.Service;

// ctrl + alt + o import 정리
import com.callor.library.config.Naver;
import com.callor.library.model.NaverParent;

import retrofit2.Call;

public class NaverAPIServiceV1 extends Thread {

    private String search;

    public NaverAPIServiceV1() {
    }

    // 3. 생성된 Connection을 통하여 데이터를 가져오고
    // 필요한 데이터를 parsing하여 books 객체에 담기
    public void getNaverBooks(String search) throws Exception {
        Call<NaverParent> books = RetrofitClient.getClient()
                .getNaverBook(Naver.CLIENT_ID, Naver.CLIENT_SECRET, search, 10, 1);
    }




}

