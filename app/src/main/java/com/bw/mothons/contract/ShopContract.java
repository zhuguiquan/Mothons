package com.bw.mothons.contract;


import com.bw.mothons.model.bean.ShopBean;

/**
 * DateTime:2020/3/16 0016
 * author:朱贵全(Administrator)
 * function:
 */
public interface ShopContract {
    interface  IView{
        void onShopSuccess(ShopBean shopBean);
        void onShopFarlure(Throwable throwable);

    }
    interface  IPresenter{
        void getShopData();

    }
    interface  IModel{
        void getShopData(IModelCallBack iModelCallBack);

        interface  IModelCallBack{
            void onShopSuccess(ShopBean shopBean);
            void onShopFarlure(Throwable throwable);

        }
    }
}
