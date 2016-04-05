package com.bertadata.databinding;

import android.databinding.BindingAdapter;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

/**
 * 说明:
 * 日期:2016/4/5
 * 时间:16:52
 * 创建者：hkwy
 * 修改者：
 **/
public class DataBinder
{
    private DataBinder()
    {

    }
    @BindingAdapter("imageUrl")
    public static  void setImageUrl(ImageView imageView,String url )
    {
        Glide.with(imageView.getContext()).load(url).into(imageView);
    }
}
