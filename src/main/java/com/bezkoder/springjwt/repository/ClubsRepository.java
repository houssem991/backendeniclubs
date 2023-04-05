package com.bezkoder.springjwt.repository;

import com.bezkoder.springjwt.models.Clubs;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClubsRepository extends JpaRepository<Clubs, Long> {
}
