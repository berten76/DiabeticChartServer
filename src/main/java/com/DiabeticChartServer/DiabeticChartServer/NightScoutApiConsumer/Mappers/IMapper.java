package com.DiabeticChartServer.DiabeticChartServer.NightScoutApiConsumer.Mappers;

import com.DiabeticChartServer.DiabeticChartServer.DataModels.GlucoseData;
import com.DiabeticChartServer.DiabeticChartServer.NightScoutApiConsumer.DataModelsDto.DeviceStatusDto;

public interface IMapper {
    GlucoseData[] map(DeviceStatusDto[] deviceStatus);
}
