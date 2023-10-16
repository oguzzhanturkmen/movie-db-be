package com.moviedb.moviedbapp.controllers;

import com.moviedb.moviedbapp.entity.Favorite;
import com.moviedb.moviedbapp.requests.FavoriteCreateRequest;
import com.moviedb.moviedbapp.services.FavoriteService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/favorites")
public class FavoriteController {

    FavoriteService favoriteService;

    public FavoriteController(FavoriteService favoriteService) {
        this.favoriteService = favoriteService;
    }

    @GetMapping
    public List<Favorite> getAllLikes(@PathVariable Optional<Long> userId , @PathVariable Optional <Long> movieId) {
        return favoriteService.getAllLikes(userId , movieId);
    }
    @GetMapping("/{favoriteId}")
    public Favorite getLikeById(@PathVariable Long favoriteId) {
        return favoriteService.favoriteById(favoriteId);

    }
    @PostMapping
    public Favorite createLike(@RequestBody FavoriteCreateRequest favoriteCreateRequest) {
        return favoriteService.createFavorite(favoriteCreateRequest);
    }
    @DeleteMapping("/{favoriteId}")
    public void deleteLikeById(@PathVariable Long favoriteId) {
        favoriteService.deleteFavoriteById(favoriteId);
    }
}


