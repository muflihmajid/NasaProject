package com.CleanArc.ProjectNasa.Infrastructure.Interface.Model;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.CleanArc.ProjectNasa.Application.Interface.Model.IModel;
import com.CleanArc.ProjectNasa.Application.UseCases.Feed.Model.MeteorModel;
import com.CleanArc.ProjectNasa.Domain.Entitas.Feed.Components.Meteor;

@Service
public class Model implements IModel{
    @Override
    public List<MeteorModel> convertToMeteorModelList(List<Meteor> meteorList) {
        List<MeteorModel> datamodelList = new ArrayList<>();
        meteorList.sort((m1, m2) -> m1.getCloseApproachData()
                             .get(0).getMissDistance().kilometers.compareTo(m2
                             .getCloseApproachData().get(0).getMissDistance().kilometers));
        meteorList.forEach(meteor -> datamodelList.add(convertToMeteorModel(meteor)));
        return datamodelList.subList(0, Math.min(datamodelList.size(), 10));
    }

    private MeteorModel convertToMeteorModel(Meteor meteor) {
        return new MeteorModel(
            meteor.links.getSelf(),
            meteor.getId(),
            meteor.neoReferenceRid,
            meteor.getName(),
            meteor.getPotentiallyHazardousAsteroid(),
            meteor.getCloseApproachData().get(0).closeApproachDate,
            meteor.getCloseApproachData().get(0).closeApproachDateFull,
            meteor.getCloseApproachData().get(0).relativeVelocity.kilometersPerSecond,
            meteor.getCloseApproachData().get(0).getMissDistance().kilometers,
            meteor.getSentryObject()
        );
    }
}
