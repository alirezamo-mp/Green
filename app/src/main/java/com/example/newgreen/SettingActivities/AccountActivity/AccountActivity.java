package com.example.newgreen.SettingActivities.AccountActivity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.newgreen.AddCardActivity.AddCardActivity;
import com.example.newgreen.BasketFragments.CardFragment.CardViewModel;
import com.example.newgreen.BasketFragments.CardFragment.ModelAdapter.CardModelItem;
import com.example.newgreen.BasketFragments.CardFragment.ModelAdapter.rcvCardAdapter;
import com.example.newgreen.MainActivity.MainActivity;
import com.example.newgreen.R;
import com.example.newgreen.SettingActivities.AccountActivity.ModelAdapter.AccountInModel;

import java.util.List;

import io.reactivex.SingleObserver;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class AccountActivity extends AppCompatActivity {
    CardView cardView;
    AccountViewModel accountViewModel;
    RecyclerView rcvCards;
    CompositeDisposable compositeDisposable;
    ImageView imgBack, imgName, imgPass, imgAddress, imgEmail,imgOk;
    EditText edtName, edtPass, edtEmail, edtAddress;
    boolean reset = false;
    String ppp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_account);

        SetUpViews();
        getUser();
        getCards();
        MyOnClick();
    }

    private void getUser() {
        accountViewModel.getUser(accountViewModel.getIde())
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new SingleObserver<AccountInModel>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                        compositeDisposable.add(d);
                    }

                    @Override
                    public void onSuccess(AccountInModel accountInModel) {
                        edtName.setHint(accountInModel.getName());
                        edtAddress.setHint(accountInModel.getAddress());
                        edtEmail.setHint(accountInModel.getEmail());
                        edtPass.setHint("********");
                        ppp=accountInModel.getPass();
                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.i("LOG", "onError: " + e);
                    }
                });
    }

    private void MyOnClick() {
        imgBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });

        imgName.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                edtName.setEnabled(true);
                edtName.requestFocus();
                reset = true;
            }
        });

        imgEmail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                edtEmail.setEnabled(true);
                edtEmail.requestFocus();
                reset = true;
            }
        });

        imgAddress.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                edtAddress.setEnabled(true);
                edtAddress.requestFocus();
                reset = true;
            }
        });

        imgPass.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                edtPass.setEnabled(true);
                edtPass.requestFocus();
                reset = true;
            }
        });

        imgOk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (reset) {
                    UpdateUser();
                    reset=false;
                    edtAddress.setEnabled(false);
                    edtEmail.setEnabled(false);
                    edtName.setEnabled(false);
                    edtPass.setEnabled(false);
                    getUser();
                    Toast.makeText(AccountActivity.this, "changed", Toast.LENGTH_SHORT).show();
                }else {
                    Toast.makeText(AccountActivity.this, "noooooo", Toast.LENGTH_SHORT).show();
                }

            }
        });

    }

    private void getCards() {
        accountViewModel.getCards(accountViewModel.getIde())
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new SingleObserver<List<CardModelItem>>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                        compositeDisposable.add(d);
                    }

                    @Override
                    public void onSuccess(List<CardModelItem> cardModelItems) {
                        rcvCards.setAdapter(new rcvCardAdapter(AccountActivity.this, cardModelItems, new rcvCardAdapter.onNewClick() {
                            @Override
                            public void OnClick() {
                                startActivity(new Intent(AccountActivity.this, AddCardActivity.class));
                            }

                            @Override
                            public void OnOk(String id) {

                            }
                        }));
                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.i("LOG", "onError: " + e);
                    }
                });
    }

    private void SetUpViews() {
        imgOk=findViewById(R.id.img_account_select);
        imgPass = findViewById(R.id.img_E4);
        imgAddress = findViewById(R.id.img_E2);
        imgEmail = findViewById(R.id.img_E3);
        imgName = findViewById(R.id.img_E1);

        edtName = findViewById(R.id.edt_account_name);
        edtPass = findViewById(R.id.edt_account_pass);
        edtAddress = findViewById(R.id.edt_account_address);
        edtEmail = findViewById(R.id.edt_account_email);

        imgBack = findViewById(R.id.img_account_imgBack);
        compositeDisposable = new CompositeDisposable();
        rcvCards = findViewById(R.id.rcv_account_cards);
        rcvCards.setLayoutManager(new LinearLayoutManager(this, RecyclerView.HORIZONTAL, false));
        cardView = findViewById(R.id.card_account_title);
        cardView.setBackgroundResource(R.drawable.card_radius_style);
        accountViewModel = new AccountViewModel(this);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        compositeDisposable.dispose();
    }


    @Override
    protected void onResume() {
        super.onResume();
        getCards();
    }

    @Override
    protected void onPause() {
        super.onPause();
        if (reset) {
            Toast.makeText(this, "ok", Toast.LENGTH_SHORT).show();
        }

    }

    private void UpdateUser() {
        String name;
        String pass;
        String email;
        String address;
        if (!edtName.getText().toString().equals("")) {
            name = edtName.getText().toString();
        } else {
            name = edtName.getHint().toString();
        }

        if (!edtPass.getText().toString().equals("")) {
            pass = edtPass.getText().toString();
        } else {
            pass = ppp;
        }

        if (!edtEmail.getText().toString().equals("")) {
            email = edtEmail.getText().toString();
        } else {
            email = edtEmail.getHint().toString();
        }

        if (!edtAddress.getText().toString().equals("")) {
            address = edtAddress.getText().toString();
        } else {
            address = edtAddress.getHint().toString();
        }

        accountViewModel.updateUser(accountViewModel.getIde(), name, email, pass, address)
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
                        Log.i("LOG", "onError: " + e);
                    }
                });
    }
}
