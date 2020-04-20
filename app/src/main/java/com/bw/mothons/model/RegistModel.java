package com.bw.mothons.model;

import com.bw.mothons.contract.RegistContract;
import com.bw.mothons.model.bean.RegistBean;
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
public class RegistModel implements RegistContract.IModel {
    @Override
    public void getRegistData(String phone, String pwd, IModelCallBacks iModelCallBacks) {
        NetUtil.getInstance().getApi().RegistData(phone,pwd)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<RegistBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(RegistBean registBean) {
                        iModelCallBacks.onRegistSuccess(registBean);

                    }

                    @Override
                    public void onError(Throwable e) {
                        iModelCallBacks.onRegistFailure(e);

                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }
}
