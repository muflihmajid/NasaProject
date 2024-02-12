package com.CleanArc.ProjectNasa.Domain.Entitas.Feed.Components;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.stereotype.Repository;
@Repository
public class Links {
    @JsonProperty("next")
    private String next;
    @JsonProperty("previous")
    private String previous;
    @JsonProperty("self")
    private String self;
  
  
   // Getter Methods 
  
    public String getNext() {
      return next;
    }
  
    public String getPrevious() {
      return previous;
    }
  
    public String getSelf() {
      return self;
    }
  
   // Setter Methods 
  
    public void setNext( String next ) {
      this.next = next;
    }
  
    public void setPrevious( String previous ) {
      this.previous = previous;
    }
  
    public void setSelf( String self ) {
      this.self = self;
    }
 
}
