package Sem1.GigaFarm_1999W;

import Sem1.GigaFarm_1999W.Animals.Horse;

public class HorseList {
    static class Node {
        Horse horse;
        public Node next, prev;
        public Node(Horse horse) {
            this.horse = horse;
            this.next = null;
            this.prev = null;
        }
        public Horse getHorse() {return this.horse;}

    }
    private Node head;

    public HorseList() {
        head = null;
    }
    public void addHorse(Horse horse) {
        Node n = new Node(horse);
        if (head==null) {
            head = n;
            head.next = head;
        }
        else {
            Node lcN = head;
            while (lcN.next != null) {
                lcN = lcN.next;
            }
            lcN.next = n;
            n.next = head;
        }

    }
}
