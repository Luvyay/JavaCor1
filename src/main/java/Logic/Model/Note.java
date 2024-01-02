package Logic.Model;

import java.io.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Note {
    private String path = "src/main/java/Notes/";
    public boolean createNote(String name, String bodyOfNote) {
        boolean isCreate = false;

        if (!findNote(name)) {
            String fullPath = this.path + name + ".txt";

            try {
                FileWriter writer = new FileWriter(fullPath);

                DateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy");
                Date date = new Date();
                writer.write(dateFormat.format(date) + " -> " + bodyOfNote);

                writer.close();
                isCreate = true;
            } catch (IOException e) {
                System.out.println(e);
                isCreate = false;
            }
        } else {
            isCreate = false;
        }

        return isCreate;
    }

    public boolean rewriteNote(String name, String bodyOfNote) {
        boolean isRewrite = false;

        if (findNote(name)) {
            String fullPath = this.path + name + ".txt";

            try {
                FileWriter writer = new FileWriter(fullPath, true);
                BufferedWriter bufferWriter = new BufferedWriter(writer);

                DateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy");
                Date date = new Date();
                bufferWriter.write("\n" + dateFormat.format(date) + " -> " + bodyOfNote);

                bufferWriter.close();
                isRewrite = true;
            } catch (IOException e) {
                isRewrite = false;
            }


        } else {
            isRewrite = false;
        }

        return isRewrite;
    }

    public boolean findNote(String name) {
        boolean isFind = false;

        String fullPath = this.path + name + ".txt";

        File findFile = new File(fullPath);
        if (findFile.exists() && !findFile.isDirectory()) {
            isFind = true;
        } else {
            isFind = false;
        }

        return isFind;
    }

    public boolean deleteNote(String name) {
        boolean isDelete = false;

        if (findNote(name)) {
            String fullPath = this.path + name + ".txt";
            File file = new File(fullPath);

            file.delete();
            isDelete = true;
        } else {
            isDelete = false;
        }

        return isDelete;
    }

    public boolean showBodyOfNote(String name) {
        boolean isShow = false;

        if (findNote(name)) {
            String fullPath = this.path + name + ".txt";
            File file = new File(fullPath);

            try {
                Scanner scanner = new Scanner(file);

                while(scanner.hasNextLine()) {
                    System.out.println(scanner.nextLine());
                }

                isShow = true;

                scanner.close();
            } catch (FileNotFoundException e) {
                isShow = false;
            }

        }

        return isShow;
    }

    public void showAllNotes() {
        File dir = new File(this.path);

        for (File file : dir.listFiles()) {
            if (file.isFile()) {
                System.out.println(file.getName());
            }
        }
    }
}
