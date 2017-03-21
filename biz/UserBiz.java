package com.dev.simplemvp.biz;

import com.dev.simplemvp.view.IUserLoginView;

/**
 * Created by Administrator on 2017/3/13.
 */
public class UserBiz implements IUserBiz {
    private IUserLoginView iUserLoginView;

    public UserBiz(IUserLoginView iUserLoginView) {
        this.iUserLoginView = iUserLoginView;
    }

    @Override
    public void login(String userName, String userPwd, LoginListener loginListener) {
        try {
            iUserLoginView.showLoading();
            Thread.sleep(2000);
            if(userName.equals("wx")&&userPwd.equals("123456")){
                iUserLoginView.toActivity();
                iUserLoginView.hindLoading();
            }else{
                iUserLoginView.showError();
                iUserLoginView.hindLoading();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
