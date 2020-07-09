package com.example.newgreen.LoginFragments.SignIn;

import android.content.Context;
import android.content.SharedPreferences;

import com.example.newgreen.LoginFragments.SignIn.AdapterModel.CheckUserModel;

import io.reactivex.Single;

public class LocalSignInDataSource implements SignInDataSource {
    SharedPreferences sharedPreferences;
    public LocalSignInDataSource (Context context){
        sharedPreferences=context.getSharedPreferences("login",Context.MODE_PRIVATE);
    }
    @Override
    public Single<CheckUserModel> CheckUser(String email, String pass) {
        return null;
    }

    @Override
    public void SaveUser(String email, String ide) {
        SharedPreferences.Editor editor=sharedPreferences.edit();
        editor.putString("email",email);
        editor.putString("ide",ide);
        editor.apply();
    }
}
