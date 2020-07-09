package com.example.newgreen.AddCardActivity;

import android.content.Context;

import com.example.newgreen.BasketFragments.CardFragment.ApiCardDataSource;
import com.example.newgreen.BasketFragments.CardFragment.ModelAdapter.CardModelItem;
import com.example.newgreen.SettingActivities.AccountActivity.AccountDataSource;

import java.util.List;

import io.reactivex.Single;

public class ACardRepository implements ACardDataSource {
    LocalACardDataSource aCardDataSource;
    ApiACardDataSource apiACardDataSource=new ApiACardDataSource();
    public ACardRepository (Context context){
        aCardDataSource=new LocalACardDataSource(context);
    }

    @Override
    public String getIde() {
        return aCardDataSource.getIde();
    }

    @Override
    public Single<String> addCard(String ide, String name, String number, String code, String date) {
        return apiACardDataSource.addCard(ide, name, number, code, date);
    }
}
