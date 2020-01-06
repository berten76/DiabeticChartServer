package com.DiabeticChartServer.DiabeticChartServer.NightScoutApiConsumer.DataModelsDto;

public class TreatmentDto {

    private String _id;
    private String eventType;
    private Integer duration;
    private Integer percent;
    private Double rate;
    private String created_at;
    private String enteredBy;
    private Long pumpId;
    private Long NSCLIENT_ID;
    private Integer carbs;
    private Double insulin;
    private boolean isSMB;



    public TreatmentDto() {
    }

    public void setCarbs(Integer carbs) {
        this.carbs = carbs;
    }

    public Integer getDuration() {
        return duration;
    }

    public void setDuration(Integer duration) {
        this.duration = duration;
    }

    public Integer getPercent() {
        return percent;
    }

    public void setPercent(Integer percent) {
        this.percent = percent;
    }

    public Double getRate() {
        return rate;
    }

    public void setRate(Double rate) {
        this.rate = rate;
    }

    public boolean isSMB() {
        return isSMB;
    }

    public void setSMB(boolean SMB) {
        isSMB = SMB;
    }

    public String get_id() {
        return _id;
    }

    public void set_id(String _id) {
        this._id = _id;
    }

    public String getEventType() {
        return eventType;
    }

    public void setEventType(String eventType) {
        this.eventType = eventType;
    }

    public String getCreated_at() {
        return created_at;
    }

    public void setCreated_at(String created_at) {
        this.created_at = created_at;
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

    public Long getNSCLIENT_ID() {
        return NSCLIENT_ID;
    }

    public void setNSCLIENT_ID(Long NSCLIENT_ID) {
        this.NSCLIENT_ID = NSCLIENT_ID;
    }

    public Integer getCarbs() {
        return carbs;
    }

    public Double getInsulin() {
        return insulin;
    }

    public void setInsulin(Double insulin) {
        this.insulin = insulin;
    }
}