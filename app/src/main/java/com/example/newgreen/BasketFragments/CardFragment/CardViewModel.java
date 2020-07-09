package com.example.newgreen.BasketFragments.CardFragment;

import android.content.Context;

import com.example.newgreen.BasketFragments.CardFragment.ModelAdapter.CardModelItem;

import java.util.List;

import io.reactivex.Single;

public class CardViewModel implements CardDataSource{
    CardRepository cardRepository;
    public CardViewModel(Context context){
        cardRepository=new CardRepository(context);
    }

    @Override
    public String getIde() {
        return cardRepository.getIde();
    }

    @Override
    public Single<List<CardModelItem>> getCards(String ide) {
        return cardRepository.getCards(ide);
    }
}
