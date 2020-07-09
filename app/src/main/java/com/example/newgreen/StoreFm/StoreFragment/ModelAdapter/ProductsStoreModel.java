
package com.example.newgreen.StoreFm.StoreFragment.ModelAdapter;

import com.google.gson.annotations.Expose;


@SuppressWarnings("unused")
public class ProductsStoreModel {

    @Expose
    private String color;
    @Expose
    private String id;
    @Expose
    private String img;
    @Expose
    private String title;

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

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

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

}
