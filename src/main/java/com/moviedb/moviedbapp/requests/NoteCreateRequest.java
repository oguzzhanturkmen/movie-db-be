package com.moviedb.moviedbapp.requests;

import lombok.Data;

@Data
public class NoteCreateRequest {

    String text;
    Long userId;
    Long movieId;
}
