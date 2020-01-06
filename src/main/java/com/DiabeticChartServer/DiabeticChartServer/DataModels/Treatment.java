package com.DiabeticChartServer.DiabeticChartServer.DataModels;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class Treatment {
    private String eventType;
    private Integer duration;
    private Integer percent;
    private Double rate;
    private String created_at;
    private String enteredBy;
    private Long pumpId;
    private Double insulin;
    private boolean isSMB;
    private LocalDateTime timeStamp;
    private Integer carbs;
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss'Z'");
    //private SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'");

    public void setTimeStamp(LocalDateTime timeStamp) {
        this.timeStamp = timeStamp;
    }

    public void Init(){

        this.timeStamp = LocalDateTime.parse(created_at, formatter);
    }

    public Integer getCarbs() {
        return carbs;
    }

    public void setCarbs(Integer carbs) {
        this.carbs = carbs;
    }

    public String getEventType() {
        return eventType;
    }

    public void setEventType(String eventType) {
        this.eventType = eventType;
    }

    public Integer getDuration() {
        return duration;
    }

    public void setDuration(Integer duration) {
        this.duration = duration;
    }

   // public Integer getPercent() {
   //     return percent;
  //  }

    public void setPercent(Integer percent) {
        this.percent = percent;
    }

    public Double getRate() {
        return rate;
    }

    public void setRate(Double rate) {
        this.rate = rate;
    }

    public String getCreated_at() {
        return created_at;
    }

    public void setCreated_at(String created_at) {

        this.created_at = created_at;
        Init();
    }

    public LocalDateTime getTimeStamp() {
        return timeStamp;
    }

    public String getEnteredBy() {
        return enteredBy;
    }

    public void setEnteredBy(String enteredBy) {
        this.enteredBy = enteredBy;
    }

    public Long getPumpId() {
        return pumpId;
    }

    public void setPumpId(Long pumpId) {
        this.pumpId = pumpId;
    }

    public Double getInsulin() {
        return insulin;
    }

    public void setInsulin(Double insulin) {
        this.insulin = insulin;
    }

    public boolean isSMB() {
        return isSMB;
    }

    public void setSMB(boolean SMB) {
        isSMB = SMB;
    }
}
