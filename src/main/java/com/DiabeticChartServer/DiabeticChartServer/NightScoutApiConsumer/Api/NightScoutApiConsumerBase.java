package com.DiabeticChartServer.DiabeticChartServer.NightScoutApiConsumer.Api;

/*
public abstract class NightScoutApiConsumerBase<Dto,Dm>  {
    @Autowired
    private IMapper fromDtoToGlucoseMapper;
    final String treatmentUri = "https://berten76app2.herokuapp.com/api/v1/devicestatus.json?find[created_at][$gte]=%s&find[created_at][$lt]=%s&count=10000";
    final SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'");


    public GlocoseData[] getData(Date from, Date to) throws Exception {
        String uri = String.format(treatmentUri, simpleDateFormat.format(from), simpleDateFormat.format(to));

        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<Dto[]> resp = restTemplate.getForEntity(uri, Dto[].class);
        Dto[] deviceStatus = resp.getBody();

        GlocoseData[] glocoseData = fromDtoToGlucoseMapper.map(deviceStatus);
        return glocoseData;
    }
}
*/