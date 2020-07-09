package com.example.newgreen.RecipesFragment.VeganFragment;

import com.example.newgreen.RecipesFragment.ModelAdapter.RModel;

import java.util.List;

import io.reactivex.Single;

public class VeganRepository implements VeganDataSource {
    ApiVeganDataSource apiVeganDataSource=new ApiVeganDataSource();
    @Override
    public Single<List<RModel>> getVeganList() {
        return apiVeganDataSource.getVeganList();
    }
}
