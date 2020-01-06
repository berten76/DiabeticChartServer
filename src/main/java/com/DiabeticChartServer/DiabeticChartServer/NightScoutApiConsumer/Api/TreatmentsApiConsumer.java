package com.DiabeticChartServer.DiabeticChartServer.NightScoutApiConsumer.Api;

import com.DiabeticChartServer.DiabeticChartServer.DataModels.Treatment;
import com.DiabeticChartServer.DiabeticChartServer.SettingsInterfaces.IApiSettings;
import com.DiabeticChartServer.DiabeticChartServer.NightScoutApiConsumerInterfaces.ITreatmentsConsumer;
import com.DiabeticChartServer.DiabeticChartServer.NightScoutApiConsumer.DataModelsDto.TreatmentDto;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.List;

@Component
public class TreatmentsApiConsumer implements ITreatmentsConsumer {

    private IApiSettings apiSettings;
    final String treatmentUri;
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss'Z'");
    final RestTemplate restTemplate = new RestTemplate();
    final ModelMapper mapper = new ModelMapper();

    @Autowired
    public TreatmentsApiConsumer(IApiSettings apiSettings){
        this.apiSettings = apiSettings;
        treatmentUri = apiSettings.getGlucoseDataUri() + "/treatments.json?find[created_at][$gte]=%s&find[created_at][$lt]=%s";
    }
    public List<Treatment> getTreatments(LocalDateTime from, LocalDateTime to) throws Exception {

        String uri = String.format(treatmentUri, from.format(formatter), to.format(formatter));

        ResponseEntity<TreatmentDto[]> resp = restTemplate.getForEntity(uri, TreatmentDto[].class);
        TreatmentDto[] treats = resp.getBody();

        Treatment[] treatments =  mapper.map(treats, Treatment[].class);
        return Arrays.asList(treatments);
    }
}

