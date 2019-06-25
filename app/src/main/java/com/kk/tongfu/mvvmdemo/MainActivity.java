package com.kk.tongfu.mvvmdemo;

import android.databinding.DataBindingUtil;
import android.databinding.Observable;
import android.databinding.ObservableField;
import android.os.Bundle;
import android.os.UserHandle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.kk.tongfu.mvvmdemo.databinding.ActivityMainBinding;
import com.kk.tongfu.mvvmdemo.model.User;

public class MainActivity extends AppCompatActivity {

    private User mUser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.e("onCreate", "onCreate");
        ActivityMainBinding viewDataBinding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        mUser = new User("tongfu", "123456","henan");
        viewDataBinding.setUserInfo(mUser);
        UsersHandler handler=new UsersHandler();
        viewDataBinding.setUsersHandler(handler);

        mUser.addOnPropertyChangedCallback(new Observable.OnPropertyChangedCallback() {
            @Override
            public void onPropertyChanged(Observable observable, int i) {

            }
        });

        //viewDataBinding.setUserHandler(new UsersHandler());
        //viewDataBinding.tvUserPassword.setText("666666");
    }

    public class UsersHandler {

        public void changeUserName() {
            mUser.setName("sun");
            Log.e("UsersHandler","changeUserName");
            mUser.setAddress(new ObservableField<>("henan"));
        }

        public void changeUserPassword() {
            mUser.setPassword("666666");
            Log.e("UsersHandler","changeUserPassword");
        }

        public void changeUserAddress(){
            mUser.setAddress(new ObservableField<>("anhui"));
        }
    }
}

