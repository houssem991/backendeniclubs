package com.bezkoder.springjwt.Services;



import com.bezkoder.springjwt.models.Materiel;
import com.bezkoder.springjwt.payload.request.MaterielRequest;
import com.bezkoder.springjwt.repository.MaterielRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class MaterielService implements IMaterielService {
    
    @Autowired
    MaterielRepository materielRepository;
    

    @Override
    public List<Materiel> findall() {
        return materielRepository.findAll();
    }

    @Override
    public Materiel findbyId(Long id) {
        return (Materiel) materielRepository.findById(id).get();
    }




    @Override
    public void add(MaterielRequest v) {
        Materiel Materiel = new Materiel();
       Materiel.setName(v.getName());
       Materiel.setQuantite(v.getQuantite());
        materielRepository.save(Materiel);

    }

    @Override
    public void update(Long id, MaterielRequest v) {
        Materiel Materiel = materielRepository.findById(id).get();
        Materiel.setName(v.getName());
        Materiel.setQuantite(v.getQuantite());
        materielRepository.save(Materiel);
    }

    @Override
    public void delete(Long id) {
        Materiel Materiel = materielRepository.findById(id).get();

        materielRepository.delete(Materiel);
    }


}
