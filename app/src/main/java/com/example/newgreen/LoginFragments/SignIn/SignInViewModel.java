package com.example.newgreen.LoginFragments.SignIn;

import android.content.Context;

import com.example.newgreen.LoginFragments.SignIn.AdapterModel.CheckUserModel;

import io.reactivex.Single;

public class SignInViewModel implements SignInDataSource{
    SignInRepository signInRepository;

    public SignInViewModel (Context context){
        signInRepository=new SignInRepository(context);
    }

    @Override
    public Single<CheckUserModel> CheckUser(String email, String pass) {
        return signInRepository.CheckUser(email,pass);
    }

    @Override
    public void SaveUser(String email, String ide) {
        signInRepository.SaveUser(email, ide);
    }
}
