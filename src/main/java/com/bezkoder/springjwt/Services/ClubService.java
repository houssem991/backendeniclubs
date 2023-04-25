package com.bezkoder.springjwt.Services;


import com.bezkoder.springjwt.models.Clubs;
import com.bezkoder.springjwt.models.Clubs;
import com.bezkoder.springjwt.models.ERole;
import com.bezkoder.springjwt.models.User;
import com.bezkoder.springjwt.payload.request.ClubsRequest;
import com.bezkoder.springjwt.payload.response.ClubsResponse;
import com.bezkoder.springjwt.repository.ClubsRepository;
import com.bezkoder.springjwt.repository.ClubsRepository;
import com.bezkoder.springjwt.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
public class ClubService implements IClubService {
    
    @Autowired
    ClubsRepository clubsRepository;
    @Autowired
    UserRepository userRepository;
    

    @Override
    public List<ClubsResponse> findall() {
       List<Clubs>  c =clubsRepository.findAll();
       List<ClubsResponse> cc=new ArrayList<>();
       c.forEach(val->{
           ClubsResponse ccc = new ClubsResponse();
           ccc.setId(val.getId());
           ccc.setName(val.getName());
           ccc.setImage(val.getImage());
           ccc.setNbmembers(val.getNbmembers());
           ccc.setNameresp(val.getUser().getUsername());
           cc.add(ccc);
           });


        return cc;
    }
    @Override
    public List<User> findresp() {
        List<User> resp =  userRepository.findallresp();


        return resp;
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
