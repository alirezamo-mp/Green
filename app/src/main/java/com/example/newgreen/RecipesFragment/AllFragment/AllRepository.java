package com.example.newgreen.RecipesFragment.AllFragment;

import com.example.newgreen.RecipesFragment.ModelAdapter.RModel;

import java.util.List;

import io.reactivex.Single;

public class AllRepository implements AllDataSource {
    ApiAllDataSource apiAllDataSource=new ApiAllDataSource();
    @Override
    public Single<List<RModel>> getRecipesList() {
        return apiAllDataSource.getRecipesList();
    }
}
