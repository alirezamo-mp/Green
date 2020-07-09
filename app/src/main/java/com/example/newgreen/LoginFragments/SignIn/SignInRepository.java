package com.example.newgreen.LoginFragments.SignIn;

import android.content.Context;

import com.example.newgreen.LoginFragments.SignIn.AdapterModel.CheckUserModel;

import io.reactivex.Single;

public class SignInRepository implements SignInDataSource {

    ApiSignInDataSource apiSignInDataSource=new ApiSignInDataSource();
    LocalSignInDataSource localSignInDataSource;
    public SignInRepository(Context context){
        localSignInDataSource=new LocalSignInDataSource(context);
    }

    @Override
    public Single<CheckUserModel> CheckUser(String email, String pass) {
        return apiSignInDataSource.CheckUser(email,pass);
    }

    @Override
    public void SaveUser(String email, String ide) {
        localSignInDataSource.SaveUser(email, ide);
    }
}
