package com.example.newgreen.RecipesFragment.VeganFragment;

import com.example.newgreen.RecipesFragment.ModelAdapter.RModel;

import java.util.List;

import io.reactivex.Single;

public class VeganViewModel implements VeganDataSource {
    VeganRepository veganRepository=new VeganRepository();
    @Override
    public Single<List<RModel>> getVeganList() {
        return veganRepository.getVeganList();
    }
}
