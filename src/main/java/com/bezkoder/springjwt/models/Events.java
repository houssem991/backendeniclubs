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
@EqualsAndHashCode
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


  @OneToMany(mappedBy = "events",fetch = FetchType.LAZY , cascade = CascadeType.ALL)
  private Set<Events_Materiel> events_materiels;
  @ManyToOne()
  @JsonIgnore
  @JoinColumn(name = "Salle_id")
  private Salle salle;
  @ManyToMany(fetch = FetchType.LAZY)
  @JoinTable(  name = "events_clubs",
          joinColumns = @JoinColumn(name = "event_id"),
          inverseJoinColumns = @JoinColumn(name = "clubs_id"))
  private Set<Clubs> clubs = new HashSet<>();
  public Events() {
  }


}
