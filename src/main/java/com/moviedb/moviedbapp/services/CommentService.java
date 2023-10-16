package com.moviedb.moviedbapp.services;

import com.moviedb.moviedbapp.entity.Comment;
import com.moviedb.moviedbapp.entity.User;
import com.moviedb.moviedbapp.repos.CommentRepository;
import com.moviedb.moviedbapp.requests.CommentCreateRequest;
import com.moviedb.moviedbapp.requests.CommentUpdateRequest;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CommentService {

    CommentRepository commentRepository;
    UserService userService;

    public CommentService(CommentRepository commentRepository) {
        this.commentRepository = commentRepository;
        this.userService = userService;
    }
    public List<Comment> getAllComments(Optional<Long> userId, Optional<Long> movieId) {
        if (userId.isPresent() && movieId.isPresent()) {
            return commentRepository.findAllByUserIdAndMovieId(userId.get(), movieId.get());
        } else if (userId.isPresent()) {
            return commentRepository.findAllByUserId(userId.get());
        } else if (movieId.isPresent()) {
            return commentRepository.findAllByMovieId(movieId.get());
        }
        return commentRepository.findAll();

    }

    public Comment getCommentById(Long commentId) {
        return commentRepository.findById(commentId).orElse(null);
    }

    public Comment createComment(CommentCreateRequest commentCreateRequest) {
        User user = userService.getOneUser(commentCreateRequest.getUserId());

        if (user == null ) {
            return null;
        }
        Comment commentToSave = new Comment();
        commentToSave.setText(commentCreateRequest.getText());
        commentToSave.setUser(user);
        commentToSave.setMovieId(commentCreateRequest.getMovieId());
        return commentRepository.save(commentToSave);

    }

    public Comment updateComment(Long commentId, CommentUpdateRequest commentUpdateRequest) {
        Optional<Comment> comment = commentRepository.findById(commentId);
        if (comment.isPresent()) {
            Comment commentToUpdate = comment.get();
            commentToUpdate.setText(commentUpdateRequest.getText());
            return commentRepository.save(commentToUpdate);
        }
        return null;
    }

    public void deleteCommentById(Long commentId) {
        Optional<Comment> comment = commentRepository.findById(commentId);
        if (comment.isPresent()) {
            commentRepository.deleteById(commentId);
        }
    }
}
