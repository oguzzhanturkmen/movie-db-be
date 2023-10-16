package com.moviedb.moviedbapp.services;

import com.moviedb.moviedbapp.entity.Note;
import com.moviedb.moviedbapp.entity.User;
import com.moviedb.moviedbapp.repos.NoteRepository;
import com.moviedb.moviedbapp.requests.NoteCreateRequest;
import com.moviedb.moviedbapp.requests.NoteUpdateRequest;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class NoteService {

    NoteRepository noteRepository;
    UserService userService;

    public NoteService(NoteRepository noteRepository, UserService userService) {
        this.noteRepository = noteRepository;
        this.userService = userService;
    }
    public List<Note> getAllNotes(Optional<Long> userId, Optional<Long> movieId) {
        if (userId.isPresent() && movieId.isPresent()) {
            return noteRepository.findAllByUserIdAndMovieId(userId.get(), movieId.get());
        } else if (userId.isPresent()) {
            return noteRepository.findAllByUserId(userId.get());
        } else if (movieId.isPresent()) {
            return noteRepository.findAllByMovieId(movieId.get());
        }
        return noteRepository.findAll();

    }

    public Note getNoteById(Long noteId) {
        return noteRepository.findById(noteId).orElse(null);
    }

    public Note createNote(NoteCreateRequest noteCreateRequest) {
        User user = userService.getOneUser(noteCreateRequest.getUserId());

        if (user == null ) {
            return null;
        }
        Note noteToSave = new Note();
        noteToSave.setText(noteCreateRequest.getText());
        noteToSave.setUser(user);
        noteToSave.setMovieId(noteCreateRequest.getMovieId());
        return noteRepository.save(noteToSave);
    }

    public Note updateNote(Long noteId, NoteUpdateRequest noteUpdateRequest) {
        Optional<Note> note = noteRepository.findById(noteId);
        if (note.isPresent()) {
            Note noteToUpdate = note.get();
            noteToUpdate.setText(noteUpdateRequest.getText());
            return noteRepository.save(noteToUpdate);
        }
        return null;
    }

    public void deleteNoteById(Long noteId) {
        Optional<Note> note = noteRepository.findById(noteId);
        if (note.isPresent()) {
            noteRepository.deleteById(noteId);
        }
    }
}
