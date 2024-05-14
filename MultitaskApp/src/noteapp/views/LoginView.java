package noteapp.views;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class LoginView extends JFrame {
    private JFrame mainFrame;

    private JPanel mainPanel;
    private JPasswordField passwordInput;
    private JLabel forgetPassword;
    private JButton loginButton;

    public LoginView(){
        /* Thiết lập cho JFrame */
        mainFrame = new JFrame();
        mainFrame.setTitle("Login");
        mainFrame.setContentPane(mainPanel);
        mainFrame.setSize(800, 600);
        mainFrame.setDefaultCloseOperation(EXIT_ON_CLOSE);
        mainFrame.setLocationRelativeTo(null);
        mainFrame.setVisible(true);
        /* Khởi tạo các component */
        initComponent();
        /* Xử lý sự kiện */
        processEvent();

    }

    public void initComponent(){

    }

    public void processEvent(){
        forgetPassword.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                JOptionPane.showMessageDialog(mainPanel, "Success");
            }
            @Override
            public void mouseEntered(MouseEvent e) {
                super.mouseEntered(e);
                forgetPassword.setForeground(Color.BLUE);
                mainFrame.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
            }
            @Override
            public void mouseExited(MouseEvent e) {
                super.mouseExited(e);
                forgetPassword.setForeground(new Color(160,160,160));
                mainFrame.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
            }
        });

        passwordInput.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                super.mouseEntered(e);
                mainFrame.setCursor(Cursor.getPredefinedCursor(Cursor.TEXT_CURSOR));
            }
            @Override
            public void mouseExited(MouseEvent e) {
                super.mouseExited(e);
                mainFrame.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
            }
        });

        loginButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                String password = String.valueOf(passwordInput.getPassword());
            }
            @Override
            public void mouseEntered(MouseEvent e){
                super.mouseEntered(e);
                mainFrame.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
            }
            @Override
            public void mouseExited(MouseEvent e){
                super.mouseExited(e);
                mainFrame.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
            }
        });
    }

    public static void main(String[] args) {
        new LoginView();
    }
}
