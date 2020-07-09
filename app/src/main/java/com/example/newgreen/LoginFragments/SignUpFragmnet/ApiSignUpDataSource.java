package com.example.newgreen.LoginFragments.SignUpFragmnet;

import com.example.newgreen.LoginFragments.SignIn.AdapterModel.CheckUserModel;
import com.example.newgreen.Server.ApiProvider;
import com.example.newgreen.Server.ApiService;

import io.reactivex.Single;

public class ApiSignUpDataSource implements SignUpDataSource {
    ApiService apiService= ApiProvider.apiProvider();

    @Override
    public Single<CheckUserModel> addUser(String email, String pass, String name) {
        return apiService.addUser(email, pass, name);
    }

    @Override
    public void saveUser(String email, String ide) {

    }
}
