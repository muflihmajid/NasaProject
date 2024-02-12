package com.CleanArc.ProjectNasa.Application.UseCases.Feed.Query;
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
import static com.CleanArc.ProjectNasa.Infrastructure.Authorization.Token.Auth;
import static com.CleanArc.ProjectNasa.Infrastructure.Utils.GlobalConstanta.NEO_FEED_URL;

// This class is responsible for handling the GetNeoFeedQuery and returning the GetNeoFeedDto
@RestController
public class GetNeoFeedHandler {
    private final IApi Apicall;
    private final GetNeoFeedDto getNeoFeedDto;
    private final IModel Model;

    public GetNeoFeedHandler(IApi Apicall, GetNeoFeedDto getNeoFeedDto, IModel Model)
    {
        this.Apicall = Apicall;
        this.getNeoFeedDto = getNeoFeedDto;
        this.Model = Model;
    }
    public GetNeoFeedDto Handle(GetNeoFeedQuery query) throws ExceptionClass, JsonMappingException, JsonProcessingException 
    {
        String Url = NEO_FEED_URL + "start_date=" + query.getStartDate() + "&end_date=" + query.getEndDate() + "&api_key=" + Auth;
        String Json = this.Apicall.GetApiCall(Url);
        try {
            Gson gson = new Gson();
            Neo asteroidByDates = gson.fromJson(Json, Neo.class);
            //this function for mapping data from api
            asteroidByDates.setMeteor();
            List<Meteor> meteorList = new ArrayList<>();
            asteroidByDates.getMeteor().values().forEach(meteorList::addAll);
            getNeoFeedDto.data = Model.convertToMeteorModelList(meteorList);

            // meteorList.sort((m1, m2) -> m1.getCloseApproachData()
            //                  .get(0).getMissDistance().kilometers.compareTo(m2
            //                  .getCloseApproachData().get(0).getMissDistance().kilometers));         
            // List<MeteorModel> datamodelList = new ArrayList<>();
            // //mapping to new model
            // meteorList.forEach(meteor -> datamodelList.add(new MeteorModel(meteor.links.getSelf(),meteor.getId(),meteor.neoReferenceRid, meteor.getName(),
            // meteor.getPotentiallyHazardousAsteroid(),meteor.getCloseApproachData().get(0).closeApproachDate, meteor.getCloseApproachData().get(0).closeApproachDateFull,
            // meteor.getCloseApproachData().get(0).relativeVelocity.kilometersPerSecond,meteor.getCloseApproachData().get(0).getMissDistance().kilometers, meteor.getSentryObject())));
            // getNeoFeedDto.datamModels = datamodelList.subList(0, 10);
        } catch (Exception e) {
            System.out.println(e);
        }
        return new GetNeoFeedDto(){
            {
                Success = true;
                Message = "Data are successfully retrieved";
                data = getNeoFeedDto.data;
            }
        };
    }
}
