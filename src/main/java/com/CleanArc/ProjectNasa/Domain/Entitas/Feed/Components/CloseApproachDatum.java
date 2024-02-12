package com.CleanArc.ProjectNasa.Domain.Entitas.Feed.Components;
import com.google.gson.annotations.SerializedName;

public class CloseApproachDatum {
    @SerializedName("close_approach_date")
    public String closeApproachDate;
    @SerializedName("close_approach_date_full")
    public String closeApproachDateFull;
    @SerializedName("epoch_date_close_approach")
    public Object epochDateCloseApproach;
    @SerializedName("relative_velocity")
    public RelativeVelocity relativeVelocity;
    @SerializedName("miss_distance")
    public MissDistance missDistance;
    @SerializedName("orbiting_body")
    public String orbitingBody;


    public String getCloseApproachDate() {
        return closeApproachDate;
    }
    public RelativeVelocity getRelativeVelocity() {
        return relativeVelocity;
    }
    public MissDistance getMissDistance() {
        return missDistance;
    }
    public String getOrbitingBody() {
        return orbitingBody;
    }

    public double getVelocity(){
        return Double.parseDouble(getRelativeVelocity().getKilometersPerSecond());
    }

    public double getMissedDistanceInAU(){
        return Double.parseDouble(getMissDistance().getAstronomical());
    }

    public double getMissedDistanceInKM(){
        return Double.parseDouble(getMissDistance().getKilometers());
    }
}
