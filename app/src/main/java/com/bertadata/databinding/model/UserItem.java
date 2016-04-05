package com.bertadata.databinding.model;

import android.databinding.BaseObservable;
import android.databinding.Bindable;

import com.bumptech.glide.Glide;

import java.io.Serializable;

/**
 * 说明:
 * 日期:2016/4/1
 * 时间:14:40
 * 创建者：hkwy
 * 修改者：
 **/
public class UserItem extends BaseObservable implements Serializable
{
    @Bindable
    public String userName;
    @Bindable
    public String password;
    @Bindable
    public String imageUrl;

    public UserItem()
    {

    }

    public UserItem(String userName, String password)
    {
        this.userName = userName;
        this.password = password;
    }

    public UserItem(String userName, String password, String imageUrl)
    {
        this.userName = userName;
        this.password = password;
        this.imageUrl = imageUrl;
    }

    public void setUserName(String userName)
    {
        this.userName = userName;
        notifyPropertyChanged(com.bertadata.databinding.BR.userName);

    }

    public void setPassword(String password)
    {
        this.password = password;
        notifyPropertyChanged(com.bertadata.databinding.BR.password);
    }
}
