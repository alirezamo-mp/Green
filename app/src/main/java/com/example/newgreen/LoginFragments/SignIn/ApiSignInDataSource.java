package com.example.newgreen.LoginFragments.SignIn;

import com.example.newgreen.LoginFragments.SignIn.AdapterModel.CheckUserModel;
import com.example.newgreen.Server.ApiProvider;
import com.example.newgreen.Server.ApiService;

import io.reactivex.Single;

public class ApiSignInDataSource implements SignInDataSource {
    ApiService apiService= ApiProvider.apiProvider();
    @Override
    public Single<CheckUserModel> CheckUser(String email, String pass) {
        return apiService.checkUser(email,pass);
    }

    @Override
    public void SaveUser(String email, String ide) {

    }
}
