package com.example.newgreen.SettingActivities.OrderActivity;

import android.content.Context;

import com.example.newgreen.SettingActivities.OrderActivity.ModelAdapter.OrderList;

import java.util.List;

import io.reactivex.Single;

public class OrderViewModel implements OrderDataSource {
    OrderRepository orderRepository;
    public OrderViewModel (Context context){
       orderRepository=new OrderRepository(context);
    }

    @Override
    public String getIde() {
        return orderRepository.getIde();
    }

    @Override
    public Single<List<OrderList>> getOrderList(String id) {
        return orderRepository.getOrderList(id);
    }
}
