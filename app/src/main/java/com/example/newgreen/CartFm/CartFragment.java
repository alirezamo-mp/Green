package com.example.newgreen.CartFm;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.newgreen.BasketActivity.BasketActivity;
import com.example.newgreen.CartFm.Adapter.CartDeleteModel;
import com.example.newgreen.CartFm.Adapter.CartModel;
import com.example.newgreen.CartFm.Adapter.RcvCartListAdapter;
import com.example.newgreen.R;

import io.reactivex.SingleObserver;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class CartFragment extends Fragment {

    View view;
    CardView cardView;
    CartViewModel cartViewModel;
    RecyclerView rcvList;
    CompositeDisposable compositeDisposable;
    TextView txtPrice, txtPprice,txtEmpty;
    Handler handler;
    RcvCartListAdapter adapter;
    Button btnCheck;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = LayoutInflater.from(getContext()).inflate(R.layout.cart_fragment, container, false);

        SetUpViews();
        getList();
        MyOnClick();


        return view;
    }

    private void MyOnClick() {
        btnCheck.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (adapter.getItemCount()==0){
                    Toast.makeText(getContext(), "empty", Toast.LENGTH_SHORT).show();
                }else {
                   startActivity(new Intent(getContext(),BasketActivity.class));

                }

            }
        });
    }

    private void getList() {
        if (cartViewModel.getUserIde().equals("#404")){
            Toast.makeText(getContext(), "#404", Toast.LENGTH_SHORT).show();
        }
        cartViewModel.getBasketList(cartViewModel.getUserIde()).
                subscribeOn(Schedulers.newThread())
                .observeOn(Schedulers.newThread())
                .subscribe(new SingleObserver<CartModel>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                        compositeDisposable.add(d);
                    }

                    @Override
                    public void onSuccess(CartModel cartModel) {
                        handler.post(new Runnable() {
                            @Override
                            public void run() {
                                if (cartModel.getCartItemList().size()==0){
                                    txtEmpty.setVisibility(View.VISIBLE);
                                }else {
                                    txtEmpty.setVisibility(View.GONE);
                                }
                                txtPprice.setText("£" + cartModel.getPprice());
                                txtPrice.setText("£" + cartModel.getPrice());
                                adapter=new RcvCartListAdapter(getContext(), cartModel.getCartItemList(),true);
                                rcvList.setAdapter(adapter);
                                DeleteItem();
                            }
                        });
                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.i("LOG", "onError: " + e);
                    }
                });
    }

    private void DeleteItem() {
        adapter.setOnItemClick(new RcvCartListAdapter.onItemClick() {
            @Override
            public void onDelete(String id, String ide) {
                cartViewModel.DeleteItem(id,ide)
                        .subscribeOn(Schedulers.newThread())
                        .observeOn(Schedulers.newThread())
                        .subscribe(new SingleObserver<CartDeleteModel>() {
                            @Override
                            public void onSubscribe(Disposable d) {
                                compositeDisposable.add(d);
                            }

                            @Override
                            public void onSuccess(CartDeleteModel cartDeleteModel) {
                                handler.post(new Runnable() {
                                    @Override
                                    public void run() {


                                if (cartDeleteModel.getStatus().equals("success")){
                                    txtPprice.setText("£"+cartDeleteModel.getPprice());
                                    txtPrice.setText("£"+cartDeleteModel.getPrice());

                                    if (cartDeleteModel.getPrice().equals("0")){
                                        txtEmpty.setVisibility(View.VISIBLE);
                                    }else {
                                        txtEmpty.setVisibility(View.GONE);
                                    }
                                }else {

                                }
                                    }
                                });
                            }

                            @Override
                            public void onError(Throwable e) {
                                Log.i("LOG", "onError: "+e);
                            }
                        });
            }

            @Override
            public void onEdit() {

            }
        });
    }



    private void SetUpViews() {
        handler = new Handler();
        txtPrice = view.findViewById(R.id.txt_cartFM_price);
        txtPprice = view.findViewById(R.id.txt_cartFM_subGH);
        txtEmpty = view.findViewById(R.id.txt_cartFM_empty);
        compositeDisposable = new CompositeDisposable();
        cardView = view.findViewById(R.id.card_cartFM_title);
        cardView.setBackgroundResource(R.drawable.card_radius_style);
        cartViewModel = new CartViewModel(getContext());
        rcvList = view.findViewById(R.id.rcv_cartFm_list);
        rcvList.setLayoutManager(new LinearLayoutManager(getContext()));
        btnCheck=view.findViewById(R.id.btn_cartFm_add);

    }

    @Override
    public void onResume() {
        super.onResume();
        getList();
    }



    @Override
    public void onDestroy() {
        super.onDestroy();
        compositeDisposable.dispose();
    }


}
