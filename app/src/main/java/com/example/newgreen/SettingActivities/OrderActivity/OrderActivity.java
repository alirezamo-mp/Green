package com.example.newgreen.SettingActivities.OrderActivity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

import com.example.newgreen.R;
import com.example.newgreen.SettingActivities.OrderActivity.ModelAdapter.OrderList;
import com.example.newgreen.SettingActivities.OrderActivity.ModelAdapter.RcvOrderAdapter;

import java.util.List;

import io.reactivex.SingleObserver;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class OrderActivity extends AppCompatActivity {
    ImageView imhBack;
    RecyclerView rcvList;
    OrderViewModel orderViewModel;
    CompositeDisposable compositeDisposable;
    CardView cardView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_oreder);


        SetupViews();
        MyOnClick();
        getOrderList();

    }

    private void getOrderList() {
        orderViewModel.getOrderList(orderViewModel.getIde())
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new SingleObserver<List<OrderList>>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                        compositeDisposable.add(d);
                    }

                    @Override
                    public void onSuccess(List<OrderList> orderLists) {
                        rcvList.setAdapter(new RcvOrderAdapter(OrderActivity.this,orderLists));
                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.i("LOG", "onError: "+e);
                    }
                });


    }

    private void MyOnClick() {
        imhBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });
    }

    private void SetupViews() {
        cardView=findViewById(R.id.card_order_title);
        cardView.setBackgroundResource(R.drawable.card_radius_style);
        compositeDisposable=new CompositeDisposable();
        orderViewModel=new OrderViewModel(this);
        imhBack=findViewById(R.id.img_order_imgBack);
        rcvList=findViewById(R.id.rcv_order_list);
        rcvList.setLayoutManager(new LinearLayoutManager(this));
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        compositeDisposable.dispose();
    }
}
