package Prog285bDLL;

import java.io.File;
import java.io.IOException;
import java.util.*;

public class Prog285B_DLL {
    public static void main(String[] args) throws IOException {
        Prog285B_HelperDLL dll = new Prog285B_HelperDLL();
        Scanner file = new Scanner(new File("Langdats/Prog285b.txt"));

        while (file.hasNext()) {
            int id = file.nextInt();
            int code = file.nextInt();
            double sales = file.nextDouble();
            dll.addFront(new Prog285B_HelperDLL.DoubleNode(id, code, sales));
        }
        dll.calcAll();
        dll.deleteZeros();
        dll.print();
    }
}
