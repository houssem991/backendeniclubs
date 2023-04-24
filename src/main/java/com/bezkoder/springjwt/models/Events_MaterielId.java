package com.bezkoder.springjwt.models;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

@AllArgsConstructor
@ToString
@Getter
@Setter
@Embeddable
public class Events_MaterielId implements Serializable {


  @JoinColumn(name = "Event_id")
  private Long events;


  @JoinColumn(name = "materiel_id")
  private Long materiel;

  public Events_MaterielId() {
  }


}
