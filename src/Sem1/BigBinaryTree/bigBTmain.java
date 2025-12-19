package Sem1.BigBinaryTree;

import java.util.Random;

public class bigBTmain {
    public static void main(String[] args) {
        BinaryTree binaryTree = new BinaryTree();
        Random rand = new Random();
        //1
        for (int i =0; i <= 50; i ++) {
            int n = rand.nextInt(100);
            binaryTree.add(n);
        //2
            System.out.print(n +" ");
        }
        System.out.println();
        //3
        System.out.print("NLR:\t");binaryTree.printPREFIX(); System.out.println();
        System.out.print("LNR:\t");binaryTree.printINFIX();  System.out.println();
        System.out.print("LRN:\t");binaryTree.printPOSTFIX();System.out.println();
        System.out.println("\n\n");
        //4
        System.out.println(binaryTree.contains(32));
        System.out.println("\n\n");
        //5
        System.out.println(binaryTree.DFS_depth());
        System.out.println("\n\n");
        //6
        System.out.println("Width:\t" + binaryTree.BFS_width());
        System.out.println("\n\n");
        //7
        binaryTree.add(new int[]{51, 102});
        binaryTree.printPREFIX();
        System.out.println("\n\n");
        //8
        binaryTree.KillClosestToAvg();



    }
}
