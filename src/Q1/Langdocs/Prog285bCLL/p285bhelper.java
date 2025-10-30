package Q1.Langdocs.Prog285bCLL;


public class p285bhelper {
    public Node head;

    public static class Node {
        public Node next;
        public Node prev;
        private Com Data;

        public Node(Com C) {
            this.Data = C;
        }

        public Com getData() {
            return Data;
        }
    }

    public void add(Com c) {
        Node newNode = new Node(c);

        if (head == null) {
            head = newNode;
            newNode.next = newNode;
            newNode.prev = newNode;
        } else {
            Node lcN = head;
            while (lcN.next != head)
                lcN = lcN.next;
            lcN.next = newNode;
            newNode.prev = lcN;
            newNode.next = head;
            head.prev = newNode;
        }
    }

    public void PrintAllOfNum(int n) {
        Node lcN = head;
        while (lcN.next != head) {
            if (lcN.getData().getCode() == n) {
                System.out.println("ID:\t" + lcN.getData().getId() + "\tComm:\t" + lcN.getData().getcommision() + "\tCode: " + lcN.getData().getCode());
            }
            lcN = lcN.next;
        }
    }

    public void calc() {
        Node temp = head;
        while (temp.next != head) {
            temp.getData().calc();
            temp = temp.next;
        }


    }
}
