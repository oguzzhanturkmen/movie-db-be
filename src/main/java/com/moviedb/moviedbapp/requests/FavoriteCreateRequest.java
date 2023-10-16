package com.moviedb.moviedbapp.requests;

import lombok.Data;

@Data
public class FavoriteCreateRequest {

    Long userId;
    Long movieId;
}
