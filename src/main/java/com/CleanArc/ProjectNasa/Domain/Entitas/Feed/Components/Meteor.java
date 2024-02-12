package com.CleanArc.ProjectNasa.Domain.Entitas.Feed.Components;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import com.google.gson.annotations.SerializedName;

import java.util.Optional;

public class Meteor {
    @SerializedName("links")
    public Links links;
    @SerializedName("id")
    public String id;
    @SerializedName("neo_reference_id")
    public String neoReferenceRid;
    @SerializedName("name")
    public String name;
    @SerializedName("nasa_jpl_url")
    public String nasaJplUrl;
    @SerializedName("absolute_magnitude_h")
    public double absoluteMagnitudeH;
    @SerializedName("estimated_diameter")
    public EstimatedDiameter estimatedDiameter;
    @SerializedName("is_potentially_hazardous_asteroid")
    public boolean isPotentiallyHazardousAsteroid;
    @SerializedName("close_approach_data")
    public ArrayList<CloseApproachDatum> closeApproachData;
    @SerializedName("is_sentry_object")
    public boolean isSentryObject;
    // Getter Methods
    public String getId() {
        return id;
    }
    public String getName() {
        return name;
    }
    public String getNasaJplUrl() {
        return nasaJplUrl;
    }
    public Double getAbsoluteMagnitudeH() {
        return absoluteMagnitudeH;
    }
    public EstimatedDiameter getEstimatedDiameter() {
        return estimatedDiameter;
    }
    public Boolean getPotentiallyHazardousAsteroid() {
        return isPotentiallyHazardousAsteroid;
    }
    public List<CloseApproachDatum> getCloseApproachData() {
        return closeApproachData;
    }
    public Boolean getSentryObject() {
        return isSentryObject;
    }

    //Functionality 10
    //This function to get mapping of meteor based on their approach date
    public List<String> getOrbitedBodies(){
        return closeApproachData.stream()
                .map(CloseApproachDatum::getOrbitingBody).distinct().collect(Collectors.toList());
    }

    public double getFirstCloseApproachVelocity(){
        return closeApproachData.get(0).getVelocity();
    }

    public double getFirstCloseApproachMissDistanceAU(){
        return closeApproachData.get(0).getMissedDistanceInAU();
    }
    public double getFirstCloseApproachMissDistanceKM(){
        return closeApproachData.get(0).getMissedDistanceInKM();
    }

    public double getAverageDiameterMeters(){
        return estimatedDiameter.getAvgDiameterInMeters();
    }
    public double getAverageDiameterFeet(){
        return estimatedDiameter.getAvgDiameterInFeet();
    }

    //Functionality 6
    //This function to make sure there is meteor or not
    //how it works is by checking closeApproachDate and compare it with today's date
    //if there is no meteor that will approach in the future, it will return "No future approach found"
    public String getClosestApproach(){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate today = LocalDate.now();
        Optional<CloseApproachDatum> date = closeApproachData.stream().filter(datum -> {
            LocalDate approach = LocalDate.parse(datum.getCloseApproachDate(), formatter);
            return approach.isAfter(today);
        }).findFirst();
        if (date.isPresent()){
            return date.get().getCloseApproachDate();
        } else {
            return "No future approach found";
        }
    }
    
}
