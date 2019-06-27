package com.kk.tongfu.mvvmdemo.model;

import android.databinding.ObservableArrayList;
import android.databinding.ObservableList;

import com.kk.tongfu.mvvmdemo.base.BaseViewModel;
import com.kk.tongfu.mvvmdemo.bean.Article;
import com.kk.tongfu.mvvmdemo.bean.DataManager;

import javax.inject.Inject;

/**
 * Created by tongfu
 * on 2019/6/26
 * Desc:
 */

public class HomeFragmentViewModel extends BaseViewModel {

    public final  ObservableList<Object> mDataList=new ObservableArrayList<>();

    @Inject
    public HomeFragmentViewModel(DataManager dataManager){

    }




}
