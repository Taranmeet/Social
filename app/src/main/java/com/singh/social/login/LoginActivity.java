package com.singh.social.login;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.singh.social.R;
import com.singh.social.databinding.ActivityLoginBinding;


public class LoginActivity extends AppCompatActivity implements LoginView{

    private LoginViewModel mViewModel;

    private ActivityLoginBinding mBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mBinding = DataBindingUtil.setContentView(this, R.layout.activity_login);

        mViewModel = new LoginViewModel(this);

        mBinding.setViewModel(mViewModel);

    }

    @Override
    public Context getContext() {
        return this;
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mViewModel.onDestroy();
    }
}
