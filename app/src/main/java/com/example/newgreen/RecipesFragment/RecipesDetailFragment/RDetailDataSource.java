package com.example.newgreen.RecipesFragment.RecipesDetailFragment;

import com.example.newgreen.RecipesFragment.RecipesDetailFragment.ModelAdapter.AddRecipesStoreModel;
import com.example.newgreen.RecipesFragment.RecipesDetailFragment.ModelAdapter.RDModel;
import com.example.newgreen.RecipesFragment.RecipesDetailFragment.ModelAdapter.RDStoreItem;

import java.util.List;

import io.reactivex.Single;

public interface RDetailDataSource {
    String getIde();
    Single<String> addRecipesStore(AddRecipesStoreModel storeModel);
    Single<RDModel> getVDModel(String id);
}
