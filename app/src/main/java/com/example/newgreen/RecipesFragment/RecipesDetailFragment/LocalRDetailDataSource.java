package com.example.newgreen.RecipesFragment.RecipesDetailFragment;

import android.content.Context;
import android.content.SharedPreferences;

import com.example.newgreen.RecipesFragment.RecipesDetailFragment.ModelAdapter.AddRecipesStoreModel;
import com.example.newgreen.RecipesFragment.RecipesDetailFragment.ModelAdapter.RDModel;

import io.reactivex.Single;

public class LocalRDetailDataSource implements RDetailDataSource {
    SharedPreferences sharedPreferences;
    public LocalRDetailDataSource (Context context){
        sharedPreferences=context.getSharedPreferences("login",Context.MODE_PRIVATE);
    }
    @Override
    public String getIde() {
        return sharedPreferences.getString("ide","#404");
    }

    @Override
    public Single<String> addRecipesStore(AddRecipesStoreModel storeModel) {
        return null;
    }

    @Override
    public Single<RDModel> getVDModel(String id) {
        return null;
    }
}
