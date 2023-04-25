package com.bezkoder.springjwt.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.bezkoder.springjwt.models.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
  Optional<User> findByUsername(String username);
  Optional<User> findByEmail(String email);
  Boolean existsByUsername(String username);

  Boolean existsByEmail(String email);
  @Query("SELECT u FROM User u " +
          "JOIN FETCH u.roles r " +
          "LEFT JOIN FETCH u.clubs c " +
          "WHERE r.name = 'ROLE_RESPONSABLE_CLUB' " +
          "AND (c IS NULL OR u NOT IN (SELECT cu.user FROM Clubs cu))")
  List<User> findallresp();
  @Query("SELECT u FROM User u " +
          "JOIN FETCH u.roles r " +
          "WHERE r.name = 'ROLE_ADMIN' " )
  List<User> admin();
}
