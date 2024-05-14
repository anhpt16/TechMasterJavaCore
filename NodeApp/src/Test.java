import javax.swing.*;
import java.awt.*;

public class Test extends JFrame{

    private JPanel panel1;

    public Test() throws HeadlessException {
        setTitle("Test");
        setSize(800, 600);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public static void main(String[] args) {
        new Test();
    }
}
