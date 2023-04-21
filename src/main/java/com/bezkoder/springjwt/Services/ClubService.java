package com.bezkoder.springjwt.Services;


import com.bezkoder.springjwt.models.Clubs;
import com.bezkoder.springjwt.models.Clubs;
import com.bezkoder.springjwt.payload.request.ClubsRequest;
import com.bezkoder.springjwt.repository.ClubsRepository;
import com.bezkoder.springjwt.repository.ClubsRepository;
import com.bezkoder.springjwt.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class ClubService implements IClubService {
    
    @Autowired
    ClubsRepository clubsRepository;
    @Autowired
    UserRepository userRepository;
    

    @Override
    public List<Clubs> findall() {
        return clubsRepository.findAll();
    }

    @Override
    public Clubs findbyId(Long id) {
        return (Clubs) clubsRepository.findById(id).get();
    }




    @Override
    public void add(ClubsRequest v) {
        Clubs clubs = new Clubs();
       clubs.setName(v.getName());
       clubs.setNbmembers(v.getNbmembers());
       clubs.setUser(userRepository.findById(v.getIdresp()).get());
        clubsRepository.save(clubs);

    }

    @Override
    public void update(Long id, ClubsRequest v) {
        Clubs clubs = clubsRepository.findById(id).get();
        clubs.setName(v.getName());
        clubs.setNbmembers(v.getNbmembers());
        clubs.setUser(userRepository.findById(v.getIdresp()).get());
        clubsRepository.save(clubs);
    }

    @Override
    public void delete(Long id) {
        Clubs Clubs = clubsRepository.findById(id).get();

        clubsRepository.delete(Clubs);
    }


}
