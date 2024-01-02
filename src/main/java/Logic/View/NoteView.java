package Logic.View;

import Logic.Controller.NoteController;

import java.util.Scanner;

public class NoteView {
    private NoteController noteController;
    public NoteView(NoteController noteController) {
        this.noteController = noteController;
    }

    public void run() {
        showMenu();
        int create = 1;
        int rewrite = 2;
        int delete = 3;
        int showAllNotes = 4;
        int showNote = 5;
        int exit = 6;

        System.out.print("Введите число: ");

        Scanner scanner = new Scanner(System.in);
        int command = scanner.nextInt();

        while (command != exit) {
            if (command == create) {
                create();
            }

            if (command == rewrite) {
                rewrite();
            }

            if (command == delete) {
                delete();
            }

            if (command == showAllNotes) {
                this.noteController.showAllNotes();
            }

            if (command == showNote) {
                showNote();
            }

            showMenu();

            System.out.print("Введите число: ");

            command = scanner.nextInt();
        }

    }

    private void showMenu() {
        System.out.println("1. Создать заметку.");
        System.out.println("2. Дозаписать заметку.");
        System.out.println("3. Удалить заметку.");
        System.out.println("4. Показать список заметок.");
        System.out.println("5. Показать текст заметки.");
        System.out.println("6. Выйти.");
    }

    private void create() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Введите название заметки: ");
        String name = scanner.nextLine();
        System.out.print("Введите текст заметки: ");
        String bodyOfNote = scanner.nextLine();

        if (this.noteController.createNote(name, bodyOfNote)) {
            System.out.println("Заметка " + name + " создана.");
        } else {
            System.out.println("Не удалось создать заметку " + name + ".");
        }
    }

    private void rewrite() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Введите название заметки: ");
        String name = scanner.nextLine();
        System.out.print("Введите текст заметки: ");
        String bodyOfNote = scanner.nextLine();

        if (this.noteController.rewriteNote(name, bodyOfNote)) {
            System.out.println("Заметка " + name + " перезаписана.");
        } else {
            System.out.println("Не удалось перезаписать заметку " + name + ".");
        }
    }

    private void delete() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Введите название заметки: ");
        String name = scanner.nextLine();

        if (this.noteController.deleteNote(name)) {
            System.out.println("Заметка " + name + " удалена.");
        } else {
            System.out.println("Не удалось удалить заметку " + name + ".");
        }
    }

    private void showNote() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Введите название заметки: ");
        String name = scanner.nextLine();

        if (this.noteController.showBodyOfNote(name)) {
            System.out.println("Текст заметки:");
        } else {
            System.out.println("Произошла ошибка.");
        }
    }
}
