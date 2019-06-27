package com.kk.tongfu.mvvmdemo.util;

import java.util.List;

/**
 * Created by tongfu
 * on 2019/6/27
 * Desc:
 */

public final class Utils {

    private Utils(){

    }

    public static boolean isListEmpty(List<?> list){
        return list==null||list.size()==0;
    }

}
