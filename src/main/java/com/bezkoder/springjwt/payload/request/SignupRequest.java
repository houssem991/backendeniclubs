package com.bezkoder.springjwt.payload.request;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.Set;

import javax.validation.constraints.*;
@Getter
@Setter
public class SignupRequest {
  @NotBlank
  @Size(min = 3, max = 20)
  private String username;
  private String firstname;
  private String lastname;
  private String cin;
  private LocalDate datenaissance;
  private Set<String> nameclubs;
  @NotBlank
  @Size(max = 50)
  @Email
  private String email;

  private Set<String> role;

  @NotBlank
  @Size(min = 6, max = 40)
  private String password;


}
