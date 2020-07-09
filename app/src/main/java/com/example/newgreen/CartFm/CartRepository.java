package com.example.newgreen.CartFm;

import android.content.Context;

import com.example.newgreen.CartFm.Adapter.CartDeleteModel;
import com.example.newgreen.CartFm.Adapter.CartModel;

import io.reactivex.Single;

public class CartRepository implements CartDataSource  {
    LocalCartDataSource localCartDataSource;
    ApiCartDataSource apiCartDataSource=new ApiCartDataSource();
    public CartRepository (Context context){
        localCartDataSource=new LocalCartDataSource(context);
    }
    @Override
    public Single<CartModel> getBasketList(String id) {
        return apiCartDataSource.apiService.getBasketList(id);
    }

    @Override
    public Single<CartDeleteModel> DeleteItem(String id, String ide) {
        return apiCartDataSource.DeleteItem(id,ide);
    }

    @Override
    public String getUserIde() {
        return localCartDataSource.getUserIde();
    }
}
