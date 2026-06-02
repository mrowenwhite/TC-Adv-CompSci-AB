package Sem2.ConnectionsGame;

import javax.swing.*;
import java.awt.*;
import java.io.*;
import java.util.*;
import java.util.List;


public class GameFrame extends JFrame {
    static GameFrame gameFrame;
    private static final ArrayList<MyButton> clicked =  new ArrayList<>();
    static Map<String, String[]> map = new HashMap<>();

    public GameFrame() throws FileNotFoundException {
        gameFrame = this;
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

        ArrayList<MyButton> buttons = new ArrayList<>();
        final Color[] colors = {Color.red, Color.yellow, Color.green, Color.blue};

        while (file.hasNextLine()) {
            String line = file.nextLine();
            if (line.charAt(line.length() - 1) == ':') {
                map.put(line.substring(0, line.length() - 1), new String[]{file.nextLine(), file.nextLine(), file.nextLine(), file.nextLine()});
            }
        }
        int cnt = 0;
        for (String[] stuff : map.values()) {
            for (String str : stuff)
                buttons.add(new MyButton(str, colors[cnt]));
            cnt++;
        }

        gameFrame.setLayout(new GridLayout(4,4));
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
            this.text = txt;
            this.color = color;
            this.addActionListener(e -> {
                if (this.isSelected()) {
                    clicked.remove(this);
                }
                else {
                    clicked.add(this);
                }
                clicked.add(this);
                if (clicked.size()<=3)return;
                for (MyButton button : clicked) {
                        if (!button.color.equals(this.color)) {
                            JOptionPane.showMessageDialog(gameFrame, "Try Again");
                            clicked.clear();
                            for  (MyButton button2 : clicked) {
                                button2.setSelected(false);
                            }
                            return;
                        }
                }
                String[] cat = clicked.stream().map(MyButton::getText).toArray(String[]::new);
                ArrayList<MyButton> buttons = new ArrayList<>();
                for (MyButton b : clicked) {
                    if (!(Arrays.stream(cat)).toList().contains(b))
                        buttons.add(b);
                }
                gameFrame.setLayout(new GridLayout(4,4));
                gameFrame.removeAll();

                for (String s : cat) {
                    MyButton button = new MyButton(s, color);
                    gameFrame.add(button);
                    button.setBackground(color);
                }
                Collections.shuffle(buttons);
                for (MyButton button : buttons) {
                    gameFrame.add(button);
                }
                clicked.clear();
            });
        }
    }
}
