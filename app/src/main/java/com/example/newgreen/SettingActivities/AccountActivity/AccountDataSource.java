package com.example.newgreen.SettingActivities.AccountActivity;

import com.example.newgreen.BasketFragments.CardFragment.ModelAdapter.CardModelItem;
import com.example.newgreen.SettingActivities.AccountActivity.ModelAdapter.AccountInModel;

import java.util.List;

import io.reactivex.Single;

public interface AccountDataSource {
    Single<String> updateUser(String ide,String name,String email,String pass,String address);
    Single<AccountInModel> getUser(String ide);
    String getIde();
    Single<List<CardModelItem>> getCards(String id);
}
