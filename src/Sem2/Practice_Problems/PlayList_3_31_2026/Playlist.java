package Sem2.Practice_Problems.PlayList_3_31_2026;

import java.util.Scanner;

public class Playlist {
    public static Song head;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        boolean loop = true;
        while (loop) {
            System.out.println("Enter Song (1):");
            System.out.println("Show Queue (2):");
            System.out.println("Quit(3):");
            int choice = sc.nextInt();
            if (choice==1) {
                System.out.print("Enter Song Name: ");
               sc.nextLine();
                String name = sc.nextLine();
                addSong(name);
            }
            if (choice==2) {
                Song lcN = head;
                while (lcN != null) {
                    System.out.println(lcN.getName());
                    lcN = lcN.next;
                }
            }
            if (choice==3) {loop = false;}
            }
        }

    public static void addSong(String name) {
        if (head==null) {
            head = new Song(name);
        }
        else {
            Song lcN = head;
            while (lcN.next!=null) {
                lcN = lcN.next;
            }
            lcN.next = new Song(name);
        }
    }
}

