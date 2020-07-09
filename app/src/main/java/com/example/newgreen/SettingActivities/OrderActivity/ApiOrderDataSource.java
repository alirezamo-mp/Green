package com.example.newgreen.SettingActivities.OrderActivity;

import com.example.newgreen.Server.ApiProvider;
import com.example.newgreen.Server.ApiService;
import com.example.newgreen.SettingActivities.OrderActivity.ModelAdapter.OrderList;

import java.util.List;

import io.reactivex.Single;

public class ApiOrderDataSource implements OrderDataSource {
    ApiService apiService= ApiProvider.apiProvider();

    @Override
    public String getIde() {
        return null;
    }

    @Override
    public Single<List<OrderList>> getOrderList(String id) {
    return apiService.getOrderList(id);
    }

}
