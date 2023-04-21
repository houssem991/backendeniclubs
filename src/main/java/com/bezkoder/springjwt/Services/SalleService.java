package com.bezkoder.springjwt.Services;


import com.bezkoder.springjwt.models.Salle;
import com.bezkoder.springjwt.payload.request.SalleRequest;
import com.bezkoder.springjwt.repository.SalleRepository;
import com.bezkoder.springjwt.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class SalleService implements ISalleService {
    
    @Autowired
    SalleRepository salleRepository;
    @Autowired
    UserRepository userRepository;
    

    @Override
    public List<Salle> findall() {
        return salleRepository.findAll();
    }

    @Override
    public Salle findbyId(Long id) {
        return (Salle) salleRepository.findById(id).get();
    }




    @Override
    public void add(SalleRequest v) {
        Salle salle = new Salle();
       salle.setName(v.getName());
    salle.setLocal(v.getLocal());
        salleRepository.save(salle);

    }

    @Override
    public void update(Long id, SalleRequest v) {
        Salle salle = salleRepository.findById(id).get();
        salle.setName(v.getName());
        salle.setLocal(v.getLocal());
        salleRepository.save(salle);
    }

    @Override
    public void delete(Long id) {
        Salle salle = salleRepository.findById(id).get();

        salleRepository.delete(salle);
    }


}
