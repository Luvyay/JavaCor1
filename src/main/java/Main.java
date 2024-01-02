import Logic.Controller.NoteController;
import Logic.Model.Note;
import Logic.View.NoteView;

public class Main {
    public static void main(String[] args) {
        /*
        Что может данная программа:
        1. Создавать заметки (с записью времени).
        2. Дозаписывать заметки (с записью времени).
        3. Удалять заметки.
        4. Показывать текст заметки.

        Для создания заметки нужно:
        1. Название заметки.
        2. Текст заметки.

        Для дозаписи заметки нужно:
        1. Название заметки.
        2. Текст заметки.

        Для удаления заметки нужно:
        1. Название заметки.

        Для отображения текста заметки нужно:
        1. Название заметки.

        Создавать 2 заметки с одинакомым названием нельзя!

        Меню состоит из:
        1. Создать заметку. +
        2. Дозаписать заметку. +
        3. Удалить заметку. +
        4. Показать список заметок. +
        5. Показать текст заметки. +
        6. Выйти. +

        Структура папок:
        Logic -> Model | Controller | View
        Notes
         */

        NoteView noteView = callingMethods();
        noteView.run();

    }

    public static NoteView callingMethods() {
        Note note = new Note();
        NoteController noteController = new NoteController(note);
        return new NoteView(noteController);
    }
}
