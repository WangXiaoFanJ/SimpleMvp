package com.dev.simplemvp;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.dev.simplemvp.presenter.UserLoginPresenter;
import com.dev.simplemvp.view.IUserLoginView;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity implements IUserLoginView {
    private Context mContext;
    @BindView(R.id.edit_phone)
    EditText phoneEdit;
    @BindView(R.id.edit_pwd)
    EditText pwdEdit;
    @BindView(R.id.tv_login)
    TextView loginTv;
    @BindView(R.id.tv_cancle)
    TextView cancleTv;
    @BindView(R.id.progress_bar)
    ProgressBar progressBar;
    private UserLoginPresenter mUserLoginPresenter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        mContext = MainActivity.this;
        mUserLoginPresenter = new UserLoginPresenter(this);
        loginTv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mUserLoginPresenter.login();
            }
        });
        cancleTv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mUserLoginPresenter.cancle();
            }
        });
    }

    @Override
    public String getUserName() {
        return phoneEdit.getText().toString().trim();
    }

    @Override
    public String getUserPwd() {
        return pwdEdit.getText().toString().trim();
    }

    @Override
    public void toActivity() {
        Toast.makeText(mContext, "跳转到登录成功页面", Toast.LENGTH_LONG).show();
    }

    @Override
    public void showError() {
        Toast.makeText(mContext, "error:账号或密码错误", Toast.LENGTH_LONG).show();
    }

    @Override
    public void showLoading() {
        progressBar.setVisibility(View.VISIBLE);
    }

    @Override
    public void hindLoading() {
        progressBar.setVisibility(View.GONE);
    }

    @Override
    public void clearUserName() {
        phoneEdit.setText("");
    }

    @Override
    public void clearUserPwd() {
        pwdEdit.setText("");
    }
}
