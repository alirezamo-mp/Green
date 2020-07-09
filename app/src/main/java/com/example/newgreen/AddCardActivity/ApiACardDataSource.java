package com.example.newgreen.AddCardActivity;

import com.example.newgreen.Server.ApiProvider;
import com.example.newgreen.Server.ApiService;

import io.reactivex.Single;

public class ApiACardDataSource implements ACardDataSource {
    ApiService apiService= ApiProvider.apiProvider();

    @Override
    public String getIde() {
        return null;
    }

    @Override
    public Single<String> addCard(String ide, String name, String number, String code, String date) {
        return apiService.addCard(ide, name, number, code, date);
    }
}
