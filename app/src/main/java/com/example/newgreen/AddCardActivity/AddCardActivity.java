package com.example.newgreen.AddCardActivity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.newgreen.MainActivity.MainActivity;
import com.example.newgreen.R;
import com.example.newgreen.SettingActivities.AccountActivity.AccountActivity;

import io.reactivex.SingleObserver;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class AddCardActivity extends AppCompatActivity {
    ImageView imgBack;
    Button btnAdd;
    ACardViewModel aCardViewModel;
    EditText edtName, edtCode, edtDate, edtNumber;
    CompositeDisposable compositeDisposable;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_card);
        SetUpViews();
        MyOnClick();
    }

    private void MyOnClick() {
        imgBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });
        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!edtName.getText().toString().equals("") && !edtCode.getText().toString().equals("") &&
                        !edtDate.getText().toString().equals("") && !edtNumber.getText().toString().equals("")) {

                    if (!aCardViewModel.getIde().equals("#404")) {


                        addCard(aCardViewModel.getIde(),
                                edtCode.getText().toString(), edtName.getText().toString(),
                                edtDate.getText().toString(), edtNumber.getText().toString());
                    }
                } else {
                    Toast.makeText(AddCardActivity.this, "por alll", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }

    private void addCard(String ide, String code, String name, String date, String number) {
        aCardViewModel.addCard(ide,name,number,code,date)
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new SingleObserver<String>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                        compositeDisposable.add(d);
                    }

                    @Override
                    public void onSuccess(String s) {

                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.i("LOG", "onError: "+e);
                    }
                });


        Toast.makeText(AddCardActivity.this, "ok", Toast.LENGTH_SHORT).show();
        onBackPressed();

    }

    private void SetUpViews() {
        compositeDisposable=new CompositeDisposable();
        edtNumber = findViewById(R.id.edt_AddCard_number);
        edtName = findViewById(R.id.edt_AddCard_name);
        edtDate = findViewById(R.id.edt_AddCard_date);
        edtCode = findViewById(R.id.edt_AddCard_code);
        btnAdd = findViewById(R.id.btn_AddCard_add);
        imgBack = findViewById(R.id.img_AddCard_close);
        aCardViewModel = new ACardViewModel(this);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        compositeDisposable.dispose();
    }

}
