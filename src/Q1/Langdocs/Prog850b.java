package Q1.Langdocs;
import java.util.*;
import java.io.*;

public class Prog850b {
    public static void main(String[] args) throws IOException {
        Scanner file = new Scanner(new File("Langdats/Prog850b.csv"));
        Map<String, Integer> map = new HashMap<>();

        while (file.hasNextLine()) {
            String[] line =  file.nextLine().split(",");
            if (!line[1].equals("total"))map.put(line[0], map.getOrDefault(line[0], Integer.parseInt(line[5])));
        }
        for  (Map.Entry<String, Integer> entry : map.entrySet()) {
            System.out.println(entry.getKey() + " : " + entry.getValue());
        }


    }
}
