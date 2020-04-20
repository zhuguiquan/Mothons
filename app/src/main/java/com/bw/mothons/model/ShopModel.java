package com.bw.mothons.model;

import android.view.View;

import com.bw.mothons.contract.ShopContract;
import com.bw.mothons.model.bean.ShopBean;
import com.bw.mothons.util.NetUtil;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

/**
 * DateTime:2020/4/13 0013
 * author:朱贵全(Administrator)
 * function:
 */
public class ShopModel implements ShopContract.IModel {
    @Override
    public void getShopData(IModelCallBack iModelCallBack) {
        NetUtil.getInstance().getApi().shopData()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<ShopBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(ShopBean shopBean) {
                        iModelCallBack.onShopSuccess(shopBean);

                    }

                    @Override
                    public void onError(Throwable e) {
                        iModelCallBack.onShopFarlure(e);

                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }
}
