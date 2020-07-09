package com.example.newgreen.SettingActivities.AccountActivity;

import android.content.Context;

import com.example.newgreen.BasketFragments.CardFragment.ModelAdapter.CardModelItem;
import com.example.newgreen.SettingActivities.AccountActivity.ModelAdapter.AccountInModel;

import java.util.List;

import io.reactivex.Single;

public class AccountRepository implements AccountDataSource {
    ApiAccountDataSource apiAccountDataSource = new ApiAccountDataSource();
    LocalAccountDataSource localAccountDataSource;

    public AccountRepository(Context context) {
        localAccountDataSource = new LocalAccountDataSource(context);
    }

    @Override
    public Single<String> updateUser(String ide, String name, String email, String pass, String address) {
        return apiAccountDataSource.updateUser(ide,name,email,pass,address);
    }

    @Override
    public Single<AccountInModel> getUser(String ide) {
        return apiAccountDataSource.getUser(ide);
    }

    @Override
    public String getIde() {
        return localAccountDataSource.getIde();
    }

    @Override
    public Single<List<CardModelItem>> getCards(String id) {
        return apiAccountDataSource.getCards(id);
    }
}
