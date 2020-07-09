
package com.example.newgreen.RecipesFragment.RecipesDetailFragment.ModelAdapter;

import java.util.List;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;



public class RDModel {

    @Expose
    private String date;
    @Expose
    private String description;
    @Expose
    private String img;
    @SerializedName("recipe_items")
    private List<RDItems> RDItems;
    @SerializedName("recipe_store_items")
    private List<RDStoreItem> RDStoreItems;
    @Expose
    private String time;
    @Expose
    private String type;

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public List<RDItems> getRDItems() {
        return RDItems;
    }

    public void setRDItems(List<RDItems> RDItems) {
        this.RDItems = RDItems;
    }

    public List<RDStoreItem> getRDStoreItems() {
        return RDStoreItems;
    }

    public void setRDStoreItems(List<RDStoreItem> RDStoreItems) {
        this.RDStoreItems = RDStoreItems;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

}
