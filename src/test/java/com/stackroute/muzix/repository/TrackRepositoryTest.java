package com.stackroute.muzix.repository;

import com.stackroute.muzix.domain.Track;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@DataMongoTest
public class TrackRepositoryTest {

    @Autowired
    TrackRepository trackRepository;
    Track track;

    //runs before test
    @Before
    public void setUp()
    {
        track = new Track();
        track.setName("Kalank Title Track");
        track.setComment("Arijit Singh");
        //System.out.println(track);
    }

    //runs after every test
    @After
    public void tearDown()
    {
        trackRepository.deleteAll();
    }
    //test case to check for savetrack method
    @Test
    public void testSaveUser(){
        trackRepository.save(track);
        Track fetchUser = trackRepository.findById(track.getId()).get();
        Assert.assertEquals(0,fetchUser.getId());
    }
    //test case to check savetrack method for failure case
    @Test
    public void testSaveUserFailure(){
        Track testUser = new Track("Buddhu sa Mann","Amaal Malik");
        trackRepository.save(track);
        Track fetchUser = trackRepository.findById(track.getId()).get();
        Assert.assertNotSame(testUser,track);
    }
    //test case to check for getAllTracks method
    @Test
    public void testGetAllUser(){
         Track t = new Track(1,"Dil me ho tum","Armaan Malik");
         Track t1 = new Track(2,"suraj dooba hai","Amaal Malik");
        trackRepository.save(t);
        trackRepository.save(t1);

        List<Track> list = trackRepository.findAll();
        Assert.assertEquals("Armaan Malik",list.get(0).getComment());
    }
    //test case to check for updatetrack method
    @Test
    public void testUpdateTrack(){
        trackRepository.save(track);
        Track track1 = new Track(1,"Despacito","Spanish");
        trackRepository.save(track1);
        Assert.assertEquals(track1,trackRepository.findById(track1.getId()).get());
    }
    //test case to check for deletetrack method
    @Test
    public void testDeleteTrack()
    {
        //System.out.println(track.getId());
        Track track1 = new Track(1,"Senorita","jnmd");
        trackRepository.save(track1);
        trackRepository.deleteById(1);
        Assert.assertNull(trackRepository.findById(track.getId()).orElse(null));
    }


}
