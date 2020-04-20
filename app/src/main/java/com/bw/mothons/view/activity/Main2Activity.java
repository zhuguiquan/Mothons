package com.bw.mothons.view.activity;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import com.bw.mothons.R;
import com.bw.mothons.base.BaseActivity;
import com.bw.mothons.base.BasePresenter;
import com.bw.mothons.view.fragment.LoginFragment;
import com.bw.mothons.view.fragment.RegistFragment;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class Main2Activity extends BaseActivity {


    @BindView(R.id.tab)
    TabLayout tab;
    @BindView(R.id.vp)
    ViewPager vp;
List<Fragment>fragmentLists=new ArrayList<>();
List<String>mStrings=new ArrayList<>();
    @Override
    protected void initData() {
        LoginFragment loginFragment = new LoginFragment();
        RegistFragment registFragment = new RegistFragment();
        fragmentLists.add(loginFragment);
        fragmentLists.add(registFragment);
        mStrings.add("登录");
        mStrings.add("注册");
        vp.setAdapter(new FragmentPagerAdapter(getSupportFragmentManager()) {
            @NonNull
            @Override
            public Fragment getItem(int position) {
                return fragmentLists.get(position);
            }

            @Override
            public int getCount() {
                return fragmentLists.size();
            }

            @Nullable
            @Override
            public CharSequence getPageTitle(int position) {
                return mStrings.get(position);
            }
        });
        tab.setupWithViewPager(vp);
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
        return R.layout.activity_main2;
    }

    @Override
    protected void onActivityDestroy() {

    }


}
