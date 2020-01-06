package com.DiabeticChartServer.DiabeticChartServer;

//import org.springframework.boot.SpringApplication;
//import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.DiabeticChartServer.DiabeticChartServer.NightScoutApiConsumer.Api.DeviceStatusApiConsumer;
import com.DiabeticChartServer.DiabeticChartServer.NightScoutApiConsumer.DataModelsDto.Quote;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

import java.util.Date;

@SpringBootApplication
public class DiabeticChartServerApplication {

	private static final Logger log = LoggerFactory.getLogger(DiabeticChartServerApplication.class);

	public static void main(String[] args) {

		ApplicationContext ctx = SpringApplication.run(DiabeticChartServerApplication.class, args);

		//DeviceStatusApiConsumer v = ctx.getBean(DeviceStatusApiConsumer.class);
		try{
			//v.getDeviceStatus(new Date(), new Date());
		}
		catch(Exception e){

		}

	}
/*
	@Bean
	public RestTemplate restTemplate(RestTemplateBuilder builder) {
		return builder.build();
	}

	@Bean
	public CommandLineRunner run(RestTemplate restTemplate) throws Exception {
		return args -> {
			Quote quote = restTemplate.getForObject(
					"https://gturnquist-quoters.cfapps.io/api/random", Quote.class);
			log.info(quote.toString());
		};
	}*/

}
