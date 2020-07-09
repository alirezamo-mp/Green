package com.example.newgreen.Server;

public class ApiProvider {

     static ApiService apiService = null;

    public static ApiService apiProvider() {
        if (apiService == null) {
            apiService = ApiClient.getRetrofit().create(ApiService.class);
        }
        return apiService;
    }

}
