package com.DiabeticChartServer.DiabeticChartServer.DataModels;

import java.time.LocalDateTime;

public class DiabeticParams {
    private ParameterInterval parameterInterval;
    private LocalDateTime day;
    double insulin;
    double carbs;


    public DiabeticParams(ParameterInterval parameterInterval, LocalDateTime timeStamp){

        this.parameterInterval = parameterInterval;
        this.day =timeStamp;
    }
    public Boolean isWithinInterval(LocalDateTime date){
        return parameterInterval.isWhithinInterval(date);
    }
    public void addInsulin(Double insulin){
        this.insulin += insulin;
    }
    public void addCarbs(Integer carbs){
        this.carbs += carbs;
    }
    public Integer getDay(){
        return day.getDayOfYear();
    }
    /*public Boolean isCorrectDay(LocalDateTime timeStamp
    }*/
    public double getInsulin() {
        return insulin;
    }

    public double getCarbs() {
        return carbs;
    }

    public double getQuota(){
        return carbs/insulin;
    }
}
