package com.example.newgreen.LoginFragments.SignIn;

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

public class SignInFragment extends Fragment {
    EditText edtEmail, edtPass;
    Button btnAdd;
    SignInViewModel signInViewModel;
    View view;
    TextView txtChange;
    OnChange onChange;
    CompositeDisposable compositeDisposable;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = LayoutInflater.from(getContext()).inflate(R.layout.signin_fragment, container, false);

        SetUpViews();
        MyOnClick();


        return view;
    }

    private void MyOnClick() {

        txtChange.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onChange.OnClick();

            }
        });

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!edtPass.getText().toString().equals("") && !edtEmail.getText().toString().equals("")) {

                    signInViewModel.CheckUser(edtEmail.getText().toString(),edtPass.getText().toString())
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
                                        signInViewModel.SaveUser(checkUserModel.getMessage(),checkUserModel.getIde());
                                        onChange.OnOk();
                                    }else {
                                        Toast.makeText(getContext(), "Username or password is incorrect", Toast.LENGTH_SHORT).show();
                                    }
                                }

                                @Override
                                public void onError(Throwable e) {
                                    Log.i("LOG", "onError: "+e);
                                    Toast.makeText(getContext(), "ERROR", Toast.LENGTH_SHORT).show();
                                }
                            });

                } else {
                    Toast.makeText(getContext(), "Please fill in all the fields", Toast.LENGTH_SHORT).show();
                }
            }
        });


    }

    private void SetUpViews() {
        txtChange = view.findViewById(R.id.txt_signIn_change);
        signInViewModel = new SignInViewModel(getContext());
        btnAdd = view.findViewById(R.id.btn_signIn_add);
        edtEmail = view.findViewById(R.id.edt_singIn_email);
        edtPass = view.findViewById(R.id.edt_signIn_pass);
        compositeDisposable=new CompositeDisposable();
    }



    public void setOnChange(OnChange onChange) {
        this.onChange = onChange;
    }


    public interface OnChange {
        void OnClick();
        void OnOk();
    }

    @Override
    public void onPause() {
        super.onPause();
        compositeDisposable.dispose();
    }
}
