package com.wt.commonres.utils;

import android.app.Application;
import android.widget.Toast;

import es.dmoral.toasty.Toasty;

public class ToastContext {
    private static final ToastContext ourInstance = new ToastContext();

    public static ToastContext getInstance() {
        return ourInstance;
    }

    public Application application;

    private ToastContext() {
    }

    public void init(Application application) {
        this.application = application;
        Toasty.Config.getInstance()
                .allowQueue(false) //不允许排队
                .apply();
    }

    private String getString(int res) {
        return application.getString(res);
    }

    public void toastShort(int resString) {
        Toasty.info(application, getString(resString), Toast.LENGTH_SHORT, false).show();
    }

    public void toastShort(String message) {
//        Toasty.info(application, message, Toast.LENGTH_SHORT, false).show();
        Toasty.custom(application, message, null, Toast.LENGTH_SHORT, false).show();
    }

    public void toastLong(int resString) {
        Toasty.info(application, getString(resString), Toast.LENGTH_LONG, false).show();
    }

    public void toastLong(String message) {
        Toasty.info(application, message, Toast.LENGTH_LONG, false).show();
    }

    private long mLastClickTime = 0;
    public static final long TIME_INTERVAL = 1100L;


    public void preventDuplicationToast(int message) {
        long nowTime = System.currentTimeMillis();
        if (nowTime - mLastClickTime > TIME_INTERVAL) {
            // do something
            mLastClickTime = nowTime;
            toastShort(message);
        } else {

        }
    }

    public void preventDuplicationToast(String message) {
        long nowTime = System.currentTimeMillis();
        if (nowTime - mLastClickTime > TIME_INTERVAL) {
            // do something
            toastShort(message);
            mLastClickTime = nowTime;
        } else {

        }
    }

}
