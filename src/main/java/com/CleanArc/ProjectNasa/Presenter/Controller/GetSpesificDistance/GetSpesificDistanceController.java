package com.CleanArc.ProjectNasa.Presenter.Controller.GetSpesificDistance;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.CleanArc.ProjectNasa.Application.Interface.Exception.ExceptionClass;
import com.CleanArc.ProjectNasa.Application.UseCases.SpesificDistanceAndDate.GetSpesificDistanceAndDateDto;
import com.CleanArc.ProjectNasa.Application.UseCases.SpesificDistanceAndDate.GetSpesificDistanceAndDateHandler;
import com.CleanArc.ProjectNasa.Application.UseCases.SpesificDistanceAndDate.GetSpesificDistanceAndDateQuery;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;


@RestController
public class GetSpesificDistanceController {
    private final GetSpesificDistanceAndDateHandler getSpesificDistanceAndDateHandler;
    
    public GetSpesificDistanceController(GetSpesificDistanceAndDateHandler getSpesificDistanceAndDateHandler) {
        this.getSpesificDistanceAndDateHandler = getSpesificDistanceAndDateHandler;
    }

    @GetMapping("/NeoFeed/SpesificDistanceAndDate")
    @ResponseStatus(HttpStatus.OK)
    public GetSpesificDistanceAndDateDto GetNeoFeed(@RequestParam("startDate") String startDate, @RequestParam("endDate")
     String endDate,@RequestParam("distance") String distance) throws ExceptionClass,JsonMappingException, JsonProcessingException {
        GetSpesificDistanceAndDateQuery getSpesificDistanceAndDateQuery = new GetSpesificDistanceAndDateQuery(startDate, endDate, distance);
        GetSpesificDistanceAndDateDto getSpesificDistanceAndDateDto = getSpesificDistanceAndDateHandler.Handle(getSpesificDistanceAndDateQuery);

        return getSpesificDistanceAndDateDto;
    }
}
