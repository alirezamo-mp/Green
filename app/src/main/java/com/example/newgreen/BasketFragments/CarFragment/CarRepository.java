package com.example.newgreen.BasketFragments.CarFragment;

import com.example.newgreen.BasketFragments.CarFragment.ModelAdapter.DateAndTimeModel;

import java.util.List;

import io.reactivex.Single;

public class CarRepository implements CarDateSource {
    ApiCarDateSource apiCarDateSource=new ApiCarDateSource();

    @Override
    public Single<DateAndTimeModel> getTimeAndDate() {
        return apiCarDateSource.getTimeAndDate();
    }




}
