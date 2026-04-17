package Sem2.NewConcepts;

import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;
import java.io.*;

public class TemplateFrame1 extends JFrame {

    TemplateFrame1(int len, int wid){
        this.setSize(len, wid);
        this.setVisible(true);
        this.setResizable(false);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setIconImage(new ImageIcon("img.png").getImage());
        this.getContentPane().setBackground(new Color(181, 181, 181));
    }
}
