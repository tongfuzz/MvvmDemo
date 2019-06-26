package com.kk.tongfu.mvvmdemo.base;

import android.databinding.DataBindingUtil;
import android.databinding.Observable;
import android.databinding.ViewDataBinding;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.kk.tongfu.mvvmdemo.R;
import com.kk.tongfu.mvvmdemo.databinding.ActivityBaseBinding;
import com.kk.tongfu.mvvmdemo.databinding.ViewErrorBinding;
import com.kk.tongfu.mvvmdemo.databinding.ViewLoadingBinding;
import com.kk.tongfu.mvvmdemo.databinding.ViewNoDataBinding;
import com.kk.tongfu.mvvmdemo.databinding.ViewNoNetworkBinding;
import com.kk.tongfu.mvvmdemo.enums.LoadState;

/**
 * Created by tongfu
 * on 2019/6/26
 * Desc:
 */

public abstract class BaseActivity<DB extends ViewDataBinding, VM extends BaseViewModel> extends AppCompatActivity {

    protected DB mDataBinding;
    protected VM mViewModel;

    private ActivityBaseBinding mActivityBaseBinding;

    private Observable.OnPropertyChangedCallback mLoadStateCallBack;

    private ViewLoadingBinding mViewLoading;
    private ViewNoNetworkBinding mViewNoNetwork;
    private ViewNoDataBinding mViewNoDataBinding;
    private ViewErrorBinding mViewErrorBinding;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mActivityBaseBinding = DataBindingUtil.setContentView(this, R.layout.activity_base);
        mDataBinding = DataBindingUtil.inflate(getLayoutInflater(), getLayoutResId(), mActivityBaseBinding.fragmentContainer, true);
        initViewModel();
        bindViewModel();
        initLoadState();
        init();
        if (mViewModel != null) {
            getLifecycle().addObserver(mViewModel);
        }
    }

    protected void initLoadState() {
        if (mViewModel != null && isSupportLoad()) {
            mLoadStateCallBack = new Observable.OnPropertyChangedCallback() {
                @Override
                public void onPropertyChanged(Observable observable, int i) {
                    switchLoadView(mViewModel.getLoadState());
                }
            };
            mViewModel.loadState.addOnPropertyChangedCallback(mLoadStateCallBack);
        }
    }

    private void removeLoadView() {
        int childCount = mActivityBaseBinding.fragmentContainer.getChildCount();
        if (childCount > 1) {
            mActivityBaseBinding.fragmentContainer.removeViews(1, childCount - 1);
        }
    }

    private void switchLoadView(LoadState loadState) {
        removeLoadView();
        switch (loadState) {
            case LOADING:
                if (mViewLoading == null) {
                    mViewLoading = DataBindingUtil.inflate(getLayoutInflater(), R.layout.view_loading, mActivityBaseBinding.fragmentContainer, false);
                }
                mActivityBaseBinding.fragmentContainer.addView(mViewLoading.getRoot());
                break;
            case NO_NETWORK:
                if(mViewNoNetwork==null) {
                    mViewNoNetwork = DataBindingUtil.inflate(getLayoutInflater(), R.layout.view_no_network, mActivityBaseBinding.fragmentContainer, false);
                }
                mActivityBaseBinding.fragmentContainer.addView(mViewNoNetwork.getRoot());
                break;
            case NO_DATA:
                if(mViewNoDataBinding==null) {
                    mViewNoDataBinding = DataBindingUtil.inflate(getLayoutInflater(), R.layout.view_no_data, mActivityBaseBinding.fragmentContainer, false);
                }
                mActivityBaseBinding.fragmentContainer.addView(mViewNoDataBinding.getRoot());
                break;
            case ERROR:
                if(mViewErrorBinding==null) {
                    mViewErrorBinding = DataBindingUtil.inflate(getLayoutInflater(), R.layout.view_error, mActivityBaseBinding.fragmentContainer, false);
                }
                mActivityBaseBinding.fragmentContainer.addView(mViewErrorBinding.getRoot());
                break;
            default:
                break;
        }
    }


    protected abstract int getLayoutResId();

    protected abstract void initViewModel();

    protected abstract void bindViewModel();

    protected abstract void init();

    protected boolean isSupportLoad() {
        return false;
    }


}
