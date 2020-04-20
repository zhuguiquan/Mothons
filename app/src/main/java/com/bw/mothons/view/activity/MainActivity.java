package com.bw.mothons.view.activity;

import android.os.Bundle;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import com.bw.mothons.R;
import com.bw.mothons.base.BaseActivity;
import com.bw.mothons.base.BasePresenter;
import com.bw.mothons.view.fragment.MyFragment;
import com.bw.mothons.view.fragment.ShopFragment;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends BaseActivity {


    @BindView(R.id.rg1)
    RadioButton rg1;
    @BindView(R.id.rg2)
    RadioButton rg2;
    @BindView(R.id.rg3)
    RadioButton rg3;
    @BindView(R.id.rg4)
    RadioButton rg4;
    @BindView(R.id.rg)
    RadioGroup rg;
    @BindView(R.id.vp)
    ViewPager vp;
    List<Fragment>fragmentList=new ArrayList<>();

    @Override
    protected void initData() {
        ShopFragment shopFragment = new ShopFragment();
        ShopFragment shopFragment1 = new ShopFragment();
        MyFragment myFragment = new MyFragment();
        MyFragment myFragment1 = new MyFragment();
        fragmentList.add(shopFragment);
        fragmentList.add(shopFragment1);
        fragmentList.add(myFragment);
        fragmentList.add(myFragment1);
        vp.setAdapter(new FragmentPagerAdapter(getSupportFragmentManager()) {
            @NonNull
            @Override
            public Fragment getItem(int position) {
                return fragmentList.get(position);
            }

            @Override
            public int getCount() {
                return fragmentList.size();
            }
        });
        rg.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                switch (i){
                    case R.id.rg1:
                        vp.setCurrentItem(0);
                        break;
                    case R.id.rg2:
                        vp.setCurrentItem(1);
                        break;
                    case R.id.rg3:
                        vp.setCurrentItem(2);
                        break;
                    case R.id.rg4:
                        vp.setCurrentItem(3);
                        break;
                }
            }
        });
        vp.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                rg.check(rg.getChildAt(position).getId());

            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
        vp.setOffscreenPageLimit(4);


    }

    @Override
    protected void initView() {
    }

    @Override
    protected BasePresenter providePresenter() {
        return null;
    }

    @Override
    protected int layoutId() {
        return R.layout.activity_main;
    }

    @Override
    protected void onActivityDestroy() {

    }



}
