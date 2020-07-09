package com.example.newgreen.StoreFm.DetailFragment;

import com.example.newgreen.StoreFm.DetailFragment.ModelAdapter.DetailModel;

import io.reactivex.Single;

public interface DetailDataSource {

    String getUserIde();

    Single<String> addBasket(String userId, String itemId, String ghId);

    Single<DetailModel> getInformationList(String id);
}
