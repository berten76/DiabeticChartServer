package com.DiabeticChartServer.DiabeticChartServer.RestServices;

import java.util.List;

public class RequestParameters {
    private DateInterval dateInterval;
    private List<DateInterval> timeIntervals;

    public DateInterval getDateInterval() {
        return dateInterval;
    }

    public void setDateInterval(DateInterval dateInterval) {
        this.dateInterval = dateInterval;
    }

    public List<DateInterval> getTimeIntervals() {
        return timeIntervals;
    }

    public void setTimeIntervals(List<DateInterval> timeIntervals) {
        this.timeIntervals = timeIntervals;
    }
}
