package com.stackroute.muzix.service;

import com.stackroute.muzix.domain.Track;

import java.util.List;


public interface TrackService {

    //methods for performing crud operation on track class
    //creation
    public Track saveTrack(Track track);

    //retrieve
    public List<Track> getAllTracks();

    //deletion
    public void deleteTrack(int id);

    //update
    public Track updateTrack(Track track);

    //find by name
    Track findByName(String name);

}
