package com.CleanArc.ProjectNasa.Application.UseCases.Feed.Model;

public class MeteorModel {
    public String links;
    public String id;
    public String neoReferenceId;
    public String name;
    public Boolean isPotentiallyHazardousAsteroid;
    public String closeApproachDate;
    public String closeApproachDateFull;
    public String velocityKilometererSec;
    public String missDistanceKilometers;
    public Boolean isSentryObject;

    public MeteorModel(String links, String id, String neoReferenceId, String name, Boolean isPotentiallyHazardousAsteroid, 
    String closeApproachDate, String closeApproachDateFull, 
    String velocityKilometererSec, String missDistanceKilometers, 
    Boolean isSentryObject) 
    {
        this.links = links;
        this.id = id;
        this.neoReferenceId = neoReferenceId;
        this.name = name;
        this.isPotentiallyHazardousAsteroid = isPotentiallyHazardousAsteroid;
        this.closeApproachDate = closeApproachDate;
        this.closeApproachDateFull = closeApproachDateFull;
        this.velocityKilometererSec = velocityKilometererSec;
        this.missDistanceKilometers = missDistanceKilometers;
        this.isSentryObject = isSentryObject;
    }
}
