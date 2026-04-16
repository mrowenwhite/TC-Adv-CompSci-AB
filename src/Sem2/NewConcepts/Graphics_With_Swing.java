package Sem2.NewConcepts;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.rmi.ssl.SslRMIClientSocketFactory;
import javax.swing.*;
import java.io.*;

public class Graphics_With_Swing {
    public static void main(String[] args) {
        JFrame frame = new JFrame();
        frame.setBounds(800, 450, 800, 450); // centering stuff
        frame.setVisible(true);


        JButton exit = new JButton("Quit");
        frame.add(exit);
        exit.setBounds(frame.getX()/2, frame.getY()/2, frame.getWidth()/5, frame.getHeight()/5);
        exit.setHorizontalAlignment(JButton.CENTER);
        exit.setVerticalAlignment(JButton.CENTER);

        exit.addActionListener(new ActionListener() {@Override public void actionPerformed(ActionEvent e) {System.exit(0);}});


        JLabel label = new JLabel("test");
        label.setAlignmentX(Component.CENTER_ALIGNMENT);
        label.setAlignmentY(Component.CENTER_ALIGNMENT);
        label.setBounds(frame.getX()/2, frame.getY()/2, frame.getX()/20, frame.getY()/20);
        frame.add(label);
    }
}
