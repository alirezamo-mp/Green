package com.example.newgreen.BasketFragments.LocationFragment;

import com.example.newgreen.BasketFragments.LocationFragment.ModelAdapter.CityModel;
import com.example.newgreen.Server.ApiProvider;
import com.example.newgreen.Server.ApiService;

import java.util.List;

import io.reactivex.Single;

public class ApiLocationDataSource implements LocationDataSource {
    ApiService apiService= ApiProvider.apiProvider();


    @Override
    public Single<List<CityModel>> getCities() {
        return apiService.getCities();
    }
}
