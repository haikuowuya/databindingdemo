package com.bertadata.databinding;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.bertadata.databinding.fragment.DataBindFragment;
import com.bertadata.databinding.fragment.RecyclerViewDataBindFragment;

public class FragmentRecyclerViewDataBindActivity extends AppCompatActivity
{
    public static final void actionFragmentRecyclerViewDataBind(Activity activity)
    {
        Intent intent = new Intent(activity, FragmentRecyclerViewDataBindActivity.class);
        activity.startActivity(intent);
    }


    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fragment_recycler_view_databind);
        getFragmentManager().beginTransaction().add(R.id.linear_container, RecyclerViewDataBindFragment.newInstance()).commit();

    }

}
