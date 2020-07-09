package com.example.newgreen.BasketFragments.CardFragment;

import com.example.newgreen.BasketFragments.CardFragment.ModelAdapter.CardModelItem;

import java.util.List;

import io.reactivex.Single;

public interface CardDataSource {
    String getIde();
    Single<List<CardModelItem>> getCards(String ide);
}
