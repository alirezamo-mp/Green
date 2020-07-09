
package com.example.newgreen.BasketFragments.CarFragment.ModelAdapter;

import java.util.List;

import com.google.gson.annotations.Expose;


@SuppressWarnings("unused")
public class DateAndTimeModel {

    @Expose
    private List<DateModel> dateModel;
    @Expose
    private List<TimeModel> timeModel;

    public List<DateModel> getDateModel() {
        return dateModel;
    }

    public void setDateModel(List<DateModel> dateModel) {
        this.dateModel = dateModel;
    }

    public List<TimeModel> getTimeModel() {
        return timeModel;
    }

    public void setTimeModel(List<TimeModel> timeModel) {
        this.timeModel = timeModel;
    }

}
