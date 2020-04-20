package com.bw.mothons.presenter;

import com.bw.mothons.base.BasePresenter;
import com.bw.mothons.contract.ShopContract;
import com.bw.mothons.model.ShopModel;
import com.bw.mothons.model.bean.ShopBean;

/**
 * DateTime:2020/4/13 0013
 * author:朱贵全(Administrator)
 * function:
 */
public class ShopPresenter extends BasePresenter<ShopContract.IView> implements ShopContract.IPresenter {

    private ShopModel mShopModel;

    @Override
    protected void initModel() {
        mShopModel = new ShopModel();
    }

    @Override
    public void getShopData() {
        mShopModel.getShopData(new ShopContract.IModel.IModelCallBack() {
            @Override
            public void onShopSuccess(ShopBean shopBean) {
                view.onShopSuccess(shopBean);
            }

            @Override
            public void onShopFarlure(Throwable throwable) {
                view.onShopFarlure(throwable);

            }
        });
    }
}
