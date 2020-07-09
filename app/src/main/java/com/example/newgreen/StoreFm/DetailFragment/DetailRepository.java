package com.example.newgreen.StoreFm.DetailFragment;

import android.content.Context;

import com.example.newgreen.StoreFm.DetailFragment.ModelAdapter.DetailModel;

import java.security.PublicKey;

import io.reactivex.Single;

public class DetailRepository implements DetailDataSource {
    ApiDetailDataSource apiDetailDataSource=new ApiDetailDataSource();
    LocalDetailFmDataSource localDetailFmDataSource;
    public DetailRepository (Context context){
        localDetailFmDataSource=new LocalDetailFmDataSource(context);
    }

    @Override
    public String getUserIde() {
        return localDetailFmDataSource.getUserIde();
    }

    @Override
    public Single<String> addBasket(String userId, String itemId, String ghId) {
        return apiDetailDataSource.addBasket(userId, itemId, ghId);
    }

    @Override
    public Single<DetailModel> getInformationList(String id) {
        return apiDetailDataSource.getInformationList(id);
    }
}
