package com.bezkoder.springjwt.repository;


import com.bezkoder.springjwt.models.Salle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface SalleRepository extends JpaRepository<Salle, Long> {
}
