package com.example.newgreen.SplashActivity.IntroLogoFragment;

import android.content.Context;

public class LogoRepository implements LogoDataSource {
    LocalLogoDataSource localLogoDataSource;
    public LogoRepository(Context context){
        localLogoDataSource=new LocalLogoDataSource(context);
    }
    @Override
    public String CheckIntro() {
        return localLogoDataSource.CheckIntro();
    }

    @Override
    public String CheckUserLogin() {
        return localLogoDataSource.CheckUserLogin();
    }
}
