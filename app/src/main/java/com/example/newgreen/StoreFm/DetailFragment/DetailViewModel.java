package com.example.newgreen.StoreFm.DetailFragment;

import android.content.Context;

import com.example.newgreen.StoreFm.DetailFragment.ModelAdapter.DetailModel;

import io.reactivex.Single;

public class DetailViewModel {
    DetailRepository detailRepository ;
    public DetailViewModel(Context context){
        detailRepository=new DetailRepository(context);
    }

    String getUserIde(){
        return detailRepository.getUserIde();
    }

    public Single<DetailModel> getInformationList(String id) {
        return detailRepository.getInformationList(id);
    }
    public Single<String> addBasket (String userId,String itemId,String ghId){
      return   detailRepository.addBasket(userId, itemId, ghId);
    }
}
