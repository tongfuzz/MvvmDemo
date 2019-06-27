package com.kk.tongfu.mvvmdemo.component;

import com.kk.tongfu.mvvmdemo.fragment.HomeFragment;
import com.kk.tongfu.mvvmdemo.model.HomeFragmentViewModel;

import dagger.Component;

/**
 * Created by tongfu
 * on 2019/6/27
 * Desc:
 */
@Component
public interface FragmentComponent {

    void inject(HomeFragment model);
}
