package com.moviedb.moviedbapp.requests;

import lombok.Data;

@Data
public class CommentCreateRequest {

    String text;
    Long userId;
    Long movieId;
}
