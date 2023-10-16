package com.moviedb.moviedbapp.requests;

import lombok.Data;

@Data
public class WatchCreateRequest {

    Long userId;
    Long movieId;
}
