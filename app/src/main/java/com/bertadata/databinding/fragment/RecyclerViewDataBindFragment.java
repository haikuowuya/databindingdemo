package com.bertadata.databinding.fragment;

import android.app.Fragment;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bertadata.databinding.R;
import com.bertadata.databinding.databinding.FragmentRecyclerViewDatabindBinding;
import com.bertadata.databinding.databinding.RecyclerListItemBinding;
import com.bertadata.databinding.model.UserItem;

import java.util.LinkedList;
import java.util.List;

/**
 * 说明:
 * 日期:2016/4/1
 * 时间:15:51
 * 创建者：hkwy
 * 修改者：
 **/
//http://developer.android.com/tools/data-binding/guide.html#custom_setters
public class RecyclerViewDataBindFragment extends Fragment
{
    public static RecyclerViewDataBindFragment newInstance()
    {
        RecyclerViewDataBindFragment fragment = new RecyclerViewDataBindFragment();
        return fragment;
    }

    private List<UserItem> mUserItems;

    private FragmentRecyclerViewDatabindBinding mFragmentRecyclerViewDatabindBinding;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        mFragmentRecyclerViewDatabindBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_recycler_view_databind, container, false);
        View view = mFragmentRecyclerViewDatabindBinding.getRoot();
        return view;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState)
    {
        super.onActivityCreated(savedInstanceState);
        mUserItems = genUserItems();
        mFragmentRecyclerViewDatabindBinding.setUserItem(new UserItem("李四", "333333"));
        mFragmentRecyclerViewDatabindBinding.rvRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        mFragmentRecyclerViewDatabindBinding.rvRecyclerView.setAdapter(new RecyclerViewListAdapter(mUserItems));

    }

    private List<UserItem> genUserItems()
    {
        LinkedList<UserItem> userItems = new LinkedList<>();
        for (int i = 0; i < 20; i++)
        {
            UserItem userItem = new UserItem();
            userItem.imageUrl="http://ss.bdimg.com/static/superman/img/logo/bd_logo1_31bdc765.png";
            userItem.userName = "**********" + i;
            userItem.password = "" + i;
            userItems.add(userItem);
        }
        return userItems;

    }

    private static class RecyclerViewListAdapter extends RecyclerView.Adapter<RecyclerViewListAdapter.UserItemViewHolder>
    {
        private List<UserItem> mUserItems;

        public RecyclerViewListAdapter(List<UserItem> userItems)
        {
            mUserItems = userItems;
        }

        @Override
        public UserItemViewHolder onCreateViewHolder(ViewGroup parent, int viewType)
        {
            View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_list_item, parent, false);
            return new UserItemViewHolder(itemView);
        }

        @Override
        public void onBindViewHolder(UserItemViewHolder holder, int position)
        {
            holder.bindDataToView(mUserItems.get(position));
        }

        @Override
        public int getItemCount()
        {
            return null == mUserItems ? 0 : mUserItems.size();
        }

        public static class UserItemViewHolder extends RecyclerView.ViewHolder
        {
            private RecyclerListItemBinding mRecyclerListItemBinding;

            public UserItemViewHolder(View itemView)
            {
                super(itemView);
                mRecyclerListItemBinding = DataBindingUtil.bind(itemView);
            }

            public void bindDataToView(UserItem userItem)
            {
                mRecyclerListItemBinding.setUserItem(userItem);
            }

        }
    }
}
