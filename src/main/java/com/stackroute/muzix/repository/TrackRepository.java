package com.stackroute.muzix.repository;

import com.stackroute.muzix.domain.Track;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.List;


//repository for track which extends JpaRepository
@Repository
public interface TrackRepository extends JpaRepository<Track, Integer> {

    @Query("SELECT u FROM Track u WHERE u.name = ?1")
    Track findUserByName(String name);
}
