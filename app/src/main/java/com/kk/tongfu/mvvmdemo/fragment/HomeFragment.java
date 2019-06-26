package com.kk.tongfu.mvvmdemo.fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.kk.tongfu.mvvmdemo.R;
import com.kk.tongfu.mvvmdemo.adapter.ArticleListAdapter;
import com.kk.tongfu.mvvmdemo.base.BaseFragment;
import com.kk.tongfu.mvvmdemo.model.HomeFragmentViewModel;
import com.kk.tongfu.mvvmdemo.databinding.FragmentHomeBinding;


/**
 * Created by tongfu
 * on 2019/6/26
 * Desc:
 */

public class HomeFragment extends BaseFragment<FragmentHomeBinding,HomeFragmentViewModel> {


    @Override
    protected void init() {
        mDataBinding.recyclerView.setLayoutManager(new LinearLayoutManager(getContext(),LinearLayoutManager.VERTICAL,false));
        mDataBinding.recyclerView.setAdapter(new ArticleListAdapter(mViewModel.mDataList));
    }

    @Override
    protected void bindModel() {
        mDataBinding.setHomeFragmentModel(mViewModel);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_home;
    }

    @Override
    protected void initViewModel() {
        mViewModel=new HomeFragmentViewModel();
    }
}
