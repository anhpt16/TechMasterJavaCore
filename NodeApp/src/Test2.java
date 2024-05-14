import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Test2 extends JFrame{

    private JPanel testPanel;
    private JButton button1;

    public Test2(){
        this.setTitle("Test2");
        this.setContentPane(this.testPanel);
        this.setSize(800, 600);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        this.setVisible(true);

        processEvent();
    }

    public void processEvent(){
//        button1.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                JOptionPane.showMessageDialog(testPanel, "Sucess");
//            }
//        });
    }

    public static void main(String[] args) {
        new Test2();
    }
}
