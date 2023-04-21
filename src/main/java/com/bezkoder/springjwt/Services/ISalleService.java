package com.bezkoder.springjwt.Services;


import com.bezkoder.springjwt.models.Clubs;
import com.bezkoder.springjwt.models.Salle;
import com.bezkoder.springjwt.payload.request.ClubsRequest;
import com.bezkoder.springjwt.payload.request.SalleRequest;

import java.util.List;

public interface ISalleService {

    List<Salle> findall();
    Salle findbyId(Long id);
    void add(SalleRequest v);
    void update (Long id , SalleRequest v);
    void delete (Long id);
}
