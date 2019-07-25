package com.stackroute.muzix.service;

import com.stackroute.muzix.domain.Track;

import com.stackroute.muzix.exceptions.TrackAlreadyExistsException;
import com.stackroute.muzix.exceptions.TrackNotFoundException;
import com.stackroute.muzix.repository.TrackRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

//service class to perform operations
@Service
public class TrackServiceImpl implements TrackService {
    //creating reference for trackRepository
    private TrackRepository trackRepository;
//
//    @Autowired
//    private Track track;
    @Autowired
    public TrackServiceImpl(TrackRepository trackRepository) {
        this.trackRepository = trackRepository;
    }

    //saveTrack
    @Override
    public Track saveTrack(Track track) throws TrackAlreadyExistsException {
        //finding if track exists with getid
        if (trackRepository.existsById(track.getId()))
        {
            throw new TrackAlreadyExistsException("Track already exists...");
        }
        Track savedTrack = trackRepository.save(track);
        return savedTrack;
    }

    //fetch all tracks
    @Override
    public List<Track> getAllTracks() {
        return trackRepository.findAll();

    }

    //delete specific id
    @Override
    public void deleteTrack(int id) throws TrackNotFoundException {
        //if id doesnt exists means track is not there
        if (!trackRepository.existsById(id))
        {
            throw new TrackNotFoundException("Track doesn't exists...");
        }

         trackRepository.deleteById(id);
    }

    //update some id
    @Override
    public Track updateTrack(Track track) {
        Track track1 = trackRepository.save(track);
        return track1;
    }
    //find using name
    @Override
    public Track findByName(String name)
    {
        Track track1 = trackRepository.findUserByName(name);
        return track1;
    }
}
