package com.bezkoder.springjwt.Services;




import com.bezkoder.springjwt.models.Events_Materiel;
import com.bezkoder.springjwt.models.Events_MaterielId;

import com.bezkoder.springjwt.payload.request.EventMaterielRequest;

import com.bezkoder.springjwt.repository.EventMaterielRepository;
import com.bezkoder.springjwt.repository.EventsRepository;
import com.bezkoder.springjwt.repository.MaterielRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.Optional;


@Service
public class EventMaterielService implements IEventMaterielService {
    
    @Autowired
    EventMaterielRepository eventMaterielRepository;
    @Autowired
    EventsRepository eventsRepository;
    @Autowired
    MaterielRepository materielRepository;
    

    @Override
    public List<Events_Materiel> findall() {
        return eventMaterielRepository.findAll();
    }

    @Override
    public Optional<Events_Materiel> findbyId(Long idevent,Long idMateriel) {

        Events_MaterielId events_materielId=new Events_MaterielId(idevent,idMateriel);
        return  eventMaterielRepository.findById(events_materielId);
    }




    @Override
    public void add(EventMaterielRequest v) {

        Events_MaterielId events_materielId=new Events_MaterielId(v.getIdevent(),v.getIdmateriel());
        Events_Materiel events_materiel = new Events_Materiel();
        events_materiel.setId(events_materielId);
        events_materiel.setQuantite(v.getQuantite());
        eventMaterielRepository.save(events_materiel);

    }

    @Override
    public void update(Long id, EventMaterielRequest v) {

        Events_MaterielId events_materielId=new Events_MaterielId(v.getIdevent(),v.getIdmateriel());
        Events_Materiel events_materiel= eventMaterielRepository.findById(events_materielId).get();
        events_materiel.setId(events_materielId);
        events_materiel.setQuantite(v.getQuantite());
        eventMaterielRepository.save(events_materiel);
    }

    @Override
    public void delete(Long idevent,Long idMateriel) {

        Events_MaterielId events_materielId=new Events_MaterielId(idevent,idMateriel);
        Events_Materiel events_materiel= eventMaterielRepository.findById(events_materielId).get();

        eventMaterielRepository.delete(events_materiel);
    }


}
