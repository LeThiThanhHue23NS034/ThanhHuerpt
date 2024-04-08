package main;

import java.io.File;
import java.io.IOException;

import controller.TextEditorController;
import model.TextEditor;
import view.TextEditorView;

public class Main {
    public static void main(String[] args) throws IOException {
        TextEditor model = new TextEditor();

        
        String currentDirectory = new File("").getAbsolutePath();
        String filePath = currentDirectory + File.separator + "example1.txt";

        model.openFile(filePath);

        TextEditorView view = new TextEditorView();
        TextEditorController controller = new TextEditorController(model, view);
        controller.start();
    }
}
