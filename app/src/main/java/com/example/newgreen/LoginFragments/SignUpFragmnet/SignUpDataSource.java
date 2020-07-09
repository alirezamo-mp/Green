package com.example.newgreen.LoginFragments.SignUpFragmnet;

import com.example.newgreen.LoginFragments.SignIn.AdapterModel.CheckUserModel;

import io.reactivex.Single;

public interface SignUpDataSource {

    Single<CheckUserModel> addUser(String email,String pass,String name);

    void saveUser(String email,String ide);

}
