package com.CleanArc.ProjectNasa.Domain.Entitas.Feed;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.CleanArc.ProjectNasa.Domain.Entitas.Feed.Components.Links;
import com.CleanArc.ProjectNasa.Domain.Entitas.Feed.Components.Meteor;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.annotations.SerializedName;

@Repository
public class Neo {
    @SerializedName("links")
    private Links links;
    @SerializedName("element_count")
    private float elementCount;
    @SerializedName("near_earth_objects")
    private Map<String, JsonArray> nearEarthObjects;
    public Map<String, ArrayList<Meteor>> Meteor;

  
   // Getter Methods 
    public Links getLinks() {
      return links;
    }
  
    public float getElement_count() {
      return elementCount;
    }

    public Map<String, ArrayList<Meteor>> getMeteor() {
      return Meteor;
    }
  
    private Map<String,ArrayList<Meteor>> JSONMapToAsteroids(Map<String, JsonArray> near_earth_objects) {
        Map<String, ArrayList<Meteor>> asteroidMap = new HashMap<>();
        Gson gson = new Gson();
        for(Map.Entry<String,JsonArray> entry : near_earth_objects.entrySet()) {
            ArrayList<Meteor> tmp = new ArrayList<>();
            for (JsonElement jsonElement : near_earth_objects.get(entry.getKey())){
                Meteor asteroid = gson.fromJson(jsonElement,Meteor.class);
                tmp.add(asteroid);
            }
            asteroidMap.put(entry.getKey(), tmp);
        }
        return asteroidMap;
    }
  
   // Setter Methods 
    public void setLinks( Links Links ) {
      this.links = Links;
    }
  
    public void setElement_count( float elementCount ) {
      this.elementCount = elementCount;
    }
  
    public void setMeteor(){
      this.Meteor = JSONMapToAsteroids(nearEarthObjects);
    }
}