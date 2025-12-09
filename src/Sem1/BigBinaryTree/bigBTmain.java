package Sem1.BigBinaryTree;

public class bigBTmain {
    public static void main(String[] args) {
        int[] list = {4,2,8,5,1,7,3};
        BinaryTree bt = new BinaryTree();
        bt.add(list);
        //bt.printIntOrder();
        bt.printPREFIX();
        System.out.println();
        bt.delete(7);
        bt.printINFIX();
    }
}
