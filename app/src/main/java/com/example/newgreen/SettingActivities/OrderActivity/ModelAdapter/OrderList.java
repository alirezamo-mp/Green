
package com.example.newgreen.SettingActivities.OrderActivity.ModelAdapter;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;


@SuppressWarnings("unused")
public class OrderList {

    @SerializedName("list")
    private ItemList itemList;
    @Expose
    private String id;

    public ItemList getItemList() {
        return itemList;
    }

    public void setItemList(ItemList itemList) {
        this.itemList = itemList;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
