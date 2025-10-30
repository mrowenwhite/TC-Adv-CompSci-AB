package Q1.Langdocs.Prog285bCLL;


import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class Prog285bCLL {


    public static void main(String[] args) throws IOException {
        p285bhelper list = new  p285bhelper();
        Scanner input = new Scanner(new File("Langdats/Prog285b.txt"));
        while (input.hasNext()) {
            list.add(new Com(input.nextInt(),input.nextInt(),input.nextDouble()));
        }


        list.calc();
        list.PrintAllOfNum(5);
        list.PrintAllOfNum(8);
        list.PrintAllOfNum(17);
    }
}
/*
//HELPER CLASS\\
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







//OUTPUT//
ID:	103	Comm:	290.0	Code: 5
ID:	125	Comm:	502.5	Code: 5
ID:	218	Comm:	375.0	Code: 5
ID:	235	Comm:	396.25	Code: 5
ID:	118	Comm:	574.75	Code: 8
ID:	192	Comm:	640.625	Code: 8
ID:	203	Comm:	243.75	Code: 8
ID:	101	Comm:	213.75	Code: 17
ID:	138	Comm:	550.625	Code: 17
ID:	264	Comm:	394.25	Code: 17
 */
