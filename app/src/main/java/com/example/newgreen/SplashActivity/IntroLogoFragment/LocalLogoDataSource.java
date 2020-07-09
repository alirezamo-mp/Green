package com.example.newgreen.SplashActivity.IntroLogoFragment;

import android.content.Context;
import android.content.SharedPreferences;

public class LocalLogoDataSource implements LogoDataSource {
    SharedPreferences sharedPreferences;
    SharedPreferences login;
    public LocalLogoDataSource(Context context){
      login=context.getSharedPreferences("login",Context.MODE_PRIVATE);
    }


    @Override
    public String CheckIntro() {
        return null;
    }

    @Override
    public String CheckUserLogin() {
        return login.getString("email","no");
    }
}
