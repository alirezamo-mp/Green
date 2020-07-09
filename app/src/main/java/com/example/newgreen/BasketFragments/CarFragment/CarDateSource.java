package com.example.newgreen.BasketFragments.CarFragment;

import com.example.newgreen.BasketFragments.CarFragment.ModelAdapter.DateAndTimeModel;

import java.util.List;

import io.reactivex.Single;

public interface CarDateSource {
    Single<DateAndTimeModel> getTimeAndDate();

}
