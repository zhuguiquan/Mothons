package com.bw.mothons.view.fragment;


import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.fragment.app.Fragment;

import com.bw.mothons.R;
import com.bw.mothons.base.BaseFragment;
import com.bw.mothons.base.BasePresenter;
import com.bw.mothons.contract.LoginContract;
import com.bw.mothons.model.bean.LoginBean;
import com.bw.mothons.presenter.LoginPresenter;
import com.bw.mothons.view.activity.MainActivity;

import java.util.regex.Pattern;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * A simple {@link Fragment} subclass.
 */
public class LoginFragment extends BaseFragment<LoginPresenter>implements LoginContract.IView {


    @BindView(R.id.phone)
    EditText phone;
    @BindView(R.id.pwd)
    EditText pwd;
    @BindView(R.id.login)
    Button login;


    @Override
    protected void initView(View inflate) {

    }

    @Override
    protected LoginPresenter providePresenter() {
        return new LoginPresenter();
    }


    @Override
    protected int layoutId() {
        return R.layout.fragment_fenlei;
    }

    @Override
    protected void initData() {

    }

    @Override
    public void startActivitys(Context context, Class cls) {
        startActivity(new Intent(context,cls));

    }

    @Override
    protected void onFragmentDestroy() {

    }

    @OnClick(R.id.login)
    public void onViewClicked() {
        String phones = phone.getText().toString().trim();
        if (TextUtils.isEmpty(phones)) {
            Toast.makeText(getContext(), "手机号不能为空", Toast.LENGTH_SHORT).show();
            return;
        }
        String pwds = pwd.getText().toString().trim();

        if (TextUtils.isEmpty(pwds)) {
            Toast.makeText(getContext(), "密码不能为空", Toast.LENGTH_SHORT).show();
            return;
        }
        String  PHONES="^(13[0-9]|14[5|7]|15[0|1|2|3|5|6|7|8|9]|18[0|1|2|3|5|6|7|8|9])\\d{8}$";
        boolean matches = Pattern.matches(PHONES, phones);
        if(matches){
            mpresenter.getloginData(phones, pwds);
        }else{
            Toast.makeText(getContext(), "失败", Toast.LENGTH_SHORT).show();
        }

    }

    @Override
    public void onLoginSuccess(LoginBean loginBean) {
        if ("0000".equals(loginBean.getStatus())) {
            startActivitys(getContext(),MainActivity.class);
        } else {
            Toast.makeText(getContext(), "" + loginBean.getMessage(), Toast.LENGTH_SHORT).show();
        }

    }

    @Override
    public void onLoginFailure(Throwable throwable) {

    }
}
