package Q1.Prog1061h;

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
        if (head == null) {
            head = new Node(data);
        }
        else {
            Node temp = head;
            while (temp.next != null) {
                if (temp.next.getData().compareTo(data) <= 0) {
                    Node newNode = new Node(data);
                    newNode.next = temp.next;
                    temp.next = newNode;
                    break;
                }
                temp = temp.next;
            }
        }
    }

    public void print() {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.getData() + ", ");
            temp = temp.next;
        }
    }


}
