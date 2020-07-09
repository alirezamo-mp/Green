package com.example.newgreen.SettingActivities.AccountActivity;

import android.content.Context;
import android.content.SharedPreferences;

import com.example.newgreen.BasketFragments.CardFragment.ModelAdapter.CardModelItem;
import com.example.newgreen.SettingActivities.AccountActivity.ModelAdapter.AccountInModel;

import java.util.List;

import io.reactivex.Single;

public class LocalAccountDataSource implements AccountDataSource {
    SharedPreferences sharedPreferences;

    public LocalAccountDataSource(Context context) {
        sharedPreferences = context.getSharedPreferences("login", Context.MODE_PRIVATE);
    }

    @Override
    public Single<String> updateUser(String ide, String name, String email, String pass, String address) {
        return null;
    }

    @Override
    public Single<AccountInModel> getUser(String ide) {
        return null;
    }

    @Override
    public String getIde() {
        return sharedPreferences.getString("ide", "#404");
    }

    @Override
    public Single<List<CardModelItem>> getCards(String id) {
        return null;
    }
}
