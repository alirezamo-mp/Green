package com.example.newgreen.BasketFragments.MoreFragment;

import com.example.newgreen.BasketActivity.BasketItem;
import com.example.newgreen.CartFm.Adapter.CartModel;

import io.reactivex.Single;

public interface MoreDataSource {
    Single<String> AddOrder(BasketItem basketItem);
    Single<CartModel> getList(String id);
}
