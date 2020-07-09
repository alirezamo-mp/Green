package com.example.newgreen.StoreFm.StoreFragment;


import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;

import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.newgreen.StoreFm.DetailFragment.DetailFragment;
import com.example.newgreen.R;
import com.example.newgreen.StoreFm.StoreFragment.ModelAdapter.ProductsStoreModel;
import com.example.newgreen.StoreFm.StoreFragment.ModelAdapter.RcvStoreAdapter;

import java.util.List;

import io.reactivex.SingleObserver;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class StoreFragment extends Fragment {
    CompositeDisposable compositeDisposable;
    FrameLayout fmProgress;
    StoreViewModel storeViewModel;
    CardView card;
    FrameLayout fm;
    RecyclerView rcv;
    View view;
    RcvStoreAdapter rcvStoreAdapter;
    FragmentManager fragmentManager;
    Handler handler;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view=LayoutInflater.from(getContext()).inflate(R.layout.store_fragment,container,false);

        SetUpViews();
        getProductList();



        MyOnClick();
        return view;
    }

    private void getProductList() {

        storeViewModel.getProductList().subscribeOn(Schedulers.newThread())
                .observeOn(Schedulers.newThread())
                .subscribe(new SingleObserver<List<ProductsStoreModel>>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                        compositeDisposable.add(d);
                    }

                    @Override
                    public void onSuccess(List<ProductsStoreModel> productsStoreModels) {
                        handler.post(new Runnable() {
                            @Override
                            public void run() {
                                rcvStoreAdapter =new RcvStoreAdapter(getContext(), productsStoreModels, new RcvStoreAdapter.OnClickItem() {
                                    @Override
                                    public void OnClick(String name,String id,String img) {

                                        DetailFragment detailFragment=new DetailFragment();
                                        detailFragment.setId(id,name,img);
                                        fm.setVisibility(View.VISIBLE);
                                        fragmentManager.beginTransaction().add(R.id.fm_storeFragment,detailFragment).commit();

                                        detailFragment.setOnBackClick(new DetailFragment.OnBackClick() {
                                            @Override
                                            public void OnClick() {
                                                fm.setVisibility(View.GONE);
                                                fragmentManager.beginTransaction().remove(detailFragment).commit();
                                                rcv.setVisibility(View.VISIBLE);
                                                fmProgress.setVisibility(View.GONE);
                                                rcv.setAdapter(rcvStoreAdapter);
                                            }
                                        });

                                    }
                                });
                                rcv.setAdapter(rcvStoreAdapter);
                                rcv.setVisibility(View.VISIBLE);
                                fmProgress.setVisibility(View.GONE);
                            }
                        });


                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.i("LOG", "onError: "+e);
                    }
                });

    }

    private void MyOnClick() {

    }


    private void SetUpViews() {
        handler=new Handler();
        compositeDisposable=new CompositeDisposable();
        storeViewModel=new StoreViewModel();
        fmProgress=view.findViewById(R.id.fm_storeFm_progress);
        fm=view.findViewById(R.id.fm_storeFragment);
        fragmentManager=getActivity().getSupportFragmentManager();
        card=view.findViewById(R.id.card_store_fragment);
        card.setBackgroundResource(R.drawable.card_radius_style);
        rcv=view.findViewById(R.id.rcv_store_list);
        rcv.setLayoutManager(new LinearLayoutManager(getContext(),RecyclerView.HORIZONTAL,false));

    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        compositeDisposable.dispose();
    }
}
