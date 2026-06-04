package Sem2.ConnectionsGame;

import jdk.jfr.Category;

import javax.swing.*;
import java.awt.*;
import java.io.*;
import java.util.*;
import java.util.List;
import java.util.stream.Collectors;


public class GameFrame extends JFrame {
    protected static GameFrame gameFrame;
    private static final ArrayList<MyButton> clicked =  new ArrayList<>();
    static Map<String, String[]> map = new HashMap<>();
    static ArrayList<MyButton> buttons = new ArrayList<>();

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
    public void solve(MyButton[] category) {
        System.out.println("test1");
        MyButton[] cat = new MyButton[category.length];
        String[] catStr = new String[category.length];
        for  (int i = 0; i < category.length; i++) {
            cat[i] = category[i];
            catStr[i] = cat[i].getText();
        }

        buttons = buttons.stream().filter(b ->(!(Arrays.stream(cat)).toList().contains(b))).collect(Collectors.toCollection(ArrayList::new));
        for (String str : map.keySet()) {
            for  (int lcv = 0; lcv < category.length; lcv++) {
                if (Arrays.stream(category).toList().contains(clicked.getFirst())) {
                    System.out.println("test2");
                    for (String s : Arrays.stream(category).map(MyButton::getText).toList()) {
                        MyButton b = new MyButton(s, buttons.getFirst().color);
                        this.add(b);
                        b.setBackground(buttons.getFirst().color);
                        b.setEnabled(false);
                    }
                    Collections.shuffle(buttons);
                    for (MyButton button : buttons) {
                        this.add(button);
                    }
                    clicked.clear();

                }
                System.out.println("test3");
            }

        }
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
                            for  (MyButton button2 : clicked) {
                                button2.setSelected(false);
                            }
                            clicked.clear();
                            return;
                        }
                }

                gameFrame.setLayout(new GridLayout(4,4));
                gameFrame.removeAll();
                gameFrame.solve(clicked.toArray(new MyButton[4]));
                gameFrame.revalidate();
                gameFrame.repaint();

                /*
                for (String s : cat) {
                    MyButton b = new MyButton(s, color);
                    gameFrame.add(b);
                    b.setBackground(color);
                    b.setEnabled(false);
                }
                Collections.shuffle(buttons);
                for (MyButton button : buttons) {
                    gameFrame.add(button);
                }
                clicked.clear();
                System.out.println("test");

                 */
            });
        }
    }
}
