
package com.example.newgreen.SettingActivities.AccountActivity.ModelAdapter;

import com.google.gson.annotations.Expose;

@SuppressWarnings("unused")
public class AccountInModel {

    @Expose
    private String address;
    @Expose
    private String email;
    @Expose
    private String name;
    @Expose
    private String pass;

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
