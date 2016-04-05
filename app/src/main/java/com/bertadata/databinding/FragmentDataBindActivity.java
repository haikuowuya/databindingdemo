package com.bertadata.databinding;

import android.app.Activity;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

import com.bertadata.databinding.databinding.ActivityMainBinding;
import com.bertadata.databinding.fragment.DataBindFragment;
import com.bertadata.databinding.model.UserItem;

public class FragmentDataBindActivity extends AppCompatActivity
{
    public static final void actionFragmentDataBind(Activity activity)
    {
        Intent intent = new Intent(activity, FragmentDataBindActivity.class);
        activity.startActivity(intent);
    }


    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fragment_databind);
        getFragmentManager().beginTransaction().add(R.id.linear_container, DataBindFragment.newInstance()).commit();
    }
}
