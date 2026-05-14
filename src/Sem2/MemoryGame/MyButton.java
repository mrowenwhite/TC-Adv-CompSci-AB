package Sem2.MemoryGame;

import javax.swing.*;
import java.awt.*;

public class MyButton extends JButton {
    public boolean isFinished;

    public MyButton() {
        isFinished = false;
        this.setSize(20, 20);
        this.setBackground(Color.DARK_GRAY);
    }

    public MyButton(Color color) {
        isFinished = false;
        this.setSize(20, 20);
        this.setBackground(Color.DARK_GRAY);

        this.addActionListener(e -> {
            //TODO
        });
    }
}