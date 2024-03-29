package com.CleanArc.ProjectNasa.Application.UseCases.Feed.Query;

import java.util.List;

import org.springframework.stereotype.Component;

import com.CleanArc.ProjectNasa.Application.Interface.Base.BaseDto;
import com.CleanArc.ProjectNasa.Domain.Entitas.Model.MeteorModel;

//this class is used to get the data from the NeoFeedQuery
@Component
public class GetNeoFeedDto extends BaseDto{
    public List<MeteorModel> data;
}
