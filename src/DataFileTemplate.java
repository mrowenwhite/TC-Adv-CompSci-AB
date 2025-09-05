import java.util.*;
import java.io.*;
public class DataFileTemplate {
    public static void main(String[] args) {
        try {
            Scanner input = new Scanner(new File("prog285b.txt"));

        }
        catch (IOException e) {
            System.out.println("Can't Find Data File.");
        }
    }
}
