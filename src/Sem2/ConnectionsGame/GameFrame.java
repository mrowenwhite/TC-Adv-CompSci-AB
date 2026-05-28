package Sem2.ConnectionsGame;

import javax.swing.*;
import javax.xml.catalog.Catalog;
import java.awt.*;
import java.io.*;
import java.util.*;
import java.util.List;
import java.util.stream.Collectors;


public class GameFrame extends JFrame {
    static JToggleButton[][] GameBoard =  new JToggleButton[4][4];

    public GameFrame() throws FileNotFoundException {
        GameBuilder();
        this.setTitle("Game");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(800, 600);
        this.setVisible(true);
        this.revalidate();
    }





    public void GameBuilder() throws FileNotFoundException {
        Scanner file = new Scanner(new File("C:\\Users\\white.o3\\IdeaProjects\\TC CompSci\\src\\Sem2\\ConnectionsGame\\ConnectionsFile.txt"));
        Map<String, Stack<String>> map = new HashMap<>();
        Random random = new Random();


        ArrayList<String> items = new ArrayList<>();
        while (file.hasNextLine()) {
            String line = file.nextLine();
            if (line.charAt(line.length()-1)==':') {
                String category = line;
                map.put(category, map.getOrDefault(category, new Stack<>()));
                line = file.nextLine();
                while (!(line.charAt(line.length()-1)==':')) {
                    map.get(category).add(line);
                    line = file.nextLine();
                }
            }
        } //Populate Categories From File // populates map
        ArrayList<String> TempCats = new ArrayList<>(map.keySet());
        Collections.shuffle(TempCats);
        String[] categories = new String[4];
        for (int i = 0; i < 4; i++) {
            categories[i] = TempCats.get(i); // INDEX OUT OF BOUNDS
        }
         // populate categories for gameBoard, no repeats
        for (int row = 0; row < 4; row++) {
            for (int col = 0; col < 4; col++) {
                items.add(map.get(categories[row]).pop());
            }
        } // create Items for gameBoard based on categories
        Collections.shuffle(Arrays.asList(items));
        int Ilcv = -1;
        for (int r = 0; r < 4; r++) {
            for (int c = 0; c < 4; c++) {
                GameBoard[r][c] = new JToggleButton(items.get(Ilcv++));
            }
        } // populate GameBoard based on items
        this.setLayout(new GridLayout(4,4));
        for (String item : items) this.add(new MyButton(item));

    }


    private static class MyButton extends JToggleButton {

        public MyButton(String text) {
            super(text);
        }
    }
}
