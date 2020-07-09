
package com.example.newgreen.SettingActivities.OrderActivity.ModelAdapter;


import com.google.gson.annotations.Expose;


public class OrderItem {

    @Expose
    private String name;
    @Expose
    private String pprice;
    @Expose
    private String price;
    @Expose
    private String value;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

}
