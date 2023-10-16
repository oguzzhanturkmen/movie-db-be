package com.moviedb.moviedbapp.services;

import com.moviedb.moviedbapp.entity.Comment;
import com.moviedb.moviedbapp.entity.Favorite;
import com.moviedb.moviedbapp.entity.User;
import com.moviedb.moviedbapp.repos.FavoriteRepository;
import com.moviedb.moviedbapp.requests.FavoriteCreateRequest;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FavoriteService {

    FavoriteRepository favoriteRepository;
    UserService userService;

    public FavoriteService(FavoriteRepository favoriteRepository , UserService userService) {
        this.favoriteRepository = favoriteRepository;
        this.userService = userService;
    }
    public List<Favorite> getAllLikes(Optional<Long> userId, Optional<Long> movieId) {
        if (userId.isPresent() && movieId.isPresent()) {
            return favoriteRepository.findAllByUserIdAndMovieId(userId.get(), movieId.get());
        } else if (userId.isPresent()) {
            return favoriteRepository.findAllByUserId(userId.get());
        } else if (movieId.isPresent()) {
            return favoriteRepository.findAllByMovieId(movieId.get());
        }
        return favoriteRepository.findAll();
    }

    public Favorite favoriteById(Long favoriteId) {
        return favoriteRepository.findById(favoriteId).orElse(null);
    }

    public Favorite createFavorite(FavoriteCreateRequest favoriteCreateRequest) {
        User user = userService.getOneUser(favoriteCreateRequest.getUserId());

        if (user == null ) {
            System.out.println("PROBLEM WITH USER *************");
            return null;

        }
        Favorite favoriteToSave = new Favorite();
        favoriteToSave.setUser(user);
        favoriteToSave.setMovieId(favoriteCreateRequest.getMovieId());
        return favoriteRepository.save(favoriteToSave);
    }

    public void deleteFavoriteById(Long favoriteId) {
        Optional<Favorite> favorite = favoriteRepository.findById(favoriteId);
        if (favorite.isPresent()) {
            favoriteRepository.deleteById(favoriteId);
        }
    }
}
