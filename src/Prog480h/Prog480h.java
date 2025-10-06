package Prog480h;
import java.util.*;
import java.io.*;

public class Prog480h {
    public static void main(String[] args) throws IOException {
        Scanner file = new Scanner(new File("Langdats/Prog480h.txt"));
        LinkedList<Student> students = new LinkedList<>();


        //key
        String[] tempKey = file.nextLine().split(" ");
        int[] key = new int[tempKey.length];
        for (int i = 1; i < tempKey.length; i++) {
            key[i] = Integer.parseInt(tempKey[i]);
        }

        //students
        while (file.hasNextLine()) {
            String line = file.nextLine();
            int id = Integer.parseInt(line.split(" ")[0]);
            int[] scores = new int[10];
            for (int i = 1; i < line.split(" ").length-1; i++) {
                scores[i] = Integer.parseInt(line.split(" ")[i]);
            }
            students.add(new Student(id, scores, key));
        }

        System.out.println("Key: " + Arrays.toString(key) + "\n");

        for (Student student : students) {
            System.out.println(student);
        }
    }
}
