package com.example.newgreen.BasketActivity;

import com.example.newgreen.Server.ApiProvider;
import com.example.newgreen.Server.ApiService;

public class ApiBasketDataSource implements BasketDataSource {
    ApiService apiService= ApiProvider.apiProvider();

}
