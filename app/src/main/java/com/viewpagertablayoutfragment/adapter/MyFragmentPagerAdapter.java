package com.viewpagertablayoutfragment.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.List;

/**
 * Created by Administrator on 2016/12/30.
 */

public class MyFragmentPagerAdapter extends FragmentPagerAdapter {


    List<Fragment> list;
    String tabTitleArray[];

    public MyFragmentPagerAdapter(FragmentManager fm, List<Fragment> list) {
        super(fm);

        this.list = list;
    }

    @Override
    public Fragment getItem(int position) {
        return list.get(position);
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return super.getPageTitle(position);
    }

}
