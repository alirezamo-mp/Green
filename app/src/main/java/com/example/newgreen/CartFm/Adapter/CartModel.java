
package com.example.newgreen.CartFm.Adapter;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;


@SuppressWarnings("unused")
public class CartModel {

    @SerializedName("list")
    private java.util.List<CartItemList> cartItemList;
    @Expose
    private String pprice;
    @Expose
    private String price;

    public java.util.List<CartItemList> getCartItemList() {
        return cartItemList;
    }

    public void setCartItemList(java.util.List<CartItemList> cartItemList) {
        this.cartItemList = cartItemList;
    }

    public String getPprice() {
        return pprice;
    }

    public void setPprice(String pprice) {
        this.pprice = pprice;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

}
