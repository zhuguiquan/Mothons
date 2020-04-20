package com.bw.mothons.view.fragment;


import android.content.Context;
import android.view.View;
import android.widget.CheckBox;
import android.widget.ExpandableListView;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

import com.bw.mothons.R;
import com.bw.mothons.base.BaseFragment;
import com.bw.mothons.contract.ShopContract;
import com.bw.mothons.model.bean.ShopBean;
import com.bw.mothons.presenter.ShopPresenter;
import com.bw.mothons.view.adapter.ShopAdapter;

import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * A simple {@link Fragment} subclass.
 */
public class ShopFragment extends BaseFragment<ShopPresenter> implements ShopContract.IView {


    @BindView(R.id.ex)
    ExpandableListView ex;

    @BindView(R.id.price)
    TextView price;
    @BindView(R.id.check)
    CheckBox check;
    private ShopAdapter mShopAdapter;

    @Override
    protected void initView(View inflate) {

    }

    @Override
    protected ShopPresenter providePresenter() {
        return new ShopPresenter();
    }


    @Override
    protected int layoutId() {
        return R.layout.fragment_shop;
    }

    @Override
    protected void initData() {
        mpresenter.getShopData();
    }

    @Override
    public void startActivitys(Context context, Class cls) {

    }

    @Override
    protected void onFragmentDestroy() {

    }

    @Override
    public void onShopSuccess(ShopBean shopBean) {
        List<ShopBean.OrderDataBean> orderData = shopBean.getOrderData();
        mShopAdapter = new ShopAdapter(orderData);
        mShopAdapter.setOnClickListener(new ShopAdapter.OnClickListener() {
            @Override
            public void onClick() {
                check.setChecked(mShopAdapter.allChecked());
                price.setText("合计:" + mShopAdapter.getPricess() + "");
            }
        });
        ex.setAdapter(mShopAdapter);
        for (int i = 0; i < orderData.size(); i++) {
            ex.expandGroup(i);
        }


    }

    @Override
    public void onShopFarlure(Throwable throwable) {

    }

    @OnClick(R.id.check)
    public void onViewClicked() {
        if (mShopAdapter != null) {
            boolean b = mShopAdapter.allChecked();
            b=!b;
            mShopAdapter.allCheckedStatus(b);
            check.setChecked(mShopAdapter.allChecked());
            price.setText("合计:" + mShopAdapter.getPricess() + "");
        }
    }
}
