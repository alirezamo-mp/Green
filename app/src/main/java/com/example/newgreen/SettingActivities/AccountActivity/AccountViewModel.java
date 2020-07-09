package com.example.newgreen.SettingActivities.AccountActivity;

import android.content.Context;

import com.example.newgreen.BasketFragments.CardFragment.ModelAdapter.CardModelItem;
import com.example.newgreen.SettingActivities.AccountActivity.ModelAdapter.AccountInModel;

import java.util.List;

import io.reactivex.Single;

public class AccountViewModel implements AccountDataSource {
    AccountRepository accountRepository;
    public AccountViewModel(Context context) {
        accountRepository=new AccountRepository(context);
    }

    @Override
    public Single<String> updateUser(String ide, String name, String email, String pass, String address) {
        return accountRepository.updateUser(ide, name, email, pass, address);
    }

    @Override
    public Single<AccountInModel> getUser(String ide) {
        return accountRepository.getUser(ide);
    }

    @Override
    public String getIde() {
        return accountRepository.getIde();
    }

    @Override
    public Single<List<CardModelItem>> getCards(String id) {
        return accountRepository.getCards(id);
    }
}
