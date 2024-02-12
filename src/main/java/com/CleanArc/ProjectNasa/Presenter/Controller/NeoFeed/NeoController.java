package com.CleanArc.ProjectNasa.Presenter.Controller.NeoFeed;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.HttpStatus;

import com.CleanArc.ProjectNasa.Application.Interface.Exception.ExceptionClass;
import com.CleanArc.ProjectNasa.Application.UseCases.Feed.Query.GetNeoFeedDto;
import com.CleanArc.ProjectNasa.Application.UseCases.Feed.Query.GetNeoFeedHandler;
import com.CleanArc.ProjectNasa.Application.UseCases.Feed.Query.GetNeoFeedQuery;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;

@RestController
public class NeoController {
    private final GetNeoFeedHandler getNeoFeedHandler;
    
    public NeoController(GetNeoFeedHandler getNeoFeedHandler) {
        this.getNeoFeedHandler = getNeoFeedHandler;
    }

    @GetMapping("/NeoFeed")
    @ResponseStatus(HttpStatus.OK)
    public GetNeoFeedDto GetNeoFeed(@RequestParam("startDate") String startDate, @RequestParam("endDate")
     String endDate) throws ExceptionClass,JsonMappingException, JsonProcessingException {
        GetNeoFeedQuery getNeoFeedQuery = new GetNeoFeedQuery(startDate, endDate);
        GetNeoFeedDto NeoFeed = getNeoFeedHandler.Handle(getNeoFeedQuery);

        return NeoFeed;
    }
}
