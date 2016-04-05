package com.bertadata.databinding;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.bertadata.databinding.databinding.ActivityMainBinding;
import com.bertadata.databinding.model.UserItem;

//http://blog.csdn.net/jdsjlzx/article/details/48133293
public class MainActivity extends AppCompatActivity
{

    private UserItem mUserItem = new UserItem();

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);

        ActivityMainBinding bind = DataBindingUtil.setContentView(this, R.layout.activity_main);
        mUserItem.userName = "张三";
        mUserItem.password = "123456";
        bind.setUserItem(mUserItem);
        bind.setOnBtnClcik(this);
    }

    public void updateUserItemValue(View view)
    {
        mUserItem.setUserName("KKKKK");
        mUserItem.setPassword("######");
    }

    /***
     * 跳转到{@link FragmentDataBindActivity}
     *
     * @param view:clicked view
     */
    public void actionFragmentDataBind(View view)
    {
        FragmentDataBindActivity.actionFragmentDataBind(this);
    }

    /***
     * 跳转到{@link FragmentRecyclerViewDataBindActivity}
     *
     * @param view :clicked view
     */
    public void actionFragmentRecyclerViewDataBind(View view)
    {
        FragmentRecyclerViewDataBindActivity.actionFragmentRecyclerViewDataBind(this);
    }

}
