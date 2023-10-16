package com.moviedb.moviedbapp.repos;

import com.moviedb.moviedbapp.entity.Note;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface NoteRepository extends JpaRepository<Note, Long> {
    List<Note> findAllByUserIdAndMovieId(Long aLong, Long aLong1);

    List<Note> findAllByUserId(Long aLong);

    List<Note> findAllByMovieId(Long aLong);
}
