package com.bertadata.databinding.model;

import android.databinding.BaseObservable;
import android.databinding.Bindable;
import android.databinding.ObservableField;

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
    public String userName;
    public String password;
    public String imageUrl;

    public UserItem()
    {

    }

    public UserItem(String userName, String password)
    {
        this(userName, password, null);

    }

    public UserItem(String userName, String password, String imageUrl)
    {
        this.userName = userName;
        this.password = password;
        this.imageUrl = imageUrl;
    }

    @Bindable
    public String getUserName()
    {
        return userName;
    }

    @Bindable
    public String getPassword()
    {
        return password;
    }

    @Bindable
    public String getImageUrl()
    {
        return imageUrl;
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

    public void setImageUrl(String imageUrl)
    {
        this.imageUrl = imageUrl;
        notifyPropertyChanged(com.bertadata.databinding.BR.imageUrl);
    }
}
