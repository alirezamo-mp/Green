package com.example.newgreen.RecipesFragment.RecipesDetailFragment;

import com.example.newgreen.RecipesFragment.RecipesDetailFragment.ModelAdapter.AddRecipesStoreModel;
import com.example.newgreen.RecipesFragment.RecipesDetailFragment.ModelAdapter.RDModel;
import com.example.newgreen.RecipesFragment.RecipesDetailFragment.ModelAdapter.RDStoreItem;
import com.example.newgreen.Server.ApiProvider;
import com.example.newgreen.Server.ApiService;

import java.util.List;

import io.reactivex.Single;

public class ApiRDetailDataSource implements RDetailDataSource {
    ApiService apiService= ApiProvider.apiProvider();


    @Override
    public String getIde() {
        return null;
    }

    @Override
    public Single<String> addRecipesStore(AddRecipesStoreModel storeModel) {
        return apiService.addRecipesStore(storeModel);
    }

    @Override
    public Single<RDModel> getVDModel(String id) {
        return apiService.getVDetailList(id);
    }
}
