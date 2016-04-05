package com.bertadata.databinding.fragment;

import android.app.Activity;
import android.app.Fragment;
import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;

import com.bertadata.databinding.R;
import com.bertadata.databinding.databinding.FragmentDatabindBinding;
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
public class DataBindFragment extends Fragment
{
    public static DataBindFragment newInstance()
    {
        DataBindFragment fragment = new DataBindFragment();
        return fragment;
    }

    private List<UserItem> mUserItems;

    //    private ListView mListView;
    private FragmentDatabindBinding mFragmentDatabindBinding;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        mFragmentDatabindBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_databind, container, false);
        View view = mFragmentDatabindBinding.getRoot();
//        initView(view);
        return view;
    }

    private void initView(View view)
    {
//        mListView = (ListView) view.findViewById(R.id.lv_listview);
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState)
    {
        super.onActivityCreated(savedInstanceState);
//        mListView.setAdapter(new ListBindDataAdapter(getActivity(), genUserItems()));
        mUserItems = genUserItems();
        mFragmentDatabindBinding.lvListview.setAdapter(new ListBindDataAdapter(getActivity(), mUserItems));
        mFragmentDatabindBinding.setUserItem(new UserItem("李四", "333333"));
        mFragmentDatabindBinding.lvListview.setOnItemClickListener(new AdapterView.OnItemClickListener()
        {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id)
            {
                mUserItems.get(position).setUserName("EEEEEEEEEEEEEE");
                mUserItems.get(position).setPassword("888888888888");
            }
        });
    }

    private List<UserItem> genUserItems()
    {
        LinkedList<UserItem> userItems = new LinkedList<>();
        for (int i = 0; i < 20; i++)
        {
            UserItem userItem = new UserItem();
            userItem.userName = "KKKK" + i;
            userItem.password = "" + i;
            userItems.add(userItem);
        }
        return userItems;

    }

    private class ListBindDataAdapter extends BaseAdapter
    {
        private Activity mActivity;
        private List<UserItem> mUserItems;

        public ListBindDataAdapter(Activity activity, List<UserItem> userItems)
        {
            mActivity = activity;
            mUserItems = userItems;
        }

        @Override
        public int getCount()
        {
            return null == mUserItems ? 0 : mUserItems.size();
        }

        @Override
        public Object getItem(int position)
        {
            return null == mUserItems ? null : mUserItems.get(position);
        }

        @Override
        public long getItemId(int position)
        {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent)
        {
            ViewDataBinding dataBind = null;
            if (convertView == null)
            {
                dataBind = DataBindingUtil.inflate(LayoutInflater.from(mActivity), R.layout.list_item, parent, false);
                convertView = dataBind.getRoot();
                convertView.setTag(dataBind);
            }
            else
            {
                dataBind = (ViewDataBinding) convertView.getTag();
            }
            dataBind.setVariable(com.bertadata.databinding.BR.userItem, mUserItems.get(position));
//            dataBind.executePendingBindings();
            return convertView;
        }
    }
}
