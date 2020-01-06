package com.DiabeticChartServer.DiabeticChartServer.NightScoutApiConsumer.DataModelsDto.OpenAps;

public class IobDto {
    private double iob;
    private double basaliob;
    private double activity;
    private String time;

    public double getIob() {
        return iob;
    }

    public void setIob(double iob) {
        this.iob = iob;
    }

    public double getBasaliob() {
        return basaliob;
    }

    public void setBasaliob(double basaliob) {
        this.basaliob = basaliob;
    }

    public double getActivity() {
        return activity;
    }

    public void setActivity(double activity) {
        this.activity = activity;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }
}
