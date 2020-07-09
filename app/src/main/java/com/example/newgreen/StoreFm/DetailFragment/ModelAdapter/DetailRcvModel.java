
package com.example.newgreen.StoreFm.DetailFragment.ModelAdapter;


import com.google.gson.annotations.Expose;


public class DetailRcvModel {

    @Expose
    private String title;
    @Expose
    private String value;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

}
