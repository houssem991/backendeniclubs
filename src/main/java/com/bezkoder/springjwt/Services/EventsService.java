package com.bezkoder.springjwt.Services;


import com.bezkoder.springjwt.models.*;
import com.bezkoder.springjwt.payload.request.EventsRequest;
import com.bezkoder.springjwt.repository.ClubsRepository;
import com.bezkoder.springjwt.repository.EventsRepository;
import com.bezkoder.springjwt.repository.SalleRepository;
import com.bezkoder.springjwt.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;


@Service
public class EventsService implements IEventsService {
    
    @Autowired
    EventsRepository eventsRepository;
    @Autowired
    ClubsRepository clubsRepository;
    @Autowired
    SalleRepository salleRepository;
    @Autowired
    UserRepository userRepository;
    @Autowired
    EmailSenderService emailSenderService;
    

    @Override
    public List<Events> findall() {
        return eventsRepository.findAll();
    }

    @Override
    public Events findbyId(Long id) {
        return (Events) eventsRepository.findById(id).get();
    }




    @Override
    public void add(EventsRequest v) {
        Events event = new Events();
       event.setName(v.getName());
    event.setDate(v.getDate());
    event.setDescription(v.getDescription());
    event.setEtat(EEvent.EnAttente);
        Set<Clubs> clubs= new HashSet<>();
        v.getNameClubs().forEach(club->{
            Clubs c = clubsRepository.findByName(club).get();
            clubs.add(c);
        });
        event.setClubs(clubs);
        event.setSalle(salleRepository.findById(v.getIdsalle()).get());
        eventsRepository.save(event);

    }

    @Override
    public void update(Long id, EventsRequest v) {
        Events event =eventsRepository.findById(id).get();
        event.setName(v.getName());
        event.setDate(v.getDate());
        event.setDescription(v.getDescription());
        event.setEtat(EEvent.EnAttente);
        Set<Clubs> clubs= new HashSet<>();
        v.getNameClubs().forEach(club->{
            Clubs c = clubsRepository.findByName(club).get();
            clubs.add(c);
        });
        event.setClubs(clubs);
        event.setSalle(salleRepository.findById(v.getIdsalle()).get());
        eventsRepository.save(event);
    }

    @Override
    public void delete(Long id) {
        Events event =eventsRepository.findById(id).get();

        eventsRepository.delete(event);
    }
    @Override
    public String sendacceptation(long iduser, long idevent) throws Exception {
        User user = userRepository.findById(iduser).get();
        Events event = eventsRepository.findById(idevent).get();

        event.setEtat(EEvent.Confirmee);

       eventsRepository.save(event);
        emailSenderService.sendAcceptation(user.getEmail(),event.getName(),user.getUsername(),user.getClub().getName());


        return "accepter";
    }
    @Override
    public String sendRefus(long iduser,long idevent) throws Exception {
        User user = userRepository.findById(iduser).get();
        Events event = eventsRepository.findById(idevent).get();

        event.setEtat(EEvent.Refusee);

        eventsRepository.save(event);
        emailSenderService.sendRefus(user.getEmail(),event.getName(),user.getUsername(),user.getClub().getName());


        return "Refuse";
    }


}
