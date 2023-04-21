package com.bezkoder.springjwt.Services;

import com.bezkoder.springjwt.models.User;


import java.util.List;

public interface IUserService {

    List<User> findall();

    User findbyId(Long id);


    void delete (Long id );
}
