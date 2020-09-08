package com.example.newgreen.AddCardActivity;

import com.example.newgreen.Server.ApiService;

import io.reactivex.Single;

public interface ACardDataSource {

    String getIde();
    Single<String> addCard(String ide,String name,String number,String code,String date);
}
