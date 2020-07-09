package com.example.newgreen.MainActivity;

import android.content.Context;

import com.example.newgreen.StoreFm.DetailFragment.ModelAdapter.DetailModel;
import com.example.newgreen.StoreFm.StoreFragment.ModelAdapter.ProductsStoreModel;

import java.util.List;

import io.reactivex.Single;

public class MainRepository implements MainDataSource {
    ApiMainDataSource apiMainDataSource=new ApiMainDataSource();
    LocalMainDataSource localMainDataSource;
    public  MainRepository (Context context){
        localMainDataSource=new LocalMainDataSource(context);
    }


    @Override
    public String CheckIntro() {
        return localMainDataSource.CheckIntro();
    }
}
