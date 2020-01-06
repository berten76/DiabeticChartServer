package com.DiabeticChartServer.DiabeticChartServer.NightScoutApiConsumer.Api;

import com.DiabeticChartServer.DiabeticChartServer.DataModels.GlucoseData;
import com.DiabeticChartServer.DiabeticChartServer.SettingsInterfaces.IApiSettings;
import com.DiabeticChartServer.DiabeticChartServer.NightScoutApiConsumerInterfaces.IGlucoseDataConsumer;
import com.DiabeticChartServer.DiabeticChartServer.NightScoutApiConsumer.DataModelsDto.DeviceStatusDto;
import com.DiabeticChartServer.DiabeticChartServer.NightScoutApiConsumer.Mappers.IMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.List;

@Component
public class DeviceStatusApiConsumer implements IGlucoseDataConsumer {

    private IApiSettings apiSettings;
    @Autowired
    private IMapper fromDtoToGlucoseMapper;
    final String treatmentUri;// = "https://berten76app2.herokuapp.com/api/v1/devicestatus.json?find[created_at][$gte]=%s&find[created_at][$lt]=%s&count=10000";
    DateTimeFormatter formatter;

    @Autowired
    public DeviceStatusApiConsumer(IApiSettings apiSettings){
        this.apiSettings = apiSettings;
        this.formatter = apiSettings.getFormatter();
        this.treatmentUri = apiSettings.getGlucoseDataUri() + "/devicestatus.json?find[created_at][$gte]=%s&find[created_at][$lt]=%s&count=10000";
    }

    public List<GlucoseData> getDeviceStatus(LocalDateTime from, LocalDateTime to) throws Exception {
        String uri = String.format(treatmentUri,from.format(formatter), to.format(formatter));

        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<DeviceStatusDto[]> resp = restTemplate.getForEntity(uri, DeviceStatusDto[].class);
        DeviceStatusDto[] deviceStatus = resp.getBody();

        GlucoseData[] glucoseData = fromDtoToGlucoseMapper.map(deviceStatus);
        return Arrays.asList(glucoseData);
    }
}
