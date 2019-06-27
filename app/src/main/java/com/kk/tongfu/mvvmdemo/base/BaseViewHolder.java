package com.kk.tongfu.mvvmdemo.base;

import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by tongfu
 * on 2019/6/26
 * Desc:
 */

public abstract class BaseViewHolder<DB extends ViewDataBinding ,VM extends BaseItemViewModel> extends RecyclerView.ViewHolder {

    protected DB mDataBinding;

    protected VM mViewModel;

    public BaseViewHolder(@NonNull ViewGroup parent, @LayoutRes int layoutResId){
        super(DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()),layoutResId,parent,false).getRoot());
        mDataBinding=DataBindingUtil.getBinding(itemView);
        initViewModel();
        bindViewModel();
        init();
    }


    public VM getmViewModel(){
        return mViewModel;
    }


    protected abstract void init();

    protected abstract void bindViewModel();

    protected abstract void initViewModel();



}
