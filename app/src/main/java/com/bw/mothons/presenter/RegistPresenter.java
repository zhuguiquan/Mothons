package com.bw.mothons.presenter;

import com.bw.mothons.base.BasePresenter;
import com.bw.mothons.contract.RegistContract;
import com.bw.mothons.model.RegistModel;
import com.bw.mothons.model.bean.RegistBean;

/**
 * DateTime:2020/4/13 0013
 * author:朱贵全(Administrator)
 * function:
 */
public class RegistPresenter extends BasePresenter<RegistContract.IView>implements RegistContract.IPresenter {

    private RegistModel mRegistModel;

    @Override
    protected void initModel() {
        mRegistModel = new RegistModel();
    }

    @Override
    public void getRegistData(String phone, String pwd) {
        mRegistModel.getRegistData(phone, pwd, new RegistContract.IModel.IModelCallBacks() {
            @Override
            public void onRegistSuccess(RegistBean registBean) {
                view.onRegistSuccess(registBean);
            }

            @Override
            public void onRegistFailure(Throwable throwable) {
                view.onRegistFailure(throwable);

            }
        });

    }
}
