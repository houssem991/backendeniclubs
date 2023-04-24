package com.bezkoder.springjwt.Services;


import com.bezkoder.springjwt.models.Events;

import com.bezkoder.springjwt.payload.request.EventsRequest;


import java.util.List;

public interface IEventsService {

    List<Events> findall();
    Events findbyId(Long id);
    void add(EventsRequest v);
    void update (Long id,EventsRequest v);
    void delete (Long id);
    String sendacceptation(long iduser, long idevent) throws Exception;
    String sendRefus(long iduser, long idevent) throws Exception;
}