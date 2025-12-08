package Sem1.BigBinaryTree;

import java.io.*;

public class bigBTmain {
    public static void main(String[] args) {
        int[] list = {4,2,8,5,1,7,3};
        BinaryTree bt = new BinaryTree();
        bt.add(list);
        bt.printIntOrder();
    }
}
