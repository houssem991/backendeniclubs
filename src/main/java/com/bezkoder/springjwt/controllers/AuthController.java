package com.bezkoder.springjwt.controllers;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

import javax.validation.Valid;


import com.bezkoder.springjwt.Services.FileStorageService;
import com.bezkoder.springjwt.Services.IUserService;

import com.bezkoder.springjwt.models.Clubs;
import com.bezkoder.springjwt.payload.request.UpdateRequest;

import com.bezkoder.springjwt.payload.response.UserResponse;
import com.bezkoder.springjwt.repository.ClubsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import com.bezkoder.springjwt.models.ERole;
import com.bezkoder.springjwt.models.Role;
import com.bezkoder.springjwt.models.User;
import com.bezkoder.springjwt.payload.request.LoginRequest;
import com.bezkoder.springjwt.payload.request.SignupRequest;
import com.bezkoder.springjwt.payload.response.JwtResponse;
import com.bezkoder.springjwt.payload.response.MessageResponse;
import com.bezkoder.springjwt.repository.RoleRepository;
import com.bezkoder.springjwt.repository.UserRepository;
import com.bezkoder.springjwt.security.jwt.JwtUtils;
import com.bezkoder.springjwt.security.services.UserDetailsImpl;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/auth")
public class AuthController {
  @Autowired
  AuthenticationManager authenticationManager;

  @Autowired
  UserRepository userRepository;

  @Autowired
  RoleRepository roleRepository;
  @Autowired
  ClubsRepository clubsRepository;
  @Autowired

  IUserService iUserService;

  @Autowired
  PasswordEncoder encoder;

  @Autowired
  JwtUtils jwtUtils;
  @Autowired
  private FileStorageService fileStorageService;

  @PostMapping("/signin")
  public ResponseEntity<?> authenticateUser(@Valid @RequestBody LoginRequest loginRequest) {
    Optional<User> optional = userRepository.findByEmail(loginRequest.getEmail());
    User user =optional.get();

    Authentication authentication = authenticationManager.authenticate(
            new UsernamePasswordAuthenticationToken(user.getUsername(), loginRequest.getPassword()));

    SecurityContextHolder.getContext().setAuthentication(authentication);
    String jwt = jwtUtils.generateJwtToken(authentication);

    UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();
    List<String> roles = userDetails.getAuthorities().stream()
            .map(item -> item.getAuthority())
            .collect(Collectors.toList());

    return ResponseEntity.ok(new JwtResponse(jwt,
            userDetails.getId(),
            userDetails.getUsername(),
            userDetails.getEmail(),
            roles));
  }

  @PostMapping("/signup")
  public ResponseEntity<?> registerUser(@Valid @RequestBody SignupRequest signUpRequest) {
    if (userRepository.existsByUsername(signUpRequest.getUsername())) {
      return ResponseEntity
              .badRequest()
              .body(new MessageResponse("Error: Username is already taken!"));
    }

    if (userRepository.existsByEmail(signUpRequest.getEmail())) {
      return ResponseEntity
              .badRequest()
              .body(new MessageResponse("Error: Email is already in use!"));
    }

    // Create new user's account
    User user = new User();
   user.setUsername(signUpRequest.getUsername());
       user.setEmail(signUpRequest.getEmail());
       user.setPassword(encoder.encode(signUpRequest.getPassword()));
            user.setFirstname(signUpRequest.getFirstname());
            user.setLastname(  signUpRequest.getLastname());
            user.setCin(signUpRequest.getCin());
            user.setDatenaissance(signUpRequest.getDatenaissance());

          /* Set<Clubs> clubs =new HashSet<>();
            signUpRequest.getNameclubs().forEach(c->{
              Clubs club =clubsRepository.findByName(c).get();
              clubs.add(club);

            });
            user.setClubs(clubs);*/





    Set<String> strRoles = signUpRequest.getRole();
    Set<Role> roles = new HashSet<>();

    if (strRoles == null) {
      Role userRole = roleRepository.findByName(ERole.ROLE_Membre)
              .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
      roles.add(userRole);
    } else {
      strRoles.forEach(role -> {
        switch (role) {
          case "resp":
            Role resp = roleRepository.findByName(ERole.ROLE_RESPONSABLE_CLUB)
                    .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
            roles.add(resp);

            break;
          case "admin":
            Role adminRole = roleRepository.findByName(ERole.ROLE_ADMIN)
                    .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
            roles.add(adminRole);

            break;

          default:
            Role userRole = roleRepository.findByName(ERole.ROLE_Membre)
                    .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
            roles.add(userRole);
        }
      });
    }

    user.setRoles(roles);
    userRepository.save(user);

    return ResponseEntity.ok(new MessageResponse("User registered successfully!"));
  }
  @GetMapping("/all")
  public List<User> all() {
    return iUserService.findall();
  }

  @GetMapping("/find/{id}")
  public User find(@PathVariable("id") long id)
  {
    User u=iUserService.findbyId(id);



    return u;
  }
  @GetMapping("/findu/{username}")
  public UserResponse findU(@PathVariable("username") String username)
  {
    UserResponse u=iUserService.findbyUsername(username);



    return u;
  }
  @DeleteMapping("/delete/{id}")
  public String delete(@PathVariable("id") long id ) {
    iUserService.delete(id);
    return "oki";
  }
  @PutMapping("/update/{id}")
  public ResponseEntity<?> UpdateUser(@Valid @RequestBody UpdateRequest updateRequest, @PathVariable("id") long id) {

    User user= userRepository.findById(id).get();
    user.setUsername(updateRequest.getUsername());
    user.setEmail(updateRequest.getEmail());

    Set<String> strRoles = updateRequest.getRole();
    Set<Role> roles = new HashSet<>();

    if (strRoles == null) {
      Role userRole = roleRepository.findByName(ERole.ROLE_Membre)
              .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
      roles.add(userRole);
    } else {
      strRoles.forEach(role -> {
        switch (role) {

          case "admin":
            Role adminRole = roleRepository.findByName(ERole.ROLE_ADMIN)
                    .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
            roles.add(adminRole);

            break;
          default:
            Role userRole = roleRepository.findByName(ERole.ROLE_Membre)
                    .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
            roles.add(userRole);
        }
      });
    }
    user.setRoles(roles);






    userRepository.save(user);

    return ResponseEntity.ok(new MessageResponse("User updated successfully!"));
  }
  @PostMapping("/uploadImage/{id}")
  public String uploadImage(@PathVariable("id") long id, @RequestParam("file") MultipartFile file) {
    String fileName = fileStorageService.storeImageUser(id, file);

    String fileDownloadUri = ServletUriComponentsBuilder.fromCurrentContextPath()
            .path("/downloadFile/")
            .path(fileName)
            .toUriString();

    return "le fichier a téléchargé avec succès";
  }
}
