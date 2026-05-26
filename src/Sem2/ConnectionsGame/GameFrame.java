package Sem2.ConnectionsGame;

import javax.swing.*;
import java.io.*;
import java.util.*;
import java.util.stream.Collectors;


public class GameFrame extends JFrame {
    static JToggleButton[][] GameBoard =  new JToggleButton[4][4];

    public GameFrame() throws FileNotFoundException {
        GameBuilder();
    }





    public void GameBuilder() throws FileNotFoundException {
        Scanner file = new Scanner(new File("ConnectionsFile.txt"));
        Map<String, HashSet<String>> map = new HashMap<>();
        Random random = new Random();
        while (file.hasNextLine()) {
            String line = file.nextLine();
            if (line.charAt(line.length()-1)==':') {
                String category = line;
                map.put(category, map.getOrDefault(category, new HashSet<>()));
                line = file.nextLine();
                while (!(line.charAt(line.length()-1)==':')) {
                    map.get(category).add(line);
                    line = file.nextLine();
                }
            }
        } //Populate Categories From File
        String[] categories = new String[4];
        for  (int i = 0; i < 4; i++) {

            int n = random.nextInt(categories.length);
            while (List.of(categories).contains(map.keySet().stream().toList().get(n))) n  = random.nextInt(categories.length);
            categories[i] = map.keySet().stream().toList().get(n);
        } // populate categories for gameBoard, no repeats

    }
}
