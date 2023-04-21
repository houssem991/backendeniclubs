package com.bezkoder.springjwt.services;

import com.bezkoder.springjwt.models.*;
import com.bezkoder.springjwt.payload.response.UserResponse;
import com.bezkoder.springjwt.repository.RoleRepository;
import com.bezkoder.springjwt.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
class UserService implements IUserService {
    @Autowired

    UserRepository userRepository;
    @Autowired

    RoleRepository roleRepository;

    @Override
    public List<UserResponse> findall() {

        List<User> users = userRepository.findAll();
        List<UserResponse> ur = new ArrayList<>();
        users.forEach(val -> {
            val.getRoles().forEach(val1 -> {
                if (val1.getName() == ERole.ROLE_ADMIN || val1.getName() == ERole.ROLE_DRH) {
                    UserResponse u = new UserResponse();
                    u.setId(val.getId());
                    u.setAdresse(val.getAdresse());
                    u.setEmail(val.getEmail());
                    u.setBac(val.getBac());
                    u.setCin(val.getCin());
                    u.setDescription(val.getDescription());
                    u.setDatenaissance(val.getDatenaissance());
                    u.setExperience(val.getExperience());
                    u.setFirstname(val.getFirstname());
                    u.setNiveau(val.getNiveau());
                    u.setHobbies(val.getHobbies());
                    u.setSecondname(val.getSecondname());
                    u.setEtat(val.getEtat());
                    u.setPassword(val.getPassword());
                    u.setUsername(val.getUsername());
                    u.setUserScores(val.getUserScores());
                    u.setReponses(val.getReponses());
                    u.setConcours(val.getConcours());
                    u.setRoles(val.getRoles());
                    u.setCv(val.getCv());
                    u.setImage(val.getImage());
                    ur.add(u);
                }
            });

        });

        return ur;

    }

    @Override
    public List<UserResponse> findallCandidat() {
        List<User> users = userRepository.findAll();
        List<UserResponse> ur = new ArrayList<>();
        users.forEach(val -> {
            val.getRoles().forEach(val1 -> {
                if (val1.getName()==ERole.ROLE_CANDIDATURE) {
                    UserResponse u = new UserResponse();
                    u.setId(val.getId());
                    u.setAdresse(val.getAdresse());
                    u.setEmail(val.getEmail());
                    u.setBac(val.getBac());
                    u.setCin(val.getCin());
                    u.setDescription(val.getDescription());
                    u.setDatenaissance(val.getDatenaissance());
                    u.setExperience(val.getExperience());
                    u.setFirstname(val.getFirstname());
                    u.setNiveau(val.getNiveau());
                    u.setHobbies(val.getHobbies());
                    u.setSecondname(val.getSecondname());
                    u.setEtat(val.getEtat());
                    u.setPassword(val.getPassword());
                    u.setUsername(val.getUsername());
                    u.setUserScores(val.getUserScores());
                    u.setReponses(val.getReponses());
                    u.setConcours(val.getConcours());
                    u.setRoles(val.getRoles());
                    u.setCv(val.getCv());
                    u.setImage(val.getImage());
                    ur.add(u);
                }
            });

        });

        return ur;

    }

    @Override
    public UserResponse findbyId(Long id) {
        User val = userRepository.findById(id).get();
        UserResponse u = new UserResponse();

        u.setId(val.getId());
        u.setAdresse(val.getAdresse());
        u.setEmail(val.getEmail());
        u.setBac(val.getBac());
        u.setCin(val.getCin());
        u.setDescription(val.getDescription());
        u.setDatenaissance(val.getDatenaissance());
        u.setExperience(val.getExperience());
        u.setFirstname(val.getFirstname());
        u.setNiveau(val.getNiveau());
        u.setHobbies(val.getHobbies());
        u.setSecondname(val.getSecondname());
        u.setEtat(val.getEtat());
        u.setPassword(val.getPassword());
        u.setUsername(val.getUsername());
        u.setUserScores(val.getUserScores());
        u.setReponses(val.getReponses());
        u.setConcours(val.getConcours());
        u.setRoles(val.getRoles());
        u.setCv(val.getCv());
        u.setImage(val.getImage());

        return u;
    }

    @Override
    public UserResponse findbyUsername(String username) {
        User val = userRepository.findByUsername(username).get();
        UserResponse u = new UserResponse();
        u.setId(val.getId());
        u.setAdresse(val.getAdresse());
        u.setEmail(val.getEmail());
        u.setBac(val.getBac());
        u.setCin(val.getCin());
        u.setDescription(val.getDescription());
        u.setDatenaissance(val.getDatenaissance());
        u.setExperience(val.getExperience());
        u.setFirstname(val.getFirstname());
        u.setNiveau(val.getNiveau());
        u.setHobbies(val.getHobbies());
        u.setSecondname(val.getSecondname());
        u.setEtat(val.getEtat());
        u.setPassword(val.getPassword());
        u.setUsername(val.getUsername());
        u.setUserScores(val.getUserScores());
        u.setReponses(val.getReponses());
        u.setConcours(val.getConcours());
        u.setRoles(val.getRoles());
        u.setImage(val.getImage());
        u.setCv(val.getCv());
        return u;
    }

    @Override
    public String Validation(Long id) {
        User con = userRepository.findById(id).get();

        if (con.getEtat() == EUser.Bloquer) {
            con.setEtat(EUser.nonbloquer);
            userRepository.save(con);
            return "NON";
        } else {
            con.setEtat(EUser.Bloquer);
            userRepository.save(con);
            return " bloquer";
        }

    }

    @Override
    public void delete(Long id) {
        User user = userRepository.findById(id).get();

        userRepository.delete(user);
    }
}
