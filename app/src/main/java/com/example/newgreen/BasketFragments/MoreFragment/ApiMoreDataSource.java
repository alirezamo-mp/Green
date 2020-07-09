package com.example.newgreen.BasketFragments.MoreFragment;

import com.example.newgreen.BasketActivity.BasketItem;
import com.example.newgreen.CartFm.Adapter.CartModel;
import com.example.newgreen.Server.ApiProvider;
import com.example.newgreen.Server.ApiService;

import io.reactivex.Single;

public class ApiMoreDataSource implements MoreDataSource{
    ApiService apiService= ApiProvider.apiProvider();

    @Override
    public Single<String> AddOrder(BasketItem basketItem) {
        return apiService.addOrder(basketItem);
    }

    @Override
    public Single<CartModel> getList(String id) {
        return apiService.getBasketList(id);
    }
}
