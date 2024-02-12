package com.CleanArc.ProjectNasa.Application.UseCases.SpesificDistanceAndDate;

public class GetSpesificDistanceAndDateQuery {
    private String startDate;
    private String endDate;
    private String kilometers;

    public GetSpesificDistanceAndDateQuery(String startDate, String endDate, String kilometers) {
        this.startDate = startDate;
        this.endDate = endDate;
        this.kilometers = kilometers;
    }

    public String getKilomentersString(){
        return kilometers;
    }

    public String getStartDate() {
        return startDate;
    }

    public String getEndDate() {
        return endDate;
    }   
}
