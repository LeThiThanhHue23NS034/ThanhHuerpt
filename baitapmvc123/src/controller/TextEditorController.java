package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import model.TextEditor;
import view.TextEditorView;

public class TextEditorController {
    private TextEditor model;
    private TextEditorView view;

    public TextEditorController(TextEditor model, TextEditorView view) {
        this.model = model;
        this.view = view;

        view.addSaveButtonListener(new SaveButtonListener());
    }

    public void start() {
        view.createAndShowGUI();
    }

    private class SaveButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String text = view.getText();
            model.setLines(new ArrayList<>(Arrays.asList(text.split("\n"))));
            try {
                model.saveFile();
                view.showSuccessMessage("Đã lưu file thành công!");
            } catch (IOException ex) {
                view.showErrorMessage("Lỗi khi lưu file: " + ex.getMessage());
            }
        }
    }
}