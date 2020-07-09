package com.example.newgreen.BasketFragments.LocationFragment;

import com.example.newgreen.BasketFragments.LocationFragment.ModelAdapter.CityModel;

import java.util.List;

import io.reactivex.Single;

public class LocationViewModel implements LocationDataSource {
    LocationRepository locationRepository=new LocationRepository();

    @Override
    public Single<List<CityModel>> getCities() {
        return locationRepository.getCities();
    }
}
