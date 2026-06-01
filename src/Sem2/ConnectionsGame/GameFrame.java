package Sem2.ConnectionsGame;

import javax.swing.*;
import java.awt.*;
import java.io.*;
import java.util.*;
import java.util.List;


public class GameFrame extends JFrame {
    static GameFrame gameFrame;
    private static ArrayList<MyButton> clicked;
    static Map<String, String[]> map = new HashMap<>();

    public GameFrame() throws FileNotFoundException {
        GameBuilder();
        this.setTitle("Game");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(1920/2, 1080/2);
        this.setVisible(true);
        this.revalidate();
        this.repaint();
    }


    public void GameBuilder() throws FileNotFoundException {
        Scanner file = new Scanner(new File("C:\\Users\\white.o3\\IdeaProjects\\TC CompSci\\src\\Sem2\\ConnectionsGame\\ConnectionsFile.txt"));

        ArrayList<String> items = new ArrayList<>();
        ArrayList<MyButton> buttons = new ArrayList<>();
        final Color[] colors = {Color.red, Color.yellow, Color.green, Color.blue};

        while (file.hasNextLine()) {
            String line = file.nextLine();
            if (line.charAt(line.length() - 1) == ':') {
                map.put(line.substring(0, line.length() - 1), new String[]{String.valueOf(items.add(file.nextLine())), String.valueOf(items.add(file.nextLine())), String.valueOf(items.add(file.nextLine())), String.valueOf(items.add(file.nextLine()))});
            }
        }
        int cnt = 0;
        for (String[] stuff : map.values()) {
            for (String str : stuff)
                buttons.add(new MyButton(str, colors[cnt]));
            cnt++;
        }

        gameFrame.setLayout(new GridLayout(4,4));
        Collections.shuffle(items);
        Collections.shuffle(buttons);
        for (MyButton button : buttons) {
            gameFrame.add(button);
        }
        gameFrame = this;
    }


    private static class MyButton extends JToggleButton {
        private final Color color;
        public String text;

        public MyButton(String txt, Color color) {
            super(txt);
            text = txt;
            this.color = color;
            this.addActionListener(e -> {
                clicked.add(this);
                for (MyButton button : clicked) {
                    if (!button.color.equals(this.color)) {
                        JOptionPane.showMessageDialog(gameFrame, "Try Again");
                        return;
                    }
                }
                String[] cat = clicked.stream().map(MyButton::getText).toArray(String[]::new);
                ArrayList<MyButton> buttons = new ArrayList<>();
                for ()

                this.setBackground(this.color);
            });
        }
    }
}
