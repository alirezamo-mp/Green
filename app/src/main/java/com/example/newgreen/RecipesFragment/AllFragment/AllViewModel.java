package com.example.newgreen.RecipesFragment.AllFragment;

import com.example.newgreen.RecipesFragment.ModelAdapter.RModel;

import java.util.List;

import io.reactivex.Single;

public class AllViewModel implements AllDataSource {
    AllRepository allRepository=new AllRepository();
    @Override
    public Single<List<RModel>> getRecipesList() {
        return allRepository.getRecipesList();
    }
}
