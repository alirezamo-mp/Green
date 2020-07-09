package com.example.newgreen.SettingActivities.OrderActivity;

import android.content.Context;

import com.example.newgreen.SettingActivities.OrderActivity.ModelAdapter.OrderList;

import java.util.List;

import io.reactivex.Single;

public class OrderRepository implements OrderDataSource {
    ApiOrderDataSource apiOrderDataSource=new ApiOrderDataSource();
    LocalOrderDataSource localOrderDataSource;
    public OrderRepository (Context context){
        localOrderDataSource=new LocalOrderDataSource(context);
    }

    @Override
    public String getIde() {
        return localOrderDataSource.getIde();
    }

    @Override
    public Single<List<OrderList>> getOrderList(String id) {
        return apiOrderDataSource.getOrderList(id);
    }
}
