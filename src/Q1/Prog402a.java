package Q1;
import java.io.IOException;
import java.util.Map;
import java.util.Scanner;
import java.io.*;
import java.util.HashMap;

public class Prog402a {
    public static void main(String[] args) throws IOException {
        Scanner file = new Scanner (new File("Langdats/prg402a.dat"));
        Map<Integer, Tuple> map = new HashMap<>();
        while (file.hasNextLine()) {
            map.put(file.nextInt(), new Tuple(file.nextInt(), file.nextInt()));
        }
    }
}
