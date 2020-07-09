package com.example.newgreen.StoreFm.DetailFragment;

import android.content.Context;
import android.content.SharedPreferences;

import com.example.newgreen.StoreFm.DetailFragment.ModelAdapter.DetailModel;

import io.reactivex.Single;

public class LocalDetailFmDataSource implements DetailDataSource {
    SharedPreferences sharedPreferences;

    public LocalDetailFmDataSource(Context context) {
        sharedPreferences = context.getSharedPreferences("login", Context.MODE_PRIVATE);
    }

    @Override
    public String getUserIde() {
        return sharedPreferences.getString("ide", "#404");
    }

    @Override
    public Single<String> addBasket(String userId, String itemId, String ghId) {
        return null;
    }

    @Override
    public Single<DetailModel> getInformationList(String id) {
        return null;
    }
}
