package com.DiabeticChartServer.DiabeticChartServer.NightScoutAPi.Api;

import com.DiabeticChartServer.DiabeticChartServer.DataModels.GlucoseData;
import com.DiabeticChartServer.DiabeticChartServer.SettingsInterfaces.IApiSettings;
import com.DiabeticChartServer.DiabeticChartServer.NightScoutApiConsumerInterfaces.IGlucoseDataConsumer;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.text.ParseException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class DeviceStatusApiConsumerTest {

    @Autowired
    private IGlucoseDataConsumer api;

    @Autowired
    private IApiSettings settings;

    @Test
    void test_getDeviceStatus_not_null(){
        List<GlucoseData> glucoseData = null;
        DateTimeFormatter formatter = settings.getFormatter();

        LocalDateTime from, to;
        try {
            from = LocalDateTime.parse("2019-12-27T00:30:00Z", formatter);
            to = LocalDateTime.parse("2019-12-28T00:30:05Z", formatter);
            glucoseData = api.getDeviceStatus(from, to);

            assertThat(glucoseData.size()).isGreaterThan(2);
        } catch (ParseException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}


