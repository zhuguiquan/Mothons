package com.bw.mothons.model;

import com.bw.mothons.contract.LoginContract;
import com.bw.mothons.model.bean.LoginBean;
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
public class LoginModel implements LoginContract.IModel {
    @Override
    public void getloginData(String phone, String pwd, IModelCallBack iModelCallBack) {
        NetUtil.getInstance().getApi().loginData(phone,pwd)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<LoginBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(LoginBean loginBean) {
                        iModelCallBack.onLoginSuccess(loginBean);

                    }

                    @Override
                    public void onError(Throwable e) {
                        iModelCallBack.onLoginFailure(e);

                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }
}
