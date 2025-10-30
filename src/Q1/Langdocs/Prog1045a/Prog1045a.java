package Q1.Langdocs.Prog1045a;

import java.util.Scanner;

public class Prog1045a {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        p1045helper list = new p1045helper();
        System.out.print("Enter the number of employees: ");
        int x = input.nextInt();
        for (int lcv = 1; lcv <= x; lcv++)
            list.add(lcv);
        System.out.println(list.GetSafeSpot());
    }
}
/*
//HELPER CLASS:

package Q1.Langdocs.Prog1045a;

public class p1045helper {

    public static class Node {
        public Node next;
        public int val;

        public Node(int val) {
            this.val = val;
        }

    }
    private Node  head;
    private Node  tail;

    public int GetSafeSpot() {
        Node temp = head;
        while (temp.next != temp) {

            if (temp.next==head) {
                head = temp.next.next;
            }
            else {
                temp.next = temp.next.next;
                temp = temp.next;
            }
        }
        return temp.val;
    }
    public void add(int n) {
        Node newNode = new Node(n);
        if (head==null) {
            head = newNode;
            newNode.next = newNode;
        }
        else {
            Node lcN = head;
            while (lcN.next != head)
                lcN = lcN.next;
            lcN.next = newNode;
            newNode.next = head;
        }
    }
    public void print() {
        Node temp = head;
        while (temp.next != head) {
            System.out.print(temp.val);
            temp = temp.next;
        }
    }
}
//OUTPUT:
Enter the number of employees: 6
5
 */