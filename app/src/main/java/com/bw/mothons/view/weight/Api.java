package com.bw.mothons.view.weight;

import com.bw.mothons.model.bean.LoginBean;
import com.bw.mothons.model.bean.RegistBean;
import com.bw.mothons.model.bean.ShopBean;

import io.reactivex.Observable;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;

/**
 * DateTime:2020/4/13 0013
 * author:朱贵全(Administrator)
 * function:
 */
public interface Api {
    @FormUrlEncoded
    @POST("small/user/v1/register")
    Observable<RegistBean>RegistData(@Field("phone") String phone,@Field("pwd") String pwd);
    @FormUrlEncoded
    @POST("small/user/v1/login")
    Observable<LoginBean>loginData(@Field("phone") String phone, @Field("pwd") String pwd);
    @GET("http://blog.zhaoliang5156.cn/api/shop/month_shopcart_new.json")
    Observable<ShopBean>shopData();
}
