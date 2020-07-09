package com.example.newgreen.Server;

import com.example.newgreen.BasketActivity.BasketItem;
import com.example.newgreen.BasketFragments.CarFragment.ModelAdapter.DateAndTimeModel;
import com.example.newgreen.BasketFragments.CardFragment.ModelAdapter.CardModelItem;
import com.example.newgreen.BasketFragments.LocationFragment.ModelAdapter.CityModel;
import com.example.newgreen.CartFm.Adapter.CartDeleteModel;
import com.example.newgreen.CartFm.Adapter.CartModel;
import com.example.newgreen.LoginFragments.SignIn.AdapterModel.CheckUserModel;
import com.example.newgreen.RecipesFragment.ModelAdapter.RModel;
import com.example.newgreen.RecipesFragment.RecipesDetailFragment.ModelAdapter.AddRecipesStoreModel;
import com.example.newgreen.RecipesFragment.RecipesDetailFragment.ModelAdapter.RDModel;
import com.example.newgreen.SettingActivities.AccountActivity.ModelAdapter.AccountInModel;
import com.example.newgreen.SettingActivities.OrderActivity.ModelAdapter.OrderList;
import com.example.newgreen.StoreFm.StoreFragment.ModelAdapter.ProductsStoreModel;
import com.example.newgreen.StoreFm.DetailFragment.ModelAdapter.DetailModel;

import java.util.List;

import io.reactivex.Single;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface ApiService {
    @GET("read_products.php")
    Single<List<ProductsStoreModel>> getProductList();

    @GET("get_detail.php")
    Single<DetailModel> getProductIn(@Query("id") String id);

    @FormUrlEncoded
    @POST("read_basket.php")
    Single<CartModel> getBasketList(@Field("id") String id);

    @FormUrlEncoded
    @POST("delete_item_basket.php")
    Single<CartDeleteModel> DeleteItem(@Field("id") String id, @Field("ide") String ide);

    @GET("get_city.php")
    Single<List<CityModel>> getCities();

    @GET("get_time.php")
    Single<DateAndTimeModel> getTimeD();

    @FormUrlEncoded
    @POST("read_card.php")
    Single<List<CardModelItem>> getCards(@Field("ide") String ide);

    @FormUrlEncoded
    @POST("get_order.php")
    Single<List<OrderList>> getOrderList(@Field("ide") String ide);

    @GET("get_recipes.php")
    Single<List<RModel>> getRecipesList(@Query("type") String type);

    @GET("get_recipes_detail.php")
    Single<RDModel> getVDetailList(@Query("id") String id);

    @FormUrlEncoded
    @POST("check_user.php")
    Single<CheckUserModel> checkUser(@Field("email") String email, @Field("pass") String pass);

    @FormUrlEncoded
    @POST("add_user.php")
    Single<CheckUserModel> addUser(@Field("email") String email, @Field("pass") String pass, @Field("name") String name);

    @FormUrlEncoded
    @POST("add_basket.php")
    Single<String> addBasket(@Field("user_id") String userId, @Field("item_id") String itemId, @Field("gh_id") String ghId);

    @FormUrlEncoded
    @POST("add_card.php")
    Single<String> addCard(@Field("ide") String ide, @Field("name") String name, @Field("number") String number, @Field("code") String code, @Field("date") String date);

    @FormUrlEncoded
    @POST("read_user.php")
    Single<AccountInModel> getUser(@Field("ide") String ide);

    @FormUrlEncoded
    @POST("update_user.php")
    Single<String> updateUser(@Field("ide") String ide, @Field("name") String name, @Field("email") String email, @Field("pass") String pass, @Field("address") String address);

    @POST("add_recipes_store.php")
    Single<String> addRecipesStore(@Body AddRecipesStoreModel storeModel);


    @POST("add_order.php")
    Single<String> addOrder(@Body BasketItem basketItem);

}
