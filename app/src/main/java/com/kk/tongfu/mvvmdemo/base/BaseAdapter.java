package com.kk.tongfu.mvvmdemo.base;

import android.databinding.ObservableList;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;

/**
 * Created by tongfu
 * on 2019/6/26
 * Desc:
 */

public abstract class BaseAdapter<VH extends RecyclerView.ViewHolder> extends RecyclerView.Adapter<VH>{

    protected ObservableList<Object> mDataList;

    public BaseAdapter(@NonNull ObservableList<Object> dataList){
        mDataList=dataList;
        initCallback();
    }

    private void initCallback() {
        mDataList.addOnListChangedCallback(new ObservableList.OnListChangedCallback<ObservableList<Object>>() {
            @Override
            public void onChanged(ObservableList<Object> objects) {
                notifyDataSetChanged();
            }

            @Override
            public void onItemRangeChanged(ObservableList<Object> objects, int i, int i1) {
                notifyItemRangeChanged(i,i1);
            }

            @Override
            public void onItemRangeInserted(ObservableList<Object> objects, int i, int i1) {
                notifyItemRangeInserted(i,i1);
            }

            @Override
            public void onItemRangeMoved(ObservableList<Object> objects, int i, int i1, int i2) {
                if(i2==1){
                    notifyItemMoved(i,i1);
                }else{
                    notifyDataSetChanged();
                }
            }

            @Override
            public void onItemRangeRemoved(ObservableList<Object> objects, int i, int i1) {
                notifyItemRangeRemoved(i,i1);
            }
        });
    }

    @Override
    public int getItemCount() {
        return mDataList==null?0:mDataList.size();
    }
}
