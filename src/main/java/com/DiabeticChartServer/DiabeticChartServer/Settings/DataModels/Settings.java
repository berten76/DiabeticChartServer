package com.DiabeticChartServer.DiabeticChartServer.Settings.DataModels;

import com.DiabeticChartServer.DiabeticChartServer.SettingsInterfaces.IApiSettings;
import org.springframework.stereotype.Service;

import java.time.format.DateTimeFormatter;

@Service
public class Settings implements IApiSettings {
    private String glucoseDataUri = "https://berten76app2.herokuapp.com/api/v1/";
    private DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss'Z'");
    private  DateTimeFormatter formatterAlt = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'");

    public String getGlucoseDataUri() {
        return glucoseDataUri;
    }

    public void setGlucoseDataUri(String glucoseDataUri) {
        this.glucoseDataUri = glucoseDataUri;
    }

    public DateTimeFormatter getFormatter() {
        return formatter;
    }

    public DateTimeFormatter getFormatterAlt() {
        return formatterAlt;
    }
}
