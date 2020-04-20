package com.bw.mothons.view.fragment;


import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.View;
import android.widget.ImageView;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.bw.mothons.R;
import com.bw.mothons.base.BaseFragment;
import com.bw.mothons.base.BasePresenter;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * A simple {@link Fragment} subclass.
 */
public class MyFragment extends BaseFragment {


    @BindView(R.id.ima)
    ImageView ima;

    @Override
    protected void initView(View inflate) {

    }

    @Override
    protected BasePresenter providePresenter() {
        return null;
    }

    @Override
    protected int layoutId() {
        return R.layout.fragment_my;
    }

    @Override
    protected void initData() {

    }

    @Override
    public void startActivitys(Context context, Class cls) {

    }

    @Override
    protected void onFragmentDestroy() {

    }

    @OnClick(R.id.ima)
    public void onViewClicked() {
        Intent intent = new Intent(Intent.ACTION_PICK);
        intent.setType("image/*");
        startActivityForResult(intent,0);
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode==0){
            Uri data1 = data.getData();
            ima.setImageURI(data1);
        }
    }
}
