package com.CleanArc.ProjectNasa.Application.Interface.Model;

import java.util.List;

import org.springframework.stereotype.Service;

import com.CleanArc.ProjectNasa.Domain.Entitas.Feed.Components.Meteor;
import com.CleanArc.ProjectNasa.Domain.Entitas.Model.MeteorModel;

@Service
public interface IModel {
    List<MeteorModel> convertToMeteorModelList(List<Meteor> meteors);
    List<MeteorModel> convertToMeteorModelListWithFilter(List<Meteor> meteorList, String kilomentersString);
}
