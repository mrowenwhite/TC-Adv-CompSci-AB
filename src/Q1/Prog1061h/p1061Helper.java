package Q1.Prog1061h;

public class p1061Helper {
    private Node head;

    public static class Node {
        public Node next;
        private String data;

        public Node(String data) {
            this.data = data;
            this.next = null;
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
        if (this.head == null)
            this.head = newNode;
        else {
            Node temp = head;
            if (newNode.getData().compareTo(temp.getData()) < 0) {
                newNode.next = temp;
                head = newNode;
            }
            else {
                while (temp.next != null) {
                    if (newNode.getData().compareTo(temp.next.getData()) <= 0) {
                        newNode.next = temp.next;
                        temp.next = newNode;
                        break;
                    }
                    temp = temp.next;
                }
            }
        }
    }


    public void print() {
        Node temp = this.head;
        while (temp.next != null) {
            System.out.print(temp.getData() + ", ");
            temp = temp.next;
        }
        System.out.println(temp.getData());
    }
}
