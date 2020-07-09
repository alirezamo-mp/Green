package com.example.newgreen.CartFm;

import com.example.newgreen.CartFm.Adapter.CartDeleteModel;
import com.example.newgreen.CartFm.Adapter.CartModel;
import com.example.newgreen.Server.ApiProvider;
import com.example.newgreen.Server.ApiService;

import io.reactivex.Single;

public class ApiCartDataSource implements CartDataSource {
    ApiService apiService= ApiProvider.apiProvider();
    @Override
    public Single<CartModel> getBasketList(String id) {
        return apiService.getBasketList(id);
    }

    @Override
    public Single<CartDeleteModel> DeleteItem(String id, String ide) {
        return apiService.DeleteItem(id,ide);
    }

    @Override
    public String getUserIde() {
        return null;
    }
}
