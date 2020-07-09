package com.example.newgreen.BasketFragments.LocationFragment;

import com.example.newgreen.BasketFragments.LocationFragment.ModelAdapter.CityModel;

import java.util.List;

import io.reactivex.Single;

public interface LocationDataSource {
    Single<List<CityModel>> getCities();
}
