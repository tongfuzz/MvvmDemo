package com.kk.tongfu.mvvmdemo.activity;

import android.databinding.ObservableField;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.MenuItem;

import com.kk.tongfu.mvvmdemo.R;
import com.kk.tongfu.mvvmdemo.base.BaseActivity;
import com.kk.tongfu.mvvmdemo.databinding.ActivityMainBinding;
import com.kk.tongfu.mvvmdemo.enums.LoadState;
import com.kk.tongfu.mvvmdemo.fragment.HomeFragment;
import com.kk.tongfu.mvvmdemo.model.MainViewModel;

public class MainActivity extends BaseActivity<ActivityMainBinding, MainViewModel> {

    private static final int INDEX_HOMEPAGE = 0;
    private static final int SYSTEM = 1;
    private static final int WE_CHAT = 2;
    private static final int NAVIGATION = 3;
    private static final int PROJECT = 4;

    private int mLastIndex;

    @Override
    protected int getLayoutResId() {
        return R.layout.activity_main;
    }

    @Override
    protected void initViewModel() {
        mViewModel = new MainViewModel();
    }

    @Override
    protected void bindViewModel() {
        mDataBinding.setViewModel(mViewModel);
    }

    @Override
    protected void init() {
        initBottomNavigationView();
        switchFragment(INDEX_HOMEPAGE);
    }

    private void initBottomNavigationView() {
        mDataBinding.bottomNavigationView.setLabelVisibilityMode(1);
        mDataBinding.bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                switch (menuItem.getItemId()) {
                    case R.id.home:
                        switchFragment(INDEX_HOMEPAGE);
                        return true;
                    case R.id.system:
                        switchFragment(INDEX_HOMEPAGE);
                        return true;
                    case R.id.wechat:
                        switchFragment(INDEX_HOMEPAGE);
                        return true;
                    case R.id.navigation:
                        switchFragment(INDEX_HOMEPAGE);
                        return true;
                    case R.id.project:
                        switchFragment(INDEX_HOMEPAGE);
                        return true;
                    default:
                        return false;
                }
            }
        });
    }

    private void switchFragment(int indexHomepage) {
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        if (mLastIndex != -1) {
            fragmentTransaction.hide(getFragment(mLastIndex));
        }

        mLastIndex = indexHomepage;
        Fragment fragment = getFragment(indexHomepage);
        if (!fragment.isAdded()) {
            fragmentTransaction.add(R.id.fragment_container, fragment);
        }

        fragmentTransaction.show(fragment).commitAllowingStateLoss();
    }

    private Fragment getFragment(int mLastIndex) {
        HomeFragment fragment = new HomeFragment();
        return fragment;
    }

    @Override
    protected boolean isSupportLoad() {
        return true;
    }
}

