package com.example.newgreen.Receiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;

public class CheckConnectionReceiver extends BroadcastReceiver {
    CheckConnect checkConnect;

    @Override
    public void onReceive(Context context, Intent intent) {
        ConnectivityManager service= (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        if (service.getActiveNetworkInfo()!=null  && service.getActiveNetworkInfo().isConnected()){
            checkConnect.on();
        }else {
          checkConnect.off();
        }

    }

    public void setCheckConnect(CheckConnect checkConnect) {
        this.checkConnect = checkConnect;
    }

    public interface CheckConnect{
        void on();
        void off();
    }

}
