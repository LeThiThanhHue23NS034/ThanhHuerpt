package view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.WindowConstants;

public class TextEditorView {
	private JFrame frame;
    private JTextArea textArea;
    private JButton saveButton;

    public TextEditorView() {
        frame = new JFrame("Text Editor");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        textArea = new JTextArea();

        saveButton = new JButton("Lưu");
        JPanel panel = new JPanel(new BorderLayout());
        panel.add(new JScrollPane(textArea), BorderLayout.CENTER);
        panel.add(saveButton, BorderLayout.SOUTH);

        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.getContentPane().add(panel);
        frame.setPreferredSize(new Dimension(400, 300));
        frame.pack();
    }

    public void createAndShowGUI() {
    	 frame.setVisible(true);
    }

    public String getText() {
        return textArea.getText();
    }

    public void setText(String text) {
        textArea.setText(text);
    }

    public void addSaveButtonListener(ActionListener listener) {
        saveButton.addActionListener(listener);
    }

    public void showSuccessMessage(String message) {
        JOptionPane.showMessageDialog(frame, message);
    }

    public void showErrorMessage(String message) {
        JOptionPane.showMessageDialog(frame, message, "Lỗi", JOptionPane.ERROR_MESSAGE);
    }
}


