package com.stackroute.muzix.service;

import com.stackroute.muzix.domain.Track;
import com.stackroute.muzix.exceptions.TrackAlreadyExistsException;
import com.stackroute.muzix.exceptions.TrackNotFoundException;
import com.stackroute.muzix.repository.TrackRepository;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;
import static org.mockito.Mockito.when;

public class TrackServiceTest {

    Track track;

    //Create a mock for trackRepository
    @Mock
    TrackRepository trackRepository;

    //Inject the mocks as dependencies into trackServiceImpl
    @InjectMocks
    TrackServiceImpl trackService;
    List<Track> list= null;


    @Before
    public void setUp(){
        //Initialising the mock object
        MockitoAnnotations.initMocks(this);
        track = new Track();
       //track.setId(100);
        track.setName("inkem inkem kavale challe idi challe");
        track.setComment("telugu song");
//        track.setName("chale aana");
//        track.setComment("hindi song");
        list = new ArrayList<>();
        list.add(track);

        System.out.println(list);
    }

    //test case to check for savetrack method
    @Test
    public void saveTrackTestSuccess() throws TrackAlreadyExistsException {

        when(trackRepository.save((Track)any())).thenReturn(track);
        Track savedUser = trackService.saveTrack(track);
        Assert.assertEquals(track,savedUser);

        //verify here verifies that userRepository save method is only called once
        verify(trackRepository,times(1)).save(track);

    }
    //test case to check for savetrack method for failure case
    @Test(expected = TrackAlreadyExistsException.class)
    public void saveUserTestFailure() throws TrackAlreadyExistsException {
        when(trackRepository.save((Track) any())).thenReturn(null);
        Track savedUser = trackService.saveTrack(track);
        System.out.println("savedTrack" + savedUser);
        //Assert.assertEquals(user,savedUser);

       /*doThrow(new UserAlreadyExistException()).when(userRepository).findById(eq(101));
       userService.saveUser(user);*/


    }
    //test case to check for getAllTracks method
    @Test
    public void getAllTrack(){

        trackRepository.save(track);
        //stubbing the mock to return specific data
        when(trackRepository.findAll()).thenReturn(list);
        List<Track> userlist = trackService.getAllTracks();
        Assert.assertEquals(list,userlist);
    }
    //test case to check for updatetrack method
    @Test
    public void updateTrackSuccessTest()
    {
        when(trackRepository.save((Track)any())).thenReturn(track);
        Track savedUser = trackService.updateTrack(track);
        Assert.assertEquals(track,savedUser);

        //verify here verifies that userRepository save method is only called once
        verify(trackRepository,times(1)).save(track);
    }
    //test case to check for deletetrack method
    @Test
    public void deleteTrackSuccessTest() throws Exception{
       // when(trackRepository.findById(anyInt())).thenReturn(java.util.Optional.ofNullable(track));
         when(trackRepository.existsById(anyInt())).thenReturn(true);
                trackService.deleteTrack(track.getId());
        verify(trackRepository,times(1)).deleteById(track.getId());

    }



}
