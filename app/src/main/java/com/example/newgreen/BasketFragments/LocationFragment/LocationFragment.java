package com.example.newgreen.BasketFragments.LocationFragment;

import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.newgreen.BasketActivity.BasketItem;
import com.example.newgreen.BasketFragments.LocationFragment.ModelAdapter.CityModel;
import com.example.newgreen.BasketFragments.LocationFragment.ModelAdapter.RcvCityAdapter;
import com.example.newgreen.R;

import java.util.List;

import io.reactivex.SingleObserver;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class LocationFragment extends Fragment {
    LocationViewModel locationViewModel;
    RecyclerView rcvCity;
    View view;
    Handler handler;
    EditText editCity, editSt;
    Button btnAdd;
    OnBtnClick onBtnClick;
    BasketItem basketItem;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = LayoutInflater.from(getContext()).inflate(R.layout.location_fragment, container, false);
        SetUpViews();
        getcities();
        OnClick();
        return view;
    }

    private void OnClick() {
        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (!editCity.getText().toString().equals("") && !editSt.getText().toString().equals("")) {
                    basketItem.setCity(editCity.getText().toString());
                    basketItem.setAddress(editSt.getText().toString());
                    onBtnClick.OnClick(basketItem);
                } else {
                    Toast.makeText(getContext(), "noooooo", Toast.LENGTH_SHORT).show();
                }

            }
        });
    }

    private void getcities() {
        locationViewModel.getCities().subscribeOn(Schedulers.newThread())
                .observeOn(Schedulers.newThread())
                .subscribe(new SingleObserver<List<CityModel>>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onSuccess(List<CityModel> cityModels) {
                        handler.post(new Runnable() {
                            @Override
                            public void run() {
                                rcvCity.setAdapter(new RcvCityAdapter(getContext(), cityModels, new RcvCityAdapter.onCityClick() {
                                    @Override
                                    public void onClick(String name) {
                                        editCity.setText(name);
                                    }
                                }));
                            }
                        });

                    }

                    @Override
                    public void onError(Throwable e) {

                    }
                });

    }

    private void SetUpViews() {
        basketItem = new BasketItem();
        btnAdd = view.findViewById(R.id.btn_location_add);
        handler = new Handler();
        locationViewModel = new LocationViewModel();
        rcvCity = view.findViewById(R.id.rcv_locationFM_cityList);
        rcvCity.setLayoutManager(new LinearLayoutManager(getContext()));
        editCity = view.findViewById(R.id.edt_locationFM_city);
        editSt = view.findViewById(R.id.edt_locationFM_st);

    }

    public void setOnBtnClick(OnBtnClick onBtnClick) {
        this.onBtnClick = onBtnClick;
    }

    public interface OnBtnClick {
        void OnClick(BasketItem basketItem);

    }
}
