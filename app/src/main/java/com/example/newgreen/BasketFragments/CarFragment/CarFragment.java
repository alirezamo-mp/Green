package com.example.newgreen.BasketFragments.CarFragment;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.newgreen.BasketActivity.BasketItem;
import com.example.newgreen.BasketFragments.CarFragment.ModelAdapter.DateAndTimeModel;
import com.example.newgreen.BasketFragments.CarFragment.ModelAdapter.RcvTimeAdapter;
import com.example.newgreen.BasketFragments.CarFragment.ModelAdapter.RcvDateAdapter;
import com.example.newgreen.R;

import io.reactivex.SingleObserver;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class CarFragment extends Fragment {
    RecyclerView rcvTime,rcvDate;
    CarViewModel carViewModel;
    Button btnAdd;
    View view;
    onCarClick onCarClick;
    BasketItem basketItem;
    CompositeDisposable compositeDisposable;
    RcvTimeAdapter rcvTimeAdapter;
    RcvDateAdapter rcvDateAdapter;
    CheckBox chSpeed;
    CheckBox chLow;
    String speed;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view=LayoutInflater.from(getContext()).inflate(R.layout.car_fragment,container,false);
        basketItem=getArguments().getParcelable("item");

        SetUpViews();
        getDateAndTime();
        onCheckBox();

        return view;
    }

    private void onCheckBox() {
        chSpeed.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked){
                    speed="ok";
                    chLow.setChecked(false);
                }else {
                    speed="no";
                    chLow.setChecked(true);
                }
            }
        });

        chLow.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked){
                    speed="no";
                    chSpeed.setChecked(false);
                }else {
                    speed="ok";
                    chSpeed.setChecked(true);
                }
            }
        });
    }

    private void getDateAndTime() {
        carViewModel.getTimeAndDate()
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new SingleObserver<DateAndTimeModel>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                        compositeDisposable.add(d);
                    }

                    @Override
                    public void onSuccess(DateAndTimeModel dateAndTimeModel) {
                        rcvDateAdapter =new RcvDateAdapter(getContext(),dateAndTimeModel.getDateModel());
                        rcvTimeAdapter=new RcvTimeAdapter(getContext(),dateAndTimeModel.getTimeModel());
                        rcvDate.setAdapter(rcvDateAdapter);
                        rcvTime.setAdapter(rcvTimeAdapter);
                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.i("LOG", "onError: "+e);
                    }
                });
    }


    private void SetUpViews() {
        speed="ok";
        chLow=view.findViewById(R.id.ch_carFm_low);
        chSpeed=view.findViewById(R.id.ch_carFm_speed);
        compositeDisposable=new CompositeDisposable();
        btnAdd=view.findViewById(R.id.btn_car_add);
        carViewModel=new CarViewModel();
        rcvDate=view.findViewById(R.id.rcv_carFm_date);
        rcvTime=view.findViewById(R.id.rcv_carFm_time);
        rcvDate.setLayoutManager(new LinearLayoutManager(getContext(),RecyclerView.HORIZONTAL,false));
        rcvTime.setLayoutManager(new LinearLayoutManager(getContext(),RecyclerView.HORIZONTAL,false));

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                basketItem.setTime(rcvTimeAdapter.getTime());
                basketItem.setDate(rcvDateAdapter.getDate());
                basketItem.setSpeed(speed);
                onCarClick.OnClick(basketItem);
            }
        });

    }

    public void setOnCarClick(CarFragment.onCarClick onCarClick) {
        this.onCarClick = onCarClick;
    }

    public interface onCarClick{
        void OnClick(BasketItem basketItem);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        compositeDisposable.dispose();
    }
}
