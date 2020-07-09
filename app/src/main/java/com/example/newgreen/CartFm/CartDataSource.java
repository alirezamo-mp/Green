package com.example.newgreen.CartFm;

import com.example.newgreen.CartFm.Adapter.CartDeleteModel;
import com.example.newgreen.CartFm.Adapter.CartModel;

import io.reactivex.Single;

public interface CartDataSource {

    Single<CartModel> getBasketList(String id);
    Single<CartDeleteModel> DeleteItem(String id,String ide);
    String  getUserIde();

}
