package Q1.Langdocs.Prog1045a;

public class p1045helper {

    public static class Node {
        protected Node next;
        public int val;

        public Node(int val) {
            this.val = val;
        }

    }
    private Node  head;
    private Node  tail;

    public int GetSafeSpot() {
        Node temp = head.next;
        while (temp != head) {
            if (temp.next == temp) {
                return temp.val;
            }
            else {
                temp.next = temp.next.next;
                temp = temp.next;
            }
        }
        return -1;
    }
    public void addfront(int n) {
        Node t = new Node(n);
        t.next = head;
        tail.next = t;
        head = t;
    }

    public boolean addlast(int n) {
        Node t = new Node(n);
        if (head == null) {
            head = t;
            head.next = t;
            tail = t;
            return true;
        }
        Node c = head;
        while (c.next != head)
            c = c.next;
        c.next = t;
        t.next = head;
        return true;
    }

    public Node getLastNode() {
        Node temp = head;
        while (temp != tail) {
            temp = temp.next;
        }
        return temp;
    }

    public void print() {
        Node temp = head;
        while (temp.next != head) {
            System.out.print(temp.val);
            temp = temp.next;
        }
    }
}
