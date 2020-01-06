package com.DiabeticChartServer.DiabeticChartServer.NightScoutApiConsumer.DataModelsDto;

import com.DiabeticChartServer.DiabeticChartServer.NightScoutApiConsumer.DataModelsDto.OpenAps.OpenApsDto;

public class DeviceStatusDto {
    private String _id;
    private String device;
    private Object pump;
    private OpenApsDto openaps;
    private Integer uploaderBattery;
    private String created_at;
    private Long NSCLIENT_ID;


    public String get_id() {
        return _id;
    }

    public void set_id(String _id) {
        this._id = _id;
    }

    public String getDevice() {
        return device;
    }

    public void setDevice(String device) {
        this.device = device;
    }

    public Object getPump() {
        return pump;
    }

    public void setPump(Object pump) {
        this.pump = pump;
    }

    public OpenApsDto getOpenaps() {
        return openaps;
    }

    public void setOpenaps(OpenApsDto openaps) {
        this.openaps = openaps;
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
