package com.example.newgreen.BasketFragments.CarFragment;

import com.example.newgreen.BasketFragments.CarFragment.ModelAdapter.DateAndTimeModel;

import java.util.List;

import io.reactivex.Single;

public class CarViewModel implements CarDateSource{
    CarRepository carRepository=new CarRepository();


    @Override
    public Single<DateAndTimeModel> getTimeAndDate() {
        return carRepository.getTimeAndDate();
    }
}
