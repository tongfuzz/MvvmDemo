package com.kk.tongfu.mvvmdemo.base;

import android.databinding.DataBindingUtil;
import android.databinding.Observable;
import android.databinding.ViewDataBinding;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.kk.tongfu.mvvmdemo.R;
import com.kk.tongfu.mvvmdemo.databinding.FragmentBaseBinding;
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

public abstract class BaseFragment<DB extends ViewDataBinding, VM extends BaseViewModel> extends Fragment {

    protected DB mDataBinding;
    protected VM mViewModel;

    private FragmentBaseBinding mBaseFragmentView;
    private ViewLoadingBinding mViewLoadingBinding;
    private ViewNoNetworkBinding mViewNoNetworkBinding;
    private ViewNoDataBinding mViewNoDataBinding;
    private ViewErrorBinding mViewErrorBinding;

    private Observable.OnPropertyChangedCallback mLoadStateCallback;


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        initViewModel();

        if (mViewModel != null) {
            getLifecycle().addObserver(mViewModel);
        }

    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        mBaseFragmentView = DataBindingUtil.inflate(inflater, R.layout.fragment_base, container, false);
        mDataBinding = DataBindingUtil.inflate(inflater, getLayoutId(), mBaseFragmentView.fragmentContainer, true);
        initViewModel();
        bindModel();
        initLoadState();
        init();
        return mBaseFragmentView.getRoot();
    }

    private void initLoadState() {
        if (mViewModel != null && isSupportLoad()) {
            mLoadStateCallback = new Observable.OnPropertyChangedCallback() {
                @Override
                public void onPropertyChanged(Observable observable, int i) {
                    switchLoadView(mViewModel.getLoadState());
                }
            };
            mViewModel.loadState.addOnPropertyChangedCallback(mLoadStateCallback);
        }
    }

    private void switchLoadView(LoadState loadState) {
        removeLoadView();
        switch (loadState) {
            case LOADING:
                if (mViewLoadingBinding == null) {
                    mViewLoadingBinding = DataBindingUtil.inflate(getLayoutInflater(), R.layout.view_loading, mBaseFragmentView.fragmentContainer, false);
                }
                mBaseFragmentView.fragmentContainer.addView(mViewLoadingBinding.getRoot());
                break;
            case NO_DATA:
                if (mViewNoDataBinding == null) {
                    mViewNoDataBinding = DataBindingUtil.inflate(getLayoutInflater(), R.layout.view_no_data, mBaseFragmentView.fragmentContainer, false);
                }
                mBaseFragmentView.fragmentContainer.addView(mViewNoDataBinding.getRoot());
                break;
            case NO_NETWORK:
                if (mViewNoNetworkBinding == null) {
                    mViewNoNetworkBinding = DataBindingUtil.inflate(getLayoutInflater(), R.layout.view_no_network, mBaseFragmentView.fragmentContainer, false);
                }
                mBaseFragmentView.fragmentContainer.addView(mViewNoNetworkBinding.getRoot());
                break;
            case ERROR:
                if (mViewErrorBinding == null) {
                    mViewErrorBinding = DataBindingUtil.inflate(getLayoutInflater(), R.layout.view_error, mBaseFragmentView.fragmentContainer, false);
                }
                mBaseFragmentView.fragmentContainer.addView(mViewErrorBinding.getRoot());
                break;
        }
    }

    private void removeLoadView() {
        int childCount = mBaseFragmentView.fragmentContainer.getChildCount();
        if (childCount > 1) {
            mBaseFragmentView.fragmentContainer.removeViews(1, childCount - 1);
        }
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        if (mViewModel != null && isSupportLoad()) {
            mViewModel.loadState.removeOnPropertyChangedCallback(mLoadStateCallback);
        }
    }

    protected abstract void init();

    protected abstract void bindModel();

    protected abstract int getLayoutId();

    protected abstract void initViewModel();

    protected boolean isSupportLoad() {
        return false;
    }
}
