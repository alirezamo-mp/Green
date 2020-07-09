
package com.example.newgreen.StoreFm.DetailFragment.ModelAdapter;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

@SuppressWarnings("unused")
public class DetailModel {

    @Expose
    private String desc;
    @SerializedName("list")
    private List<DetailRcvModel> detailRcvModel;
    @SerializedName("ghi")
    private List<String> detailGhiList;
    @Expose
    private String origin;
    @Expose
    private String pre;
    @Expose
    private String storage;

    public List<String> getDetailGhiList() {
        return detailGhiList;
    }

    public void setDetailGhiList(List<String> detailGhiList) {
        this.detailGhiList = detailGhiList;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public java.util.List<DetailRcvModel> getDetailRcvModel() {
        return detailRcvModel;
    }

    public void setDetailRcvModel(java.util.List<DetailRcvModel> detailRcvModel) {
        this.detailRcvModel = detailRcvModel;
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public String getPre() {
        return pre;
    }

    public void setPre(String pre) {
        this.pre = pre;
    }

    public String getStorage() {
        return storage;
    }

    public void setStorage(String storage) {
        this.storage = storage;
    }

}
