package com.DiabeticChartServer.DiabeticChartServer.DataModels;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Date;

public class ParameterInterval {
    private LocalTime from;
    private LocalTime to;
    private LocalTime midnightMinus1Minut = LocalTime.of(23,59, 59);
    private LocalTime midnight = LocalTime.of(00,00);

    public ParameterInterval(LocalTime from, LocalTime to) {
        this.from = from;
        this.to = to;
    }

    public LocalTime getFrom() {
        return from;
    }

    public LocalTime getTo() {
        return to;
    }

    public Boolean isWhithinInterval(LocalDateTime dateTimeToCheck){
        LocalTime timeToCheck = LocalTime.of(dateTimeToCheck.getHour(), dateTimeToCheck.getMinute(),dateTimeToCheck.getSecond());

        if(timeToCheck.isAfter(from) && timeToCheck.isBefore(to))
            return true;
        if(from.isAfter(to)){
            if(timeToCheck.isAfter(from) && timeToCheck.isBefore(midnightMinus1Minut))
                return true;
            if(timeToCheck.isAfter(midnight) && timeToCheck.isBefore(to))
                return true;
        }
        return false;
    }
}
