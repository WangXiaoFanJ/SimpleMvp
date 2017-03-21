package com.dev.simplemvp.presenter;

import com.dev.simplemvp.biz.LoginListener;
import com.dev.simplemvp.biz.UserBiz;
import com.dev.simplemvp.view.IUserLoginView;

/**
 * Created by Administrator on 2017/3/13.
 */
public class UserLoginPresenter {
    private LoginListener loginListener = new LoginListener();
    private IUserLoginView userLoginView;
    private UserBiz userBiz;

    public UserLoginPresenter(IUserLoginView userLoginView) {
        this.userLoginView = userLoginView;
        this.userBiz = new UserBiz(userLoginView);
    }

    public void login(){
        userBiz.login(userLoginView.getUserName(),userLoginView.getUserPwd(),loginListener);
    }
    public void cancle(){
        userLoginView.clearUserName();
        userLoginView.clearUserPwd();
    }
}
