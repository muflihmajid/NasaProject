package com.CleanArc.ProjectNasa.Application.UseCases.Feed.Query;

//this class is used to get the data from the NeoFeedQuery
public class GetNeoFeedQuery {
    private String startDate;
    private String endDate;

    public GetNeoFeedQuery(String startDate, String endDate) {
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public String getStartDate() {
        return startDate;
    }

    public String getEndDate() {
        return endDate;
    }
}
