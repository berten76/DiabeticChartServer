package com.DiabeticChartServer.DiabeticChartServer.DataModels;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class DiabeticParamDay {
    private List<DiabeticParams> diabeticParams;
    private LocalDateTime date;
    private Integer day;

    public DiabeticParamDay(List<ParameterInterval> parameterIntervals, LocalDateTime date) {
        diabeticParams = new ArrayList<>();
        for (ParameterInterval pi: parameterIntervals) {
            diabeticParams.add(new DiabeticParams(pi,  date));
        }
        this.date = date;
    }

    public Integer getDay(){
        return date.getDayOfYear();
    }

    public List<DiabeticParams> getDiabeticParams(){
        return diabeticParams;
    }
}
