package com.DiabeticChartServer.DiabeticChartServer.GlucoseParamCalculations;

import com.DiabeticChartServer.DiabeticChartServer.DataModels.DiabeticParamDay;
import com.DiabeticChartServer.DiabeticChartServer.DataModels.DiabeticParams;
import com.DiabeticChartServer.DiabeticChartServer.DataModels.ParameterInterval;
import com.DiabeticChartServer.DiabeticChartServer.DataModels.Treatment;
import com.DiabeticChartServer.DiabeticChartServer.NightScoutApiConsumerInterfaces.ITreatmentsConsumer;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@ActiveProfiles("test")
@SpringBootTest
class ParameterCalculatorTest {

    @Autowired
    private ITreatmentsConsumer treatmentsConsumer;

    @Autowired
    private ParameterCalculator parameterCalculator;

    @Test
    void calculateParametersOneTimerIntervalOneDayBasalTest() {
        List<ParameterInterval> paramIntervals = new ArrayList<>();

        ParameterInterval p = new ParameterInterval(LocalTime.of(6, 0), LocalTime.of(7, 00));
        paramIntervals.add(p);
        List<Treatment> treatments = new ArrayList<>();
        //basal
        treatments.add(createTempBonus(0.6, LocalDateTime.of(2019, 11, 04, 6, 1)));
        treatments.add(createTempBonus(null, LocalDateTime.of(2019, 11, 04, 6, 59)));



        LocalDateTime from = LocalDateTime.of(2019, 11, 03, 7, 0);
        LocalDateTime to = LocalDateTime.of(2019, 11, 04, 7, 0);
        try {
            Mockito.when(treatmentsConsumer.getTreatments(from, to)).thenReturn(treatments);

            List<DiabeticParamDay> diabeticParams = parameterCalculator.calculateParameters(from, to, paramIntervals);

            assertThat(diabeticParams.get(0).getDiabeticParams().get(0).getInsulin()).isEqualTo(15);
            assertThat(diabeticParams.get(0).getDiabeticParams().get(0).getCarbs()).isEqualTo(15);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    void calculateParametersOneTimerIntervalOneDay() {
        List<ParameterInterval> paramIntervals = new ArrayList<>();

        ParameterInterval p = new ParameterInterval(LocalTime.of(6, 0), LocalTime.of(12, 00));
        paramIntervals.add(p);
        List<Treatment> treatments = new ArrayList<>();
        //insulin
        treatments.add(createBolus(10, LocalDateTime.of(2019, 11, 04, 8, 00)));
        treatments.add(createBolus(5, LocalDateTime.of(2019, 11, 04, 9, 00)));

        //add Bolus outside interval
        treatments.add(createBolus(5, LocalDateTime.of(2019, 11, 04, 14, 00)));

        //carbs
        treatments.add(createMeal(10, LocalDateTime.of(2019, 11, 04, 8, 00)));
        treatments.add(createMeal(5, LocalDateTime.of(2019, 11, 04, 9, 00)));

        LocalDateTime from = LocalDateTime.of(2019, 11, 03, 7, 0);
        LocalDateTime to = LocalDateTime.of(2019, 11, 04, 7, 0);
        try {
            Mockito.when(treatmentsConsumer.getTreatments(from, to)).thenReturn(treatments);

            List<DiabeticParamDay> diabeticParams = parameterCalculator.calculateParameters(from, to, paramIntervals);

            assertThat(diabeticParams.get(0).getDiabeticParams().get(0).getInsulin()).isEqualTo(15);
            assertThat(diabeticParams.get(0).getDiabeticParams().get(0).getCarbs()).isEqualTo(15);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    void calculateParametersOneTimerIntervalTwoDays() {
        List<ParameterInterval> paramIntervals = new ArrayList<>();

        ParameterInterval p = new ParameterInterval(LocalTime.of(6, 0), LocalTime.of(12, 00));
        paramIntervals.add(p);
        List<Treatment> treatments = new ArrayList<>();
        //insulin day 1
        treatments.add(createBolus(10, LocalDateTime.of(2019, 11, 04, 8, 00)));
        treatments.add(createBolus(5, LocalDateTime.of(2019, 11, 04, 9, 00)));

        //insulin day 2
        treatments.add(createBolus(10, LocalDateTime.of(2019, 11, 05, 8, 00)));

        LocalDateTime from = LocalDateTime.of(2019, 11, 03, 7, 0);
        LocalDateTime to = LocalDateTime.of(2019, 11, 04, 7, 0);
        try {
            Mockito.when(treatmentsConsumer.getTreatments(from, to)).thenReturn(treatments);

            List<DiabeticParamDay> diabeticParams = parameterCalculator.calculateParameters(from, to, paramIntervals);

            assertThat(diabeticParams.size()).isEqualTo(2);
            assertThat(diabeticParams.get(0).getDiabeticParams().size()).isEqualTo(1);

            assertThat(diabeticParams.get(0).getDiabeticParams().get(0).getInsulin()).isEqualTo(15);
            assertThat(diabeticParams.get(1).getDiabeticParams().get(0).getInsulin()).isEqualTo(10);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    void calculateParametersTwoTimerIntervalOneDay() {
        List<ParameterInterval> paramIntervals = new ArrayList<>();

        ParameterInterval p = new ParameterInterval(LocalTime.of(6, 0), LocalTime.of(12, 00));
        ParameterInterval p2 = new ParameterInterval(LocalTime.of(12, 0), LocalTime.of(16, 00));
        paramIntervals.add(p);
        paramIntervals.add(p2);
        List<Treatment> treatments = new ArrayList<>();
        //insulin interval 1
        treatments.add(createBolus(10, LocalDateTime.of(2019, 11, 04, 8, 00)));
        treatments.add(createBolus(5, LocalDateTime.of(2019, 11, 04, 9, 00)));

        //insulin interval 2
        treatments.add(createBolus(10, LocalDateTime.of(2019, 11, 04, 13, 00)));

        LocalDateTime from = LocalDateTime.of(2019, 11, 03, 7, 0);
        LocalDateTime to = LocalDateTime.of(2019, 11, 04, 7, 0);
        try {
            Mockito.when(treatmentsConsumer.getTreatments(from, to)).thenReturn(treatments);

            List<DiabeticParamDay> diabeticParams = parameterCalculator.calculateParameters(from, to, paramIntervals);

            assertThat(diabeticParams.size()).isEqualTo(1);
            assertThat(diabeticParams.get(0).getDiabeticParams().size()).isEqualTo(2);

            assertThat(diabeticParams.get(0).getDiabeticParams().get(0).getInsulin()).isEqualTo(15);
            assertThat(diabeticParams.get(0).getDiabeticParams().get(1).getInsulin()).isEqualTo(10);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    void calculateParametersOneTimerIntervalTImerIntervalPassesMidnight() {
        List<ParameterInterval> paramIntervals = new ArrayList<>();

        ParameterInterval p = new ParameterInterval(LocalTime.of(22, 0), LocalTime.of(04, 00));
        paramIntervals.add(p);
        List<Treatment> treatments = new ArrayList<>();
        //insulin day 1
        treatments.add(createBolus(10, LocalDateTime.of(2019, 11, 04, 23, 00)));
        treatments.add(createBolus(5, LocalDateTime.of(2019, 11, 04, 1, 00)));

        LocalDateTime from = LocalDateTime.of(2019, 11, 03, 7, 0);
        LocalDateTime to = LocalDateTime.of(2019, 11, 04, 7, 0);
        try {
            Mockito.when(treatmentsConsumer.getTreatments(from, to)).thenReturn(treatments);

            List<DiabeticParamDay> diabeticParams = parameterCalculator.calculateParameters(from, to, paramIntervals);

            assertThat(diabeticParams.size()).isEqualTo(1);
            assertThat(diabeticParams.get(0).getDiabeticParams().size()).isEqualTo(1);

            assertThat(diabeticParams.get(0).getDiabeticParams().get(0).getInsulin()).isEqualTo(15);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    private Treatment createTempBonus(Double rate, LocalDateTime time){
        Treatment t = new Treatment();
        t.setRate(rate);
        t.setEventType("Temp Basal");
        t.setTimeStamp(time);
        return t;
    }
    private Treatment createBolus(double insulin, LocalDateTime time){
        Treatment t = new Treatment();
        t.setInsulin(insulin);
        t.setEventType("Bolus Wizard");
        t.setTimeStamp(time);
        return t;
    }
    private Treatment createMeal(Integer carb, LocalDateTime time){
        Treatment t = new Treatment();
        t.setCarbs(carb);
        t.setEventType("Meal Bolus");
        t.setTimeStamp(time);
        return t;
    }
}
/*if(treatment.getEventType() == "Temp Basal"){
            calcBasal(treatment);
           tempBasal = new TempBasal(treatment.getTimeStamp(), treatment.getRate(), 0.6);
        }else if(treatment.getEventType() == "Correction Bolus" ||
                treatment.getEventType() == "Bolus Wizard"){
            insulin += treatment.getInsulin();
        }else if(treatment.getEventType() == "Meal Bolus"){
            carbs += treatment.getCarbs();*/