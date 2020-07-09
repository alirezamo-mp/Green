
package com.example.newgreen.CartFm.Adapter;

import com.google.gson.annotations.Expose;

@SuppressWarnings("unused")
public class CartDeleteModel {

    @Expose
    private String pprice;
    @Expose
    private String price;
    @Expose
    private String status;

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

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

}
