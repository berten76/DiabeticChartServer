package com.DiabeticChartServer.DiabeticChartServer.SettingsInterfaces;

import java.time.format.DateTimeFormatter;

public interface IApiSettings {
    String getGlucoseDataUri();
    DateTimeFormatter getFormatter();
    DateTimeFormatter getFormatterAlt();
}
