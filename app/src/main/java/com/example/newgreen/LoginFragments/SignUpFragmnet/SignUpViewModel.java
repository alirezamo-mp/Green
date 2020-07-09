package com.example.newgreen.LoginFragments.SignUpFragmnet;

import android.content.Context;

import com.example.newgreen.LoginFragments.SignIn.AdapterModel.CheckUserModel;

import io.reactivex.Single;

public class SignUpViewModel implements SignUpDataSource {
    SignUpRepository signUpRepository;
    public SignUpViewModel(Context context){
        signUpRepository=new SignUpRepository(context);
    }

    @Override
    public Single<CheckUserModel> addUser(String email, String pass, String name) {
        return signUpRepository.addUser(email, pass, name);
    }

    @Override
    public void saveUser(String email, String ide) {
        signUpRepository.saveUser(email, ide);
    }
}
