package com.DiabeticChartServer.DiabeticChartServer.NightScoutApiConsumer.Api;

import com.DiabeticChartServer.DiabeticChartServer.NightScoutApiConsumer.DataModelsDto.Quote;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

public class Qturnquist {


    @Bean
    public Quote getQuotes() throws Exception {
        //final String uri = "http://localhost:8080/springrestexample/employees.xml";

        RestTemplate restTemplate = new RestTemplate();

        Quote quote = restTemplate.getForObject(
                "https://gturnquist-quoters.cfapps.io/api/random", Quote.class);

        return quote;
    }
}
