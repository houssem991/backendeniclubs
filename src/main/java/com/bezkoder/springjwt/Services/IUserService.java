package com.bezkoder.springjwt.services;

import com.bezkoder.springjwt.payload.response.UserResponse;

import java.util.List;

public interface IUserService {

    List<UserResponse> findall();
    List<UserResponse> findallCandidat();

    UserResponse findbyId(Long id);
    UserResponse findbyUsername(String username);
  String Validation(Long id);
    void delete (Long id );
}
