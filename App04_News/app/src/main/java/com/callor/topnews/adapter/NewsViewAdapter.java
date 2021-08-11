package com.callor.topnews.adapter;

import android.text.Html;
import android.text.Spanned;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.callor.topnews.databinding.NewsItemViewBinding;
import com.callor.topnews.model.NaverNewsDTO;

import java.util.List;

public class NewsViewAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private List<NaverNewsDTO> newsList;

    public NewsViewAdapter(List<NaverNewsDTO> newsList) {
        this.newsList = newsList;
    }


    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(
            @NonNull ViewGroup parent, int viewType) {

        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        NewsItemViewBinding viewBinding = NewsItemViewBinding.inflate(layoutInflater, parent, false);

        return new NewsViewHolder(viewBinding);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {

        // 매개변수로 받은 holder는
        // RecyclerView.ViewHolder type으로 실제 사용해야하는
        // NewsViewHolder의 부모 클래스 type이다
        // 이 때문에 실제 사용하기 위해서는 NewsViewHolder type으로
        // 형변환 (cast) 해야 한다
        NewsViewHolder viewHolder = (NewsViewHolder) holder;
        NewsItemViewBinding newBinding = viewHolder.viewBinding;

        NaverNewsDTO newsDTO = newsList.get(position);
        Spanned newsTitle = Html.fromHtml(newsDTO.getTitle(),Html.FROM_HTML_MODE_LEGACY);
        newBinding.viewsItemTitle.setText(newsDTO.getTitle());

        Spanned newsDesc = Html.fromHtml(newsDTO.getDescription(),Html.FROM_HTML_MODE_LEGACY);
        newBinding.viewsItemDesc.setText(newsDTO.getDescription());

    }

    @Override
    public int getItemCount() {

        return newsList == null ? 0 : newsList.size();
    }

    public static class NewsViewHolder extends RecyclerView.ViewHolder{
        /**
         * binding 속성을 사용하면
         * item_view.xml에 설정된 view component를 일일이 찾아서
         * 초기화 하는 코드를 안써도 된다
         * ItemViewBinding 클래스를 사용하여 모든 view component를 한번에
         * viewHolder로 생성가능하다
         */
        public NewsItemViewBinding viewBinding;
        public NewsViewHolder(@NonNull NewsItemViewBinding viewBinding) {
            super(viewBinding.getRoot());
            this.viewBinding = viewBinding;
        }
    }
}
