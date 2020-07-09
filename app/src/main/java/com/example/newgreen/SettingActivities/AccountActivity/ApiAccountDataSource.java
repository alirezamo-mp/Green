package com.example.newgreen.SettingActivities.AccountActivity;

import com.example.newgreen.BasketFragments.CardFragment.ModelAdapter.CardModelItem;
import com.example.newgreen.Server.ApiProvider;
import com.example.newgreen.Server.ApiService;
import com.example.newgreen.SettingActivities.AccountActivity.ModelAdapter.AccountInModel;

import java.util.List;

import io.reactivex.Single;

public class ApiAccountDataSource implements AccountDataSource {
    ApiService apiService= ApiProvider.apiProvider();

    @Override
    public Single<String> updateUser(String ide, String name, String email, String pass, String address) {
        return apiService.updateUser(ide,name,email,pass,address);
    }

    @Override
    public Single<AccountInModel> getUser(String ide) {
        return apiService.getUser(ide);
    }

    @Override
    public String getIde() {
        return null;
    }

    @Override
    public Single<List<CardModelItem>> getCards(String id) {
        return apiService.getCards(id);
    }
}
