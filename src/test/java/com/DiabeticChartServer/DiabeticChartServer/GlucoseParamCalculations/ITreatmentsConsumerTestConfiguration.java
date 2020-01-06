package com.DiabeticChartServer.DiabeticChartServer.GlucoseParamCalculations;

import com.DiabeticChartServer.DiabeticChartServer.NightScoutApiConsumerInterfaces.ITreatmentsConsumer;
import org.mockito.Mockito;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Profile;

@Profile("test")
@Configuration
public class ITreatmentsConsumerTestConfiguration {

    @Bean
    @Primary
    public ITreatmentsConsumer treatmentsConsumer() {
        return Mockito.mock(ITreatmentsConsumer.class);
    }
}
