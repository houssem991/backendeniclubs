package com.bezkoder.springjwt.Services;


import com.bezkoder.springjwt.models.Events_Materiel;
import com.bezkoder.springjwt.models.Materiel;
import com.bezkoder.springjwt.payload.request.EventMaterielRequest;
import com.bezkoder.springjwt.payload.request.MaterielRequest;

import java.util.List;
import java.util.Optional;

public interface IEventMaterielService {

    List<Events_Materiel> findall();
    Optional<Events_Materiel> findbyId(Long idevent,Long idMateriel);
    void add(EventMaterielRequest v);
    void update (EventMaterielRequest v);
    void delete (Long idevent,Long idMateriel);
}
