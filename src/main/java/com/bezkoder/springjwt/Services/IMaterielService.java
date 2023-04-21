package com.bezkoder.springjwt.Services;




import com.bezkoder.springjwt.models.Clubs;

import com.bezkoder.springjwt.payload.request.ClubsRequest;

import java.util.List;

public interface IClubService {

    List<Clubs> findall();
    Clubs findbyId(Long id);
    void add(ClubsRequest v);
    void update (Long id , ClubsRequest v);
    void delete (Long id);
}
