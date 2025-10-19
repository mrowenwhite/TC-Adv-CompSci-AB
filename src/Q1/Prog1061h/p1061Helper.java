package Q1.Prog1061h;

import java.util.Arrays;

public class p1061Helper {
    private Node head;

    public class Node {
        private Node next;
        private String data;

        public Node(String data) {
            this.data = data;
        }

        public String getData() {
            return data;
        }
    }

    public p1061Helper() {
        head = null;
    }

    public void addAlphabetically(String s) { //WHY!?
        Node newNode = new Node(s);
        if (head == null) {
            head = newNode;
        }
        else {
            Node temp = head;
            while (temp.next != null) {
                if (s.compareTo(head.data) < 0) {
                    newNode.next = head;
                    head = newNode;
                }
                else {
                    if (s.compareTo(temp.data) < 0) {
                        newNode.next = temp.next;
                        temp.next = newNode;

                    }
                }
                temp = temp.next;
            }
        }
    }


    public void print() {
        System.out.print(Arrays.toString(this.toArray()));
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

    public String[] toArray() {
        String[] arr = new String[this.getSize()];
        Node temp = head;
        int i = 0;
        while (temp != null) {
            arr[i] = temp.getData();
            temp = temp.next;
        }
        return arr;
    }


}
