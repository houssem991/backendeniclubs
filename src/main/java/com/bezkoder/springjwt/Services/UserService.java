package com.bezkoder.springjwt.Services;


import com.bezkoder.springjwt.models.User;

import com.bezkoder.springjwt.repository.RoleRepository;
import com.bezkoder.springjwt.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;

@Service
class UserService implements IUserService {
    @Autowired

    UserRepository userRepository;
    @Autowired

    RoleRepository roleRepository;

    @Override
    public List<User> findall() {

        List<User> users = userRepository.findAll();

        return users;

    }



    @Override
    public User findbyId(Long id) {
        User val = userRepository.findById(id).get();

        return val;
    }





    @Override
    public void delete(Long id) {
        User user = userRepository.findById(id).get();

        userRepository.delete(user);
    }
}
