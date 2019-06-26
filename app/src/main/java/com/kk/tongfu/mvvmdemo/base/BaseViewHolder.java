package com.kk.tongfu.mvvmdemo.base;

import android.databinding.ViewDataBinding;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;

/**
 * Created by tongfu
 * on 2019/6/26
 * Desc:
 */

public abstract class BaseViewHolder<DB extends ViewDataBinding ,VM extends BaseItemViewModel> extends RecyclerView.ViewHolder {

    protected DB mDataBinding;

    protected VM mViewModel;

    public BaseViewHolder(@NonNull View itemView) {
        super(itemView);
    }
}
