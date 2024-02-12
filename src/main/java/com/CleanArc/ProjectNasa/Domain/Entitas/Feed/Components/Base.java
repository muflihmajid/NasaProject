package com.CleanArc.ProjectNasa.Domain.Entitas.Feed.Components;

import org.springframework.stereotype.Repository;
import com.google.gson.annotations.SerializedName;

@Repository
public class Base {
    @SerializedName("estimated_diameter_min")
    public Double estimatedDiameterMin;
    @SerializedName("estimated_diameter_max")
    public Double estimatedDiameterMax;

    public Double getEstimatedDiameterAvg(){
        return (estimatedDiameterMax + estimatedDiameterMin)/2;
    }
    
}
