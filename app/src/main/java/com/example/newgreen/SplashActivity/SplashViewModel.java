package com.example.newgreen.SplashActivity;

import android.content.Context;

public class SplashViewModel implements SplashDataSource{
    SplashRepository splashRepository;

    public SplashViewModel(Context context) {
        splashRepository = new SplashRepository(context);
    }


    @Override
    public String CheckIntro() {
        return splashRepository.CheckIntro();
    }

    public void saveIntro() {
        splashRepository.saveIntro();
    }
}
