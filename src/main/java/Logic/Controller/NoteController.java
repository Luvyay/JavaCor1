package Logic.Controller;

import Logic.Model.Note;

public class NoteController {
    private Note note;
    public NoteController(Note note) {
        this.note = note;
    }

    public boolean createNote(String name, String bodyOfNote) {
        return this.note.createNote(name, bodyOfNote);
    }

    public boolean rewriteNote(String name, String bodyOfNote) {
        return this.note.rewriteNote(name, bodyOfNote);
    }

    public boolean deleteNote(String name) {
        return this.note.deleteNote(name);
    }

    public boolean showBodyOfNote(String name) {
        return this.note.showBodyOfNote(name);
    }

    public void showAllNotes() {
        this.note.showAllNotes();
    }
}
