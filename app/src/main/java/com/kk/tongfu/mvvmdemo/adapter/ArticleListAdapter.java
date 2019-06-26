package com.kk.tongfu.mvvmdemo.adapter;

import android.databinding.ObservableList;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;

import com.kk.tongfu.mvvmdemo.base.BaseAdapter;
import com.kk.tongfu.mvvmdemo.viewholder.ArticleViewHolder;

/**
 * Created by tongfu
 * on 2019/6/26
 * Desc:
 */

public class ArticleListAdapter extends BaseAdapter<RecyclerView.ViewHolder> {

    public ArticleListAdapter(@NonNull ObservableList<Object> dataList) {
        super(dataList);
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        return new ArticleViewHolder(viewGroup);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i) {

    }

}
