package com.DiabeticChartServer.DiabeticChartServer.GlucoseParamCalculations;

import com.DiabeticChartServer.DiabeticChartServer.DataModels.*;

import java.time.LocalDateTime;
import java.util.*;

public class ParameterBuilder {
    final private List<ParameterInterval> parameterInterval;
    //Map<Integer, DiabeticParams> diabeticParamMap = new HashMap<>();
    Map<Integer, DiabeticParamDay> diabeticParamMap = new HashMap<>();
    //private double insulin=0;
    //private double carbs=0;
    private double basalRate;
    private TempBasal tempBasal = null;
    private LocalDateTime lastTimeStamp= null;

    public ParameterBuilder(List<ParameterInterval> parameterInterval) {
        this.parameterInterval = parameterInterval;
    }

    public void addIfWhithinInterval(Treatment treatment){

      /*  if(!isCorrectInterval(treatment.getTimeStamp())) {
            return;
        }*/
        List<DiabeticParams> diabeticParams = getCParamsFromCorrectDay(treatment).getDiabeticParams();
        int index=0;
        Double tmpBasal = 0.0;
        for (DiabeticParams dp:diabeticParams) {
            if( treatment.getEventType().equals("Bolus Wizard")){
              int hit=0;
            }
            if(!dp.isWithinInterval(treatment.getTimeStamp()))
                continue;
            if (treatment.getEventType().equals("Temp Basal")) {
                if (treatment.getRate() == null){
                    if(index==0) {
                        tmpBasal = calcBasal(treatment.getTimeStamp());
                    }
                    dp.addInsulin(tmpBasal);
                    index++;
                    continue;
                }
                if(index==0) {
                    tempBasal = new TempBasal(treatment.getTimeStamp(), treatment.getRate(), 0.6);
                }

            } else if (treatment.getEventType().equals("Correction Bolus") ||
                    treatment.getEventType().equals("Bolus Wizard")) {
                dp.addInsulin(treatment.getInsulin());
            } else if (treatment.getEventType().equals("Meal Bolus")) {
                dp.addCarbs(treatment.getCarbs());
            }

        }
        lastTimeStamp = treatment.getTimeStamp();
    }
    private DiabeticParamDay getCParamsFromCorrectDay(Treatment treatment) {
        DiabeticParamDay dp = new DiabeticParamDay(parameterInterval, treatment.getTimeStamp());

        if (diabeticParamMap.containsKey(dp.getDay())) {
            return diabeticParamMap.get(dp.getDay());
        }
        Integer day = dp.getDay();
        diabeticParamMap.put(day, dp);
        return dp;
    }

    public List<DiabeticParamDay> getDiabeticPrams()
    {
        if(lastTimeStamp != null)
            calcBasal(lastTimeStamp);

        Collection<DiabeticParamDay> values = diabeticParamMap.values();
        List<DiabeticParamDay> listOfValues = new ArrayList<DiabeticParamDay>(values);

        return listOfValues;
    }
    private Double calcBasal(LocalDateTime timeStamp){
        if(tempBasal != null){
            Double basal = tempBasal.getInsulin(timeStamp);
            tempBasal = null;
            return basal;
        }
        return 0.0;
    }
   /* private boolean isCorrectInterval(LocalDateTime creationTime){
        return parameterInterval.isWhithinInterval(creationTime);
    }*/

}
