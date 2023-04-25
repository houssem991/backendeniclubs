package com.bezkoder.springjwt.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@AllArgsConstructor
@ToString

@Getter
@Setter
@Entity
@Table(name = "events")
public class Events {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @NotBlank
  @Size(max = 20)
  private String name;

  private String description;

  private EEvent etat;
  private LocalDate date;
  private String heure;



  @ManyToOne()
  @JoinColumn(name = "Salle_id")
  private Salle salle;
  @ManyToMany(fetch = FetchType.LAZY)
  @JoinTable(  name = "events_clubs",
          joinColumns = @JoinColumn(name = "event_id"),
          inverseJoinColumns = @JoinColumn(name = "clubs_id"))
  private Set<Clubs> clubs = new HashSet<>();
  @ManyToMany(fetch = FetchType.LAZY)
  @JoinTable(  name = "events_materiel",
          joinColumns = @JoinColumn(name = "event_id"),
          inverseJoinColumns = @JoinColumn(name = "materiel_id"))
  private Set<Materiel> materiels = new HashSet<>();
  public Events() {
  }


}
