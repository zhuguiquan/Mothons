package com.bw.mothons.contract;

import com.bw.mothons.model.bean.LoginBean;

/**
 * DateTime:2020/4/13 0013
 * author:朱贵全(Administrator)
 * function:
 */
public interface LoginContract {
    interface IView{
        void onLoginSuccess(LoginBean loginBean);
        void onLoginFailure(Throwable throwable);

    }
    interface IPresenter{
        void getloginData(String phone,String pwd);

    }
    interface IModel{
        void getloginData(String phone,String pwd,IModelCallBack iModelCallBack);
        interface IModelCallBack{
            void onLoginSuccess(LoginBean loginBean);
            void onLoginFailure(Throwable throwable);

        }
    }
}
