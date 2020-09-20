import java.awt.GridLayout;

import javax.swing.*;
import javax.swing.border.BevelBorder;


public class MyPanel {
	public JLabel iArray[];
	

    public  void main(String[] args) {
        final JFrame f = new JFrame("Frame Test");

        JPanel panel = new JPanel(new GridLayout(10, 10, 4, 4));
            //declaring array
        iArray = new JLabel[100];
        

        for (int i = 0; i < 100; i++) {
            JLabel l = new JLabel("" , JLabel.CENTER);
            
            iArray[i] = l;
            //JLabel l = new JLabel(new ImageIcon("image_file.png"), JLabel.CENTER);
            l.setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED));
            l.setFont(l.getFont().deriveFont(20f));
            panel.add(l);
        }

        f.setContentPane(panel);
        f.setSize(200, 200);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setVisible(true);
    }
}
