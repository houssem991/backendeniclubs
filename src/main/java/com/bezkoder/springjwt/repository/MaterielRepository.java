package com.bezkoder.springjwt.repository;

import com.bezkoder.springjwt.models.Clubs;
import com.bezkoder.springjwt.models.Materiel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface MaterielRepository extends JpaRepository<Materiel, Long> {
    Optional<Materiel> findByName(String name);
}
