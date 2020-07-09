package com.example.newgreen.Server;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import okhttp3.OkHttpClient;

import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.Headers;

public class ApiClient {
    private static Retrofit retrofit = null;
    private static final String BASE_URL = "https://digimoplus.ir/android/";
  //  private static final String BASE_URL = "http://192.168.1.103/green/";

    public static Retrofit getRetrofit() {


        if (retrofit == null) {
            retrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                    .build();
        }
        return retrofit;
    }


}
