
package com.example.newgreen.CartFm.Adapter;

import com.google.gson.annotations.Expose;


@SuppressWarnings("unused")
public class CartItemList {

    @Expose
    private String id;
    @Expose
    private String ide;
    @Expose
    private String img;
    @Expose
    private String name;
    @Expose
    private String pprice;
    @Expose
    private String price;
    @Expose
    private String value;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

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

    public String getIde() {
        return ide;
    }

    public void setIde(String ide) {
        this.ide = ide;
    }
}
