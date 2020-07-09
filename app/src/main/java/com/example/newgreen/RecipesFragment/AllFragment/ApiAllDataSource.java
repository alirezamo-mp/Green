package com.example.newgreen.RecipesFragment.AllFragment;

import com.example.newgreen.RecipesFragment.ModelAdapter.RModel;
import com.example.newgreen.Server.ApiProvider;
import com.example.newgreen.Server.ApiService;

import java.util.List;

import io.reactivex.Single;

public class ApiAllDataSource implements AllDataSource {
    ApiService apiService= ApiProvider.apiProvider();
    @Override
    public Single<List<RModel>> getRecipesList() {
        return apiService.getRecipesList("0");
    }
}
