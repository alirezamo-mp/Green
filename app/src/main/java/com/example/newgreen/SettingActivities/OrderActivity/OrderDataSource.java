package com.example.newgreen.SettingActivities.OrderActivity;

import com.example.newgreen.SettingActivities.OrderActivity.ModelAdapter.OrderList;

import java.util.List;

import io.reactivex.Single;

public interface OrderDataSource {

    String getIde();

    Single<List<OrderList>> getOrderList(String id);

}
