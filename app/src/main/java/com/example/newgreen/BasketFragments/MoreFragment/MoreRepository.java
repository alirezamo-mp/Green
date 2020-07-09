package com.example.newgreen.BasketFragments.MoreFragment;

import com.example.newgreen.BasketActivity.BasketItem;
import com.example.newgreen.CartFm.Adapter.CartModel;

import io.reactivex.Single;

public class MoreRepository implements MoreDataSource {
    ApiMoreDataSource apiMoreDataSource=new ApiMoreDataSource();

    @Override
    public Single<String> AddOrder(BasketItem basketItem) {
        return apiMoreDataSource.AddOrder(basketItem);
    }

    @Override
    public Single<CartModel> getList(String id) {
        return apiMoreDataSource.getList(id);
    }
}
