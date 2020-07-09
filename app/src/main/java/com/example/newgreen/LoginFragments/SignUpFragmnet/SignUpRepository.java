package com.example.newgreen.LoginFragments.SignUpFragmnet;

import android.content.Context;

import com.example.newgreen.LoginFragments.SignIn.AdapterModel.CheckUserModel;

import io.reactivex.Single;

public class SignUpRepository implements SignUpDataSource {
    LocalSignUpDataSource localSignUpDataSource;
    ApiSignUpDataSource apiSignUpDataSource=new ApiSignUpDataSource();
    public SignUpRepository(Context context){
        localSignUpDataSource=new LocalSignUpDataSource(context);
    }


    @Override
    public Single<CheckUserModel> addUser(String email, String pass, String name) {
        return apiSignUpDataSource.addUser(email, pass, name);
    }

    @Override
    public void saveUser(String email, String ide) {
        localSignUpDataSource.saveUser(email, ide);
    }
}
