package com.viewpagertablayoutfragment.view;

import android.content.Context;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.view.MotionEvent;

/**
 * Created by cj on 2017/6/12.
 * 覆写两个方法，视情况使用，一个控制手指滑动，一个控制tab点击时的动画
 */

public class NoScrollViewPager extends ViewPager {

    public NoScrollViewPager(Context context) {
        super(context);
    }

    public NoScrollViewPager(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    //return true和false都无所谓，主要就是覆盖父类的方法，没有的touchEvent的处理，当然不会滑动了。
    @Override
    public boolean onTouchEvent(MotionEvent ev) {
        return false;
    }

    //去除tab切换时候的滚动动画效果。
    @Override
    public void setCurrentItem(int item) {
        //false 去除滚动效果
        super.setCurrentItem(item,false);
    }

}
