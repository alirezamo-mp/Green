
package com.example.newgreen.Server;

import com.google.gson.annotations.Expose;


@SuppressWarnings("unused")
public class Message {

    @Expose
    private String message;
    @Expose
    private String status;

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
