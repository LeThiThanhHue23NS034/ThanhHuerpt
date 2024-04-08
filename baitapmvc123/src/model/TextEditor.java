package model;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class TextEditor {
    private List<String> lines;
    private File file;

    public TextEditor() {
        lines = new ArrayList<>();
    }

    public void openFile(String filePath) throws IOException {
        file = new File(filePath);
        if (!file.exists()) {
            throw new IOException("File does not exist: " + filePath);
        }

        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = reader.readLine()) != null) {
                lines.add(line);
            }
        }
    }

    public void saveFile() throws IOException {
        if (file == null) {
            throw new IOException("No file is currently open.");
        }

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(file))) {
            for (String line : lines) {
                writer.write(line);
                writer.newLine();
            }
        }
    }

    public void setLines(List<String> lines) {
        this.lines = lines;
    }

    public void addLine(String line) {
        lines.add(line);
    }

    public void deleteLine(int index) {
        if (index >= 0 && index < lines.size()) {
            lines.remove(index);
        }
    }

    public void editLine(int index, String newLine) {
        if (index >= 0 && index < lines.size()) {
            lines.set(index, newLine);
        }
    }

    public void printLines() {
        for (String line : lines) {
            System.out.println(line);
        }
    }

    public List<String> searchFiles(File directory) {
        List<String> foundFiles = new ArrayList<>();
        searchFilesRecursive(directory, foundFiles);
        return foundFiles;
    }

    private void searchFilesRecursive(File directory, List<String> foundFiles) {
        if (directory.isDirectory()) {
            File[] files = directory.listFiles();
            if (files != null) {
                for (File file : files) {
                    if (file.isDirectory()) {
                        searchFilesRecursive(file, foundFiles);
                    } else {
                        foundFiles.add(file.getAbsolutePath());
                    }
                }
            }
        }
    }
}
