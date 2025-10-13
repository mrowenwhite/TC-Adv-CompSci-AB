package Q1.Prog1061h;


import java.io.*;
import java.util.*;

class Prog1061h {
    public static void main(String[] args) throws IOException {
        LinkedList<String> list = new LinkedList<>();
        Scanner file = new Scanner(new File("Langdats/prg1061h.txt"));
        String[] tempArr = new String[20];

        int cnt = 0;
        while (file.hasNextLine()) {
            tempArr[cnt] = file.nextLine();
            cnt++;
        }
        System.out.println(list);



    }
}
