package com.kk.tongfu.mvvmdemo.viewholder;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;

import com.kk.tongfu.mvvmdemo.R;
import com.kk.tongfu.mvvmdemo.base.BaseViewHolder;
import com.kk.tongfu.mvvmdemo.databinding.ItemArticleBinding;
import com.kk.tongfu.mvvmdemo.model.ArticleViewModel;

/**
 * Created by tongfu
 * on 2019/6/26
 * Desc:
 */

public class ArticleViewHolder extends BaseViewHolder<ItemArticleBinding,ArticleViewModel> {


    public ArticleViewHolder(@NonNull ViewGroup parent) {
        super(parent, R.layout.item_article);
    }

    @Override
    protected void init() {
        mDataBinding.tvTop.setVisibility(View.GONE);
        mDataBinding.tvFresh.setVisibility(View.GONE);
        mDataBinding.tvTag.setVisibility(View.GONE);
    }

    @Override
    protected void bindViewModel() {
        mDataBinding.setViewModel(mViewModel);
    }

    @Override
    protected void initViewModel() {
        mViewModel=new ArticleViewModel();
    }
}
