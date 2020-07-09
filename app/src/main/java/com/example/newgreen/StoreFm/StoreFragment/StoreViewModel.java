package com.example.newgreen.StoreFm.StoreFragment;

import com.example.newgreen.StoreFm.StoreFragment.ModelAdapter.ProductsStoreModel;

import java.util.List;

import io.reactivex.Single;

public class StoreViewModel {
    StoreRepository storeRepository=new StoreRepository();

    public Single<List<ProductsStoreModel>> getProductList(){
        return storeRepository.getProductList();
    }
}
