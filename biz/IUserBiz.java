package com.dev.simplemvp.biz;

/**
 * Created by Administrator on 2017/3/13.
 */
public interface IUserBiz {
    void login(String userName,String userPwd,LoginListener loginListener);
}
