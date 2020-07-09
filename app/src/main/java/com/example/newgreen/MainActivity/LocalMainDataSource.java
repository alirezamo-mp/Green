package com.example.newgreen.MainActivity;

import android.content.Context;
import android.content.SharedPreferences;

public class LocalMainDataSource implements MainDataSource {
    SharedPreferences sharedPreferences;
    public LocalMainDataSource(Context context){
        sharedPreferences=context.getSharedPreferences("intro",Context.MODE_PRIVATE);
    }


    @Override
    public String CheckIntro() {
        return sharedPreferences.getString("show","no");
    }
}
