package com.example.newgreen.StoreFm.StoreFragment;

import com.example.newgreen.Server.ApiProvider;
import com.example.newgreen.Server.ApiService;
import com.example.newgreen.StoreFm.StoreFragment.ModelAdapter.ProductsStoreModel;

import java.util.List;

import io.reactivex.Single;

public class ApiStoreDataSource implements StoreDataSource {
    ApiService apiService= ApiProvider.apiProvider();


    @Override
    public Single<List<ProductsStoreModel>> getProductList() {
        return apiService.getProductList();
    }
}
