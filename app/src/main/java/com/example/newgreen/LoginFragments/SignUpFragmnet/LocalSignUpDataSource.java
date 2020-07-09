package com.example.newgreen.LoginFragments.SignUpFragmnet;

import android.content.Context;
import android.content.SharedPreferences;

import com.example.newgreen.LoginFragments.SignIn.AdapterModel.CheckUserModel;

import io.reactivex.Single;

public class LocalSignUpDataSource implements SignUpDataSource {
    SharedPreferences sharedPreferences;
    public LocalSignUpDataSource (Context context){
        sharedPreferences=context.getSharedPreferences("login",Context.MODE_PRIVATE);
    }

    @Override
    public Single<CheckUserModel> addUser(String email, String pass, String name) {
        return null;
    }

    @Override
    public void saveUser(String email, String ide) {
        SharedPreferences.Editor editor=sharedPreferences.edit();
        editor.putString("email",email);
        editor.putString("ide",ide);
        editor.apply();
    }
}
