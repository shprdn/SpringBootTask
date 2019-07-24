package com.stackroute.muzix.repository;

import com.stackroute.muzix.domain.Track;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


//repository for track which extends JpaRepository
@Repository
public interface TrackRepository extends JpaRepository<Track, Integer> {
}
