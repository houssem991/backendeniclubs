package com.bezkoder.springjwt.Services;


import com.bezkoder.springjwt.models.Clubs;
import com.bezkoder.springjwt.models.Materiel;
import com.bezkoder.springjwt.payload.request.ClubsRequest;
import com.bezkoder.springjwt.payload.request.MaterielRequest;

import java.util.List;

public interface IMaterielService {

    List<Materiel> findall();
    Materiel findbyId(Long id);
    void add(MaterielRequest v);
    void update (Long id , MaterielRequest v);
    void delete (Long id);
}
