package com.DiabeticChartServer.DiabeticChartServer.DataModels;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class GlucoseData {
    private Double glucoseValue;
    private Double insulinOnBoard;
    private Double carbsOnBoard;
    private LocalDateTime timeStamp;
    private String timeStampString;
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss'Z'");
    DateTimeFormatter formatter2 = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'");
            //2019-12-27T21:14:43.239Z

  //  2019-12-27T21:14:43.239Z
 //   "2019-12-27T00:30:00Z"
    //2019-12-28T00:22:23Z
    //private SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'");

    public void Init(){
        try{
            this.timeStamp = LocalDateTime.parse(timeStampString, formatter);
        }
        catch(java.time.format.DateTimeParseException e){
            this.timeStamp = LocalDateTime.parse(timeStampString, formatter2);
        }

    }
    public LocalDateTime getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(LocalDateTime timeStamp) {
        this.timeStamp = timeStamp;
    }

    public String getTimeStampString() {
        return timeStampString;
    }

    public void setTimeStampString(String timeStampString) {
        this.timeStampString = timeStampString;
        Init();
    }

    /* public Boolean setTimeStampString(String timeString) {
            try{
                this.timeStamp = simpleDateFormat.parse(timeString);
            }
            catch (ParseException e){
                this.timeStamp = null;
                return false;
            }
            return true;
        }*/
    public Double getGlucoseValue() {
        return glucoseValue;
    }

    public void setGlucoseValue(Double glucoseValue) {
        this.glucoseValue = glucoseValue;
    }

    public Double getInsulinOnBoard() {
        return insulinOnBoard;
    }

    public void setInsulinOnBoard(Double insulinOnBoard) {
        this.insulinOnBoard = insulinOnBoard;
    }

    public Double getCarbsOnBoard() {
        return carbsOnBoard;
    }

    public void setCarbsOnBoard(Double carbsOnBoard) {
        this.carbsOnBoard = carbsOnBoard;
    }
}
