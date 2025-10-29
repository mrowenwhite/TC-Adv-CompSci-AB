package Q1.Langdocs;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class Prog901a {
    public static void main(String[] args) throws IOException {
        Scanner file = new Scanner(new File("Langdats/prog512h.dat"));
        helper  list = new helper();

        while (file.hasNextLine()) {
            list.add(file.nextLine());
        }
        list.printForward();
        list.printBackward();
}

    private static class helper {
        private class Node {
            String data;
            public Node next;
            public Node prev;

            public Node(String data) {
                this.data = data;
            }
        }
        public Node  head;

        public helper() {
            this.head = null;
        }

        public boolean add(String n) {
            Node newNode = new Node(n);
            if (head == null) {
                head = newNode;
                head.next = head;
                head.prev = head;
                return true;
            }
            Node c = head;
            while (c.next != head)
                c = c.next;

            c.next = t;
            c.prev = t.prev;
            t.prev = c;
            t.next = head;
            return true;
        }

        public void printForward() {
            Node lcN = head;
            while (lcN.next != head) {
                System.out.println(lcN.data);
                lcN = lcN.next;
            }
        }
        public void printBackward() {
            Node lcN = head;
            while (lcN.prev != head) {
                System.out.println(lcN.data);
                lcN = lcN.prev;
            }
        }
    }
}
