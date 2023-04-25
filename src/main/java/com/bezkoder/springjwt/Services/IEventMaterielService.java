package com.bezkoder.springjwt.Services;


import com.bezkoder.springjwt.payload.request.EventMaterielRequest;
import com.bezkoder.springjwt.payload.response.EventMAtResponse;

import java.util.List;
import java.util.Optional;

public interface IEventMaterielService {

    List<EventMAtResponse> findall(long idevent);
   // Optional<Events_Materiel> findbyId(Long idevent,Long idMateriel);
    void add(EventMaterielRequest v);
    void update (EventMaterielRequest v);
    void delete (Long idevent,Long idMateriel);
}
