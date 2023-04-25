package com.bezkoder.springjwt.Services;


import com.bezkoder.springjwt.models.*;
import com.bezkoder.springjwt.payload.request.EventsRequest;
import com.bezkoder.springjwt.payload.response.EventsResponse;
import com.bezkoder.springjwt.payload.response.UserResponse;
import com.bezkoder.springjwt.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
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
    MaterielRepository materielRepository;
    @Autowired
    EmailSenderService emailSenderService;
    @Autowired
    IUserService iUserService;
    

    @Override
    public List<EventsResponse> findallenattente() {
        List<Events> events=eventsRepository.findAll();
        List<EventsResponse> e2 =new ArrayList<>();
        events.forEach(val->{
            if(val.getEtat()==EEvent.EnAttente){
            EventsResponse e1=new EventsResponse();
            Set<String> s = new HashSet<>();
                Set<String> m = new HashSet<>();
            e1.setId(val.getId());
            val.getMateriels().forEach(val3->{
                m.add(val3.getName());
            });
            e1.setHeure(val.getHeure());
            e1.setDate(val.getDate());
            e1.setEtat(val.getEtat());
            e1.setDescription(val.getDescription());
            e1.setName(val.getName());
            val.getClubs().forEach(val1->{
                s.add(val1.getUser().getUsername());
            });
            e1.setNamerespclubs(s);
            e1.setNamesalle(val.getSalle().getName());
            e2.add(e1);}
        });
        return e2;
    }

    @Override
    public List<EventsResponse> findallRepondu() {
        List<Events> events=eventsRepository.findAll();
        List<EventsResponse> e2 =new ArrayList<>();
        events.forEach(val->{
            if(val.getEtat()==EEvent.Confirmee|| val.getEtat()==EEvent.Refusee){
                EventsResponse e1=new EventsResponse();
                Set<String> s = new HashSet<>();
                Set<String> m = new HashSet<>();
                e1.setId(val.getId());
                val.getMateriels().forEach(val3->{
                    m.add(val3.getName());
                });
                e1.setHeure(val.getHeure());
                e1.setDate(val.getDate());
                e1.setEtat(val.getEtat());
                e1.setDescription(val.getDescription());
                e1.setName(val.getName());
                val.getClubs().forEach(val1->{
                    s.add(val1.getUser().getUsername());
                });
                e1.setNamerespclubs(s);
                e1.setNamesalle(val.getSalle().getName());
                e2.add(e1);}
        });
        return e2;
    }

    @Override
    public List<EventsResponse> findallnonvalide(String username) {
        List<Events> events=eventsRepository.findAll();
        UserResponse u = iUserService.findbyUsername(username);
        List<EventsResponse> e2 =new ArrayList<>();
        events.forEach(val->{
            val.getClubs().forEach(val1->{
                if( val1.getId()==u.getIdclub()){
                    EventsResponse e1=new EventsResponse();
                    Set<String> s = new HashSet<>();
                    Set<String> m = new HashSet<>();
                    e1.setId(val.getId());
                    val.getMateriels().forEach(val3->{
                        m.add(val3.getName());
                    });
                    e1.setHeure(val.getHeure());
                    e1.setDate(val.getDate());
                    e1.setEtat(val.getEtat());
                    e1.setDescription(val.getDescription());
                    e1.setName(val.getName());
                    val.getClubs().forEach(val2->{
                        s.add(val2.getUser().getUsername());
                    });
                    e1.setNamerespclubs(s);
                    e1.setNamesalle(val.getSalle().getName());
                    e2.add(e1);}
            });

        });
        return e2;
    }

    @Override
    public EventsResponse findbyId(Long id) {

         Events e = eventsRepository.findById(id).get();
         EventsResponse e1=new EventsResponse();
         Set<String> s = new HashSet<>();
        Set<String> m = new HashSet<>();
         e1.setId(e.getId());
        e.getMateriels().forEach(val3->{
            m.add(val3.getName());
        });
        e1.setHeure(e.getHeure());
         e1.setDate(e.getDate());
         e1.setEtat(e.getEtat());
         e1.setDescription(e.getDescription());
         e1.setName(e.getName());
         e.getClubs().forEach(val->{
             s.add(val.getUser().getUsername());
         });
         e1.setNamerespclubs(s);
         e1.setNamesalle(e.getSalle().getName());
         return e1;
    }




    @Override
    public void add(EventsRequest v) {
        Events event = new Events();
        event.setName(v.getName());
        event.setDate(v.getDate());
        event.setDescription(v.getDescription());
        event.setEtat(EEvent.EnAttente);
        Set<Clubs> clubs= new HashSet<>();
        Set<Materiel> matt =new HashSet<>();
        v.getNameClubs().forEach(club->{
            Clubs c = clubsRepository.findByName(club).get();
            clubs.add(c);
        });
        v.getNameMateriels().forEach( mat->{
            Materiel m = materielRepository.findByName(mat).get();
            matt.add(m);

        });
        event.setHeure(v.getHeure());
        event.setMateriels(matt);
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
       v.getNameMateriels().forEach(mat->{
           Materiel m = materielRepository.findByName(mat).get();
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
    public String sendacceptation(String iduser, long idevent) throws Exception {
        User user = userRepository.findByUsername(iduser).get();
        Events event = eventsRepository.findById(idevent).get();

        event.setEtat(EEvent.Confirmee);

       eventsRepository.save(event);
        emailSenderService.sendAcceptation(user.getEmail(),event.getName(),user.getUsername(),user.getClub().getName());


        return "accepter";
    }
    @Override
    public String sendRefus(String iduser,long idevent) throws Exception {
        User user = userRepository.findByUsername(iduser).get();
        Events event = eventsRepository.findById(idevent).get();

        event.setEtat(EEvent.Refusee);

        eventsRepository.save(event);
        emailSenderService.sendRefus(user.getEmail(),event.getName(),user.getUsername(),user.getClub().getName());


        return "Refuse";
    }


}
