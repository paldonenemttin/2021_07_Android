package com.callor.library.adapter;

import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

/**
 * RecyclerView에 데이터를 보여주기 위한 Helper class
 */
public class BookViewAdapter extends RecyclerView.Adapter {

    @NonNull
    @Override
    /**
     * onCreateViewHolder
     * item을 그리는 item.xml 파일을 읽어서 사용할 준비를 하기
     * item.xml 파일을 view로 생성하고 데이터와 연결할 준비
     */
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return null;
    }

    /**
     * 생성된 Holder와 실제 데이터(한개의 데이터)를 연결하는 작업
     * 한개의 데이터를 연결하는 작업을 수행하지만
     * RecyclerView 에 의해서 데이터들의 갯수만큼
     * 반복적으로 호출되어 화면에 데이터를 그리는 작업을 수행
     * @param holder
     * @param position
     */
    @Override
    public void onBindViewHolder(@NonNull  RecyclerView.ViewHolder holder, int position) {

    }

    /**
     * inCreateViewHolder 에서 생성된 Holder 를 사용하여
     * onBindViewHolder 가 데이터 한개를 그리기를 수행하면
     * RecyclerView 에게 지금 데이터가 몇개인지 알려주고
     * 데이터 갯수만큼 반복적으로 Holder 를 그려라라느 값을
     * 알려주는 method
     * @return
     */
    @Override
    public int getItemCount() {
        return 0;
    }

    /**
     * onCreateViewHolder() method가 사용하는 클래스
     * 실제 item.xml에 작성된 각각의 view component를
     * 실제적으로 사용할 수 있도록 각각 개별 객체(view 객체)로
     * 생성하기 위한 보조 class
     *
     * 초기에 RecyclerView인 ListView 시절에는
     * 선택사항으로 만들지 않아도 됐었는데
     * RecyclerView에서는 반드시 있어야 하는 필수 클래스이다
     */
    public static class BookItemHolder extends RecyclerView.ViewHolder{
        public BookItemHolder(@NonNull View itemView) {
            super(itemView);
        }
    }

}