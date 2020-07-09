package com.example.newgreen.SplashActivity.IntroLogoFragment;

import android.content.Context;

public class LogoViewModel implements LogoDataSource {
    LogoRepository logoRepository;
    public LogoViewModel(Context context){
        logoRepository=new LogoRepository(context);
    }
    @Override
    public String CheckIntro() {
        return logoRepository.CheckIntro();
    }

    @Override
    public String CheckUserLogin() {
        return logoRepository.CheckUserLogin();
    }
}
