package com.bezkoder.springjwt.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.HashSet;
import java.util.Set;
@AllArgsConstructor
@ToString
@Getter
@Setter
@Entity
@Table(name = "clubs")
public class Clubs {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @NotBlank
  @Size(max = 20)
  private String name;

  private int nbmembers;
  private String image;


  @OneToOne
  @JsonIgnore
  @JoinColumn(name = "responsable_id")
  private User user;

  public Clubs() {
  }


}
