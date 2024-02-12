package com.CleanArc.ProjectNasa.Domain.Entitas.Feed.Components;

import com.google.gson.annotations.SerializedName;

public class RelativeVelocity {
    @SerializedName("kilometers_per_second")
    public String kilometersPerSecond;
    @SerializedName("kilometers_per_hour")
    public String kilometersPerHour;
    @SerializedName("miles_per_hour")
    public String milesPerHour;
    //Getter Methods
    public String getKilometersPerSecond() {
        return kilometersPerSecond;
    }
}
