package com.dev.simplemvp.view;

/**
 * Created by Administrator on 2017/3/13.
 */
public interface IUserLoginView {

    String getUserName();
    String getUserPwd();
    void toActivity();
    void showError();
    void showLoading();
    void hindLoading();
    void clearUserName();
    void clearUserPwd();
}
