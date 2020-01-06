package com.DiabeticChartServer.DiabeticChartServer.NightScoutApiConsumerInterfaces;

import com.DiabeticChartServer.DiabeticChartServer.DataModels.GlucoseData;

import java.time.LocalDateTime;
import java.util.List;

public interface IGlucoseDataConsumer {
    List<GlucoseData> getDeviceStatus(LocalDateTime from, LocalDateTime to) throws Exception;
}
