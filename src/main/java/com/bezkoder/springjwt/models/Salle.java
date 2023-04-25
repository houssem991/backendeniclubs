package com.bezkoder.springjwt.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.Set;

@AllArgsConstructor
@ToString
@Getter
@Setter
@Entity
@Table(name = "salle")
public class Salle {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @NotBlank
  @Size(max = 20)
  private String name;

  private String local;

  @OneToMany(mappedBy = "salle",fetch = FetchType.LAZY , cascade = CascadeType.ALL)
  @JsonIgnore
  private Set<Events> event;

  public Salle() {
  }


}
