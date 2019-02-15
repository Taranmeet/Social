package com.singh.social.login;

import android.databinding.ObservableField;
import android.text.TextUtils;
import android.widget.Toast;

import com.singh.social.base.BaseViewModel;

import io.reactivex.Observable;

public class LoginViewModel extends BaseViewModel<LoginView> {

    public ObservableField<String> mEmail = new ObservableField<>();

    public ObservableField<String> mPassword = new ObservableField<>();

    public LoginViewModel(LoginView iView){
        super(iView);
    }

    /**
     * Method called for performing login.
     * @return  Observable to observe result of login.
     */
    public Observable<LoginModal> doLogin() {
        return Observable.create(emitter -> {
            if (!TextUtils.isEmpty(mEmail.get()) && !TextUtils.isEmpty(mPassword.get())) {
                emitter.onNext(new LoginModal());
            } else {
                emitter.onError(new Throwable());
            }
            emitter.onComplete();
        });
    }


    /**
     * Method called when login is clicked.
     */
    public void onLoginClicked(){
        getDisposable().add(doLogin().subscribe(loginModal -> {
            // Login Done
            Toast.makeText(getView().getContext(), "Login Success", Toast.LENGTH_SHORT).show();
        }, throwable -> {
            // error in login
            Toast.makeText(getView().getContext(), "Error", Toast.LENGTH_SHORT).show();
        }));
    }


}
