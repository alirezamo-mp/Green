package com.example.newgreen.MainActivity;

import android.content.Context;

import com.example.newgreen.StoreFm.DetailFragment.ModelAdapter.DetailModel;
import com.example.newgreen.StoreFm.StoreFragment.ModelAdapter.ProductsStoreModel;

import java.util.List;

import io.reactivex.Single;

public class MainViewModel implements MainDataSource {
    MainRepository mainRepository;
    public MainViewModel(Context context){
        mainRepository=new MainRepository(context);
    }


    @Override
    public String CheckIntro() {
        return mainRepository.CheckIntro();
    }
}
