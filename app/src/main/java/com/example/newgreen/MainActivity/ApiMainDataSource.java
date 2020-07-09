package com.example.newgreen.MainActivity;

import com.example.newgreen.StoreFm.DetailFragment.ModelAdapter.DetailModel;
import com.example.newgreen.Server.ApiProvider;
import com.example.newgreen.Server.ApiService;
import com.example.newgreen.StoreFm.StoreFragment.ModelAdapter.ProductsStoreModel;

import java.util.List;

import io.reactivex.Single;

public class ApiMainDataSource implements MainDataSource {
    ApiService apiService= ApiProvider.apiProvider();

    @Override
    public String CheckIntro() {
        return null;
    }
}
