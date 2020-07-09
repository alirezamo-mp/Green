package com.example.newgreen.StoreFm.StoreFragment;

import com.example.newgreen.StoreFm.StoreFragment.ModelAdapter.ProductsStoreModel;

import java.util.List;

import io.reactivex.Single;

public interface StoreDataSource {
    Single<List<ProductsStoreModel>> getProductList();
}
