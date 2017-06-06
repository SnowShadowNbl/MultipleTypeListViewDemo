package com.nbl.multipletypelistviewdemo.app;

import android.app.Application;

/**
 *author: Nbl(SnowShadow)
 *email: vsnowshadow@gmail.com
 *created
 */
public class App extends Application {

    private static App instance;

    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;
    }

    public static App getInstance(){

        if(instance == null){

            instance = new App();

        }

        return instance;

    }

}
