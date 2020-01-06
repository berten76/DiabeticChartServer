package com.DiabeticChartServer.DiabeticChartServer.GlucoseParamCalculations;

import com.DiabeticChartServer.DiabeticChartServer.DataModels.DiabeticParamDay;
import com.DiabeticChartServer.DiabeticChartServer.DataModels.DiabeticParams;
import com.DiabeticChartServer.DiabeticChartServer.DataModels.ParameterInterval;
import com.DiabeticChartServer.DiabeticChartServer.DataModels.Treatment;
import com.DiabeticChartServer.DiabeticChartServer.NightScoutApiConsumerInterfaces.ITreatmentsConsumer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class ParameterCalculator {
    //@Autowired
    //IGlucoseDataConsumer glucoseDataConsumer;
    @Autowired
    ITreatmentsConsumer treatmentsConsumer;

    public ParameterCalculator(){

    }
    /*public ParameterCalculator(ITreatmentsConsumer treatmentsConsumer){
        this.treatmentsConsumer = treatmentsConsumer;
    }*/

    public List<DiabeticParamDay> calculateParameters(LocalDateTime from, LocalDateTime to, List<ParameterInterval> paramIntervals){
        try {
            List<Treatment> treatments = treatmentsConsumer.getTreatments(from, to);

            ParameterBuilder parameterBuilder = new ParameterBuilder(paramIntervals);
           // List<ParameterBuilder> parameterBuilders = createParameterCreators(paramIntervals);
            for (Treatment data: treatments) {
                parameterBuilder.addIfWhithinInterval(data);
            }

            /*List<List<DiabeticParams>> diabeticParams = new ArrayList<>();
            for (ParameterBuilder pb: parameterBuilders) {
                diabeticParams.add(pb.getDiabeticPrams());
            }*/

            return parameterBuilder.getDiabeticPrams();

        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }


    /*private List<ParameterBuilder> createParameterCreators(List<ParameterInterval> paramIntervals){
        List<ParameterBuilder> parameterBuilders = new ArrayList<ParameterBuilder>();

        for (ParameterInterval param: paramIntervals) {
            parameterBuilders.add(new ParameterBuilder(param));
        }

        return parameterBuilders;
    }*/
}
