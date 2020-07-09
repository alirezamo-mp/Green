
package com.example.newgreen.LoginFragments.SignIn.AdapterModel;


import com.google.gson.annotations.Expose;

@SuppressWarnings("unused")
public class CheckUserModel {

    @Expose
    private String ide;
    @Expose
    private String message;
    @Expose
    private String status;

    public String getIde() {
        return ide;
    }

    public void setIde(String ide) {
        this.ide = ide;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

}
