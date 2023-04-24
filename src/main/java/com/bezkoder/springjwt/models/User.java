package com.bezkoder.springjwt.models;

import lombok.*;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
@Getter
@Setter
@AllArgsConstructor
@ToString
@Entity
@Table(name = "users", 
    uniqueConstraints = { 
      @UniqueConstraint(columnNames = "username"),
      @UniqueConstraint(columnNames = "email") 
    })
public class User {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @NotBlank
  @Size(max = 20)
  private String username;
  private String firstname;
  private String lastname;
  private String cin;
  private LocalDate datenaissance;

  @NotBlank
  @Size(max = 50)
  @Email
  private String email;

  @NotBlank
  @Size(max = 120)
  private String password;
  private String image;
  @OneToOne(mappedBy = "user",fetch = FetchType.LAZY , cascade = CascadeType.ALL)
  private Clubs club;

  @ManyToMany(fetch = FetchType.LAZY)
  @JoinTable(  name = "user_roles", 
        joinColumns = @JoinColumn(name = "user_id"), 
        inverseJoinColumns = @JoinColumn(name = "role_id"))
  private Set<Role> roles = new HashSet<>();
  @ManyToMany(fetch = FetchType.LAZY)
  @JoinTable(  name = "membre_clubs",
          joinColumns = @JoinColumn(name = "membre_id"),
          inverseJoinColumns = @JoinColumn(name = "clubs_id"))
  private Set<Clubs> clubs = new HashSet<>();
  public User() {
  }

  public User( @NotBlank @Size(max = 20) String username, String firstname, String lastname, String cin, LocalDate datenaissance, @NotBlank @Size(max = 50) @Email String email, @NotBlank @Size(max = 120) String password) {

    this.username = username;
    this.firstname = firstname;
    this.lastname = lastname;
    this.cin = cin;
    this.datenaissance = datenaissance;
    this.email = email;
    this.password = password;

  }
}
