package com.DiabeticChartServer.DiabeticChartServer.NightScoutApiConsumerInterfaces;

import com.DiabeticChartServer.DiabeticChartServer.DataModels.Treatment;

import java.time.LocalDateTime;
import java.util.List;


public interface ITreatmentsConsumer  {
    List<Treatment> getTreatments(LocalDateTime from, LocalDateTime to) throws Exception;
}
