package com.stackroute.muzix.service;

import com.stackroute.muzix.domain.Track;
import com.stackroute.muzix.exceptions.TrackAlreadyExistsException;
import com.stackroute.muzix.exceptions.TrackNotFoundException;
import org.springframework.http.ResponseEntity;

import java.util.List;


public interface TrackService {

    //methods for performing crud operation on track class
    //creation
    //throws TrackAlreadyExists exception
    public Track saveTrack(Track track) throws TrackAlreadyExistsException;

    //retrieve
    public List<Track> getAllTracks();

    //deletion
    //throws TrackNotFound Exception
    public void deleteTrack(int id) throws TrackNotFoundException;

    //update
    public Track updateTrack(Track track);

    //find by name
    Track findByName(String name) ;

    //list the top tracks of last.fm
    void getTopTracks();

    Track getTrackById(int id);




}
