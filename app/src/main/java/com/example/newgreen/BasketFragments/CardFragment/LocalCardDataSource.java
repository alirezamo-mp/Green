package com.example.newgreen.BasketFragments.CardFragment;

import android.content.Context;
import android.content.SharedPreferences;

import com.example.newgreen.BasketFragments.CardFragment.ModelAdapter.CardModelItem;

import java.util.List;

import io.reactivex.Single;

public class LocalCardDataSource implements CardDataSource{
    SharedPreferences sharedPreferences;
    public LocalCardDataSource (Context context){
        sharedPreferences=context.getSharedPreferences("login",Context.MODE_PRIVATE);
    }


    @Override
    public String getIde() {
        return sharedPreferences.getString("ide","#404");
    }

    @Override
    public Single<List<CardModelItem>> getCards(String ide) {
        return null;
    }
}
