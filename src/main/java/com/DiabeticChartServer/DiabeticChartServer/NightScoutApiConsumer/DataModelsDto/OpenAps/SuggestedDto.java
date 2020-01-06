package com.DiabeticChartServer.DiabeticChartServer.NightScoutApiConsumer.DataModelsDto.OpenAps;

public class SuggestedDto {
    private String temp;
    private Double bg;
    private String tick;
    private Double eventualBG;
    private Double insulinReq;
    private String deliverAt;
    private Double sensitivityRatio;
    private PredBGsDto predBGs;
    private String COB;
    private Double IOB;
    private String reason;
    private String timestamp;

    public PredBGsDto getPredBGs() {
        return predBGs;
    }

    public void setPredBGs(PredBGsDto predBGs) {
        this.predBGs = predBGs;
    }

    public String getTemp() {
        return temp;
    }

    public void setTemp(String temp) {
        this.temp = temp;
    }

    public Double getBg() {
        return bg;
    }

    public void setBg(Double bg) {
        this.bg = bg;
    }

    public String getTick() {
        return tick;
    }

    public void setTick(String tick) {
        this.tick = tick;
    }

    public Double getEventualBG() {
        return eventualBG;
    }

    public void setEventualBG(Double eventualBG) {
        this.eventualBG = eventualBG;
    }

    public Double getInsulinReq() {
        return insulinReq;
    }

    public void setInsulinReq(Double insulinReq) {
        this.insulinReq = insulinReq;
    }

    public String getDeliverAt() {
        return deliverAt;
    }

    public void setDeliverAt(String deliverAt) {
        this.deliverAt = deliverAt;
    }

    public Double getSensitivityRatio() {
        return sensitivityRatio;
    }

    public void setSensitivityRatio(Double sensitivityRatio) {
        this.sensitivityRatio = sensitivityRatio;
    }

    public Double getCob2()
    {
        //COB: 0, Dev: -0.4, BGI: 0.1, ISF: 4.3, CR: 8, Target: 5.5, minPredBG 4.2, minGuardBG 4.0, IOBpredBG 4.5; Eventual BG 4.9 < 5.3
        Integer startIndex = reason.indexOf("COB:") + 4;
        Integer lastIndex = reason.indexOf(",", startIndex);
        String cobString = reason.substring(startIndex, lastIndex).trim();
        Double cob = Double.parseDouble(cobString);
       return cob;
    }

    public String getCOB() {
        return COB;
    }

    public void setCOB(String COB) {
        this.COB = COB;
    }

    public Double getIOB() {
        return IOB;
    }

    public void setIOB(Double IOB) {
        this.IOB = IOB;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }
}
