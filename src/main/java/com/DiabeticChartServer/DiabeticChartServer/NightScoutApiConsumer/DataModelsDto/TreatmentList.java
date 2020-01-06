package com.DiabeticChartServer.DiabeticChartServer.NightScoutApiConsumer.DataModelsDto;

import java.util.ArrayList;
import java.util.List;


public class TreatmentList {
    private List<TreatmentDto> employees;

    public TreatmentList() {
        employees = new ArrayList<>();
    }

    public List<TreatmentDto> getEmployees() {
        return employees;
    }

    public void setEmployees(List<TreatmentDto> employees) {
        this.employees = employees;
    }
// standard constructor and getter/setter
}