package com.bezkoder.springjwt.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.io.Serializable;

@AllArgsConstructor
@ToString
@EqualsAndHashCode
@Getter
@Setter
@Entity
@Table(name = "Events_Materiel")
public class Events_Materiel {
    @EmbeddedId
    private Events_MaterielId id;
  @ManyToOne(fetch = FetchType.LAZY)
  @JsonIgnore
 @MapsId("events")
  private Events events;
  @ManyToOne(fetch = FetchType.LAZY)
  @JsonIgnore
  @MapsId("materiel")
  private Materiel materiel;

int quantite;
  public Events_Materiel() {
  }


}
