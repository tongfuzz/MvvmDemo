package com.kk.tongfu.mvvmdemo.model;

import android.databinding.ObservableBoolean;
import android.databinding.ObservableField;
import android.support.annotation.NonNull;
import android.util.Log;
import android.widget.Toast;

import com.kk.tongfu.mvvmdemo.R;
import com.kk.tongfu.mvvmdemo.base.BaseItemViewModel;
import com.kk.tongfu.mvvmdemo.bean.Article;
import com.kk.tongfu.mvvmdemo.bean.Tag;
import com.kk.tongfu.mvvmdemo.util.ResourceUtils;
import com.kk.tongfu.mvvmdemo.util.Utils;

import java.util.List;

/**
 * Created by tongfu
 * on 2019/6/27
 * Desc:
 */

public class ArticleViewModel extends BaseItemViewModel<Article> {

    public final ObservableField<String> tag=new ObservableField<>();
    public final ObservableField<String> author=new ObservableField<>();
    public final ObservableField<String> time=new ObservableField<>();
    public final ObservableField<String> title=new ObservableField<>();
    public final ObservableField<String> chapterName=new ObservableField<>();

    public final ObservableBoolean top=new ObservableBoolean(false);
    public final ObservableBoolean fresh=new ObservableBoolean(false);


    @Override
    protected void setAllModel(@NonNull Article article) {
        author.set(article.getAuthor());
        time.set(article.getNiceDate());
        title.set(article.getTitle());
        chapterName.set(String.format(ResourceUtils.getString(R.string.chachapter_name_format),article.getSuperChapterName(),article.getChapterName()));

        List<Tag> tagList=article.getTags();
        if(!Utils.isListEmpty(tagList)){
            tag.set(tagList.get(0).getName());
        }else{
            tag.set("");
        }

        Boolean top=article.getTop();
        if(top!=null){
            this.top.set(top);
        }else{
            this.top.set(false);
        }

        Boolean fresh = article.getFresh();
        if(fresh!=null){
            this.fresh.set(fresh);
        }else{
            this.fresh.set(false);
        }
    }

    public void onClickItem(){
        Article baseModel = getBaseModel();
        Log.e("onClickItem",baseModel.getLink());
    }
}
