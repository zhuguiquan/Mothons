package com.bw.mothons.presenter;

import com.bw.mothons.base.BasePresenter;
import com.bw.mothons.contract.LoginContract;
import com.bw.mothons.model.LoginModel;
import com.bw.mothons.model.bean.LoginBean;

/**
 * DateTime:2020/4/13 0013
 * author:朱贵全(Administrator)
 * function:
 */
public class LoginPresenter extends BasePresenter<LoginContract.IView> implements LoginContract.IPresenter {

    private LoginModel mLoginModel;

    @Override
    protected void initModel() {
        mLoginModel = new LoginModel();
    }

    @Override
    public void getloginData(String phone, String pwd) {
        mLoginModel.getloginData(phone, pwd, new LoginContract.IModel.IModelCallBack() {
            @Override
            public void onLoginSuccess(LoginBean loginBean) {
                view.onLoginSuccess(loginBean);

            }

            @Override
            public void onLoginFailure(Throwable throwable) {
                view.onLoginFailure(throwable);

            }
        });

    }
}
