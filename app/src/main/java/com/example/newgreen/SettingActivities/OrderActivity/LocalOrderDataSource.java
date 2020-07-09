package com.example.newgreen.SettingActivities.OrderActivity;

import android.content.Context;
import android.content.SharedPreferences;

import com.example.newgreen.SettingActivities.OrderActivity.ModelAdapter.OrderList;

import java.util.List;

import io.reactivex.Single;

public class LocalOrderDataSource implements OrderDataSource{
    SharedPreferences sharedPreferences;
    public LocalOrderDataSource (Context context){
        sharedPreferences=context.getSharedPreferences("login",Context.MODE_PRIVATE);

    }
    @Override
    public String getIde() {
        return sharedPreferences.getString("ide","#404");
    }

    @Override
    public Single<List<OrderList>> getOrderList(String id) {
        return null;
    }
}
