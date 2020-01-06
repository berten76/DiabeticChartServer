package com.DiabeticChartServer.DiabeticChartServer.NightScoutApiConsumer.DataModelsDto.OpenAps;

public class PredBGsDto {
        private Integer IOB[];
        private Integer ZT[];

    public Integer[] getIOB() {
        return IOB;
    }

    public void setIOB(Integer[] IOB) {
        this.IOB = IOB;
    }

    public Integer[] getZT() {
        return ZT;
    }

    public void setZT(Integer[] ZT) {
        this.ZT = ZT;
    }
}
