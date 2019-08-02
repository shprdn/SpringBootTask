package com.stackroute.muzix.service;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.stackroute.muzix.domain.Track;

import com.stackroute.muzix.exceptions.TrackAlreadyExistsException;
import com.stackroute.muzix.exceptions.TrackNotFoundException;
import com.stackroute.muzix.repository.TrackRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
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
        if (savedTrack == null)
            throw new TrackAlreadyExistsException("Track already exists...");
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

    @Override
    public void getTopTracks() {
        RestTemplate restTemplate = new RestTemplate();
        //url to fetch toptracks
        final String url = "http://ws.audioscrobbler.com/2.0/?method=chart.gettoptracks" +
                "&api_key=5d12be3fbcc48de1fbb0a09cb61683dd&format=json";
        ResponseEntity<String> result = restTemplate.getForEntity(url, String.class);
        ObjectMapper objectMapper = new ObjectMapper();
        Track track = new Track();
        JsonNode jsonNode = null;

        try
        {
            jsonNode = objectMapper.readTree(result.getBody());
            ArrayNode arrayNode = (ArrayNode)(jsonNode.path("tracks").path("track"));
            for (int i=0;i<=arrayNode.size()-1;i++)
            {
                //setting the name of the track
                track.setName(arrayNode.get(i).path("name").asText());
                //setting the artist's name to comment
                track.setComment(arrayNode.get(i).path("artist").path("name").asText());
                trackRepository.save(track);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }


    }

    @Override
    public Track getTrackById(int id) {
        return trackRepository.findById(id).orElse(null);
    }


}
