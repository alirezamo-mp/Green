package com.example.newgreen.BasketFragments.CarFragment;

import com.example.newgreen.BasketFragments.CarFragment.ModelAdapter.DateAndTimeModel;
import com.example.newgreen.Server.ApiProvider;
import com.example.newgreen.Server.ApiService;

import java.util.List;

import io.reactivex.Single;

public class ApiCarDateSource implements CarDateSource {
    ApiService apiService= ApiProvider.apiProvider();
    @Override
    public Single<DateAndTimeModel> getTimeAndDate() {
        return apiService.getTimeD();
    }


}
