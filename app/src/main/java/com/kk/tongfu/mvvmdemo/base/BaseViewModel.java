package com.kk.tongfu.mvvmdemo.base;

import android.arch.lifecycle.DefaultLifecycleObserver;
import android.arch.lifecycle.LifecycleOwner;
import android.databinding.BaseObservable;
import android.databinding.Bindable;
import android.databinding.ObservableField;
import android.support.annotation.NonNull;

import com.kk.tongfu.mvvmdemo.BR;
import com.kk.tongfu.mvvmdemo.enums.LoadState;
import com.kk.tongfu.mvvmdemo.enums.RefreshState;

import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;

/**
 * Created by tongfu
 * on 2019/6/26
 * Desc:
 */

public abstract class BaseViewModel extends BaseObservable implements DefaultLifecycleObserver{


    public final ObservableField<LoadState> loadState=new ObservableField<LoadState>();

    private RefreshState refreshState;

    private Boolean hasMore;

    private CompositeDisposable mCompositeDisposable;


    @Override
    public void onCreate(@NonNull LifecycleOwner owner) {

    }

    @Override
    public void onDestroy(LifecycleOwner owner) {
        if(mCompositeDisposable!=null){
            mCompositeDisposable.clear();
        }
    }

    public LoadState getLoadState(){
        return loadState.get();
    }

    @Bindable
    public RefreshState getRefreshState(){
        return refreshState;
    }

    protected void setRefreshState(RefreshState refreshState){
        this.refreshState=refreshState;
        notifyPropertyChanged(BR.refreshState);
    }

    @Bindable
    public Boolean getHasMore(){
        return hasMore;
    }

    protected void setHasMore(boolean hasMore){
        this.hasMore=hasMore;
        notifyPropertyChanged(BR.hasMore);
    }

    public void reloadData(){

    }

    protected void addDisposable(Disposable disposable){
        if(mCompositeDisposable==null){
            mCompositeDisposable=new CompositeDisposable();
        }
        mCompositeDisposable.add(disposable);
    }
}
