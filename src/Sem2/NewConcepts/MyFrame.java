package Sem2.NewConcepts;

import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;
import java.io.*;

public class MyFrame extends JFrame implements KeyListener{
    JButton button;
    JLabel label;

    MyFrame(int len, int wid) {
        this.setSize(wid, len);
        this.setVisible(true);
        this.setLayout(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.addKeyListener(this);

        label = new JLabel();
        label.setBounds(0, 0, 50, 50);
        label.setOpaque(true);
        label.setBackground(Color.red);
        this.add(label);
    }

    @Override
    public void keyTyped(KeyEvent e) {
        switch (e.getKeyChar()) {
            case 'w': label.setLocation(label.getX(), label.getY() - 10);break;
            case 'a': label.setLocation(label.getX() - 10, label.getY());break;
            case 's': label.setLocation(label.getX(), label.getY() + 10);break;
            case 'd': label.setLocation(label.getX() + 10, label.getY());break;
            // watch video #6
        }
    }

    @Override
    public void keyPressed(KeyEvent e) {

    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}
