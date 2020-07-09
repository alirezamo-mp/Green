package com.example.newgreen.SplashActivity;

import android.content.Context;

public class SplashRepository implements SplashDataSource {
    LocalSplashDataSource localSplashDataSource;
    public SplashRepository(Context context){
        localSplashDataSource =new LocalSplashDataSource(context);
    }

    @Override
    public String CheckIntro() {
        return localSplashDataSource.CheckIntro();
    }

    @Override
    public void saveIntro() {
        localSplashDataSource.saveIntro();
    }
}
