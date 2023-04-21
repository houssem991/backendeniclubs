package com.bezkoder.springjwt.models;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.Set;

@AllArgsConstructor
@ToString
@EqualsAndHashCode
@Getter
@Setter
@Entity
@Table(name = "Materiel")
public class Materiel {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @NotBlank
  @Size(max = 20)
  private String name;

  private int quantite;

  @OneToMany(mappedBy = "materiel",fetch = FetchType.LAZY , cascade = CascadeType.ALL)
  private Set<Events_Materiel> events_materiels;

  public Materiel() {
  }


}
