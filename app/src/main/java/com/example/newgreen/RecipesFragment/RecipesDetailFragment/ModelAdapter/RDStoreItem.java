
package com.example.newgreen.RecipesFragment.RecipesDetailFragment.ModelAdapter;

import com.google.gson.annotations.Expose;


@SuppressWarnings("unused")
public class RDStoreItem {

    @Expose
    private String checked;
    @Expose
    private String ides;
    @Expose
    private String title;

    public String getChecked() {
        return checked;
    }

    public void setChecked(String checked) {
        this.checked = checked;
    }

    public String getIdes() {
        return ides;
    }

    public void setIdes(String ides) {
        this.ides = ides;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

}
