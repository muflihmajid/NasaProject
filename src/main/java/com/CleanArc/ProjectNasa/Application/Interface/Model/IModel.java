package com.CleanArc.ProjectNasa.Application.Interface.Model;

import java.util.List;

import org.springframework.stereotype.Service;

import com.CleanArc.ProjectNasa.Application.UseCases.Feed.Model.MeteorModel;
import com.CleanArc.ProjectNasa.Domain.Entitas.Feed.Components.Meteor;

@Service
public interface IModel {
    List<MeteorModel> convertToMeteorModelList(List<Meteor> meteors);
}
