package Sem1.BluePelicanBookPrograms.CodeTalker;
import java.util.*;
import java.io.*;

public class CodeTalker {
    public static void main(String[] args) throws IOException {
        Scanner file = new Scanner(new File("src/Q1/BluePelicanBookPrograms/CodeTalker/CodeTalkerData.dat"));
        Map<String, String> map = new HashMap<>();
        int count = Integer.parseInt(file.nextLine());
        for (int i = 0; i < count; i++) {
            String[] line = file.nextLine().split("=");
            map.put(line[0], line[1]);
        }
        for (String s : file.nextLine().split(" ")) {
            System.out.println(map.getOrDefault(s, s));
        }
    }
}
