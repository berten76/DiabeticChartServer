package com.DiabeticChartServer.DiabeticChartServer.NightScoutApiConsumer.Mappers;

import com.DiabeticChartServer.DiabeticChartServer.DataModels.GlucoseData;
import com.DiabeticChartServer.DiabeticChartServer.NightScoutApiConsumer.DataModelsDto.DeviceStatusDto;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeMap;
import org.springframework.stereotype.Service;

@Service
public class FromDtoToGlucoseMapper implements IMapper{
    private ModelMapper modelMapper;


    public FromDtoToGlucoseMapper() {
        modelMapper = new ModelMapper();
        // Create a TypeMap for your mapping
        TypeMap<DeviceStatusDto, GlucoseData> typeMap =
                modelMapper.createTypeMap(DeviceStatusDto.class, GlucoseData.class);
        // Define the mappings on the type map
        typeMap.addMappings(mapper -> {
            mapper.map(src -> src.getOpenaps().getSuggested().getBg(),
                    GlucoseData::setGlucoseValue);
            mapper.map(src -> src.getOpenaps().getIob().getIob(),
                    GlucoseData::setInsulinOnBoard);
            mapper.map(src -> src.getOpenaps().getSuggested().getCob2(),
                    GlucoseData::setCarbsOnBoard);
            mapper.map(src -> src.getCreated_at(),
                    GlucoseData::setTimeStampString);

        });       /**/
    }
    @Override
    public GlucoseData[] map(DeviceStatusDto[] deviceStatus){
        GlucoseData[] glucoseData = modelMapper.map(deviceStatus, GlucoseData[].class);
        return glucoseData;
    }
}








