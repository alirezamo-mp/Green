package com.example.newgreen.StoreFm.DetailFragment;

import com.example.newgreen.Server.ApiProvider;
import com.example.newgreen.Server.ApiService;
import com.example.newgreen.StoreFm.DetailFragment.ModelAdapter.DetailModel;

import io.reactivex.Single;

public class ApiDetailDataSource implements DetailDataSource {
    ApiService apiService= ApiProvider.apiProvider();

    @Override
    public String getUserIde() {
        return null;
    }

    @Override
    public Single<String> addBasket(String userId, String itemId, String ghId) {
       return apiService.addBasket(userId,itemId,ghId);
    }

    @Override
    public Single<DetailModel> getInformationList(String id) {
        return apiService.getProductIn(id);
    }
}
