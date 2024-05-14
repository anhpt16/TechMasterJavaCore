package noteapp;

import javax.swing.*;
import java.awt.*;

public class Test {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Text Field Cursor Example");
        JPanel mainPanel = new JPanel();
        frame.setLayout(new FlowLayout());

        JTextField textField = new JTextField(20);
        JButton button = new JButton();
        button.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        textField.setCursor(Cursor.getPredefinedCursor(Cursor.TEXT_CURSOR)); // Thiết lập con trỏ chuột nhập
        mainPanel.add(textField);
        mainPanel.add(button);
        frame.add(mainPanel);
        frame.setSize(300, 200);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}
