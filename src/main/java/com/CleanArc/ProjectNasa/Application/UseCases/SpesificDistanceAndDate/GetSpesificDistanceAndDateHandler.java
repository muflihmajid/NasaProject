package com.CleanArc.ProjectNasa.Application.UseCases.SpesificDistanceAndDate;

import static com.CleanArc.ProjectNasa.Infrastructure.Authorization.Token.Auth;
import static com.CleanArc.ProjectNasa.Infrastructure.Utils.GlobalConstanta.NEO_FEED_URL;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.RestController;

import com.CleanArc.ProjectNasa.Application.Interface.Api.IApi;
import com.CleanArc.ProjectNasa.Application.Interface.Exception.ExceptionClass;
import com.CleanArc.ProjectNasa.Application.Interface.Model.IModel;
import com.CleanArc.ProjectNasa.Domain.Entitas.Feed.Neo;
import com.CleanArc.ProjectNasa.Domain.Entitas.Feed.Components.Meteor;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.google.gson.Gson;

@RestController
public class GetSpesificDistanceAndDateHandler {
    
    private final IApi Apicall;
    private final GetSpesificDistanceAndDateDto getSpesificDistnaceAndDateDto;
    private final IModel Model;

    public GetSpesificDistanceAndDateHandler(IApi Apicall, GetSpesificDistanceAndDateDto getSpesificDistnaceAndDateDto, IModel Model)
    {
        this.Apicall = Apicall;
        this.getSpesificDistnaceAndDateDto = getSpesificDistnaceAndDateDto;
        this.Model = Model;
    }
    public GetSpesificDistanceAndDateDto Handle(GetSpesificDistanceAndDateQuery query) throws ExceptionClass, JsonMappingException, JsonProcessingException 
    {
         String Url = NEO_FEED_URL + "start_date=" + query.getStartDate() + "&end_date=" + query.getEndDate() + "&api_key=" + Auth;
         String Json = this.Apicall.GetApiCall(Url);
         try {
            Gson gson = new Gson();
            Neo asteroidByDates = gson.fromJson(Json, Neo.class);
            asteroidByDates.setMeteor();
            List<Meteor> meteorList = new ArrayList<>();
            asteroidByDates.getMeteor().values().forEach(meteorList::addAll);
            getSpesificDistnaceAndDateDto.data = Model.convertToMeteorModelListWithFilter(meteorList,query.getKilomentersString());          
         } catch (Exception e) {
             System.out.println(e);
         }

         return new GetSpesificDistanceAndDateDto(){
             {
                 Success = true;
                 Message = "Data are successfully retrieved";
                 data = getSpesificDistnaceAndDateDto.data;
             }
         };
    }
}
