package com.example.newgreen.RecipesFragment.AllFragment;

import com.example.newgreen.RecipesFragment.ModelAdapter.RModel;

import java.util.List;

import io.reactivex.Single;

public interface AllDataSource {
    Single<List<RModel>> getRecipesList();
}
