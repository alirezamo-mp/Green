package com.example.newgreen.AddCardActivity;

import android.content.Context;
import android.content.SharedPreferences;

import io.reactivex.Single;

public class LocalACardDataSource implements ACardDataSource {
    SharedPreferences sharedPreferences;
    public LocalACardDataSource (Context context){
        sharedPreferences=context.getSharedPreferences("login",Context.MODE_PRIVATE);
    }

    @Override
    public String getIde() {
        return sharedPreferences.getString("ide","#404");
    }

    @Override
    public Single<String> addCard(String ide, String name, String number, String code, String date) {
        return null;
    }
}
