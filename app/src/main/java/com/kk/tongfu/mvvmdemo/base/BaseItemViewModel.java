package com.kk.tongfu.mvvmdemo.base;

import android.databinding.BaseObservable;
import android.databinding.ObservableField;

/**
 * Created by tongfu
 * on 2019/6/26
 * Desc:
 */

public abstract class BaseItemViewModel<T> extends BaseObservable {

    public final ObservableField<T> baseModel=new ObservableField<>();

    public T getBaseModel(){
        return baseModel.get();
    }

    public void setBaseModel(T baseModel){
        this.baseModel.set(baseModel);
        setAllModel(baseModel);
    }

    public abstract void setAllModel(T baseModel);

}
