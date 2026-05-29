package Sem2.ConnectionsGame;

import javax.swing.*;
import java.awt.*;
import java.io.*;
import java.util.*;


public class GameFrame extends JFrame {

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
        Map<String, String[]> map = new HashMap<>();
        ArrayList<String> items = new ArrayList<>();
        final Color[] colors = {Color.red, Color.yellow, Color.green, Color.blue};

        while (file.hasNextLine()) {
            String line = file.nextLine();
            if (line.charAt(line.length() - 1) == ':') {
                map.put(line.substring(0, line.length() - 1), new String[]{String.valueOf(items.add(file.nextLine())), String.valueOf(items.add(file.nextLine())), String.valueOf(items.add(file.nextLine())), String.valueOf(items.add(file.nextLine()))});
                //TODO Colors
            }
        }
        this.setLayout(new GridLayout(4,4));
        Collections.shuffle(items);
        for (int lcv = 0; lcv < items.size(); lcv++) {
            this.add(new MyButton(items.get(lcv),(lcv%4==0)?Color.red:(lcv%4==1)?Color.green:(lcv%4==2)?Color.blue:Color.yellow));
        }
    }


    private static class MyButton extends JToggleButton {
        private final Color color;

        public MyButton(String text, Color color) {
            super(text);
            this.color = color;
            this.addActionListener(e -> {
                //temp
                this.setBackground(this.color);
            });
        }
    }
}
