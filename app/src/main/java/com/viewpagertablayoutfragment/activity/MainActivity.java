package com.viewpagertablayoutfragment.activity;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.viewpagertablayoutfragment.R;
import com.viewpagertablayoutfragment.adapter.MyFragmentPagerAdapter;
import com.viewpagertablayoutfragment.fragment.FindFragment;
import com.viewpagertablayoutfragment.fragment.HomeFragment;
import com.viewpagertablayoutfragment.fragment.MineFragment;
import com.viewpagertablayoutfragment.view.NoScrollViewPager;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private NoScrollViewPager viewpager;
    private TabLayout tablayout;
    private List<Fragment> list;
    private String[] tabnames = {"主页","发现","我的"};
    private int [] tabImages = {R.drawable.home,R.drawable.find,R.drawable.mine};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    private void initView() {
        viewpager = (NoScrollViewPager) findViewById(R.id.viewpager);
        tablayout = (TabLayout) findViewById(R.id.tablayout);

        initList();
        viewpager.setAdapter(new MyFragmentPagerAdapter(getSupportFragmentManager(),list));
        tablayout.setupWithViewPager(viewpager);
        int tabCount = tablayout.getTabCount();
        for (int i = 0; i < tabCount; i++) {
            TabLayout.Tab tab = tablayout.getTabAt(i);
            if (tab != null) {
                tab.setCustomView(getTabView(i));
            }
        }
        tablayout.getTabAt(0).getCustomView().setSelected(true);

    }

    public void initList(){
        list = new ArrayList<>();
        list.add(new HomeFragment());
        list.add(new FindFragment());
        list.add(new MineFragment());
    }


    public View getTabView(int i){
        View view = LayoutInflater.from(this).inflate(R.layout.tab_layout, null, false);
        ImageView tab_img = (ImageView) view.findViewById(R.id.tab_img);
        TextView tab_text = (TextView) view.findViewById(R.id.tab_text);
        tab_img.setImageResource(tabImages[i]);
        tab_text.setText(tabnames[i]);
        return view;
    }
}
