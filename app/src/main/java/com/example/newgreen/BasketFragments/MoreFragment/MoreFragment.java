package com.example.newgreen.BasketFragments.MoreFragment;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.newgreen.BasketActivity.BasketItem;
import com.example.newgreen.CartFm.Adapter.CartModel;
import com.example.newgreen.CartFm.Adapter.RcvCartListAdapter;
import com.example.newgreen.R;

import io.reactivex.SingleObserver;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class MoreFragment extends Fragment {
    MoreViewModel moreViewModel;
    RecyclerView rcvList;
    TextView txtPrice, txtPriceS, txtD;
    View view;
    BasketItem basketItem;
    Button btnAdd;
    onBtnClick onBtnClick;
    CompositeDisposable compositeDisposable;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = LayoutInflater.from(getContext()).inflate(R.layout.more_fragment, container, false);
        basketItem = getArguments().getParcelable("item");
        SetUpViews();
        getList();
        AddList();
        return view;
    }

    private void AddList() {
        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                moreViewModel.AddOrder(basketItem).subscribeOn(Schedulers.newThread())
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribe(new SingleObserver<String>() {
                            @Override
                            public void onSubscribe(Disposable d) {
                                compositeDisposable.add(d);
                            }

                            @Override
                            public void onSuccess(String s) {
                                onBtnClick.click();
                            }

                            @Override
                            public void onError(Throwable e) {
                                Log.i("LOG", "onError: "+e);
                                onBtnClick.click();
                            }
                        });


            }
        });
    }

    private void getList() {
        moreViewModel.getList(basketItem.getIde())
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new SingleObserver<CartModel>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                        compositeDisposable.add(d);
                    }

                    @Override
                    public void onSuccess(CartModel cartModel) {
                        float price = Float.parseFloat(cartModel.getPrice());
                        if (!basketItem.getSpeed().equals("no")) {
                            txtD.setText("£" + "4.99");
                            price = price + 4.99f;
                        } else {
                            txtD.setText("(free)");
                        }
                        txtPriceS.setText("£" + cartModel.getPrice());
                        basketItem.setPrice(price + "");
                        txtPrice.setText("£"+price);
                        rcvList.setAdapter(new RcvCartListAdapter(getContext(), cartModel.getCartItemList(),false));
                    }

                    @Override
                    public void onError(Throwable e) {

                    }
                });
    }

    private void SetUpViews() {
        compositeDisposable=new CompositeDisposable();
        btnAdd=view.findViewById(R.id.btn_more_add);
        moreViewModel = new MoreViewModel();
        txtD = view.findViewById(R.id.txt_more_deliveryGH);
        txtPriceS = view.findViewById(R.id.txt_more_subGH);
        txtPrice = view.findViewById(R.id.txt_more_price);
        rcvList = view.findViewById(R.id.rcv_more_list);
        rcvList.setLayoutManager(new LinearLayoutManager(getContext()));
    }

    public void setOnBtnClick(MoreFragment.onBtnClick onBtnClick) {
        this.onBtnClick = onBtnClick;
    }

    public interface onBtnClick{
        void  click();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        compositeDisposable.dispose();
    }
}
