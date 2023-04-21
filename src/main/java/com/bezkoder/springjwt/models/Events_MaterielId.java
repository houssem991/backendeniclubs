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
public class Events_Materiel implements Serializable {
  @Id
  @ManyToOne()
  @JsonIgnore
  @JoinColumn(name = "Event_id")
  private Events events;
  @Id
  @ManyToOne()
  @JsonIgnore
  @JoinColumn(name = "materiel_id")
  private Materiel materiel;

int quantite;
  public Events_Materiel() {
  }


}
