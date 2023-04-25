package com.bezkoder.springjwt.Services;




import com.bezkoder.springjwt.models.Clubs;

import com.bezkoder.springjwt.models.User;
import com.bezkoder.springjwt.payload.request.ClubsRequest;
import com.bezkoder.springjwt.payload.response.ClubsResponse;

import java.util.List;

public interface IClubService {

    List<ClubsResponse> findall();
    List<User> findresp();
    Clubs findbyId(Long id);
    void add(ClubsRequest v);
    void update (Long id , ClubsRequest v);
    void delete (Long id);
}
