package com.example.newgreen.BasketFragments.CardFragment;

import com.example.newgreen.BasketFragments.CardFragment.ModelAdapter.CardModelItem;
import com.example.newgreen.Server.ApiProvider;
import com.example.newgreen.Server.ApiService;

import java.util.List;

import io.reactivex.Single;

public class ApiCardDataSource implements CardDataSource {
    ApiService apiService= ApiProvider.apiProvider();

    @Override
    public String getIde() {
        return null;
    }

    @Override
    public Single<List<CardModelItem>> getCards(String ide) {
        return apiService.getCards(ide);
    }
}
