package com.nbl.multipletypelistviewdemo.utils;

import android.support.annotation.StringRes;
import android.widget.Toast;

import com.nbl.multipletypelistviewdemo.app.App;

/**
 *author: Nbl(SnowShadow)
 *email: vsnowshadow@gmail.com
 *created
 */
public class ToastUtil {

    public ToastUtil() {
    }

    public static void show(CharSequence text) {
        if (text.length() < 10) {
            Toast.makeText(App.getInstance(), text, Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(App.getInstance(), text, Toast.LENGTH_LONG).show();
        }
    }

    public static void showLongTime(CharSequence text){
        Toast.makeText(App.getInstance(), text, Toast.LENGTH_LONG).show();
    }

    public static void show(@StringRes int resId) {
        show(App.getInstance().getString(resId));
    }

}