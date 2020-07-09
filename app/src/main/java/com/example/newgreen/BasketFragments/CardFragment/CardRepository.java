package com.example.newgreen.BasketFragments.CardFragment;

import android.content.Context;

import com.example.newgreen.BasketFragments.CardFragment.ModelAdapter.CardModelItem;

import java.util.List;

import io.reactivex.Single;

public class CardRepository implements CardDataSource {
    LocalCardDataSource localCardDataSource;
    ApiCardDataSource apiCardDataSource=new ApiCardDataSource();
    public CardRepository (Context context){
        localCardDataSource=new LocalCardDataSource(context);
    }

    @Override
    public String getIde() {
        return localCardDataSource.getIde();
    }

    @Override
    public Single<List<CardModelItem>> getCards(String ide) {
        return apiCardDataSource.getCards(ide);
    }
}
