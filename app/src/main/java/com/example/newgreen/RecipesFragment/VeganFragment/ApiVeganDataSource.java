package com.example.newgreen.RecipesFragment.VeganFragment;

import com.example.newgreen.RecipesFragment.ModelAdapter.RModel;
import com.example.newgreen.Server.ApiProvider;
import com.example.newgreen.Server.ApiService;

import java.util.List;

import io.reactivex.Single;

public class ApiVeganDataSource implements VeganDataSource {
    ApiService apiService= ApiProvider.apiProvider();


    @Override
    public Single<List<RModel>> getVeganList() {
        return apiService.getRecipesList("1");
    }
}
