package com.moviedb.moviedbapp.services;

import com.moviedb.moviedbapp.entity.Favorite;
import com.moviedb.moviedbapp.entity.User;
import com.moviedb.moviedbapp.entity.Watch;
import com.moviedb.moviedbapp.repos.WatchRepository;
import com.moviedb.moviedbapp.requests.WatchCreateRequest;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class WatchService {

    WatchRepository watchRepository;
    UserService userService;

    public WatchService(WatchRepository watchRepository , UserService userService) {
        this.watchRepository = watchRepository;
        this.userService = userService;
    }
    public List<Watch> getAllWatchs(Optional<Long> userId, Optional<Long> movieId) {
        if (userId.isPresent() && movieId.isPresent()) {
            return watchRepository.findAllByUserIdAndMovieId(userId.get(), movieId.get());
        } else if (userId.isPresent()) {
            return watchRepository.findAllByUserId(userId.get());
        } else if (movieId.isPresent()) {
            return watchRepository.findAllByMovieId(movieId.get());
        }
        return watchRepository.findAll();
    }

    public Watch watchById(Long watchId) {
        return watchRepository.findById(watchId).orElse(null);
    }

    public Watch createWatch(WatchCreateRequest watchCreateRequest) {
        User user = userService.getOneUser(watchCreateRequest.getUserId());

        if (user == null ) {
            return null;
        }
        Watch watchToSave = new Watch();
        watchToSave.setUser(user);
        watchToSave.setMovieId(watchCreateRequest.getMovieId());
        return watchRepository.save(watchToSave);

    }

    public void deleteWatchById(Long favoriteId) {
        Optional<Watch> watch = watchRepository.findById(favoriteId);
        if (watch.isPresent()) {
            watchRepository.deleteById(favoriteId);
        }
    }
}
