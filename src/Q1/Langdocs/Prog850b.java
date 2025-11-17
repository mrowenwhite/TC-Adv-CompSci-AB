package Q1.Langdocs;
import java.util.*;
import java.io.*;

public class Prog850b {
    public static void main(String[] args) {
        try {
            Scanner input = new  Scanner(new File("Langdats/Prog850b.txt"));
            String header = input.nextLine();

            Map<String, Integer> answers = new HashMap<>();
            while (input.hasNextLine()) {
                String line = input.nextLine();
                String[] cols = new String[6];

                //line = line.substring(line.indexOf("\"") + 1,  line.indexOf("\""));
                if (line.substring(0, 1).equals("\"")) {
                    line = line.substring(1);
                    int spot = line.indexOf("\"");
                    String stuff =  line.substring(0, spot + 1);
                    cols[0] = line;
                    line = line.substring(spot + 2);
                }
                else {
                    int spot = line.indexOf(",");
                    String stuff =  line.substring(0, spot);
                    cols[0] = stuff;
                    line = line.substring(spot + 1);
                }


            }
        }
        catch (IOException e) {System.out.println("Wah, wah, wah");}


    }
}
