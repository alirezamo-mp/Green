
package com.example.newgreen.BasketFragments.CardFragment.ModelAdapter;

import com.google.gson.annotations.Expose;


@SuppressWarnings("unused")
public class CardModelItem {

    @Expose
    private String date;
    @Expose
    private String num;
    @Expose
    private String id;
    @Expose
    private String name;
    @Expose
    private String number;

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getNum() {
        return num;
    }

    public void setNum(String num) {
        this.num = num;
    }
}
