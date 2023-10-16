package com.moviedb.moviedbapp.repos;

import com.moviedb.moviedbapp.entity.Favorite;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface FavoriteRepository extends JpaRepository<Favorite, Long> {
    List<Favorite> findAllByUserIdAndMovieId(Long aLong, Long aLong1);

    List<Favorite> findAllByUserId(Long aLong);

    List<Favorite> findAllByMovieId(Long aLong);
}
