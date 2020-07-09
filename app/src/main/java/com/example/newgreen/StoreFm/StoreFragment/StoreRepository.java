package com.example.newgreen.StoreFm.StoreFragment;

import com.example.newgreen.StoreFm.StoreFragment.ModelAdapter.ProductsStoreModel;

import java.util.List;

import io.reactivex.Single;

public class StoreRepository implements StoreDataSource {
    ApiStoreDataSource apiStoreDataSource=new ApiStoreDataSource();
    @Override
    public Single<List<ProductsStoreModel>> getProductList() {
        return apiStoreDataSource.getProductList();
    }
}
