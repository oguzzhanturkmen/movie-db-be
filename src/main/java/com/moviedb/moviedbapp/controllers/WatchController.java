package com.moviedb.moviedbapp.controllers;

import com.moviedb.moviedbapp.entity.Watch;
import com.moviedb.moviedbapp.requests.WatchCreateRequest;
import com.moviedb.moviedbapp.services.WatchService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/watchlist")
public class WatchController {
    WatchService watchService;

    public WatchController(WatchService watchService) {
        this.watchService = watchService;
    }

    @GetMapping
    public List<Watch> getAllWatchs(@PathVariable Optional<Long> userId , @PathVariable Optional <Long> movieId) {
        return watchService.getAllWatchs(userId , movieId);
    }
    @GetMapping("/{favoriteId}")
    public Watch getWatchById(@PathVariable Long watchId){
        return watchService.watchById(watchId);

    }
    @PostMapping
    public Watch createWatch(@RequestBody WatchCreateRequest watchCreateRequest) {
        return watchService.createWatch(watchCreateRequest);

    }
    @DeleteMapping("/{likeId}")
    public void deleteWatchById(@PathVariable Long favoriteId) {
        watchService.deleteWatchById(favoriteId);
    }
}

