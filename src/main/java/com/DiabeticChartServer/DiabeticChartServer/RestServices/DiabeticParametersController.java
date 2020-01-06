package com.DiabeticChartServer.DiabeticChartServer.RestServices;

import com.DiabeticChartServer.DiabeticChartServer.DataModels.DiabeticParamDay;
import com.DiabeticChartServer.DiabeticChartServer.DataModels.DiabeticParams;
import com.DiabeticChartServer.DiabeticChartServer.DataModels.ParameterInterval;
import com.DiabeticChartServer.DiabeticChartServer.GlucoseParamCalculations.ParameterCalculator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin(origins="http://localhost:3000")
public class DiabeticParametersController {
    @Autowired
    ParameterCalculator parameterCalculator;

    @PostMapping(path= "/testGet")
    public Boolean GetTest(@RequestBody Object testName){
        return true;
    }
    @PostMapping(path = "/diabeticparams")
    public ResponseEntity<List<DiabeticParamDay>> getDiabeticParams(@RequestBody RequestParameters requestParams){
        //LocalDateTime from, LocalDateTime to, List<ParameterInterval> paramIntervals
        //return parameterCalculator.calculateParameters()
       // yyyy-MM-dd'T'HH:mm:ssX
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
        LocalDateTime from = LocalDateTime.parse(requestParams.getDateInterval().getStart(), formatter);
        LocalDateTime to = LocalDateTime.parse(requestParams.getDateInterval().getEnd(), formatter);

        List<ParameterInterval> paramIntervals = new ArrayList<>();
        for (DateInterval interval: requestParams.getTimeIntervals()) {
            LocalDateTime fromI = LocalDateTime.parse(interval.getStart(), formatter);
            LocalDateTime toI = LocalDateTime.parse(interval.getEnd(), formatter);
            ParameterInterval p = new ParameterInterval(fromI.toLocalTime(), toI.toLocalTime());
            paramIntervals.add(p);
        }
        List<DiabeticParamDay> params = parameterCalculator.calculateParameters(from, to, paramIntervals);
        List<List<DiabeticParams>> returnval = new ArrayList<>();
        return new ResponseEntity<List<DiabeticParamDay>>(params, HttpStatus.OK);
    }
}
   /* @GetMapping(path = "/user/{username}/todos/{id}")
    public Todo getTodo(@PathVariable String username, @PathVariable long id) {
        return staticTodoService.getTodo(id);
*/

