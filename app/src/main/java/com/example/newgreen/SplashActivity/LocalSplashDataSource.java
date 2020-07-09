package com.example.newgreen.SplashActivity;

import android.content.Context;
import android.content.SharedPreferences;

public class LocalSplashDataSource implements SplashDataSource  {
    SharedPreferences sharedPreferences;

    public LocalSplashDataSource(Context context){
        sharedPreferences=context.getSharedPreferences("intro",Context.MODE_PRIVATE);
    }

    @Override
    public String CheckIntro() {
        return sharedPreferences.getString("show","no");
    }

    @Override
    public void saveIntro() {
        SharedPreferences.Editor editor=sharedPreferences.edit();
        editor.putString("show","see");
        editor.apply();
    }



}
