package com.example.newgreen.SplashActivity.IntroLogoFragment;


import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import androidx.fragment.app.Fragment;

import com.example.newgreen.R;
import com.example.newgreen.Receiver.CheckConnectionReceiver;
import com.example.newgreen.SplashActivity.SplashActivity;

import java.util.Timer;
import java.util.TimerTask;


public class IntroLogoFragment extends Fragment {
    View view;
    LogoViewModel logoViewModel;
    CheckConnectionReceiver checkConnectionReceiver;
    OnIntro onIntro;
    Handler handler;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = LayoutInflater.from(getContext()).inflate(R.layout.splash_intro_fragment, container, false);

        SetUpViews();
        CheckConnection();



        return view;
    }



    private void CheckConnection() {
        checkConnectionReceiver.setCheckConnect(new CheckConnectionReceiver.CheckConnect() {
            @Override
            public void on() {
                Timer timer=new Timer();
                timer.schedule(new TimerTask() {
                    @Override
                    public void run() {
                        handler.post(new Runnable() {
                            @Override
                            public void run() {
                                CheckLogin();
                            }
                        });
                        timer.purge();
                        timer.cancel();
                    }

                },3500,1);





            }

            @Override
            public void off() {
                Toast.makeText(getContext(), "No internet connection", Toast.LENGTH_LONG).show();
            }
        });

        getContext().registerReceiver(checkConnectionReceiver, new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE"));
    }

    private void CheckLogin() {
        if (logoViewModel.CheckUserLogin().equals("no")){
            onIntro.onLogin();
        }else {
             onIntro.OnOk();
        }

    }




    private void SetUpViews() {
        handler=new Handler();
        logoViewModel = new LogoViewModel(getContext());
        checkConnectionReceiver = new CheckConnectionReceiver();
    }

    public void setOnIntro(OnIntro onIntro) {
        this.onIntro = onIntro;
    }

    public interface OnIntro{
        void OnOk();
        void onLogin();
    }
}
