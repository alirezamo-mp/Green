package com.example.newgreen.RecipesFragment.RecipesDetailFragment.ModelAdapter;

import java.util.List;

public class AddRecipesStoreModel {

    String size;
    String ide;
    List<RDStoreItem> items;

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getIde() {
        return ide;
    }

    public void setIde(String ide) {
        this.ide = ide;
    }

    public List<RDStoreItem> getItems() {
        return items;
    }

    public void setItems(List<RDStoreItem> items) {
        this.items = items;
    }
}
