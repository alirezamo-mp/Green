package com.example.newgreen.BasketActivity;

import android.os.Parcel;
import android.os.Parcelable;

public class BasketItem implements Parcelable {

    String date;
    String time;
    String city;
    String address;
    String price;
    String cardId;
    String ide;
    String speed;


    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getCardId() {
        return cardId;
    }

    public void setCardId(String cardId) {
        this.cardId = cardId;
    }

    public String getIde() {
        return ide;
    }

    public void setIde(String ide) {
        this.ide = ide;
    }

    public String getSpeed() {
        return speed;
    }

    public void setSpeed(String speed) {
        this.speed = speed;
    }



    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.date);
        dest.writeString(this.time);
        dest.writeString(this.city);
        dest.writeString(this.address);
        dest.writeString(this.price);
        dest.writeString(this.cardId);
        dest.writeString(this.ide);
        dest.writeString(this.speed);

    }

    public BasketItem() {
    }

    protected BasketItem(Parcel in) {
        this.date = in.readString();
        this.time = in.readString();
        this.city = in.readString();
        this.address = in.readString();
        this.price = in.readString();
        this.cardId = in.readString();
        this.ide = in.readString();
        this.speed = in.readString();

    }

    public static final Parcelable.Creator<BasketItem> CREATOR = new Parcelable.Creator<BasketItem>() {
        @Override
        public BasketItem createFromParcel(Parcel source) {
            return new BasketItem(source);
        }

        @Override
        public BasketItem[] newArray(int size) {
            return new BasketItem[size];
        }
    };
}
