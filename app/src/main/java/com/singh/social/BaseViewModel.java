package com.singh.social;

import io.reactivex.disposables.CompositeDisposable;

public class BaseViewModel<T extends BaseView> {

    public BaseViewModel(T iView) {
        mView = iView;
        mDisposable = new CompositeDisposable();
    }

    private T mView;

    public T getView() {
        return mView;
    }

    private CompositeDisposable mDisposable;

    public CompositeDisposable getDisposable() {
        return mDisposable;
    }

    public void setDisposable(CompositeDisposable iDisposable) {
        this.mDisposable = iDisposable;
    }

    public void onDestroy() {
        mView = null;
        mDisposable.dispose();
        mDisposable = new CompositeDisposable();
    }

}
