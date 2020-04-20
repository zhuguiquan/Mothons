package com.bw.mothons.contract;

import com.bw.mothons.model.bean.LoginBean;
import com.bw.mothons.model.bean.RegistBean;

/**
 * DateTime:2020/4/13 0013
 * author:朱贵全(Administrator)
 * function:
 */
public interface RegistContract {
    interface IView{
        void onRegistSuccess(RegistBean registBean);
        void onRegistFailure(Throwable throwable);

    }
    interface IPresenter{
        void getRegistData(String phone, String pwd);

    }
    interface IModel{
        void getRegistData(String phone, String pwd,IModelCallBacks iModelCallBacks);

        interface IModelCallBacks{
            void onRegistSuccess(RegistBean registBean);
            void onRegistFailure(Throwable throwable);

        }
    }
}
