package com.example.newgreen.RecipesFragment.RecipesDetailFragment;

import android.content.Context;

import com.example.newgreen.RecipesFragment.RecipesDetailFragment.ModelAdapter.AddRecipesStoreModel;
import com.example.newgreen.RecipesFragment.RecipesDetailFragment.ModelAdapter.RDModel;
import com.example.newgreen.RecipesFragment.RecipesDetailFragment.ModelAdapter.RDStoreItem;

import java.util.List;

import io.reactivex.Single;

public class RDetailRepository implements RDetailDataSource {
    ApiRDetailDataSource apiRDetailDataSource = new ApiRDetailDataSource();
    LocalRDetailDataSource localRDetailDataSource;

    public RDetailRepository(Context context) {
        localRDetailDataSource = new LocalRDetailDataSource(context);
    }

    @Override
    public String getIde() {
        return localRDetailDataSource.getIde();
    }

    @Override
    public Single<String> addRecipesStore(AddRecipesStoreModel storeModel) {
        return apiRDetailDataSource.addRecipesStore(storeModel);
    }

    @Override
    public Single<RDModel> getVDModel(String id) {
        return apiRDetailDataSource.getVDModel(id);
    }
}
