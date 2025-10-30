package Q1.Test;
import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class testmain {
    public static void main(String[] args) throws IOException {
        Scanner file = new Scanner(new File("src/Q1/Test/test.dat"));
        ArrayList<Integer> list = new ArrayList<>();
        while (file.hasNextInt()) {
            list.add(file.nextInt());
        }
        for  (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }
    }
}
