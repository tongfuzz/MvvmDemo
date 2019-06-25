package com.kk.tongfu.mvvmdemo.model;

import android.databinding.BaseObservable;
import android.databinding.Bindable;
import android.databinding.ObservableField;

import com.kk.tongfu.mvvmdemo.BR;

/**
 * Created by tongfu
 * on 2019/6/25
 * Desc:
 */

public class User extends BaseObservable{

    private String name;

    private String password;

    private ObservableField<String> address;


    public ObservableField<String> getAddress() {
        return address;
    }

    public void setAddress(ObservableField<String> address) {
        this.address = address;
    }


    public User(String name,String password,String address){
        this.name=name;
        this.password=password;
        this.address=new ObservableField<>(address);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
        //notifyPropertyChanged(BR.name);
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
        notifyChange();
    }


    @Override
    public String toString() {
        return "User{ name=" +name+
                ", password="+password+"}";
    }
}
