package com.example.newgreen.AddCardActivity;

import android.content.Context;

import io.reactivex.Single;

public class ACardViewModel implements ACardDataSource {
    ACardRepository aCardRepository;

    public ACardViewModel(Context context) {
        aCardRepository = new ACardRepository(context);
    }

    @Override
    public String getIde() {
        return aCardRepository.getIde();
    }

    @Override
    public Single<String> addCard(String ide, String name, String number, String code, String date) {
        return aCardRepository.addCard(ide, name, number, code, date);
    }
}
