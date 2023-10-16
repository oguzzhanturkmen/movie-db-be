package com.moviedb.moviedbapp.controllers;

import com.moviedb.moviedbapp.entity.Note;
import com.moviedb.moviedbapp.requests.NoteCreateRequest;
import com.moviedb.moviedbapp.requests.NoteUpdateRequest;
import com.moviedb.moviedbapp.services.NoteService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/notes")
public class NoteController {

    private NoteService noteService;

    public NoteController(NoteService noteService) {
        this.noteService = noteService;
    }

    @GetMapping
    public List<Note> getAllNotes(@RequestParam Optional<Long> userId, @RequestParam Optional<Long> movieId) {
        return noteService.getAllNotes(userId, movieId);
    }

    @GetMapping("/{noteId}")
    public Note getNoteById(@PathVariable Long noteId) {
        return noteService.getNoteById(noteId);
    }

    @PostMapping
    public Note createNote(@RequestBody NoteCreateRequest noteCreateRequest) {
        return noteService.createNote(noteCreateRequest);

    }

    @PutMapping("/{noteId}")
    public Note updateNoteById(@PathVariable Long noteId, @RequestBody NoteUpdateRequest noteUpdateRequest) {
        return noteService.updateNote(noteId, noteUpdateRequest);
    }

    @DeleteMapping("/{noteId}")
    public void deleteNoteById(@PathVariable Long noteId) {
        noteService.deleteNoteById(noteId);
    }
}
