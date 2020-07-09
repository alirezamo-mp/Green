package com.example.newgreen.CartFm;

import android.content.Context;

import com.example.newgreen.CartFm.Adapter.CartDeleteModel;
import com.example.newgreen.CartFm.Adapter.CartModel;

import io.reactivex.Single;

public class CartViewModel {
    CartRepository cartRepository ;
    public CartViewModel(Context context){
        cartRepository = new CartRepository(context);
    }

    public Single<CartModel> getBasketList(String id) {
        return cartRepository.getBasketList(id);
    }

    public Single<CartDeleteModel> DeleteItem(String id, String ide) {
        return cartRepository.DeleteItem(id, ide);
    }

    public String getUserIde(){
        return cartRepository.getUserIde();
    }
}
