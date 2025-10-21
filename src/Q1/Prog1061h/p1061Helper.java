package Q1.Prog1061h;

import java.util.Arrays;

public class p1061Helper {
    private Node head;

    public class Node {
        public Node next;
        public Node prev;
        private String data;

        public Node(String data) {
            this.data = data;
            this.next = null;
            this.prev = null;
        }

        public String getData() {
            return data;
        }
    }

    public p1061Helper() {
        head = null;
    }

    public void addAlphabetically(String s) {
        Node newNode = new Node(s);
        if (this.head == null) {
            this.head = newNode;
        }
        else {
            Node temp = head;
            if (s.compareTo(temp.getData()) < 0) {
                newNode.next = temp;
                head = newNode;
            }
            else {
                while (temp.next != null) {
                    if (s.compareTo(temp.getData()) <= 0) {
                        newNode.next = temp.next;
                        newNode.prev = temp;
                        temp.next = temp.next.next;
                        break;
                    }
                    temp = temp.next;
                }
            }
        }
    }


    public void print() {
        Node temp = this.head;
        while (temp != null) {
            System.out.print(temp.getData() + ", ");
            temp = temp.next;
        }
        System.out.println("\n");
    }

    public int getSize() {
        int size = 0;
        Node temp = head;
        while (temp != null) {
            size++;
            temp = temp.next;
        }
        return size;
    }




}
