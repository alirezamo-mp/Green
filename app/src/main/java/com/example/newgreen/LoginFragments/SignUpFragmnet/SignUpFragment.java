package com.example.newgreen.LoginFragments.SignUpFragmnet;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.newgreen.LoginFragments.SignIn.AdapterModel.CheckUserModel;
import com.example.newgreen.R;

import io.reactivex.SingleObserver;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class SignUpFragment extends Fragment {
    EditText edtName, edtPass, edtEmail;
    Button btnAdd;
    SignUpViewModel signUpViewModel;
    View view;
    TextView txtChange;
    OnChangeUp onChangeUp;
    CompositeDisposable compositeDisposable;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = LayoutInflater.from(getContext()).inflate(R.layout.signup_fragment, container, false);

        SetUpViews();
        MyOnClick();

        return view;
    }

    private void MyOnClick() {
        txtChange.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onChangeUp.OnClickUp();
            }
        });

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!edtEmail.getText().toString().equals("") &&
                        !edtName.getText().toString().equals("") &&
                        !edtPass.getText().toString().equals("")) {
                    signUpViewModel.addUser(edtEmail.getText().toString(),edtPass.getText().toString(),edtName.getText().toString())
                            .subscribeOn(Schedulers.newThread())
                            .observeOn(AndroidSchedulers.mainThread())
                            .subscribe(new SingleObserver<CheckUserModel>() {
                                @Override
                                public void onSubscribe(Disposable d) {
                                    compositeDisposable.add(d);
                                }

                                @Override
                                public void onSuccess(CheckUserModel checkUserModel) {
                                    if (checkUserModel.getStatus().equals("success")){
                                        signUpViewModel.saveUser(checkUserModel.getMessage(),checkUserModel.getIde());
                                        onChangeUp.OnOkUp();
                                    }else {
                                        Toast.makeText(getContext(), "Please change the email", Toast.LENGTH_SHORT).show();
                                    }
                                }

                                @Override
                                public void onError(Throwable e) {
                                    Log.i("LOG", "onError: "+e);
                                }
                            });



                }else {
                    Toast.makeText(getContext(), "Please fill in all the fields", Toast.LENGTH_SHORT).show();
                }


            }
        });


    }

    private void SetUpViews() {
        btnAdd = view.findViewById(R.id.btn_signUp_add);
        edtPass = view.findViewById(R.id.edt_signUp_pass);
        edtEmail = view.findViewById(R.id.edt_signUp_email);
        edtName = view.findViewById(R.id.edt_singUp_name);
        signUpViewModel = new SignUpViewModel(getContext());
        txtChange = view.findViewById(R.id.txt_signUp_change);
        compositeDisposable=new CompositeDisposable();
    }

    public void setOnChangeUp(OnChangeUp onChangeUp) {
        this.onChangeUp = onChangeUp;
    }

    public interface OnChangeUp {
        void OnClickUp();
        void OnOkUp();
    }


    @Override
    public void onPause() {
        super.onPause();
        compositeDisposable.dispose();
    }
}

