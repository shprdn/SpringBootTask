package com.stackroute.muzix.controller;

import com.stackroute.muzix.domain.Track;
import com.stackroute.muzix.exceptions.TrackAlreadyExistsException;
import com.stackroute.muzix.exceptions.TrackNotFoundException;
import com.stackroute.muzix.service.TrackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;


@RestController
@RequestMapping(value = "api/v1")
public class TrackController {

    //update all the methods with code

    private TrackService trackService;

    //arg constructor
    @Autowired
    public TrackController(TrackService trackService)
    {
        this.trackService = trackService;
    }
    //mapping done for saving the track to the database
    @PostMapping("track")
    public ResponseEntity<?> saveTrack(@RequestBody Track track) throws TrackAlreadyExistsException
    {
        ResponseEntity responseEntity;
        //exception handling using global exception
         trackService.saveTrack(track);
            responseEntity = new ResponseEntity<String>("successfully created", HttpStatus.CREATED);
            return responseEntity;
    }
    //mapping done for fetching all tracks
    @GetMapping("track")
    public ResponseEntity<?> getAllTrack()
    {
        return new ResponseEntity<List<Track>>(trackService.getAllTracks(), HttpStatus.OK);
    }

    //mapping done for deleting a specific id from the database
    @DeleteMapping("track/{id}")
    public ResponseEntity<?> deleteEntity(@PathVariable int id) throws TrackNotFoundException
    {
        //exception handling using global exception
        ResponseEntity responseEntity;
            trackService.deleteTrack(id);
            responseEntity = new ResponseEntity<String>("successfully deleted", HttpStatus.OK);

        return responseEntity;
    }

    //updating database based on specific id
    @PostMapping("track/{id}")
    public ResponseEntity<?> updateEntity(@RequestBody Track track)
    {
        ResponseEntity responseEntity;
        trackService.updateTrack(track);
        responseEntity = new ResponseEntity("successfully updated",HttpStatus.OK);
        return responseEntity;
    }

    //getting track by name
    @GetMapping("track/{name}")
    public ResponseEntity<?> queryList(@PathVariable String name)
    {
        ResponseEntity responseEntity;
        try
        {
            return new ResponseEntity<>(trackService.findByName(name), HttpStatus.OK);
        }
        catch (Exception e)
        {
            return new ResponseEntity(e.getMessage(),HttpStatus.CONFLICT);
        }

    }
    //fetching all top tracks
    @GetMapping("track/muzix")
    public ResponseEntity<?> getAllTrackFromLastFm()
    {
        trackService.getTopTracks();
        return new ResponseEntity<>("fetched.....", HttpStatus.OK);
    }
}
