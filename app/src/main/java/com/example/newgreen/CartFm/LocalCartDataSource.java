package com.example.newgreen.CartFm;

import android.content.Context;
import android.content.SharedPreferences;

import com.example.newgreen.CartFm.Adapter.CartDeleteModel;
import com.example.newgreen.CartFm.Adapter.CartModel;

import io.reactivex.Single;

public class LocalCartDataSource implements CartDataSource{
    SharedPreferences sharedPreferences;
    public LocalCartDataSource(Context context){
        sharedPreferences=context.getSharedPreferences("login",Context.MODE_PRIVATE);
    }


    @Override
    public Single<CartModel> getBasketList(String id) {
        return null;
    }

    @Override
    public Single<CartDeleteModel> DeleteItem(String id, String ide) {
        return null;
    }

    @Override
    public String getUserIde() {
        return sharedPreferences.getString("ide","#404");
    }
}
