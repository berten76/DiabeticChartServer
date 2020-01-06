package com.DiabeticChartServer.DiabeticChartServer.NightScoutAPi.Api;

import com.DiabeticChartServer.DiabeticChartServer.NightScoutApiConsumer.Api.Qturnquist;
import com.DiabeticChartServer.DiabeticChartServer.NightScoutApiConsumer.DataModelsDto.Quote;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import static org.assertj.core.api.Assertions.assertThat;
@SpringBootTest
public class QturnqvistTests {

    @Test
    void contextLoads() {
        Qturnquist turn = new Qturnquist();
        Quote quote = null;
        try {
             quote = turn.getQuotes();
        }catch(Exception e){

        }

        assertThat(quote).isNotEqualTo(null);
    }
}
