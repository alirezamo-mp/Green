package com.example.newgreen.RecipesFragment.VeganFragment;

import com.example.newgreen.RecipesFragment.ModelAdapter.RModel;

import java.util.List;

import io.reactivex.Single;

public interface VeganDataSource {

    Single<List<RModel>> getVeganList();

}
