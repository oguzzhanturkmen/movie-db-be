package com.moviedb.moviedbapp.repos;

import com.moviedb.moviedbapp.entity.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CommentRepository extends JpaRepository<Comment, Long> {


    List<Comment> findAllByUserIdAndMovieId(Long aLong, Long aLong1);

    List<Comment> findAllByUserId(Long aLong);

    List<Comment> findAllByMovieId(Long aLong);
}
