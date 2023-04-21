package com.bezkoder.springjwt.repository;

import com.bezkoder.springjwt.models.Events_Materiel;
import com.bezkoder.springjwt.models.Events_MaterielId;
import com.bezkoder.springjwt.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface EventMaterielRepository extends JpaRepository<Events_Materiel, Events_MaterielId> {

}
