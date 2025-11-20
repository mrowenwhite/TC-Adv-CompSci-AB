package Sem1.Langdocs.Prog1061h;

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
                boolean flag = false;
                Node prev = temp;

                while (temp != null) {
                    if (newNode.getData().compareTo(temp.getData()) < 0) {
                        flag = true;
                        newNode.next = temp.next;
                        temp.next = newNode;
                        break;
                    }
                    prev = temp;
                    temp = temp.next;
                }
                if (!flag) {
                    temp.next = newNode;
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
