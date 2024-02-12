package com.CleanArc.ProjectNasa.Domain.Entitas.Feed.Components;
import com.google.gson.annotations.SerializedName;

public class EstimatedDiameter {
    @SerializedName("kilometers")
    public Base kilometers;
    @SerializedName("meters")
    public Base meters;
    @SerializedName("miles")
    public Base miles;
    @SerializedName("feet")
    public Base feet;

    public double getAvgDiameterInMeters(){
        return meters.getEstimatedDiameterAvg();
    }
    public double getAvgDiameterInFeet(){
        return feet.getEstimatedDiameterAvg();
    }
}
