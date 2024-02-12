package com.CleanArc.ProjectNasa.Domain.Entitas.Feed.Components;

import com.google.gson.annotations.SerializedName;

public class MissDistance {
    @SerializedName("astronomical")
    public String astronomical;
    @SerializedName("lunar")
    public String lunar;
    @SerializedName("kilometers")
    public String kilometers;
    @SerializedName("miles")
    public String miles;

    public String getAstronomical() {
        return astronomical;
    }
    public String getKilometers() {
        return kilometers;
    }
}
