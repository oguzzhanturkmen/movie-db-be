package com.moviedb.moviedbapp.repos;

import com.moviedb.moviedbapp.entity.Watch;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface WatchRepository extends JpaRepository<Watch, Long> {
    List<Watch> findAllByUserIdAndMovieId(Long aLong, Long aLong1);

    List<Watch> findAllByUserId(Long aLong);

    List<Watch> findAllByMovieId(Long aLong);
}
