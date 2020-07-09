package com.example.newgreen.LoginFragments.SignIn;

import com.example.newgreen.LoginFragments.SignIn.AdapterModel.CheckUserModel;

import io.reactivex.Single;

public interface SignInDataSource {

    Single<CheckUserModel> CheckUser(String email,String pass);

    void SaveUser(String email,String ide);

}
