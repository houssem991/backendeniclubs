package com.bezkoder.springjwt.Services;

import com.bezkoder.springjwt.models.User;
import com.bezkoder.springjwt.payload.response.UserResponse;


import java.util.List;

public interface IUserService {

    List<User> findall();

    User findbyId(Long id);
    UserResponse findbyUsername(String username);


    void delete (Long id );
}
