package com.example.newgreen.BasketFragments.MoreFragment;

import com.example.newgreen.BasketActivity.BasketItem;
import com.example.newgreen.CartFm.Adapter.CartModel;

import io.reactivex.Single;

public class MoreViewModel implements MoreDataSource {
    MoreRepository moreRepository=new MoreRepository();

    @Override
    public Single<String> AddOrder(BasketItem basketItem) {
        return moreRepository.AddOrder(basketItem);
    }

    @Override
    public Single<CartModel> getList(String id) {
        return moreRepository.getList(id);
    }
}
