package Sem1.BigBinaryTree;

public class bigBTmain {
    public static void main(String[] args) {
        int[] list = {4,2,8,5,1,6,3,9,7};
        BinaryTree bt = new BinaryTree();
        bt.add(list);
        bt.printIntOrder();System.out.println();
        bt.delete(7);
        bt.printIntOrder();System.out.println();
        bt.delete(6);
        bt.printIntOrder();System.out.println();
        bt.delete(8);
        bt.printIntOrder();System.out.println();
    }
}
