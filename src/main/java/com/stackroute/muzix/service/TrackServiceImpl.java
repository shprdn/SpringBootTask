package com.stackroute.muzix.service;

import com.stackroute.muzix.domain.Track;

import com.stackroute.muzix.repository.TrackRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

//service class to perform operations
@Service
public class TrackServiceImpl implements TrackService {
    //creating reference for trackRepository
    private TrackRepository trackRepository;

    @Autowired
    public TrackServiceImpl(TrackRepository trackRepository) {
        this.trackRepository = trackRepository;
    }

    //saveTrack
    @Override
    public Track saveTrack(Track track) {
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
    public void deleteTrack(int id) {
         trackRepository.deleteById(id);
    }

    //update some id
    @Override
    public Track updateTrack(Track track) {
        Track track1 = trackRepository.save(track);
        return track1;
    }
}
