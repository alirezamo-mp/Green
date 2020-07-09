package com.example.newgreen.BasketFragments.LocationFragment;

import com.example.newgreen.BasketFragments.LocationFragment.ModelAdapter.CityModel;

import java.util.List;

import io.reactivex.Single;

public class LocationRepository implements LocationDataSource {
    ApiLocationDataSource apiLocationDataSource=new ApiLocationDataSource();
    @Override
    public Single<List<CityModel>> getCities() {
        return apiLocationDataSource.getCities();
    }
}
