package com.DiabeticChartServer.DiabeticChartServer.NightScoutApiConsumer.DataModelsDto.OpenAps;

public class OpenApsDto {
    private SuggestedDto suggested;
    private IobDto iob;
    private Integer uploaderBattery;
    private String created_at;
    private Long NSCLIENT_ID;

    public SuggestedDto getSuggested() {
        return suggested;
    }

    public void setSuggested(SuggestedDto suggested) {
        this.suggested = suggested;
    }

    public IobDto getIob() {
        return iob;
    }

    public void setIob(IobDto iob) {
        this.iob = iob;
    }

    public Integer getUploaderBattery() {
        return uploaderBattery;
    }

    public void setUploaderBattery(Integer uploaderBattery) {
        this.uploaderBattery = uploaderBattery;
    }

    public String getCreated_at() {
        return created_at;
    }

    public void setCreated_at(String created_at) {
        this.created_at = created_at;
    }

    public Long getNSCLIENT_ID() {
        return NSCLIENT_ID;
    }

    public void setNSCLIENT_ID(Long NSCLIENT_ID) {
        this.NSCLIENT_ID = NSCLIENT_ID;
    }
}
