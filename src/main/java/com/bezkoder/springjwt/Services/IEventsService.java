package com.bezkoder.springjwt.Services;



import com.bezkoder.springjwt.payload.request.EventsRequest;
import com.bezkoder.springjwt.payload.response.EventsResponse;


import java.util.List;

public interface IEventsService {

    List<EventsResponse> findallenattente();
    List<EventsResponse> findallRepondu();
    List<EventsResponse> findallnonvalide(String username);


    EventsResponse findbyId(Long id);
    void add(EventsRequest v);
    void update (Long id,EventsRequest v);
    void delete (Long id);
    String sendacceptation(String nameuser, long idevent) throws Exception;
    String sendRefus(String nameuser, long idevent) throws Exception;
}