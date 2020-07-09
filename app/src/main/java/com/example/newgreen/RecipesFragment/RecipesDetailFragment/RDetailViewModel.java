package com.example.newgreen.RecipesFragment.RecipesDetailFragment;

import android.content.Context;

import com.example.newgreen.RecipesFragment.RecipesDetailFragment.ModelAdapter.AddRecipesStoreModel;
import com.example.newgreen.RecipesFragment.RecipesDetailFragment.ModelAdapter.RDModel;
import com.example.newgreen.RecipesFragment.RecipesDetailFragment.ModelAdapter.RDStoreItem;

import java.util.List;

import io.reactivex.Single;

public class RDetailViewModel implements RDetailDataSource {
    RDetailRepository rDetailRepository;

    public RDetailViewModel(Context context) {
        rDetailRepository = new RDetailRepository(context);
    }


    @Override
    public String getIde() {
        return rDetailRepository.getIde();
    }

    @Override
    public Single<String> addRecipesStore(AddRecipesStoreModel storeModel) {
        return rDetailRepository.addRecipesStore(storeModel);
    }

    @Override
    public Single<RDModel> getVDModel(String id) {
        return rDetailRepository.getVDModel(id);
    }
}
