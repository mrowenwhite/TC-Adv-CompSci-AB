package Q1.Langdocs;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class Prog901a {
    public static void main(String[] args) throws IOException {
        Scanner file = new Scanner(new File("Langdats/prog512h.dat"));
        CLL  list = new CLL();

        while (file.hasNextLine()) {
            list.add(file.nextLine());
        }
        list.printForward();
        list.printBackward();
}

    public static class CLL {
        public Node head;

        public class Node {
            private String data;
            public  Node   next;
            public  Node   prev;

            public Node(String s) {this.data = s;}
            public String getData() {return this.data;}
        }

        public void add(String s) {
            Node newNode = new Node(s);

            if (head==null) {
                head = newNode;
                newNode.next = newNode;
                newNode.prev = newNode;
            }
            else {
                Node lcN = head;
                while (lcN.next != head)
                    lcN = lcN.next;
                lcN.next = newNode;
                newNode.prev = lcN;
                newNode.next = head;
                head.prev = newNode;
            }
        }

        public void printForward() {
            Node lcN = head;
            while (lcN.next!=head) {
                System.out.println(lcN.getData());
                lcN = lcN.next;
            }
            System.out.println(lcN.getData());
            System.out.println("\n\n");
        }
        public void printBackward() {
            Node lcN = head.prev;
            while (lcN!=head) {
                System.out.println(this.reverse(lcN.getData()));
                lcN = lcN.prev;
            }
            System.out.println(this.reverse(lcN.getData()));
            System.out.println("\n\n");
        }
        public String reverse(String s) {
            char[] arr = s.toCharArray();
            char[] res = new char[arr.length];
            for (int i = arr.length-1; i >=0; i--) {
                res[i] = arr[arr.length-i-1];
            }
            return new String(res);
        }
    }
}
/*
Good morning life and all
Things glad and beautiful
My pockets nothing hold
But he that owns the gold
The sun is my great friend
His spending has no end
Hail to the morning sky
Which bright clouds measure high
Hail to you birds whose throats
Would number leaves by notes
Hail to you shady bowers
And you green fields of flowers
Hail to you women fair
That make a show so rare
In cloth as white as milk
Be it calico or silk
Good morning life and all
Things glad and beautiful



lufituaeb dna dalg sgnihT
lla dna efil gninrom dooG
klis ro ocilac ti eB
klim sa etihw sa htolc nI
erar os wohs a ekam tahT
riaf nemow uoy ot liaH
srewolf fo sdleif neerg uoy dnA
srewob ydahs uoy ot liaH
seton yb sevael rebmun dluoW
staorht esohw sdrib uoy ot liaH
hgih erusaem sduolc thgirb hcihW
yks gninrom eht ot liaH
dne on sah gnidneps siH
dneirf taerg ym si nus ehT
dlog eht snwo taht eh tuB
dloh gnihton stekcop yM
lufituaeb dna dalg sgnihT
lla dna efil gninrom dooG
 */
