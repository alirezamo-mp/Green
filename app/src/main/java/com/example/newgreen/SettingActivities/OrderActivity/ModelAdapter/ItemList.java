
package com.example.newgreen.SettingActivities.OrderActivity.ModelAdapter;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ItemList {

    @SerializedName("opp")
    private java.util.List<OrderItem> OrderItem;
    @Expose
    private String pprice;
    @Expose
    private String price;

    public java.util.List<OrderItem> getOrderItem() {
        return OrderItem;
    }

    public void setOrderItem(java.util.List<OrderItem> orderItem) {
        this.OrderItem = orderItem;
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
