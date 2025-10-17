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

    public void addAlphabetically(String data) {

        int cnt = 0;
        if (head == null) {
            head = new Node(data);
        }
        else {
            Node prev = head;
            Node temp = head;
            boolean flag = false;

            Node newguy = new Node(data);
            if (newguy.getData().compareTo(head.getData()) <= 0) {
                System.out.println("here " + newguy.getData());
                print();
                newguy.next = head;
                head = newguy;
                System.out.println("here ");
                print();
            } else {


                while (temp != null) {

                    System.out.println(cnt);

                    if (temp.getData().compareTo(data) > 0) {
                        Node newNode = new Node(data);
                        newNode.next = temp.next;
                        prev.next = newNode;
                        flag = true;
                        break;
                    }
                    cnt++;
                    prev = temp;
                    temp = temp.next;

                }
                if (!flag) {
                    //Add to end;
                    Node temp2 = head;
                    while (temp2.next != null) {
                        temp2 = temp2.next;
                    }
                    temp2.next = new Node(data);
                }
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
