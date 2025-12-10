package Sem1.BigBinaryTree;

public class bigBTmain {
    public static void main(String[] args) {
        int[] list = {4,5,8,1,3,2,6,7};
        BinaryTree bt = new BinaryTree();
        bt.add(list);
        bt.printIntOrder();
        bt.delete(7);
        System.out.println("reprint");
        bt.printIntOrder();
        bt.delete(6);
        System.out.println("reprint 2");
        bt.printIntOrder();
    }
}
