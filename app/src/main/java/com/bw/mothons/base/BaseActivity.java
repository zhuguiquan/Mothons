package com.bw.mothons.base;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.bw.mothons.R;

import butterknife.ButterKnife;

public abstract class BaseActivity<P extends BasePresenter> extends AppCompatActivity {
    protected P mpresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(layoutId());
        mpresenter=providePresenter();
        if (mpresenter != null) {
            mpresenter.attach(this);
        }
        ButterKnife.bind(this);
        initView();
        initData();

    }

    protected abstract void initData();

    protected abstract void initView();

    protected abstract P providePresenter();

    protected abstract int layoutId();

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (mpresenter != null) {
            mpresenter.detach();
            onActivityDestroy();
        }
    }

    protected abstract void onActivityDestroy();
}
