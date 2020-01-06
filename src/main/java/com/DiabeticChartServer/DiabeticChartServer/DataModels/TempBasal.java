package com.DiabeticChartServer.DiabeticChartServer.DataModels;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.temporal.ChronoUnit;
import java.util.Date;

public class TempBasal {
    private LocalDateTime startDate;
    private LocalTime startTime;
    private double tempBasal;
    private double basal;

    public TempBasal(LocalDateTime startDate, double rate, double basal) {
        this.startDate = startDate;
        this.tempBasal = rate;
        this.basal = basal;
        this.startTime = LocalTime.from(startDate);
    }
//0,6 * 50/100 + 0,6
    public double getInsulin(LocalDateTime endDate) {

        double tempBasalDiff = tempBasal - basal;

        long minutes = ChronoUnit.MINUTES.between(startDate, endDate);
        long hours = ChronoUnit.HOURS.between(startDate, endDate);

        double insulin = tempBasalDiff * (double)(hours + minutes / 60.0);
        return insulin;
    }
}
